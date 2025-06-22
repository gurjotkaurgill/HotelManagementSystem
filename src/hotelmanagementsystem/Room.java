package hotelmanagementsystem;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Room extends JFrame {

    private final JPanel contentPane;
    private JTable table;
    private final JLabel lblAvailability, lblCleanStatus, lblPrice, lblBedType, lblRoomNumber;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Room frame = new Room();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Room() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 1100, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500, 0, 600, 600);
        add(l1);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        contentPane.add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String displayRoomsQuery = "select * from room";
                    ResultSet rs = c.s.executeQuery(displayRoomsQuery);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        btnLoadData.setBounds(100, 470, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        
        backBtn.setBounds(290, 470, 120, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        contentPane.add(backBtn);

        lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(119, 15, 69, 14);
        contentPane.add(lblAvailability);

        lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setBounds(216, 15, 76, 14);
        contentPane.add(lblCleanStatus);

        lblPrice = new JLabel("Price");
        lblPrice.setBounds(330, 15, 46, 14);
        contentPane.add(lblPrice);

        lblBedType = new JLabel("Bed Type");
        lblBedType.setBounds(417, 15, 76, 14);
        contentPane.add(lblBedType);

        lblRoomNumber = new JLabel("Room Number");
        lblRoomNumber.setBounds(10, 15, 90, 14);
        contentPane.add(lblRoomNumber);

        getContentPane().setBackground(Color.WHITE);
    }
}