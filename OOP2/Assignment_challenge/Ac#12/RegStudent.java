import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Student{
    String name,num,gender,phoneNum,address,hobbies,introduce,department;
    Student(String name,String num,String gender,String phoneNum,String adddress,String hobbies, String introduce,String department){
        this.name = name;
        this.num = num;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.address = adddress;
        this.hobbies = hobbies;
        this.introduce = introduce;
        this.department = department;
    }
    String getStudentInfoAll(){
        return num + "  " + name + "    " + gender + "  " + phoneNum + "    " +
        address + " " + department + "  " + hobbies + " " + introduce;
    }
}

class RegistStudent extends JFrame{
    Student[] students = new Student[10];
    int index=0;
    JTextField tfName,tfNum,tfPhoneNum,tfAdderss;
    JTextArea taIntroduce;
    JCheckBox cbMale,cbFemale,cbHobby1,cbHobby2,cbHobby3,cbHobby4;
    JButton btnSave,btnExit;
    JComboBox<String> cbDepartment;

    public RegistStudent(){
        setTitle("학생 등록");
        setSize(400,600);
        setLocation(400,100);
        getContentPane().setBackground(Color.yellow);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(10,2));

        panel.add(new JLabel("성명"));
        tfName = new JTextField();
        panel.add(tfName);
        
        panel.add(new JLabel("성별"));
        JPanel genPanel = new JPanel();
        ButtonGroup genGroup = new ButtonGroup();
        cbMale = new JCheckBox("남");
        cbFemale = new JCheckBox("여");
        genGroup.add(cbMale);
        genGroup.add(cbFemale);
        genPanel.add(cbMale);
        genPanel.add(cbFemale); 
        panel.add(genPanel);
        
        panel.add(new JLabel("학번"));
        tfNum = new JTextField();
        panel.add(tfNum);

        panel.add(new JLabel("전화번호"));
        tfPhoneNum = new JTextField();
        panel.add(tfPhoneNum);

        panel.add(new JLabel("주소"));
        tfAdderss = new JTextField();
        panel.add(tfAdderss);

        panel.add(new JLabel("학과"));
        cbDepartment = new JComboBox<>(new String[]{"학과 선택","컴퓨터공학과","전자공학과","정보통신공학과"});
        panel.add(cbDepartment);

        panel.add(new JLabel("취미"));
        JPanel hobbyPanel = new JPanel();
        cbHobby1 = new JCheckBox("운동",true);
        cbHobby2 = new JCheckBox("음악감상");
        cbHobby3 = new JCheckBox("영화");
        cbHobby4 = new JCheckBox("여행");
        hobbyPanel.add(cbHobby1);
        hobbyPanel.add(cbHobby2);
        hobbyPanel.add(cbHobby3);
        hobbyPanel.add(cbHobby4);

        panel.add(hobbyPanel);

        panel.add(new JLabel("자기 소개"));
        taIntroduce = new JTextArea();
        panel.add(taIntroduce);

        add(panel,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        btnSave = new JButton("저장");
        btnExit = new JButton("종료");

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                saveInfo();
            }
        });
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("학번\t이름\t성별\t전화번호\t주소\t학과\t취미\t자기소개");
                for(int i=0;i<index;i++){
                    System.out.println(students[i].getStudentInfoAll());
                }
                System.exit(0);
            }
        });

        buttonPanel.add(btnSave);
        buttonPanel.add(btnExit);
        add(buttonPanel,BorderLayout.SOUTH);
        
        setVisible(true);
    }
    void saveInfo(){
        String name = tfName.getText();
        String gender = cbMale.isSelected() ? "남" : cbFemale.isSelected() ? "여" : "";
        String num = tfNum.getText();
        String phoneNum = tfPhoneNum.getText();
        String address = tfAdderss.getText();
        String department = (String) cbDepartment.getSelectedItem();
        String hobbies = "";
        String introduce = taIntroduce.getText();
        if(cbHobby1.isSelected())hobbies+="운동 ";
        if(cbHobby2.isSelected())hobbies+="음악 감상 ";
        if(cbHobby3.isSelected())hobbies+="영화 ";
        if(cbHobby4.isSelected())hobbies+="여행 ";

        if(name.isEmpty()){JOptionPane.showMessageDialog(this, "이름을 입력하세요");return;}    
        if(gender.isEmpty()){JOptionPane.showMessageDialog(this, "성별을 선택해 주세요");return;}
        if(num.isEmpty() || num.length() !=8){JOptionPane.showMessageDialog(this, "학번이 틀렸습니다.");return;}
        if(phoneNum.isEmpty() || phoneNum.length()!=13){JOptionPane.showMessageDialog(this, "전화번호가 틀렸습니다.");return;}
        if(address.isEmpty()){JOptionPane.showMessageDialog(this, "주소를 입력하세요.");return;}
        if(department.equals("학과 선택")){JOptionPane.showMessageDialog(this, "학과를 하나 선택하세요.");return;}
        if(hobbies.trim().split(" ").length<2){JOptionPane.showMessageDialog(this, "취미를 두개 이상 선택하세요");return;}

        Student sd = new Student(name, num, gender, phoneNum, address, hobbies.trim(),introduce,department);
        students[index++] = sd; 

        //
        tfName.setText("");
        cbMale.setSelected(false);
        cbFemale.setSelected(false);
        tfNum.setText("");
        tfPhoneNum.setText("");
        tfAdderss.setText("");
        cbDepartment.setSelectedIndex(0);
        cbHobby1.setSelected(false);
        cbHobby2.setSelected(false);
        cbHobby3.setSelected(false);
        cbHobby4.setSelected(false);
    }
    public static void main(String[] args){
        RegistStudent rs = new RegistStudent();
        rs.setVisible(true);
    }
}