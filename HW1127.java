import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class HW1127 extends JFrame {
    private Map<String, String> memoMap = new HashMap<>(); // 날짜와 메모를 저장하는 Map
    private JPanel calendarPanel;
    private JLabel monthYearLabel;
    private JComboBox<Integer> monthBox, dayBox;
    private JTextField memoField;
    private int currentYear = 2024, currentMonth = 11;

    public HW1127() {
        setTitle("MyCalendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
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

    private void initCalendarPanel() {
        calendarPanel = new JPanel(new GridLayout(0, 7));
        addDayHeaders(calendarPanel);
        add(calendarPanel, BorderLayout.CENTER);
    }

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

    private void addDayHeaders(JPanel panel) {
        String[] days = {"일", "월", "화", "수", "목", "금", "토"};
        panel.removeAll();
        for (String day : days) {
            JLabel dayLabel = new JLabel(day, JLabel.CENTER);
            dayLabel.setFont(new Font("Arial", Font.BOLD, 12));
            panel.add(dayLabel);
        }
    }

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
                dayButton.setText(day + " ✔"); // 메모가 있는 경우 체크 표시
            }

            String currentKey = key; // final 로컬 변수로 복사
            int currentDay = day;
            dayButton.addActionListener(e -> showMemo(currentKey, currentDay));
            calendarPanel.add(dayButton);
        }

        monthYearLabel.setText(year + "년 " + (month + 1) + "월");
        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    private void saveMemo() {
        int selectedMonth = (int) monthBox.getSelectedItem();
        int selectedDay = (int) dayBox.getSelectedItem();
        String key = currentYear + "-" + selectedMonth + "-" + selectedDay;
        String memo = memoField.getText();

        if (memo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "메모를 입력하세요!");
            return;
        }

        memoMap.put(key, memo); // 메모 저장
        JOptionPane.showMessageDialog(this, "메모 저장:\n" + currentYear + "년 " + selectedMonth + "월 " + selectedDay + "일\n메모: " + memo);
        updateCalendar(currentYear, currentMonth);
    }

    private void showMemo(String key, int day) {
        if (memoMap.containsKey(key)) {
            JOptionPane.showMessageDialog(this, "메모:\n" + memoMap.get(key));
        } else {
            JOptionPane.showMessageDialog(this, "메모가 없습니다.");
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
        new HW1127();
    }
}