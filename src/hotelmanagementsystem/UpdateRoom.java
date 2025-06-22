package hotelmanagementsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateRoom extends JFrame {

    private JPanel contentPane;
    private JTextField availabilityTF;
    private JTextField cleanStatusTF;
    private JTextField txt_Room;
    Choice c1;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateRoom frame = new UpdateRoom();
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
    
    public UpdateRoom() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 1000, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i3 = i1.getImage().getScaledInstance(550, 250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(400, 80, 600, 250);
        add(l1);

        JLabel lblUpdateRoomStatus = new JLabel("Update Room Status");
        lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUpdateRoomStatus.setBounds(85, 11, 206, 34);
        contentPane.add(lblUpdateRoomStatus);

        JLabel lblNewLabel = new JLabel("Guest ID:");
        lblNewLabel.setBounds(27, 87, 90, 14);
        contentPane.add(lblNewLabel);

        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                c1.add(rs.getString("idNo"));
            }
        } catch (Exception e) {
        }
        c1.setBounds(160, 84, 140, 20);
        contentPane.add(c1);

        JLabel lblAvailability = new JLabel("Availability:");
        lblAvailability.setBounds(27, 187, 90, 14);
        contentPane.add(lblAvailability);

        JLabel lblCleanStatus = new JLabel("Cleaning Status:");
        lblCleanStatus.setBounds(27, 240, 90, 14);
        contentPane.add(lblCleanStatus);

        availabilityTF = new JTextField();
        availabilityTF.setBounds(160, 184, 140, 20);
        contentPane.add(availabilityTF);
        availabilityTF.setColumns(10);

        cleanStatusTF = new JTextField();
        cleanStatusTF.setBounds(160, 237, 140, 20);
        contentPane.add(cleanStatusTF);
        cleanStatusTF.setColumns(10);

        txt_Room = new JTextField();
        txt_Room.setBounds(160, 130, 140, 20);
        contentPane.add(txt_Room);
        txt_Room.setColumns(10);

        JButton b1 = new JButton("Check");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedId = c1.getSelectedItem();
                    Conn c = new Conn();
                    ResultSet rs1 = c.s.executeQuery("select * from customer where idNo = '" + selectedId+"'");

                    while (rs1.next()) {
                        txt_Room.setText(rs1.getString("room"));
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
                try {
                    Conn c = new Conn();
                    ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '" + txt_Room.getText() + "'");
                    while (rs2.next()) {
                        availabilityTF.setText(rs2.getString("availability"));
                        cleanStatusTF.setText(rs2.getString("cleaning_status"));
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });
        b1.setBounds(120, 315, 89, 23);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) throws NumberFormatException {

                try {
                    Conn c = new Conn();
                    String str = "update room set cleaning_status = '" + cleanStatusTF.getText() + "' where room_number = '" + txt_Room.getText() + "'";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Update Sucessful");
                    new Reception().setVisible(true);
                    setVisible(false);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });
        btnUpdate.setBounds(60, 355, 89, 23);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        contentPane.add(btnUpdate);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(180, 355, 89, 23);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        JLabel lblRoomId = new JLabel("Room Number:");
        lblRoomId.setBounds(27, 133, 100, 14);
        contentPane.add(lblRoomId);

        getContentPane().setBackground(Color.WHITE);
    }
}