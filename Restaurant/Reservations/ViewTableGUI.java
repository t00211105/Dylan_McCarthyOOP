package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class ViewTableGUI extends JFrame {

    private Insets normalInsets = new Insets(10, 10, 0, 10);
    private Insets topInsets = new Insets(30, 10, 0, 10);
    public ViewTableGUI()  {

        super("View Table");


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
        setSize(500,200);
        setVisible(true);
        setResizable(false);

    }

    public static void main(String args[]){

        Object viewTable =new ViewTableGUI();
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

        JButton btnViewTable = new JButton("View Tables");

        btnViewTable.addActionListener(new ActionListener() {
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


                ArrayList<Tables> allTables = new ArrayList<Tables>(Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8));

                try {

                    String allTableData = "";
                    Tables at;

                    //using an iterator here just for practice (could have easily done without it in this case)
                    Iterator<Tables> iterator = allTables.iterator();

                    while (iterator.hasNext()) {
                        at = iterator.next();
                        if (at != null)
                            allTableData += at + "\n";
                    }
                    JOptionPane.showMessageDialog(null,allTableData,
                            "List of all Tables",JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException nfe) {
                } catch (IllegalArgumentException iae) {
                    if(iae.getMessage().contains("0"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Table number", JOptionPane.ERROR_MESSAGE);
                    else if(iae.getMessage().contains("1"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(), " Invalid Table Number", JOptionPane.ERROR_MESSAGE);
                    else if(iae.getMessage().contains("010293"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid People Amount: ", JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid People Amount: ", JOptionPane.ERROR_MESSAGE);

                }
            } });

        jpanel.add(btnViewTable);

        return jpanel;
    }
}
