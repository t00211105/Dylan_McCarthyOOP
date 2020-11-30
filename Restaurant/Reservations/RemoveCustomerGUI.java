package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class RemoveCustomerGUI extends JFrame {

    private final Insets normalInsets = new Insets(10, 10, 0, 10);
    private final Insets topInsets = new Insets(30, 10, 0, 10);
    private JTextField custIDField;


    public RemoveCustomerGUI()  {

        super("Remove Customer");

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

        Object RemoveCustomer = new RemoveCustomerGUI();
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

        JButton btnRemoveCustomer = new JButton("Remove Customers");

        btnRemoveCustomer.addActionListener(new ActionListener() {
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


                    Customers c1 = new Customers(1,"Dylan",112345678);
                    Customers c2 = new Customers(2,"Mary",1234567);
                    Customers c3 = new Customers(3,"Ryan",1233656);
                    Customers c4 = new Customers(4,"Tyler",12345432);
                    Customers c5 = new Customers(5,"Evan",1239944);
                    Customers c6 = new Customers(6,"Kyle",1874318);

                    ArrayList<Customers> allCus = new ArrayList<Customers>(Arrays.asList(c1,c2,c3,c4,c5,c6));
                    ArrayList<Customers> foundCustomers = new ArrayList<Customers>();
                    String searchKey = JOptionPane.showInputDialog("Please enter the id of the customer you wish to remove");
                    for (Customers rc: allCus)
                        if (rc.getName().toLowerCase().contains(searchKey.toLowerCase()))
                            foundCustomers.add(rc);

                    String text="";

                    for (Customers rc: foundCustomers)
                        if(rc!=null){
                            text+=rc+"\n";
                        }
                    int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following customers matched your search phrase\n\n" + text +
                            "\n\nAre you sure?\nPlease re-enter the id of the one you want to remove"));
                    Customers CustomerToRemove=null;

                    for (Customers rc: foundCustomers)
                        if(rc!=null && rc.getCustID()==searchID)
                            CustomerToRemove =rc;

                    int removeChoice = JOptionPane.showConfirmDialog(null,"The details of the customer you wish to amend are:\n\n" +
                            CustomerToRemove + "\n\nAre you sure you wish to remove this customer?","Customer Removal Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);

                    if(removeChoice==JOptionPane.YES_OPTION) {
                        allCus.remove(CustomerToRemove);
                        JOptionPane.showMessageDialog(null, "Customer now removed from array list!",
                                "Customer Removed", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Customer removal canceled",
                                "Customer Not Removed", JOptionPane.INFORMATION_MESSAGE);

                    foundCustomers.clear();


                } catch (NumberFormatException nfe) {
                } catch (IllegalArgumentException iae) {
                    if (iae.getMessage().contains("0"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Customer ID!", JOptionPane.ERROR_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Customer ID! ", JOptionPane.ERROR_MESSAGE);

                    }
                }
            } });

        jpanel.add(btnRemoveCustomer);

        return jpanel;
    }
}
