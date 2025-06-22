package hotelmanagementsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pickup extends JFrame {

    ResultSet rs = null;
    private JPanel contentPane;
    private JTable table;
    Choice c1;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pickup frame = new Pickup();
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
    
    public Pickup() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPickUpService = new JLabel("Pick Up Service");
        lblPickUpService.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPickUpService.setBounds(90, 11, 158, 25);
        contentPane.add(lblPickUpService);

        JLabel lblTypeOfCar = new JLabel("Type of Car");
        lblTypeOfCar.setBounds(32, 97, 89, 14);
        contentPane.add(lblTypeOfCar);

        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while (rs.next()) {
                c1.add(rs.getString("car_company"));
            }
        } catch (Exception e) {
        }
        c1.setBounds(123, 94, 150, 25);
        contentPane.add(c1);

        JLabel driverNameLabel = new JLabel("Driver Name");
        driverNameLabel.setBounds(24, 208, 46, 14);
        contentPane.add(driverNameLabel);

        JButton btnRegister = new JButton("Display");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String SQL = "select * from driver where car_company = '" + c1.getSelectedItem() + "'";
                try {
                    Conn c = new Conn();
                    rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException ss) {
                    ss.printStackTrace();
                }
            }
        });
        btnRegister.setBounds(200, 500, 120, 30);
        btnRegister.setBackground(Color.BLACK);
        btnRegister.setForeground(Color.WHITE);
        contentPane.add(btnRegister);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(420, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        table = new JTable();
        table.setBounds(0, 233, 800, 250);
        contentPane.add(table);

        JLabel ageLabel = new JLabel("Driver's Age");
        ageLabel.setBounds(165, 208, 46, 14);
        contentPane.add(ageLabel);

        JLabel genderLabel = new JLabel("Driver's Gender");
        genderLabel.setBounds(264, 208, 46, 14);
        contentPane.add(genderLabel);

        JLabel companyLabel = new JLabel("Car Company");
        companyLabel.setBounds(366, 208, 80, 14);
        contentPane.add(companyLabel);

        JLabel modelLabel = new JLabel("Model");
        modelLabel.setBounds(486, 208, 105, 14);
        contentPane.add(modelLabel);

        JLabel availabilityLabel = new JLabel("Availability");
        availabilityLabel.setBounds(600, 208, 86, 14);
        contentPane.add(availabilityLabel);

        JLabel lblAvailable = new JLabel("Location");
        lblAvailable.setBounds(700, 208, 73, 14);
        contentPane.add(lblAvailable);

        getContentPane().setBackground(Color.WHITE);
    }
}
