package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddResGUI extends JFrame {

    private Insets normalInsets = new Insets(10, 10, 0, 10);
    private Insets topInsets = new Insets(30, 10, 0, 10);
    private JTextField resIDField;
    private JTextField tableNoField;
    private JTextField custIDField;
    private JTextField peopleField;
    private JTextField dateField;
    private JTextField resStatusField;
    private JTextField billAmountField;
    private GregorianCalendar dateChosen;

    public AddResGUI()  {

        super("Add Reservation");

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

        Object AddRes =new AddResGUI();
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

        JLabel tableNoLabel = new JLabel("Table Number: ");
        addComponent(jpanel, tableNoLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        tableNoField = new JTextField(25);
        addComponent(jpanel, tableNoField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel peopleLabel = new JLabel("People Amount: ");
        addComponent(jpanel, peopleLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        peopleField = new JTextField(25);
        addComponent(jpanel, peopleField, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel custIDLabel = new JLabel("Customer ID: ");
        addComponent(jpanel, custIDLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        custIDField = new JTextField(25);
        addComponent(jpanel, custIDField, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel resStatusLabel = new JLabel("Reservation Status: ");
        addComponent(jpanel, resStatusLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        resStatusField = new JTextField(1);
        addComponent(jpanel, resStatusField, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel dateLabel = new JLabel("Date of reservation: ");
        addComponent(jpanel, dateLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        dateField = new JTextField(25);
        dateField.setText("enter in form dd-mm-yyyy or use date-chooser");
        addComponent(jpanel, dateField, 1, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton dateButton = new JButton("...");
        dateButton.setPreferredSize(new Dimension(20,15));
        addComponent(jpanel, dateButton, 2, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
        dateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateChooser dateChooser = new DateChooser(AddResGUI.this);
                dateChosen = dateChooser.getDateChosen();

                if(dateChosen!=null) {
                    System.out.println(dateChosen.get(Calendar.DATE) + "-" +
                            dateChosen.get(Calendar.MONTH) + "-" +
                            dateChosen.get(Calendar.YEAR));

                    String dayString="", monthString="";

                    if(dateChosen.get(Calendar.DATE)<10)
                        dayString = "0" + dateChosen.get(Calendar.DATE);
                    else
                        dayString = "" + dateChosen.get(Calendar.DATE);

                    if(dateChosen.get(Calendar.MONTH)<10)
                        monthString = "0" + dateChosen.get(Calendar.MONTH);
                    else
                        monthString = "" + dateChosen.get(Calendar.MONTH);

                    dateField.setText(dayString + "-" + monthString + "-" + dateChosen.get(Calendar.YEAR));
                }
            }
        });
        JLabel billAmountLabel = new JLabel("Bill Amount: ");
        addComponent(jpanel, billAmountLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        billAmountField = new JTextField(1);
        addComponent(jpanel, billAmountField, 1, gridy++, 1, 1, normalInsets,
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

        JButton addButton = new JButton("Add Reservation");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String date = dateField.getText();

                Reservations reservations;

                if (date.length() >= 7) { //if date of birth comes from the date chooser app it'll be good anyway but
                    //                    //we need some tests if the user supplies it manually in the text-field

                    try {
                        int day = Integer.parseInt(date.substring(0, 2));
                        int month = Integer.parseInt(date.substring(3, 5));
                        int year = Integer.parseInt(date.substring(6, date.length()));

                        GregorianCalendar dateGC = new GregorianCalendar(year, month - 1, day);
                        dateGC.setLenient(false); //do this to ensure values like 13 are considered invalid as the month value, 32 invalid as the day value etc
                        dateGC.getTime(); //throws an exception if the date of birth was dodgy

                        System.out.println(dateGC.get(Calendar.DATE) + "-" +
                                (dateGC.get(Calendar.MONTH) + 1) + "-" +
                                dateGC.get(Calendar.YEAR));

                        float bA = 0;
                        String billA = billAmountField.getText();
                        if (billA != null && !billA.isEmpty()) {
                             bA = Float.parseFloat(billA);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"You did not enter a valid bill Amount","Error!!",JOptionPane.ERROR_MESSAGE);

                        }
                        int rA = 0;
                        String ResI = resIDField.getText();
                        if (ResI != null && !ResI.isEmpty()) {
                            rA = Integer.parseInt(ResI);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"You did not enter a valid reservation ID","Error!!",JOptionPane.ERROR_MESSAGE);
                        }
                        int tN = 0;
                        String TabN = tableNoField.getText();
                        if (TabN != null && !TabN.isEmpty()) {
                            tN = Integer.parseInt(TabN);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"You did not enter a valid table number","Error!!",JOptionPane.ERROR_MESSAGE);

                        }
                        int cus = 0;
                        String CusI = custIDField.getText();
                        if (CusI != null && !CusI.isEmpty()) {
                            cus = Integer.parseInt(CusI);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"You did not enter a valid customer ID!","Error!!",JOptionPane.ERROR_MESSAGE);
                        }
                        int ppl = 0;
                        String Pp = peopleField.getText();
                        if (Pp != null && !Pp.isEmpty()) {
                            ppl = Integer.parseInt(Pp);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"You did not enter a valid people  amount  ","Error!!",JOptionPane.ERROR_MESSAGE);

                        }
                        Reservations r1 = new Reservations(1,1,1,1,dateChosen,"CI",83.12f);
                        Reservations r2 = new Reservations(2,6,5,2,dateChosen,"PB",73.12f);
                        Reservations r3 = new Reservations(3,5,3,2,dateChosen,"CI",84.12f);
                        Reservations r4 = new Reservations(4,4,2,6,dateChosen,"C",1223.12f);
                        Reservations r5 = new Reservations(5,3,4,5,dateChosen,"W",13.12f);
                        Reservations r6 = new Reservations(6,2,7,4,dateChosen,"W",123.12f);

                        ArrayList<Reservations> allRes = new ArrayList<Reservations>(Arrays.asList(r1,r2,r3,r4,r5,r6));


                        Reservations r = new Reservations(rA,tN,cus,ppl,dateGC, resStatusField.getText(),bA);
                        allRes.add(r);

                        JOptionPane.showMessageDialog(null, "Reservation details added\n\nDetails are:  " + r, "Reservation Is Added", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Date must be in the form dd-mm-yyyy", "Invalid Date", JOptionPane.ERROR_MESSAGE);
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
                } else
                    JOptionPane.showMessageDialog(null, "Date of Reservation must be at least 7 characters long", "Invalid Date of Reservation", JOptionPane.ERROR_MESSAGE);
            }});

        jpanel.add(addButton);

        return jpanel;
    }
}
