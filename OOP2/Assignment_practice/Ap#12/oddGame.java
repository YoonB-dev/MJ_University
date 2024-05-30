import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class oddGame extends JFrame{
    private JButton evenButton;
    private JButton oddButton;
    JLabel resultJLabel;
    JLabel ranNumLabel;
    int ranNum;

    public oddGame(){
        setTitle("홀짝 맞추기 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(240,100);
        setLayout(new FlowLayout());

        ranNum = new Random().nextInt(101);

        evenButton = new JButton("짝수");
        oddButton = new JButton("홀수");
        resultJLabel = new JLabel();
        ranNumLabel = new JLabel("비밀번호 = ");

        evenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                checkNum(true);
            }
        });
        oddButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                checkNum(false);
            }
        });

        add(evenButton);
        add(oddButton);
        add(resultJLabel);
        add(ranNumLabel);

        resultJLabel.setVisible(false);
        ranNumLabel.setVisible(false);
    }
    void checkNum(boolean even){
        boolean isEven = ranNum % 2 ==0;
        if(isEven == even){
            resultJLabel.setText("맞았습니다.");
        }
        else{
            resultJLabel.setText("틀렸습니다.");
        }
        ranNumLabel.setText("비밀번호 = " + ranNum);

        evenButton.setVisible(false);
        oddButton.setVisible(false);
        resultJLabel.setVisible(true);
        ranNumLabel.setVisible(true);
    }
    public static void main(String args[]){
        oddGame oddGame = new oddGame();
        oddGame.setVisible(true);
    }
}
