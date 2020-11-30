package Reservations;

//DateChooser.java
/*A GUI app that can be used in conjunction with other GUIs in order to allow the user to supply date information
graphically via a calendar. Designed and created by John Brosnan for use by students for their mini-projects because
Java doesn't directly supply such a component and many projects could benefit from a GUI that allows the end user to
select a date via graphical means. It will also serve to give students a better insight into the workings of the
GregorianCalendar class if they examine the code contained in this class

It will also help to show how "links" can be created between classes. In particular, here the EmployeeDetailsGUI class
will end up having a button on it which, when pressed, will call the DateChooser() constructor and generate the GUI that
can be used to select a date graphically. When the user then selects a date graphically, the attribute dateChosen is set
to the value of the GregorianCalendar object created. The class contains an accessor called getDateChosen() that can then
be used from other classes to obtain the value of the date chosen graphically and then it can be used within those
other classes. For example, here EmployeeDetailsGUI calls getDateChosen() on the DateChooser object and it uses it to
display the date chosen in the "date of birth" text-field of its own GUI*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;

public class DateChooser extends JDialog {

    JButton backMonthButton;
    JButton forwardMonthButton;
    GregorianCalendar firstDateOfMonth;
    JButton dateButtons[];
    JLabel monthLabel;
    JTextField yearField;
    JButton backYearButton;
    JButton forwardYearButton;
    GregorianCalendar dateChosen;

    public DateChooser(JFrame jFrame) {

        super(jFrame," Reservation DateChooser App",true);
        setLocationRelativeTo(jFrame);

        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        firstDateOfMonth = new GregorianCalendar(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),1);

        /*System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(firstDateOfMonth.get(Calendar.DAY_OF_MONTH));
        System.out.println(firstDateOfMonth.get(Calendar.DAY_OF_WEEK));
        System.out.println(firstDateOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH));*/

        int firstDayOfMonth = firstDateOfMonth.get(Calendar.DAY_OF_WEEK);
        //System.out.println("first day of month: " + firstDateOfMonth.get(Calendar.DAY_OF_WEEK));
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);


        JPanel daysPanel = new JPanel(new GridLayout(1,7));
        String days[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

        for(int i=0; i<days.length; i++) {
            JLabel dayLabel = new JLabel(days[i],SwingConstants.CENTER);
            dayLabel.setFont(new Font("arial",Font.BOLD,13));
            daysPanel.add(dayLabel);
        }

        JPanel datePanel = new JPanel();
        datePanel.setLayout(new GridLayout(6,7));

        dateButtons = new JButton[42];

        int j=1;

        for(int i=0; i<dateButtons.length; i++) {

            JButton button = new JButton();
            datePanel.add(button);
            dateButtons[i] = button;

            if (i >= firstDayOfMonth-1  && i < firstDayOfMonth + daysInMonth - 1) {
                dateButtons[i].setText("" + j);
                j++;
                dateButtons[i].addActionListener(new ButtonEventHandler());
            }
        }

        JPanel topPanel = new JPanel();
        backMonthButton = new JButton("<");
        backMonthButton.addActionListener(new ButtonEventHandler());


        Formatter dateFormatter = new Formatter();
        dateFormatter.format("%tB",firstDateOfMonth);

        monthLabel = new JLabel(""+ dateFormatter);
        forwardMonthButton = new JButton(">");
        forwardMonthButton.addActionListener(new ButtonEventHandler());

        topPanel.add(backMonthButton);
        topPanel.add(monthLabel);
        topPanel.add(forwardMonthButton);

        backYearButton = new JButton("<");
        backYearButton.addActionListener(new ButtonEventHandler());

        yearField = new JTextField(""+firstDateOfMonth.get(Calendar.YEAR));
        yearField.addActionListener(new ButtonEventHandler());

        forwardYearButton = new JButton(">");
        forwardYearButton.addActionListener(new ButtonEventHandler());

        topPanel.add(new JLabel("             "));

        topPanel.add(backYearButton);
        topPanel.add(yearField);
        topPanel.add(forwardYearButton);



        JPanel topTwoPanels = new JPanel();
        topTwoPanels.setLayout(new GridLayout(2,1));
        topTwoPanels.add(topPanel);
        topTwoPanels.add(daysPanel);

        add(topTwoPanels,BorderLayout.NORTH);
        add(datePanel,BorderLayout.CENTER);

        setSize(550,350);
        setUndecorated(false);
        setVisible(true);
    }

    public static void main(String[] args) {

        DateChooser dateChooser = new DateChooser(null);
    }


    public GregorianCalendar getDateChosen() {
        return dateChosen;
    }

    private class ButtonEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backMonthButton) {
                firstDateOfMonth.set(firstDateOfMonth.get(Calendar.YEAR), firstDateOfMonth.get(Calendar.MONTH) - 1, firstDateOfMonth.get(Calendar.DATE));
                updateCalendar();
            }
            else if(e.getSource()==forwardMonthButton) {
                firstDateOfMonth.set(firstDateOfMonth.get(Calendar.YEAR), firstDateOfMonth.get(Calendar.MONTH) + 1, firstDateOfMonth.get(Calendar.DATE));
                updateCalendar();
            }
            else if(e.getSource()==forwardYearButton) {
                firstDateOfMonth.set(firstDateOfMonth.get(Calendar.YEAR)+1, firstDateOfMonth.get(Calendar.MONTH), firstDateOfMonth.get(Calendar.DATE));
                updateCalendar();
            }
            else if(e.getSource()==backYearButton) {
                firstDateOfMonth.set(firstDateOfMonth.get(Calendar.YEAR)-1, firstDateOfMonth.get(Calendar.MONTH), firstDateOfMonth.get(Calendar.DATE));
                updateCalendar();
            }
            else if(e.getSource()==yearField) {
                int newYear;

                try{
                    newYear = Integer.parseInt(yearField.getText());

                    if(newYear>=1) {
                        firstDateOfMonth.set(newYear, firstDateOfMonth.get(Calendar.MONTH), firstDateOfMonth.get(Calendar.DATE));
                        updateCalendar();
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Can't get calendar before year 1AD!","Invalid Year",JOptionPane.ERROR_MESSAGE);
                }
                catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"Invalid year input supplied!","Invalid Year",JOptionPane.ERROR_MESSAGE);
                }

            }
            else {

                dateChosen = new GregorianCalendar(firstDateOfMonth.get(Calendar.YEAR),firstDateOfMonth.get(Calendar.MONTH)+1,Integer.parseInt(e.getActionCommand()));
                dispose();
            }
        }
    }

    private void updateCalendar() {

        int firstDayOfMonth = firstDateOfMonth.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = firstDateOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

        int j = 1;

        for (int i = 0; i < dateButtons.length; i++) {

            if (i < firstDayOfMonth - 1) {
                dateButtons[i].setText("");
            }
            else if (i >= firstDayOfMonth - 1 && i < firstDayOfMonth + daysInMonth - 1) {
                dateButtons[i].setText("" + j);
                j++;
            }
            else
                dateButtons[i].setText("");
        }

        Formatter dateFormatter = new Formatter();
        dateFormatter.format("%tB",firstDateOfMonth);

        monthLabel.setText(""+ dateFormatter);
        yearField.setText(""+firstDateOfMonth.get(Calendar.YEAR));

    }
}
