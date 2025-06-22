package hotelmanagementsystem;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerInfo extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JLabel idLabel, nameLabel, genderLabel, countryLabel, roomLabel, checkInLabel, depositLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerInfo frame = new CustomerInfo();
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

    public CustomerInfo() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        backBtn.setBounds(450, 510, 120, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        contentPane.add(backBtn);

        JButton loadBtn = new JButton("Load Data");
        loadBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Conn c = new Conn();
                    String displayCustQuery = "select * from customer";
                    ResultSet rs = c.s.executeQuery(displayCustQuery);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        loadBtn.setBounds(300, 510, 120, 30);
        loadBtn.setBackground(Color.BLACK);
        loadBtn.setForeground(Color.WHITE);
        contentPane.add(loadBtn);

        idLabel = new JLabel("ID");
        idLabel.setBounds(31, 11, 46, 14);
        contentPane.add(idLabel);

        JLabel idNoLabel = new JLabel("Number");
        idNoLabel.setBounds(150, 11, 46, 14);
        contentPane.add(idNoLabel);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(270, 11, 65, 14);
        contentPane.add(nameLabel);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(360, 11, 46, 14);
        contentPane.add(genderLabel);

        table = new JTable();
        table.setBounds(0, 40, 900, 450);
        contentPane.add(table);

        countryLabel = new JLabel("Country");
        countryLabel.setBounds(480, 11, 46, 14);
        contentPane.add(countryLabel);

        roomLabel = new JLabel("Room");
        roomLabel.setBounds(600, 11, 46, 14);
        contentPane.add(roomLabel);

        checkInLabel = new JLabel("Check-in Status");
        checkInLabel.setBounds(680, 11, 100, 14);
        contentPane.add(checkInLabel);

        depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(800, 11, 100, 14);
        contentPane.add(depositLabel);

        getContentPane().setBackground(Color.WHITE);
    }
}