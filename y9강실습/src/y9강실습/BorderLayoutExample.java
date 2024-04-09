package y9강실습;
import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample extends JFrame {
    public BorderLayoutExample() {
        setTitle("BorderLayout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        String[] buttonLabels = {"Calculate", "Add", "Sub", "Mul", "Div"};
        JButton[] buttons = new JButton[buttonLabels.length];

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setBackground(mycolor[i]);
        }

     
        setLayout(new BorderLayout(5, 7));
        
        buttons[1].setBackground(Color.RED);   
        buttons[4].setBackground(Color.GREEN); 
        buttons[0].setBackground(Color.BLUE);
        buttons[2]


     
        add(buttons[0], BorderLayout.CENTER);
        add(buttons[1], BorderLayout.NORTH);
        add(buttons[2], BorderLayout.SOUTH);
        add(buttons[3], BorderLayout.EAST);
        add(buttons[4], BorderLayout.WEST);

    
        for (JButton button : buttons) {
            button.setPreferredSize(new Dimension(150, 50));
        }

        pack(); 
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BorderLayoutExample());
    }

    
    private static Color[] mycolor = {Color.CYAN, Color.RED, Color.GRAY, Color.YELLOW, Color.GREEN};
}
