package hotelmanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame {

    private final JPanel contentPane;

    public static void main(String[] args) {
        new Reception();
    }

    public Reception() {

        setBounds(530, 200, 850, 570);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(250, 30, 500, 470);
        add(l1);

        JButton newCustomerBtn = new JButton("New Customer Form");
        newCustomerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AddCustomer customer = new AddCustomer();
                    customer.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        newCustomerBtn.setBounds(10, 30, 200, 30);
        newCustomerBtn.setBackground(Color.BLACK);
        newCustomerBtn.setForeground(Color.WHITE);
        contentPane.add(newCustomerBtn);

        JButton roomBtn = new JButton("Room");
        roomBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Room room = new Room();
                    room.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        roomBtn.setBounds(10, 70, 200, 30);
        roomBtn.setBackground(Color.BLACK);
        roomBtn.setForeground(Color.WHITE);

        contentPane.add(roomBtn);

        JButton departmentBtn = new JButton("Department");
        departmentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    new Department().setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        departmentBtn.setBounds(10, 110, 200, 30);
        departmentBtn.setBackground(Color.BLACK);
        departmentBtn.setForeground(Color.WHITE);

        contentPane.add(departmentBtn);

        JButton allEmployeesBtn = new JButton("All Employee Info");
        allEmployeesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Employee em = new Employee();
                    em.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        allEmployeesBtn.setBounds(10, 150, 200, 30);
        allEmployeesBtn.setBackground(Color.BLACK);
        allEmployeesBtn.setForeground(Color.WHITE);

        contentPane.add(allEmployeesBtn);

        JButton customerInfoBtn = new JButton("Customer Info");
        customerInfoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    CustomerInfo customer = new CustomerInfo();
                    customer.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        customerInfoBtn.setBounds(10, 190, 200, 30);
        customerInfoBtn.setBackground(Color.BLACK);
        customerInfoBtn.setForeground(Color.WHITE);

        contentPane.add(customerInfoBtn);

        JButton btnManagerInfo = new JButton("Manager Info");
        btnManagerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ManagerInfo manager = new ManagerInfo();
                    manager.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnManagerInfo.setBounds(10, 230, 200, 30);
        btnManagerInfo.setBackground(Color.BLACK);
        btnManagerInfo.setForeground(Color.WHITE);

        contentPane.add(btnManagerInfo);

        JButton checkoutBtn = new JButton("Check Out");
        checkoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Checkout check;
                try {
                    check = new Checkout();
                    check.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        checkoutBtn.setBounds(10, 270, 200, 30);
        checkoutBtn.setBackground(Color.BLACK);
        checkoutBtn.setForeground(Color.WHITE);

        contentPane.add(checkoutBtn);

        JButton checkStatusBtn = new JButton("Update Check Status");
        checkStatusBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateCheck update = new UpdateCheck();
                    update.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        checkStatusBtn.setBounds(10, 310, 200, 30);
        checkStatusBtn.setBackground(Color.BLACK);
        checkStatusBtn.setForeground(Color.WHITE);

        contentPane.add(checkStatusBtn);

        JButton roomStatusBtn = new JButton("Update Room Status");
        roomStatusBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateRoom room = new UpdateRoom();
                    room.setVisible(true);
                    setVisible(false);
                } catch (Exception s) {
                    s.printStackTrace();
                }
            }
        });
        roomStatusBtn.setBounds(10, 350, 200, 30);
        roomStatusBtn.setBackground(Color.BLACK);
        roomStatusBtn.setForeground(Color.WHITE);

        contentPane.add(roomStatusBtn);

        JButton pickUpServiceBtn = new JButton("Pick up Service");
        pickUpServiceBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Pickup pickup = new Pickup();
                    pickup.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pickUpServiceBtn.setBounds(10, 390, 200, 30);
        pickUpServiceBtn.setBackground(Color.BLACK);
        pickUpServiceBtn.setForeground(Color.WHITE);

        contentPane.add(pickUpServiceBtn);

        JButton searchRoomBtn = new JButton("Search Room");
        searchRoomBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SearchRoom search = new SearchRoom();
                    search.setVisible(true);
                    setVisible(false);
                } catch (Exception ss) {
                    ss.printStackTrace();
                }
            }
        });
        searchRoomBtn.setBounds(10, 430, 200, 30);
        searchRoomBtn.setBackground(Color.BLACK);
        searchRoomBtn.setForeground(Color.WHITE);

        contentPane.add(searchRoomBtn);

        JButton logoutBtn = new JButton("Log Out");
        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Login().setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        logoutBtn.setBounds(10, 470, 200, 30);
        logoutBtn.setBackground(Color.BLACK);
        logoutBtn.setForeground(Color.WHITE);

        contentPane.add(logoutBtn);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }
}