package Reservations;


//JMenuFrame.java
/* Demonstrates the use of menus in a GUI. Here there is one JMenuBar,2 JMenus and 8 JMenuItem objects.When a menu item is selected, a string showing which menu choice is selected will appear in a label on the frame*/



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {
    JMenu TablesMenu;
    JMenu ReservationsMenu;
    JMenu CustomersMenu;
    JLabel response;


    public MainMenu() {

        super("Restaurant Main Menu");

        setLayout(new GridBagLayout());

        createTablesMenu();
        createReservationsMenu();
        createCustomersMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.WHITE);
        menuBar.add(TablesMenu);
        menuBar.add(ReservationsMenu);
        menuBar.add(CustomersMenu);
        ImageIcon icon = new ImageIcon("res.jpg");


        response = new JLabel("Welcome to the System");
        add(response);

        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(250, 200);
        setVisible(true);
    }


    public static void main(String[] args) {
        MainMenu MnMnu = new MainMenu(); }


    public void actionPerformed(ActionEvent event) {
        String menuName;
        menuName = event.getActionCommand();
        if(menuName.equals(("Add Tables"))) {
            AddTableGUI At = new AddTableGUI();
        }
        if(menuName.equals(("Update Tables"))) {
            AmendTablesGUI Ut = new AmendTablesGUI();
        }
        if(menuName.equals(("Remove Tables"))) {
            RemoveTableGUI Rt = new RemoveTableGUI();
        }

        if(menuName.equals(("Make Reservations"))) {
            AddResGUI mR = new AddResGUI();
        }
        if(menuName.equals(("Amend Reservations"))) {
            AmendResGUI AmR = new AmendResGUI();
            }
        if(menuName.equals(("Remove Reservations"))) {
            RemoveResGUI AmR = new RemoveResGUI();
        }
        if(menuName.equals(("Pay Bill"))) {
            PBResGUI PBR = new PBResGUI();
        }
        if(menuName.equals(("View Reservations"))) {
            viewResGUI vR = new viewResGUI();
        }

        if(menuName.equals(("Add Customers"))) {
            AddCustomerGUI cG = new AddCustomerGUI();
        }
        if(menuName.equals(("Update Customers"))) {
            AmendCustomerGUI aC = new AmendCustomerGUI();
        }
        if(menuName.equals(("Remove Customers"))) {
            RemoveCustomerGUI aC = new RemoveCustomerGUI();
        }
        if(menuName.equals(("View Customers"))) {
            ViewCustomerGUI vC = new ViewCustomerGUI();
        }

    }

    private void createTablesMenu() {
        JMenuItem item;

        TablesMenu = new JMenu("Manage Tables");

        item = new JMenuItem("Add Tables");
        item.setMnemonic(KeyEvent.VK_A);
        item.addActionListener(this);
        TablesMenu.add(item);

        item = new JMenuItem("Update Tables");
        item.setMnemonic(KeyEvent.VK_U);
        item.addActionListener(this);
        TablesMenu.add(item);

        item = new JMenuItem("Remove Tables");
        item.setMnemonic(KeyEvent.VK_R);
        item.addActionListener(this);
        TablesMenu.add(item);

        item = new JMenuItem("View Tables");
        item.setMnemonic(KeyEvent.VK_V);
        item.addActionListener(this);
        TablesMenu.add(item);


    }

    private void createReservationsMenu() {
        JMenuItem item;

        ReservationsMenu = new JMenu("Process Reservations");

        item = new JMenuItem("Make Reservations");
        item.addActionListener(this);
        item.setMnemonic(KeyEvent.VK_M);
        ReservationsMenu.add(item);

        item = new JMenuItem("Amend Reservations");
        item.addActionListener(this);
        item.setMnemonic(KeyEvent.VK_A);
        ReservationsMenu.add(item);

        item = new JMenuItem("Cancel Reservations");
        item.addActionListener(this);
        item.setMnemonic(KeyEvent.VK_C);
        ReservationsMenu.add(item);

        item = new JMenuItem("Pay Bill");
        item.addActionListener(this);
        item.setMnemonic(KeyEvent.VK_P);
        ReservationsMenu.add(item);

        item = new JMenuItem("View Reservations");
        item.addActionListener(this);
        item.setMnemonic(KeyEvent.VK_V);
        ReservationsMenu.add(item);
    }

    private void createCustomersMenu() {
        JMenuItem item;

        CustomersMenu = new JMenu("Manage Customers");

        item = new JMenuItem("Add Customers");
        item.addActionListener(this);
        item.setMnemonic(KeyEvent.VK_A);
        CustomersMenu.add(item);

        item = new JMenuItem("Update Customers");
        item.addActionListener(this);
        item.setMnemonic(KeyEvent.VK_U);
        CustomersMenu.add(item);

        item = new JMenuItem("Remove Customers");
        item.addActionListener(this);
        item.setMnemonic(KeyEvent.VK_R);
        CustomersMenu.add(item);

        item = new JMenuItem("View Customers");
        item.addActionListener(this);
        item.setMnemonic(KeyEvent.VK_V);
        CustomersMenu.add(item);

    }
}