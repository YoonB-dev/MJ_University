import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class hexadecimal extends JFrame{
    JButton convertButton;
    JTextField textField;
    JLabel resultLabel;
    hexadecimal(){
        setTitle("16 진수 변환");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        textField = new JTextField(10);

        convertButton = new JButton("16진수로 변환");
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                convertNum();
            }
        });
        resultLabel = new JLabel();
        
        panel.add(new JLabel("10진수 : "));
        panel.add(textField);
        panel.add(convertButton);
        panel.add(resultLabel);

        add(panel);
        setVisible(true);
    }
    void convertNum(){
        int decimal = Integer.parseInt(textField.getText());
        String hexStr = Integer.toHexString(decimal).toUpperCase();
        resultLabel.setText("변환된 16진수: " + hexStr);
    }
    public static void main(String args[]){
        hexadecimal hx = new hexadecimal();
        hx.setVisible(true);
    }
}


