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

public class ManagerInfo extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private final JLabel nameLabel, ageLabel, genderLabel, jobTitleLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerInfo frame = new ManagerInfo();
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
    
    public ManagerInfo() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430, 200, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(0, 34, 1000, 450);
        contentPane.add(table);

        JButton loadBtn = new JButton("Load Data");
        loadBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String displayMngrQuery = "select * from employee where job_title = 'Manager'";
                    ResultSet rs = c.s.executeQuery(displayMngrQuery);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        loadBtn.setBounds(350, 500, 120, 30);
        loadBtn.setBackground(Color.BLACK);
        loadBtn.setForeground(Color.WHITE);
        contentPane.add(loadBtn);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        
        backBtn.setBounds(510, 500, 120, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        contentPane.add(backBtn);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(41, 11, 46, 14);
        contentPane.add(nameLabel);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(159, 11, 46, 14);
        contentPane.add(ageLabel);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(273, 11, 46, 14);
        contentPane.add(genderLabel);

        jobTitleLabel = new JLabel("Job");
        jobTitleLabel.setBounds(416, 11, 86, 14);
        contentPane.add(jobTitleLabel);

        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(536, 11, 86, 14);
        contentPane.add(salaryLabel);

        JLabel phoneNumberLabel = new JLabel("Phone");
        phoneNumberLabel.setBounds(656, 11, 86, 14);
        contentPane.add(phoneNumberLabel);

        JLabel SINLabel = new JLabel("Sin Number");
        SINLabel.setBounds(786, 11, 86, 14);
        contentPane.add(SINLabel);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(896, 11, 86, 14);
        contentPane.add(emailLabel);
        getContentPane().setBackground(Color.WHITE);
    }
}