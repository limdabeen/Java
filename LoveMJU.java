import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyListenerEx extends JFrame {
    private JLabel[] keyMessage;

    public KeyListenerEx() {
        setTitle("KeyListener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 오타 수정
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        // 키 이벤트 처리
        c.addKeyListener(new MyKeyListener()); // 내부 클래스 MyKeyListener 사용

        // JLabel 배열 초기화
        keyMessage = new JLabel[3];
        keyMessage[0] = new JLabel(" getKeyCode() ");
        keyMessage[1] = new JLabel(" getKeyChar() ");
        keyMessage[2] = new JLabel(" getKeyText() ");

        // JLabel 스타일 설정 및 추가
        for (int i = 0; i < keyMessage.length; i++) {
            c.add(keyMessage[i]);
            keyMessage[i].setOpaque(true); // 배경색 적용 가능하도록 설정
            keyMessage[i].setBackground(Color.YELLOW); // 배경색 설정
        }

        setSize(300, 150);
        setVisible(true);

        // 키보드 포커스 설정
        c.setFocusable(true);
        c.requestFocus();
    }

    // KeyListener 내부 클래스
    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode(); // 키 코드
            char keyChar = e.getKeyChar(); // 입력된 문자

            keyMessage[0].setText(Integer.toString(keyCode)); // 키 코드 출력
            keyMessage[1].setText(Character.toString(keyChar)); // 키 문자 출력
            keyMessage[2].setText(e.getKeyText(keyCode)); // 키 이름 출력
        }
    }

    public static void main(String[] args) {
        new KeyListenerEx();
    }
}
