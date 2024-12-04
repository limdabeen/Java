import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calender extends JFrame {
    private Map<String, String> memoMap = new HashMap<>(); // 날짜와 메모를 저장하는 Map
    private Map<String, String> statusMap = new HashMap<>(); // 날짜와 상태 저장 (진행 전, 진행 중, 완료)
    private JPanel calendarPanel;
    private JLabel monthYearLabel;
    private JComboBox<Integer> monthBox, dayBox;
    private JTextField memoField;
    private int currentYear = 2024, currentMonth = 11;

    public Calender() {
        setTitle("MyCalendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLayout(new BorderLayout());

        // 상단: 월 변경 버튼과 현재 월/연도 표시
        initTopPanel();

        // 중앙: 캘린더 패널
        initCalendarPanel();

        // 하단: 입력 영역
        initBottomPanel();

        // 초기 달력 설정
        updateCalendar(currentYear, currentMonth);

        setVisible(true);
    }

    // 상단 패널 초기화
    private void initTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout());
        JButton prevButton = new JButton("<");
        JButton nextButton = new JButton(">");
        monthYearLabel = new JLabel(currentYear + "년 " + (currentMonth + 1) + "월", JLabel.CENTER);
        monthYearLabel.setFont(new Font("Arial", Font.BOLD, 16));

        topPanel.add(prevButton);
        topPanel.add(monthYearLabel);
        topPanel.add(nextButton);
        add(topPanel, BorderLayout.NORTH);

        // 월 변경 버튼 이벤트
        prevButton.addActionListener(e -> {
            if (currentMonth == 0) {
                currentMonth = 11;
                currentYear--;
            } else {
                currentMonth--;
            }
            updateCalendar(currentYear, currentMonth);
        });

        nextButton.addActionListener(e -> {
            if (currentMonth == 11) {
                currentMonth = 0;
                currentYear++;
            } else {
                currentMonth++;
            }
            updateCalendar(currentYear, currentMonth);
        });
    }

    // 중앙 패널 초기화
    private void initCalendarPanel() {
        calendarPanel = new JPanel(new GridLayout(0, 7));
        addDayHeaders(calendarPanel);
        add(calendarPanel, BorderLayout.CENTER);
    }

    // 하단 패널 초기화
    private void initBottomPanel() {
        JPanel bottomPanel = new JPanel(new GridLayout(3, 1));

        // 날짜 선택 패널
        JPanel datePanel = new JPanel(new FlowLayout());
        monthBox = new JComboBox<>(getRange(1, 12));
        monthBox.setSelectedIndex(currentMonth); // 현재 월로 초기화
        dayBox = new JComboBox<>(getRange(1, 31));
        dayBox.setSelectedIndex(0); // 1일로 초기화
        datePanel.add(new JLabel("날짜 선택:"));
        datePanel.add(monthBox);
        datePanel.add(new JLabel("월"));
        datePanel.add(dayBox);
        datePanel.add(new JLabel("일"));
        bottomPanel.add(datePanel);

        // 메모 입력 패널
        JPanel memoPanel = new JPanel(new FlowLayout());
        memoField = new JTextField(20);
        memoPanel.add(new JLabel("메모:"));
        memoPanel.add(memoField);
        bottomPanel.add(memoPanel);

        // 등록 버튼
        JButton submitButton = new JButton("등록");
        submitButton.addActionListener(e -> saveMemo());
        bottomPanel.add(submitButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    // 요일 헤더 추가
    private void addDayHeaders(JPanel panel) {
        String[] days = {"일", "월", "화", "수", "목", "금", "토"};
        panel.removeAll();
        for (String day : days) {
            JLabel dayLabel = new JLabel(day, JLabel.CENTER);
            dayLabel.setFont(new Font("Arial", Font.BOLD, 12));
            panel.add(dayLabel);
        }
    }

    // 캘린더 업데이트
    private void updateCalendar(int year, int month) {
        calendarPanel.removeAll();
        addDayHeaders(calendarPanel);

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 빈 공간 채우기
        for (int i = 1; i < startDay; i++) {
            calendarPanel.add(new JLabel(""));
        }

        // 날짜 버튼 추가
        for (int day = 1; day <= daysInMonth; day++) {
            String key = year + "-" + (month + 1) + "-" + day;
            JButton dayButton = new JButton(String.valueOf(day));
            if (memoMap.containsKey(key)) {
                dayButton.setText(day + " ✔");
            }

            if (statusMap.containsKey(key)) {
                switch (statusMap.get(key)) {
                    case "진행 전":
                        dayButton.setForeground(Color.ORANGE);
                        break;
                    case "진행 중":
                        dayButton.setForeground(Color.GREEN);
                        break;
                    case "완료":
                        dayButton.setForeground(Color.RED);
                        break;
                }
            }

            // 버튼 클릭 이벤트
            String currentKey = key;
            int currentDay = day;
            dayButton.addActionListener(e -> showDialog(currentKey, currentDay, dayButton));
            calendarPanel.add(dayButton);
        }

        monthYearLabel.setText(year + "년 " + (month + 1) + "월");
        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    // 메모 저장
    private void saveMemo() {
        int selectedMonth = (int) monthBox.getSelectedItem();
        int selectedDay = (int) dayBox.getSelectedItem();
        String key = currentYear + "-" + selectedMonth + "-" + selectedDay;
        String memo = memoField.getText();

        if (memo.isEmpty()) { // 텍스트 필드가 비어 있으면 저장하지 않음
            JOptionPane.showMessageDialog(this, "메모를 입력하세요!");
            return;
        }

        memoMap.put(key, memo);
        JOptionPane.showMessageDialog(this, "메모 저장:\n" + currentYear + "년 " + selectedMonth + "월 " + selectedDay + "일\n메모: " + memo);
        updateCalendar(currentYear, currentMonth); // 달력 갱신
    }

    // JDialog 표시
    private void showDialog(String key, int day, JButton dayButton) {
        JDialog dialog = new JDialog(this, "Event", true);
        dialog.setSize(300, 250);
        dialog.setLayout(new GridLayout(4, 1)); // 4행 1열 레이아웃
    
        JLabel dateLabel = new JLabel((currentMonth + 1) + "월 " + day + "일", JLabel.CENTER);
    
        // 메모 입력 영역
        JTextArea memoArea = new JTextArea(memoMap.getOrDefault(key, ""));
        memoArea.setLineWrap(true); // 줄 바꿈 활성화
        memoArea.setWrapStyleWord(true); // 단어 단위로 줄 바꿈
        JScrollPane scrollPane = new JScrollPane(memoArea); // 스크롤 가능 영역
    
        // 상태 버튼 패널
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        JButton notStartedButton = new JButton("진행 전");
        JButton inProgressButton = new JButton("진행 중");
        JButton completedButton = new JButton("완료");
    
        // 상태 버튼 클릭 이벤트
        notStartedButton.addActionListener(e -> updateStatus(key, "진행 전", dayButton, Color.ORANGE, notStartedButton, inProgressButton, completedButton));
        inProgressButton.addActionListener(e -> updateStatus(key, "진행 중", dayButton, Color.GREEN, notStartedButton, inProgressButton, completedButton));
        completedButton.addActionListener(e -> updateStatus(key, "완료", dayButton, Color.RED, notStartedButton, inProgressButton, completedButton));
    
        buttonPanel.add(notStartedButton);
        buttonPanel.add(inProgressButton);
        buttonPanel.add(completedButton);
    
        // 저장 버튼
        JButton saveButton = new JButton("저장");
        saveButton.addActionListener(e -> {
            String memo = memoArea.getText().trim(); // 메모 내용 가져오기
            if (!memo.isEmpty()) { // 메모가 비어있지 않을 때만 저장
                memoMap.put(key, memo); // 메모 저장
                dialog.dispose(); // 다이얼로그 닫기
            }
        
        });
    
        // 다이얼로그 구성 요소 추가
        dialog.add(dateLabel);
        dialog.add(scrollPane);
        dialog.add(buttonPanel);
        dialog.add(saveButton);
    
        dialog.setVisible(true);
    }
    private void updateStatus(String key, String status, JButton dayButton, Color color, JButton... buttons) {
        statusMap.put(key, status);
        dayButton.setForeground(color);

        // 다른 상태 버튼 비활성화
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    private Integer[] getRange(int start, int end) {
        Integer[] range = new Integer[end - start + 1];
        for (int i = 0; i < range.length; i++) {
            range[i] = start + i;
        }
        return range;
    }

    public static void main(String[] args) {
        new Calender();
    }
}