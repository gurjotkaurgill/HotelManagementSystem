package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {

    private final JPanel contentPane;
    private final JTextField nameTF, ageTF, carCompanyTF, carModelTF, locationTF;
    private final JComboBox genderComboBox, availabilityCB;
    JButton addBtn, backBtn;

    public static void main(String[] args) {
        new AddDriver().setVisible(true);
    }

    public AddDriver() {
        setBounds(450, 200, 1000, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400, 30, 500, 370);
        add(l15);

        JLabel addlabel = new JLabel("Add Driver");
        addlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        addlabel.setBounds(194, 10, 120, 22);
        contentPane.add(addlabel);

        JLabel nameLabel = new JLabel("Driver Name");
        nameLabel.setForeground(new Color(25, 25, 112));
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameLabel.setBounds(64, 70, 102, 22);
        contentPane.add(nameLabel);

        nameTF = new JTextField();
        nameTF.setBounds(174, 70, 156, 20);
        contentPane.add(nameTF);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setForeground(new Color(25, 25, 112));
        ageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        ageLabel.setBounds(64, 110, 102, 22);
        contentPane.add(ageLabel);

        ageTF = new JTextField();
        ageTF.setBounds(174, 110, 156, 20);
        contentPane.add(ageTF);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setForeground(new Color(25, 25, 112));
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        genderLabel.setBounds(64, 150, 102, 22);
        contentPane.add(genderLabel);

        genderComboBox = new JComboBox(new String[]{"Male", "Female"});
        genderComboBox.setBounds(176, 150, 154, 20);
        contentPane.add(genderComboBox);

        JLabel carCompanyLabel = new JLabel("Car's Company");
        carCompanyLabel.setForeground(new Color(25, 25, 112));
        carCompanyLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        carCompanyLabel.setBounds(64, 190, 102, 22);
        contentPane.add(carCompanyLabel);

        carCompanyTF = new JTextField();
        carCompanyTF.setBounds(174, 190, 156, 20);
        contentPane.add(carCompanyTF);

        JLabel carModelLabel = new JLabel("Car Model");
        carModelLabel.setForeground(new Color(25, 25, 112));
        carModelLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        carModelLabel.setBounds(64, 230, 102, 22);
        contentPane.add(carModelLabel);

        carModelTF = new JTextField();
        carModelTF.setBounds(174, 230, 156, 20);
        contentPane.add(carModelTF);

        JLabel availabilityLabel = new JLabel("Available");
        availabilityLabel.setForeground(new Color(25, 25, 112));
        availabilityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        availabilityLabel.setBounds(64, 270, 102, 22);
        contentPane.add(availabilityLabel);

        availabilityCB = new JComboBox(new String[]{"Yes", "No"});
        availabilityCB.setBounds(176, 270, 154, 20);
        contentPane.add(availabilityCB);

        JLabel locationLabel = new JLabel("Location");
        locationLabel.setForeground(new Color(25, 25, 112));
        locationLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        locationLabel.setBounds(64, 310, 102, 22);
        contentPane.add(locationLabel);

        locationTF = new JTextField();
        locationTF.setBounds(174, 310, 156, 20);
        contentPane.add(locationTF);

        addBtn = new JButton("Add Driver");
        addBtn.addActionListener(this);
        addBtn.setBounds(64, 380, 111, 33);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        contentPane.add(addBtn);

        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        backBtn.setBounds(198, 380, 111, 33);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        contentPane.add(backBtn);

        contentPane.setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {
        try {

            if (ae.getSource() == addBtn) {
                try {
                    Conn c = new Conn();
                    String name = nameTF.getText();
                    String age = ageTF.getText();
                    String gender = (String) genderComboBox.getSelectedItem();
                    String carCompany = carCompanyTF.getText();
                    String carModel = carModelTF.getText();
                    String availability = (String) availabilityCB.getSelectedItem();
                    String location = locationTF.getText();
                    String str = "INSERT INTO driver values( '" + name + "', '" + age + "', '" + gender + "','" + carCompany + "', '" + carModel + "', '" + availability + "','" + location + "')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                    this.setVisible(false);
                } catch (Exception ee) {
                    System.out.println(ee);
                }
            } else if (ae.getSource() == backBtn) {
                this.setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
