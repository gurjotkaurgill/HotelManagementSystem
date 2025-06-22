package hotelmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddEmployee extends JFrame {

    JTextField nameTF, ageTF, salaryTF, phoneTF, sinTF, emailTF;
    JComboBox jobTitleCB;

    public AddEmployee() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

        JLabel nameLabel = new JLabel("NAME");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        nameLabel.setBounds(60, 30, 150, 27);
        add(nameLabel);

        nameTF = new JTextField();
        nameTF.setBounds(200, 30, 150, 27);
        add(nameTF);

        JButton saveBtn = new JButton("SAVE");
        saveBtn.setBounds(200, 420, 150, 30);
        saveBtn.setBackground(Color.BLACK);
        saveBtn.setForeground(Color.WHITE);
        add(saveBtn);

        JLabel ageLabel = new JLabel("AGE");
        ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        ageLabel.setBounds(60, 80, 150, 27);
        add(ageLabel);

        ageTF = new JTextField();
        ageTF.setBounds(200, 80, 150, 27);
        add(ageTF);

        JLabel genderLabel = new JLabel("GENDER");
        genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        genderLabel.setBounds(60, 120, 150, 27);
        add(genderLabel);

        JRadioButton maleRB = new JRadioButton("MALE");
        maleRB.setBackground(Color.WHITE);
        maleRB.setBounds(200, 120, 70, 27);
        add(maleRB);

        JRadioButton femaleRB = new JRadioButton("FEMALE");
        femaleRB.setBackground(Color.WHITE);
        femaleRB.setBounds(280, 120, 70, 27);
        add(femaleRB);

        JLabel jobTitleLabel = new JLabel("JOB TITLE");
        jobTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        jobTitleLabel.setBounds(60, 170, 150, 27);
        add(jobTitleLabel);

        String[] jobTitles = {"Front Desk Clerk", "Porter", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        jobTitleCB = new JComboBox(jobTitles);
        jobTitleCB.setBackground(Color.WHITE);
        jobTitleCB.setBounds(200, 170, 150, 30);
        add(jobTitleCB);

        JLabel salaryLabel = new JLabel("SALARY");
        salaryLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        salaryLabel.setBounds(60, 220, 150, 27);
        add(salaryLabel);

        salaryTF = new JTextField();
        salaryTF.setBounds(200, 220, 150, 27);
        add(salaryTF);

        JLabel phoneLabel = new JLabel("PHONE NUMBER");
        phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        phoneLabel.setBounds(60, 270, 150, 27);
        add(phoneLabel);

        phoneTF = new JTextField();
        phoneTF.setBounds(200, 270, 150, 27);
        add(phoneTF);

        JLabel sinNoLabel = new JLabel("SIN NO");
        sinNoLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        sinNoLabel.setBounds(60, 320, 150, 27);
        add(sinNoLabel);

        sinTF = new JTextField();
        sinTF.setBounds(200, 320, 150, 27);
        add(sinTF);

        JLabel emailLabel = new JLabel("EMAIL");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        emailLabel.setBounds(60, 370, 150, 27);
        add(emailLabel);

        emailTF = new JTextField();
        emailTF.setBounds(200, 370, 150, 27);
        add(emailTF);

        JLabel addLabel = new JLabel("ADD EMPLOYEE");
        addLabel.setForeground(Color.BLUE);
        addLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        addLabel.setBounds(450, 24, 442, 35);
        add(addLabel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410, 80, 480, 410);
        add(image);

        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = nameTF.getText();
                String age = ageTF.getText();
                String salary = salaryTF.getText();
                String phone = phoneTF.getText();
                String sin = sinTF.getText();
                String email = emailTF.getText();

                String gender = null;

                if (maleRB.isSelected()) {
                    gender = "Male";
                } else if (femaleRB.isSelected()) {
                    gender = "Female";
                }

                String jobTitle = (String) jobTitleCB.getSelectedItem();

                try {
                    Conn c = new Conn();
                    String str = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + jobTitle + "', '" + salary + "', '" + phone + "','" + email + "', '" + sin + "')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(900, 600);
        setVisible(true);
        setLocation(530, 200);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}