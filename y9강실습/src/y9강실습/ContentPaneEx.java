package y9강실습;

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame {
	public ContentPaneEx() {
		setTitle("임다빈존예탱 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane= getContentPane();
		contentPane.setBackground(Color.PINK);
		contentPane.setLayout(new FlowLayout()); // 컨테이너 배치 방법
		contentPane.add(new JButton("시발인정"));
		contentPane.add(new JButton("너무예뽀"));
		contentPane.add(new JButton("시발지랄"));
		
		setSize(500, 400);
		setVisible(true); 
	}

	public static void main(String[] args) {
		new ContentPaneEx();

	}

}
