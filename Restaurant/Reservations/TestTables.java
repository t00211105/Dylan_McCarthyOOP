package Reservations;
//Project
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class TestTables extends AddTableGUI{
    public static void main(String[] args) {
        Tables t1 = new Tables(1,2,"Baby seat","A");
        Tables t2 = new Tables(2,6,"Circular Table","U");
        Tables t3 = new Tables(3,4,"High Table with Stools","A");
        Tables t4 = new Tables(4,2,"Window Table","D");
        Tables t5 = new Tables(5,6,"Corner Table","A");
        Tables t6 = new Tables(6,4,"Upstairs","U");
        Tables t7 = new Tables(7,2,"Square Table","A");
        Tables t8 = new Tables(8,2,"Rectangular Table","A");
        Tables t9 = new Tables(9,6,"Oval Table","D");
        Tables t10 = new Tables(10,2,"Triangular Table","A");

        ArrayList<Tables> allTables = new ArrayList<>(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));

        String choice;


        do{
            choice = JOptionPane.showInputDialog("1. Add a Table\n2. Amend a Table\n3. Remove a Table" +
                    "\n4. View all Tables\n5. Quit\n\nPlease enter your choice");

            int choiceAsInt = Integer.parseInt(choice);

            while(choiceAsInt<1 || choiceAsInt>5){
                choice =  JOptionPane.showInputDialog("ERROR!\nYou must utilise a choice:n\n\n1. Add a Table\n2. Amend a Table\n3. Remove a Table" +
                        "\n4. View all Tables\n5. Quit\n\nPlease enter your choice");

                choiceAsInt = Integer.parseInt(choice);
            }


            switch(choice) {
                case "1":
                    addTables(allTables);
                    break;

                case "2":
                    amendTables(allTables);
                    break;

                case "3":
                    removeTables(allTables);
                    break;

                case "4":
                    viewTables(allTables);
            }

        }while(!choice.equals("5"));

        JOptionPane.showMessageDialog(null,"Thanks for using the system!",
                "Farewell",JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
    public static void addTables(ArrayList<Tables> allTables) {
        int tableNo = Integer.parseInt(JOptionPane.showInputDialog("Please enter the table number:"));
        int tableSize = Integer.parseInt(JOptionPane.showInputDialog("Please enter the table size:"));
        String description  = JOptionPane.showInputDialog("Please enter the table status:");
        String status = JOptionPane.showInputDialog("Please enter the table status:");

        Tables t = new Tables(tableNo,tableSize,description,status);

        allTables.add(t);
        JOptionPane.showMessageDialog(null,"Table now created and saved to the database!",
                "Table Added",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void amendTables(ArrayList<Tables> allTables) {
        ArrayList<Tables> CreatedTables = new ArrayList<>();
        String searchKey = JOptionPane.showInputDialog("Please enter the number of the table you wish to amend");

        for(Tables ct: allTables)
            if(ct.getTableNo() == Integer.parseInt((searchKey)))
                CreatedTables.add(ct);

        String text="";

        for (Tables ct : CreatedTables)
            if (ct != null) {
                text += ct + "\n";
            }

        int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following tables matched your search phrase\n\n" + text +
                "\n\nEnter the id of the table you want to amend"));

        Tables tableToAmend=null;

        for (Tables ct : CreatedTables)
            if (ct != null && ct.getTableNo()==searchID)
                tableToAmend= ct;

        String amendChoice = JOptionPane.showInputDialog("The details of the product you wish to amend are:\n\n" +
                tableToAmend + "\n\n1. Amend Table number\n2. Amend Table Size" +
                "\n3. Amend Table Description\n4. Amend Table Status\n5.Cancel Activity\nPlease enter your choice");

        int amendChoiceAsInt = Integer.parseInt(amendChoice);

        while(amendChoiceAsInt<1 || amendChoiceAsInt>4){
            amendChoice = JOptionPane.showInputDialog("The details of the table you wish to amend are:\n\n" +
                    tableToAmend + "\n\n1. Amend Name\n2. Amend Description" +
                    "\n3. Cancel Amendment\n\nInvalid choice entered!! Must be a value between 1 and 3 inclusive");

            amendChoiceAsInt = Integer.parseInt(amendChoice);
        }

        switch(amendChoice){
            case "1":
                String newTableNoAsString = JOptionPane.showInputDialog("Please enter the new table number for the table");
                int newTableNo=Integer.parseInt(newTableNoAsString);
                if (tableToAmend != null)
                tableToAmend.setTableNo(newTableNo);

                break;

            case "2":
                String newTableSizeAsString = JOptionPane.showInputDialog("Please enter the new table size for the table");
                int newTableSize=Integer.parseInt(newTableSizeAsString);
                if (tableToAmend != null)
                tableToAmend.setTableSize(newTableSize);

                break;

            case "3":
                String newDescription = JOptionPane.showInputDialog("Please enter the new description for the table");
                if (tableToAmend != null)
                tableToAmend.setDescription(newDescription);

                break;
            case "4":
                String newStatus = JOptionPane.showInputDialog("Please enter the new status for the table");
                if (tableToAmend != null)
                tableToAmend.setStatus(newStatus);
                break;
        }
        JOptionPane.showMessageDialog(null,"Table details now amended!",
                "Table Amended",JOptionPane.INFORMATION_MESSAGE);
        CreatedTables.clear();  }
    public static void removeTables(ArrayList<Tables> allTables) {
        ArrayList<Tables> CreatedTables = new ArrayList<>();
        String searchKey = JOptionPane.showInputDialog("Please enter the table number of the product you wish to remove");

        for(Tables ct: allTables)
            if(ct.getTableNo()==Integer.parseInt(searchKey.toLowerCase()))
                CreatedTables.add(ct);

        String text="";

        for (Tables ct : CreatedTables)
            if (ct != null) {
                text += ct + "\n";
            }

        int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following products matched your search phrase\n\n" + text +
                "\n\nPlease enter the id of the table you want to remove"));

        Tables tableToRemove=null;

        for (Tables ct : CreatedTables)
            if (ct != null && ct.getTableNo()==searchID)
                tableToRemove= ct;

        int removeChoice = JOptionPane.showConfirmDialog(null,"The details of the product you wish to amend are:\n\n" +
                tableToRemove + "\n\nAre you sure you wish to remove this product?","Product Removal Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);

        if(removeChoice==JOptionPane.YES_OPTION) {
            allTables.remove(tableToRemove);
            JOptionPane.showMessageDialog(null, "Table now removed from array list!",
                    "Product Removed", JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Table removal canceled",
                    "Table Removal Cancelled!Q", JOptionPane.INFORMATION_MESSAGE);

        CreatedTables.clear();
    }
    public static void viewTables(ArrayList<Tables> allTables) {
        String allTableData="";
        Tables ct;

        //using an iterator here just for practice (could have easily done without it in this case)
        Iterator<Tables> iterator = allTables.iterator();

        while(iterator.hasNext()) {
            ct = iterator.next();
            if (ct != null)
                allTableData += ct + "\n";
        }

        JOptionPane.showMessageDialog(null,allTableData, "List of all Tables",JOptionPane.INFORMATION_MESSAGE);

    }
}

