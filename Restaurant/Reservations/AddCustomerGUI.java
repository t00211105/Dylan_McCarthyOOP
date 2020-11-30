package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class AddCustomerGUI extends JFrame {

    private Insets normalInsets = new Insets(10, 10, 0, 10);
    private Insets topInsets = new Insets(30, 10, 0, 10);
    private JTextField custIDField;
    private JTextField nameField;
    private JTextField phoneNoField;

    public AddCustomerGUI()  {

        super("Add Customer");

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));

        jpanel.add(Box.createVerticalStrut(50));
        jpanel.add(createTitlePanel());
        jpanel.add(createDetailsPanel());
        jpanel.add(Box.createVerticalStrut(40));
        jpanel.add(createSubmitPanel());
        jpanel.add(Box.createVerticalStrut(20));

        add(jpanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        setResizable(false);

    }

    public static void main(String args[]){

        Object AddCustomer =new AddCustomerGUI();
    }



    private JPanel createTitlePanel() {

        JPanel jpanel = new JPanel();

        JLabel titleLabel = new JLabel("Customer Details");
        titleLabel.setFont(new Font("sans-serif",Font.PLAIN,18));

        jpanel.add(titleLabel);

        return jpanel;
    }

    private JPanel createDetailsPanel() {

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel custIDLabel = new JLabel("Customer ID: ");
        addComponent(jpanel, custIDLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        custIDField = new JTextField(25);
        addComponent(jpanel, custIDField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel nameLabel = new JLabel("Customer Name: ");
        addComponent(jpanel, nameLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        nameField = new JTextField(25);
        addComponent(jpanel, nameField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
        JLabel PhoneNoLabel = new JLabel("Phone Number: ");
        addComponent(jpanel, PhoneNoLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        phoneNoField = new JTextField(25);
        addComponent(jpanel, phoneNoField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        return jpanel;
    }

    private void addComponent(Container container, Component component,
                              int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
                              int anchor, int fill) {

        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 0.0, 0.0, anchor, fill, insets, 5, 5);

        container.add(component, gbc);
    }

    private JPanel createSubmitPanel() {

        JPanel jpanel = new JPanel();

        JButton btnAddCustomer = new JButton("Add Customers");

        btnAddCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ci = 0;
                    String custId = custIDField.getText();
                    if (custId != null && !custId.isEmpty()) {
                        ci = Integer.parseInt(custId);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "You did not enter a valid Customer ID", "Error!!", JOptionPane.ERROR_MESSAGE);
                    }
                    int nm = 0;
                    String name = nameField.getText();
                    if (name!= null && !name.isEmpty()) {
                        nm = Integer.parseInt(name);
                    }
                    else {

                        JOptionPane.showMessageDialog(null, "You did not enter a valid name", "Error!!", JOptionPane.ERROR_MESSAGE);
                    }
                    long phnNum=0;
                    String phn = phoneNoField.getText();
                    if (phn!= null && !phn.isEmpty()) {
                        phnNum = Long.parseLong(phn);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "You did not enter a valid phone number", "Error!!", JOptionPane.ERROR_MESSAGE);
                    }
                    Customers c1 = new Customers(1,"Dylan",112345678);
                    Customers c2 = new Customers(2,"Mary",1234567);
                    Customers c3 = new Customers(3,"Raymond",1233656);
                    Customers c4 = new Customers(4,"Tyler",12345432);
                    Customers c5 = new Customers(5,"Evan",1239944);
                    Customers c6 = new Customers(6,"Kyle",1874318);

                    ArrayList<Customers> allCus = new ArrayList<Customers>(Arrays.asList(c1,c2,c3,c4,c5,c6));

                    Customers c = new Customers(ci, name,phnNum);
                    allCus.add(c);


                        JOptionPane.showMessageDialog(null, "Customer details added\n\nDetails are:  " + c, "Customer Is Added", JOptionPane.INFORMATION_MESSAGE);


                } catch (NumberFormatException nfe) {
                } catch (IllegalArgumentException iae) {
                    if (iae.getMessage().contains("0"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Customer Id!", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog( null, iae.getMessage(), "Invalid Name!", JOptionPane.ERROR_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Phone Number! ", JOptionPane.ERROR_MESSAGE);

                    }
                }
            } });

        jpanel.add(btnAddCustomer);

        return jpanel;
    }
}
