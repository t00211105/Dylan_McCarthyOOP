package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class AmendTablesGUI extends JFrame {

    private Insets normalInsets = new Insets(10, 10, 0, 10);
    private Insets topInsets = new Insets(30, 10, 0, 10);
    private JTextField tableNoField;
    private JTextField tableSizeField;
    private JTextField descriptionField;
    private JTextField StatusField;

    public AmendTablesGUI()  {

        super("Amend Table");


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

        Object AmendTable =new AmendTablesGUI();
    }



    private JPanel createTitlePanel() {

        JPanel jpanel = new JPanel();

        JLabel titleLabel = new JLabel("Table Details");
        titleLabel.setFont(new Font("sans-serif",Font.PLAIN,18));

        jpanel.add(titleLabel);

        return jpanel;
    }

    private JPanel createDetailsPanel() {

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel tableNoLabel = new JLabel("Table Number: ");
        addComponent(jpanel, tableNoLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        tableNoField = new JTextField(25);
        addComponent(jpanel, tableNoField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel tableSizeLabel = new JLabel("Table Size: ");
        addComponent(jpanel, tableSizeLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        tableSizeField = new JTextField(25);
        addComponent(jpanel, tableSizeField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
        JLabel descriptionLabel = new JLabel("Table Description: ");
        addComponent(jpanel, descriptionLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        descriptionField = new JTextField(25);
        addComponent(jpanel, descriptionField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel resStatusLabel = new JLabel("Table Status: ");
        addComponent(jpanel, resStatusLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
        StatusField = new JTextField(25);
        addComponent(jpanel, StatusField, 1, gridy++, 1, 1, topInsets,
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

        JButton btnAmendTable = new JButton("Amend Table Details");

        btnAmendTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tables t1 =new Tables(1,2,"High table","A");
                Tables t2 =new Tables(2,2,"High table","A");
                Tables t3 =new Tables(3,3,"Corner Table","U");
                Tables t4 =new Tables(4,4,"Window Table","A");
                Tables t5 =new Tables(5,1,"Balcony table","U");
                Tables t6 =new Tables(6,6,"Low table","A");
                Tables t7 =new Tables(7,5,"Circular table","A");
                Tables t8 =new Tables(8,4,"High table","D");
                Tables t9 =new Tables(9,4,"High table","U");

                ArrayList<Tables> allTables = new ArrayList<Tables>(Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8,t9));

                try {
                    int tN = 0;
                    String tableNo = tableNoField.getText();
                    if (tableNo != null && !tableNo.isEmpty()) {
                        tN = Integer.parseInt(tableNo);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You did not enter a valid table number","Error!!",JOptionPane.ERROR_MESSAGE);

                    }
                    int tS = 0;
                    String tableSt = tableSizeField.getText();
                    if (tableSt != null && !tableSt.isEmpty()) {
                        tS = Integer.parseInt(tableSt);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You did not enter a valid table size","Error!!",JOptionPane.ERROR_MESSAGE);

                    }

                    String status = StatusField.getText();
                    if (status != null && !status.isEmpty()) {

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You did not enter a valid table staus","Error!!",JOptionPane.ERROR_MESSAGE);
                    }

                    String desc = descriptionField.getText();
                    if (desc != null && !desc.isEmpty()) {

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You did not enter a valid table description","Error!!",JOptionPane.ERROR_MESSAGE);

                    }

                    ArrayList<Tables> foundTables = new ArrayList<Tables>();
                    String searchKey = JOptionPane.showInputDialog("Please enter the name of the product you wish to amend");

                    for (Tables at: allTables)
                        if(at.getName().toLowerCase().contains(searchKey.toLowerCase()))
                            foundTables.add(at);
                    String text="";

                    for (Tables at: foundTables)
                        if (at !=null){
                            text+=at+"\n";
                        }
                    int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following matched your search phrase\n\n" + text +
                            "\n\nEnter the id of the one do you want to amend"));
                    Tables TablesToAmend=null;

                    for(Tables at: foundTables)
                        if(at!=null && at.getTableNo()==searchID)
                            TablesToAmend = at;
                    String amendChoice = JOptionPane.showInputDialog("The details of the product you wish to amend are:\n\n" + TablesToAmend + "\n\n1. Amend Table number\n2. Amend Table size" +
                            "\n3. Amend table description\n4. Amend table status\n5. Cancel Amendment\n\nPlease enter your choice");

                    int amendChoiceAsInt = Integer.parseInt(amendChoice);
                    while(amendChoiceAsInt<1 || amendChoiceAsInt>5){
                        amendChoice = JOptionPane.showInputDialog("The details of the Table you wish to amend are:\n\n" +
                                TablesToAmend + "\n\n1. Amend Name\n2. Amend Description" +
                                "\n3. Cancel Amendment\n\nInvalid choice entered!! Must be a value between 1 and 3 inclusive");

                        amendChoiceAsInt = Integer.parseInt(amendChoice);
                    }
                    switch(amendChoice){
                        case "1":
                            String newTableNoAsString = JOptionPane.showInputDialog("Please enter the new table number for the table:");
                            int newTableNo = Integer.parseInt(newTableNoAsString);

                            TablesToAmend.setTableNo(newTableNo);

                            break;
                        case "2":
                            String newTableSizeAsString = JOptionPane.showInputDialog("Please enter the new table size for the table:");
                            int newTableSize = Integer.parseInt(newTableSizeAsString);

                            TablesToAmend.setTableSize(newTableSize);
                            break;
                        case "3":
                            String newDescription = JOptionPane.showInputDialog("Please enter the new description for the table:");
                            TablesToAmend.setDescription(newDescription);

                            break;
                        case "4":
                            String newTableStatus = JOptionPane.showInputDialog("Please enter the new status for the table:");
                            TablesToAmend.setStatus(newTableStatus);

                            break;
                        case "5":
                            break;
                    }
                    JOptionPane.showMessageDialog(null,"Table details now amended!",
                            "Table Amended",JOptionPane.INFORMATION_MESSAGE);
                    foundTables.clear();



                } catch (NumberFormatException nfe) {
                } catch (IllegalArgumentException iae) {
                    if(iae.getMessage().contains("0"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Reservation ID", JOptionPane.ERROR_MESSAGE);
                    else if(iae.getMessage().contains("custID"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Customer ID", JOptionPane.ERROR_MESSAGE);
                    else if(iae.getMessage().contains("people"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid People Amount: ", JOptionPane.ERROR_MESSAGE);
                    else if(iae.getMessage().contains("mdcemekc"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid People Amount: ", JOptionPane.ERROR_MESSAGE);

                    else
                        JOptionPane.showMessageDialog(null, "The Date of Reservation must have day and month values that must be valid", "Invalid Date", JOptionPane.ERROR_MESSAGE);

                }
            } });

        jpanel.add(btnAmendTable);

        return jpanel;
    }
}

