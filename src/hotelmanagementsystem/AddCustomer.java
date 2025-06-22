package hotelmanagementsystem;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCustomer extends JFrame {

    private JPanel contentPane;
    private JTextField idNumberTF, nameTF, countryTF, checkinTF, depositTF;
    JComboBox idComboBox;
    JRadioButton maleRB, femaleRB;
    Choice choice;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddCustomer frame = new AddCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddCustomer() throws SQLException {

        setBounds(530, 200, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480, 10, 300, 500);
        add(l1);

        JLabel newCustLabel = new JLabel("NEW CUSTOMER FORM");
        newCustLabel.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        newCustLabel.setBounds(118, 11, 260, 53);
        contentPane.add(newCustLabel);

        JLabel idLabel = new JLabel("ID :");
        idLabel.setBounds(35, 76, 200, 14);
        contentPane.add(idLabel);

        idComboBox = new JComboBox(new String[]{"Passport", "Drivers' License", "PR card", "Health card"});
        idComboBox.setBounds(271, 73, 150, 20);
        contentPane.add(idComboBox);

        JLabel idNumberLabel = new JLabel("ID Number :");
        idNumberLabel.setBounds(35, 111, 200, 14);
        contentPane.add(idNumberLabel);

        idNumberTF = new JTextField();
        idNumberTF.setBounds(271, 111, 150, 20);
        contentPane.add(idNumberTF);
        idNumberTF.setColumns(10);

        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setBounds(35, 151, 200, 14);
        contentPane.add(nameLabel);

        nameTF = new JTextField();
        nameTF.setBounds(271, 151, 150, 20);
        contentPane.add(nameTF);
        nameTF.setColumns(10);

        JLabel genderLabel = new JLabel("Gender :");
        genderLabel.setBounds(35, 191, 200, 14);
        contentPane.add(genderLabel);

        maleRB = new JRadioButton("Male");
        maleRB.setFont(new Font("Raleway", Font.BOLD, 14));
        maleRB.setBackground(Color.WHITE);
        maleRB.setBounds(271, 191, 80, 12);
        add(maleRB);

        femaleRB = new JRadioButton("Female");
        femaleRB.setFont(new Font("Raleway", Font.BOLD, 14));
        femaleRB.setBackground(Color.WHITE);
        femaleRB.setBounds(350, 191, 100, 12);
        add(femaleRB);

        JLabel countrylabel = new JLabel("Country :");
        countrylabel.setBounds(35, 231, 200, 14);
        contentPane.add(countrylabel);

        JLabel roomNumberlabel = new JLabel("Allocated Room Number :");
        roomNumberlabel.setBounds(35, 274, 200, 14);
        contentPane.add(roomNumberlabel);

        choice = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room where availability = 'Available'");
            while (rs.next()) {
                choice.add(rs.getString("room_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        choice.setBounds(271, 274, 150, 20);
        contentPane.add(choice);

        JLabel checkInStatusLabel = new JLabel("Checked-In :");
        checkInStatusLabel.setBounds(35, 316, 200, 14);
        contentPane.add(checkInStatusLabel);

        JLabel depositlabel = new JLabel("Deposit :");
        depositlabel.setBounds(35, 359, 200, 14);
        contentPane.add(depositlabel);

        countryTF = new JTextField();
        countryTF.setBounds(271, 231, 150, 20);
        contentPane.add(countryTF);
        countryTF.setColumns(10);

        checkinTF = new JTextField();
        checkinTF.setBounds(271, 316, 150, 20);
        contentPane.add(checkinTF);
        checkinTF.setColumns(10);

        depositTF = new JTextField();
        depositTF.setBounds(271, 359, 150, 20);
        contentPane.add(depositTF);
        depositTF.setColumns(10);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                String gender = null;

                if (maleRB.isSelected()) {
                    gender = "Male";
                } else if (femaleRB.isSelected()) {
                    gender = "Female";
                }

                String roomNo = choice.getSelectedItem();

                try {

                    String idType = (String) idComboBox.getSelectedItem();
                    String idNo = idNumberTF.getText();
                    String name = nameTF.getText();
                    String country = countryTF.getText();
                    String checkInTime = checkinTF.getText();
                    String deposit = depositTF.getText();

                    String q1 = "insert into customer values('" + idType + "','" + idNo + "','" + name + "','" + gender + "','" + country + "','" + roomNo + "','" + checkInTime + "','" + deposit + "')";
                    String q2 = "update room set availability = 'Occupied' where room_number = " + roomNo;
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);

                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                } catch (NumberFormatException s) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }
            }
        });
        btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}