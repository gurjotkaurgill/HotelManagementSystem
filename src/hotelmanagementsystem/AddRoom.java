package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener {

    private final JPanel contentPane;
    private final JTextField priceTF, roomNoTF;
    private final JComboBox availabilityComboBox, cleaningStatusCB, bedTypeCB;
    JButton addBtn, backBtn;

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }

    public AddRoom() {
        setBounds(450, 200, 1000, 450);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400, 30, 500, 370);
        add(l15);

        JLabel addLabel = new JLabel("Add Room");
        addLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        addLabel.setBounds(194, 10, 120, 22);
        contentPane.add(addLabel);

        JLabel rommNoLabel = new JLabel("Room Number");
        rommNoLabel.setForeground(new Color(25, 25, 112));
        rommNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        rommNoLabel.setBounds(64, 70, 102, 22);
        contentPane.add(rommNoLabel);

        roomNoTF = new JTextField();
        roomNoTF.setBounds(174, 70, 156, 20);
        contentPane.add(roomNoTF);

        JLabel availabilityLabel = new JLabel("Availability");
        availabilityLabel.setForeground(new Color(25, 25, 112));
        availabilityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        availabilityLabel.setBounds(64, 110, 102, 22);
        contentPane.add(availabilityLabel);

        availabilityComboBox = new JComboBox(new String[]{"Available", "Occupied"});
        availabilityComboBox.setBounds(176, 110, 154, 20);
        contentPane.add(availabilityComboBox);

        JLabel CleaningStatusLabel = new JLabel("Cleaning Status");
        CleaningStatusLabel.setForeground(new Color(25, 25, 112));
        CleaningStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        CleaningStatusLabel.setBounds(64, 150, 102, 22);
        contentPane.add(CleaningStatusLabel);

        cleaningStatusCB = new JComboBox(new String[]{"Clean", "Dirty"});
        cleaningStatusCB.setBounds(176, 150, 154, 20);
        contentPane.add(cleaningStatusCB);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setForeground(new Color(25, 25, 112));
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        priceLabel.setBounds(64, 190, 102, 22);
        contentPane.add(priceLabel);

        priceTF = new JTextField();
        priceTF.setBounds(174, 190, 156, 20);
        contentPane.add(priceTF);

        JLabel bedTypeLabel = new JLabel("Bed Type");
        bedTypeLabel.setForeground(new Color(25, 25, 112));
        bedTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        bedTypeLabel.setBounds(64, 230, 102, 22);
        contentPane.add(bedTypeLabel);

        bedTypeCB = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedTypeCB.setBounds(176, 230, 154, 20);
        contentPane.add(bedTypeCB);

        addBtn = new JButton("Add");
        addBtn.addActionListener(this);
        addBtn.setBounds(64, 321, 111, 33);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        contentPane.add(addBtn);

        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        backBtn.setBounds(198, 321, 111, 33);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        contentPane.add(backBtn);

        contentPane.setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == addBtn) {
                try {
                    Conn c = new Conn();
                    String roomNo = roomNoTF.getText();
                    String availability = (String) availabilityComboBox.getSelectedItem();
                    String cleaningStatus = (String) cleaningStatusCB.getSelectedItem();
                    String price = priceTF.getText();
                    String bedType = (String) bedTypeCB.getSelectedItem();

                    String str = "INSERT INTO room values( '" + roomNo + "', '" + availability + "', '" + cleaningStatus + "','" + price + "', '" + bedType + "')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Room Added Successfully");
                    this.setVisible(false);

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (ae.getSource() == backBtn) {
                this.setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}