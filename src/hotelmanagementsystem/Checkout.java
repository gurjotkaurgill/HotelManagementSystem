package hotelmanagementsystem;

import java.awt.*;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class Checkout extends JFrame {

    private JPanel contentPane;
    private JTextField roomNoTF;
    Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Checkout frame = new Checkout();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void close() {
        this.dispose();
    }
    
    public Checkout() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 800, 294);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 225, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(300, 0, 500, 225);
        add(l1);

        JLabel lblCheckOut = new JLabel("Check Out");
        lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCheckOut.setBounds(70, 11, 140, 35);
        contentPane.add(lblCheckOut);

        JLabel lblName = new JLabel("Customer ID :");
        lblName.setBounds(20, 85, 80, 14);
        contentPane.add(lblName);

        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                c1.add(rs.getString("idNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(130, 82, 150, 20);
        contentPane.add(c1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JButton tickBtn = new JButton(i6);
        tickBtn.setBounds(290, 82, 20, 20);
        add(tickBtn);

        tickBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                try {
                    Conn c = new Conn();
                    String idNo = c1.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("select * from customer where idNo = '" + idNo + "'");
                    if (rs.next()) {
                        roomNoTF.setText(rs.getString("room"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel lblRoomNumber = new JLabel("Room Number:");
        lblRoomNumber.setBounds(20, 132, 86, 20);
        contentPane.add(lblRoomNumber);

        roomNoTF = new JTextField();
        roomNoTF.setBounds(130, 132, 150, 20);
        contentPane.add(roomNoTF);

        JButton btnCheckOut = new JButton("Check Out");
        btnCheckOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String custId = c1.getSelectedItem();
                String roomNo = roomNoTF.getText();
                String deleteCustQuery = "Delete from customer where idNo = '" + custId + "'";
                String q2 = "update room set availability = 'Available' where room_number = '" + roomNo + "'";

                Conn c = new Conn();

                try {
                    c.s.executeUpdate(deleteCustQuery);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Check Out Successful");
                    new Reception().setVisible(true);
                    setVisible(false);
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });
        btnCheckOut.setBounds(50, 200, 100, 25);
        btnCheckOut.setBackground(Color.BLACK);
        btnCheckOut.setForeground(Color.WHITE);
        contentPane.add(btnCheckOut);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(160, 200, 100, 25);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}