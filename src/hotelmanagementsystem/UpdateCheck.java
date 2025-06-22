package hotelmanagementsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCheck extends JFrame {

    private JPanel contentPane;
    private JTextField roomNoTF;
    private JTextField nameTF;
    private JTextField txt_Date;
    private JTextField depositTF;
    private JTextField pendingTF;
    Choice choice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateCheck frame = new UpdateCheck();
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

    public UpdateCheck() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 950, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUpdateCheckStatus = new JLabel("Check-In Details");
        lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUpdateCheckStatus.setBounds(124, 11, 222, 25);
        contentPane.add(lblUpdateCheckStatus);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(450, 70, 476, 270);
        add(l1);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(25, 88, 46, 14);
        contentPane.add(idLabel);

        choice = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                choice.add(rs.getString("idNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        choice.setBounds(248, 85, 140, 20);
        contentPane.add(choice);

        JLabel roomNoLabel = new JLabel("Room Number :");
        roomNoLabel.setBounds(25, 129, 107, 14);
        contentPane.add(roomNoLabel);

        roomNoTF = new JTextField();
        roomNoTF.setBounds(248, 126, 140, 20);
        contentPane.add(roomNoTF);

        JLabel nameLabel = new JLabel("Name : ");
        nameLabel.setBounds(25, 174, 97, 14);
        contentPane.add(nameLabel);

        JLabel checkinLabel = new JLabel("Checked-in :");
        checkinLabel.setBounds(25, 216, 107, 14);
        contentPane.add(checkinLabel);

        JLabel amountPaidLabel = new JLabel("Amount Paid : ");
        amountPaidLabel.setBounds(25, 261, 107, 14);
        contentPane.add(amountPaidLabel);

        JLabel pendingAmountLabel = new JLabel("Pending Amount (Rs) : ");
        pendingAmountLabel.setBounds(25, 302, 150, 14);
        contentPane.add(pendingAmountLabel);

        nameTF = new JTextField();
        nameTF.setBounds(248, 171, 140, 20);
        contentPane.add(nameTF);
        nameTF.setColumns(10);

        txt_Date = new JTextField();
        txt_Date.setBounds(248, 216, 140, 20);
        contentPane.add(txt_Date);
        txt_Date.setColumns(10);

        depositTF = new JTextField();
        depositTF.setBounds(248, 258, 140, 20);
        contentPane.add(depositTF);
        depositTF.setColumns(10);

        pendingTF = new JTextField();
        pendingTF.setBounds(248, 299, 140, 20);
        contentPane.add(pendingTF);
        pendingTF.setColumns(10);

        JButton updateBtn = new JButton("Update");
        updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Conn c = new Conn();

                    String idNo = choice.getSelectedItem();
                    String roomNo = roomNoTF.getText();
                    String name = nameTF.getText();
                    String checkedIn = txt_Date.getText();
                    String deposit = depositTF.getText();

                    c.s.executeUpdate("update customer set room = '" + roomNo + "', cust_name = '" + name + "', checkin_time = '" + checkedIn + "', deposit = '" + deposit + "' where idNo = '" + idNo + "'");

                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);
                } catch (Exception ee) {
                    System.out.println(ee);
                }

            }
        });
        updateBtn.setBounds(168, 378, 89, 23);
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.WHITE);
        contentPane.add(updateBtn);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        backBtn.setBounds(281, 378, 89, 23);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        contentPane.add(backBtn);

        JButton checkBtn = new JButton("Check");
        checkBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String custId = choice.getSelectedItem();
                    Conn c = new Conn();
                    ResultSet rs1 = c.s.executeQuery("select * from customer where idNo = '" + custId + "'");

                    while (rs1.next()) {
                        roomNoTF.setText(rs1.getString("room"));
                        nameTF.setText(rs1.getString("cust_name"));
                        txt_Date.setText(rs1.getString("checkin_time"));
                        depositTF.setText(rs1.getString("deposit"));
                    }
                    ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '" + roomNoTF.getText() + "'");
                    while (rs2.next()) {
                        String totalPrice = rs2.getString("price");
                        int pendingAmt = Integer.parseInt(totalPrice) - Integer.parseInt(depositTF.getText());
                        pendingTF.setText("" + pendingAmt);
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }

                /*try {
                    String total = "";
                    Conn c = new Conn();
                    ResultSet rs2 = c.s.executeQuery("select * from room where room_number = " + roomNoTF.getText());
                    while (rs2.next()) {
                        total = rs2.getString("price");
                    }
                    String paid = depositTF.getText();
                    int pending = Integer.parseInt(total) - Integer.parseInt(paid);

                    pendingTF.setText(Integer.toString(pending));

                } catch (Exception ee) {
                    ee.printStackTrace();
                }*/
            }
        });
        checkBtn.setBounds(56, 378, 89, 23);
        checkBtn.setBackground(Color.BLACK);
        checkBtn.setForeground(Color.WHITE);
        contentPane.add(checkBtn);
        getContentPane().setBackground(Color.WHITE);
    }
}