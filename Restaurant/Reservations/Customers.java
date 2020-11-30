package Reservations;

import javax.swing.*;

public class Customers {
    private int custID;
    private String name;
    private int phoneNo;

    public Customers(int custID, String name, long phoneNo) {
        setCustID(custID);
        setName(name);
        setPhoneNo(phoneNo);

    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You have to enter a name", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (name.endsWith("1") || (name.startsWith("1"))) {
            JOptionPane.showMessageDialog(null, "You have an Integer in the name", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        } else

            this.name = name;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {

        this.phoneNo = Math.toIntExact(phoneNo);
    }
    public String toString() {
        return
                "Customer ID: " + getCustID() + "\nName: " + getName()  +
                        "\nPhone number:" + getPhoneNo();
    }
}



