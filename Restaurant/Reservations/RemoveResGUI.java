package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class RemoveResGUI extends JFrame {

    private Insets normalInsets = new Insets(10, 10, 0, 10);
    private Insets topInsets = new Insets(30, 10, 0, 10);
    private JTextField resIDField;


    public RemoveResGUI()  {

        super("Remove Reservation");

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

        Object RemoveRes =new RemoveResGUI();
    }



    private JPanel createTitlePanel() {

        JPanel jpanel = new JPanel();

        JLabel titleLabel = new JLabel("Reservation Details");
        titleLabel.setFont(new Font("sans-serif",Font.PLAIN,18));

        jpanel.add(titleLabel);

        return jpanel;
    }

    private JPanel createDetailsPanel() {

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel resIDLabel = new JLabel("Reservation ID: ");
        addComponent(jpanel, resIDLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        resIDField = new JTextField(25);
        addComponent(jpanel, resIDField, 1, gridy++, 1, 1, topInsets,
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

        JButton RemoveResButton = new JButton("Cancel Reservation");

        RemoveResButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                Reservations reservations;


                    try {
                        int rA = 0;
                        String ResI = resIDField.getText();
                        if (ResI != null && !ResI.isEmpty()) {
                            rA = Integer.parseInt(ResI);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"You did not enter a valid reservation ID","Error!!",JOptionPane.ERROR_MESSAGE);

                        }

                        ArrayList<Reservations> allRes = new ArrayList<Reservations>();
                        ArrayList<Reservations> foundRes = new ArrayList<Reservations>();
                        String searchKey = JOptionPane.showInputDialog("Please enter the ID of the reservation you wish to remove");
                        for (Reservations rr: allRes)
                            if (rr.getResID()==searchKey)
                                foundRes.add(rr);

                        String text="";

                        for (Reservations rr: foundRes)
                            if(rr!=null){
                                text+=rr+"\n";
                            }
                        int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following reservations matched your search phrase\n\n" + text +
                                "\n\nPlease enter the id of the one you want to remove"));
                        Reservations ResToRemove=null;

                        for (Reservations rr: foundRes)
                            if(rr!=null && rr.getResID()==String.valueOf(searchID))
                                ResToRemove =rr;

                        int removeChoice = JOptionPane.showConfirmDialog(null,"The details of the reservations you wish to amend are:\n\n" +
                                ResToRemove + "\n\nAre you sure you wish to remove this reservation?","Reservation Removal Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);

                        if(removeChoice==JOptionPane.YES_OPTION) {
                            allRes.remove(ResToRemove);
                            JOptionPane.showMessageDialog(null, "Reservation now removed from array list!",
                                    "Reservation Removed", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Reservation removal canceled",
                                    "Reservation Not Removed", JOptionPane.INFORMATION_MESSAGE);

                        foundRes.clear();

                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Date must be in the form dd-mm-yyyy", "Invalid Date", JOptionPane.ERROR_MESSAGE);
                    } catch (IllegalArgumentException iae) {
                        if(iae.getMessage().contains("0"))
                            JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Reservation ID", JOptionPane.ERROR_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, "The details of Reservation must have day and month values that must be valid", "Invalid Reservation Details", JOptionPane.ERROR_MESSAGE);

                    }
                } });

        jpanel.add(RemoveResButton);

        return jpanel;
    }
}
