package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton loginBtn, cancelBtn;

    Login() {

        super("Login");

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 30);
        add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 10, 150, 150);
        add(l3);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(40, 140, 120, 30);
        loginBtn.setFont(new Font("serif", Font.BOLD, 15));
        loginBtn.addActionListener(this);
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(Color.WHITE);
        add(loginBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(180, 140, 120, 30);
        cancelBtn.setFont(new Font("serif", Font.BOLD, 15));
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        add(cancelBtn);
        cancelBtn.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(600, 300);
        //setLocation(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginBtn) {
            try {
                Conn c1 = new Conn();
                String u = t1.getText();
                String v = t2.getText();

                String q = "select * from login where username='" + u + "' and password='" + v + "'";

                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) {
                    new Dashboard().setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancelBtn) {
            System.exit(0);
        }
    }

    public static void main(String[] arg) {
        new Login();
    }
}