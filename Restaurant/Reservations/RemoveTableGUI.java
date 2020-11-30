package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class RemoveTableGUI extends JFrame {

    private final Insets normalInsets = new Insets(10, 10, 0, 10);
    private final Insets topInsets = new Insets(30, 10, 0, 10);
    private JTextField tableNoField;


    public RemoveTableGUI()  {

        super("Remove Table");


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

        Object RemoveTable =new RemoveTableGUI();
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

        JButton btnRemoveTable = new JButton("Remove Tables");

        btnRemoveTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tables t1 = new Tables(1, 2, "High table", "A");
                Tables t2 = new Tables(2, 2, "High table", "A");
                Tables t3 = new Tables(3, 3, "Corner Table", "U");
                Tables t4 = new Tables(4, 4, "Window Table", "A");
                Tables t5 = new Tables(5, 1, "Balcony table", "U");
                Tables t6 = new Tables(6, 6, "Low table", "A");
                Tables t7 = new Tables(7, 5, "Circular table", "A");
                Tables t8 = new Tables(8, 4, "High table", "D");
                Tables t9 = new Tables(9, 4, "High table", "U");

                ArrayList<Tables> allTables = new ArrayList<Tables>(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9 ));

                try {
                    int tN = 0;
                    String tableNo = tableNoField.getText();
                    if (tableNo != null && !tableNo.isEmpty()) {
                        tN = Integer.parseInt(tableNo);
                    } else {
                        JOptionPane.showMessageDialog(null, "You did not enter a valid table number", "Error!!", JOptionPane.ERROR_MESSAGE);

                    }

                    ArrayList<Tables> foundTables = new ArrayList<Tables>();
                    int searchKey = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of the table you wish to remove"));
                    for (Tables rt : allTables)
                        if (rt.getTableNo() == searchKey)
                            foundTables.add(rt);

                    String text = "";

                    for (Tables rt : foundTables)
                        if (rt != null) {
                            text += rt + "\n";
                        }
                    int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following tables matched your search phrase\n\n" + text +
                            "\n\nPlease enter the id of the one you want to remove"));
                    Tables TableToRemove = null;

                    for (Tables rt : foundTables)
                        if (rt != null && rt.getTableNo() == searchID)
                            TableToRemove = rt;

                    int removeChoice = JOptionPane.showConfirmDialog(null, "The table you wish to remove are:\n\n" +
                            TableToRemove + "\n\nAre you sure you wish to remove this Table?", "Table Removal Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

                    if (removeChoice == JOptionPane.YES_OPTION) {
                        allTables.remove(TableToRemove);
                        JOptionPane.showMessageDialog(null, "Table now removed from array list!",
                                "Table Removed", JOptionPane.INFORMATION_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null, "Table removal canceled",
                                "Table Not Removed", JOptionPane.INFORMATION_MESSAGE);

                    foundTables.clear();
                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                }
            }});

        jpanel.add(btnRemoveTable);

        return jpanel;
    }
}
