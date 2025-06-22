package hotelmanagementsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchRoom extends JFrame {

    PreparedStatement pst = null;
    ResultSet rs = null;
    private JPanel contentPane, txt_Type;
    private JTable table;
    Choice bedChoice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchRoom frame = new SearchRoom();
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

    public SearchRoom() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel searchRoomLabel = new JLabel("Search For Room");
        searchRoomLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        searchRoomLabel.setBounds(250, 11, 186, 31);
        contentPane.add(searchRoomLabel);

        JLabel bedTypeLabel = new JLabel("Room Bed Type:");
        bedTypeLabel.setBounds(50, 73, 96, 14);
        contentPane.add(bedTypeLabel);

        JLabel roomNumberLabel = new JLabel("Room Number");
        roomNumberLabel.setBounds(23, 162, 96, 14);
        contentPane.add(roomNumberLabel);

        JLabel availabilityLabel = new JLabel("Availability");
        availabilityLabel.setBounds(175, 162, 120, 14);
        contentPane.add(availabilityLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(458, 162, 46, 14);
        contentPane.add(priceLabel);

        JLabel bedTypeLabel2 = new JLabel("Bed Type");
        bedTypeLabel2.setBounds(580, 162, 96, 14);
        contentPane.add(bedTypeLabel2);

        JCheckBox availableCB = new JCheckBox("Only display 'Available' rooms");
        availableCB.setBounds(400, 69, 205, 23);
        availableCB.setBackground(Color.WHITE);
        contentPane.add(availableCB);

        bedChoice = new Choice();
        bedChoice.add("Single Bed");
        bedChoice.add("Double Bed");
        bedChoice.setBounds(153, 70, 120, 20);
        contentPane.add(bedChoice);

        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String SQL = "select * from room where bed_type = '" + bedChoice.getSelectedItem() + "'";
                String SQL2 = "select * from room where availability = 'Available' AND bed_type = '" + bedChoice.getSelectedItem() + "'";
                try {
                    Conn c = new Conn();
                    rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    if (availableCB.isSelected()) {
                        rs = c.s.executeQuery(SQL2);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                } catch (SQLException ss) {
                    ss.printStackTrace();
                }
            }
        });
        
        searchBtn.setBounds(200, 400, 120, 30);
        searchBtn.setBackground(Color.BLACK);
        searchBtn.setForeground(Color.WHITE);
        contentPane.add(searchBtn);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        
        backBtn.setBounds(380, 400, 120, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        contentPane.add(backBtn);

        table = new JTable();
        table.setBounds(0, 187, 700, 300);
        contentPane.add(table);

        JLabel lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setBounds(306, 162, 96, 14);
        contentPane.add(lblCleanStatus);

        getContentPane().setBackground(Color.WHITE);
    }
}