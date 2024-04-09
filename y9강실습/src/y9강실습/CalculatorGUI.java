package y9강실습;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    private JButton dotButton, signButton;

    private double num1, num2, result;
    private char operator;

   
    public CalculatorGUI() {
        
        this.setTitle("계산기 프레임");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(6, 4));

        
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);

       
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            numberButtons[i].addActionListener(this);
        }

        
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("계산");
        clrButton = new JButton("CE");
        dotButton = new JButton(".");
        signButton = new JButton("+/-");

       
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        eqButton.addActionListener(this);
        clrButton.addActionListener(this);
        dotButton.addActionListener(this);
        signButton.addActionListener(this);

        
        this.add(textField);
        this.add(clrButton);
        this.add(signButton);
        this.add(divButton);

        this.add(numberButtons[7]);
        this.add(numberButtons[8]);
        this.add(numberButtons[9]);
        this.add(mulButton);

        this.add(numberButtons[4]);
        this.add(numberButtons[5]);
        this.add(numberButtons[6]);
        this.add(subButton);

        this.add(numberButtons[1]);
        this.add(numberButtons[2]);
        this.add(numberButtons[3]);
        this.add(addButton);

        this.add(numberButtons[0]);
        this.add(dotButton);
        this.add(eqButton);

        
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
            num1 = num2 = result = 0;
        }

        if (e.getSource() == dotButton) {
            textField.setText(textField.getText() + ".");
        }

        if (e.getSource() == signButton) {
            double value = Double.parseDouble(textField.getText());
            value = -value;
            textField.setText(String.valueOf(value));
        }
    }
}
