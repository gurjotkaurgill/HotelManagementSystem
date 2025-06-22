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

public class Department extends JFrame {

    private final JPanel contentPane;
    private JTable table;
    private final JLabel deptLabel, budgetLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Department frame = new Department();
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

    public Department() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(0, 40, 700, 350);
        contentPane.add(table);

        JButton loadBtn = new JButton("Load Data");
        loadBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String displayDeptsQuery = "select * from Department";
                    ResultSet rs = c.s.executeQuery(displayDeptsQuery);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        loadBtn.setBounds(170, 410, 120, 30);
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
        backBtn.setBounds(400, 410, 120, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        contentPane.add(backBtn);

        deptLabel = new JLabel("Department");
        deptLabel.setBounds(145, 11, 105, 14);
        contentPane.add(deptLabel);

        budgetLabel = new JLabel("Budget");
        budgetLabel.setBounds(431, 11, 75, 14);
        contentPane.add(budgetLabel);
        getContentPane().setBackground(Color.WHITE);
    }
}