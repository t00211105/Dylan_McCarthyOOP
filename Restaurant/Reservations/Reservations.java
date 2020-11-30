package Reservations;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Reservations extends AddResGUI{
    private static int resID;
    private int people;
    private int tableNo;
    private GregorianCalendar date;
    private String resStatus;
    private float billAmount;

    public Reservations(int resID,int custID, int tableNo, int people, GregorianCalendar date, String resStatus, float billAmount) {
        setResID(resID);
        setPeople(people);
        setDate(date);
        setTableNo(tableNo);
        setResStatus(resStatus);
        setBillAmount(billAmount);
    }
    void setBillAmount(Float billAmount) {
        totalRevenue(billAmount);
        this.billAmount = billAmount;
    }

    void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }


    public String getResID() {
        return String.valueOf(resID);
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public void setResID(int resID) {
        for (int i = 0; i < 30; i++) {
            resID = i;

        }
        this.resID = resID;
    }

    public String getPeople() {
        return String.valueOf(people);
    }

    public void setPeople(int people) {
        int ppl =people;
        if (people >= 1 && people <= 8) {
            this.people = people;
        }
    }

    public GregorianCalendar getDate() {
        GregorianCalendar date = this.date;
        return date;

    }

    public void setDate(GregorianCalendar date) {
        this.date = date;

    }

    /*public String getTime() {
        return time;
    }

    public void setTime(String time) {
        int timeAsInt = Integer.parseInt(time);
        if (!(!Character.isDigit(timeAsInt) || (((time.charAt(0)) >= 1) || (time.charAt(0)) <= 2) || (time.charAt(1)) >= 1)
                || (time.charAt(1)) >= 0 || ((time.charAt(3)) >= 0) || (time.charAt(3)) <= 5 || ((time.charAt(4)) >= 0) || (time.charAt(1)) <= 9) {
            timeAsInt = 1000;

        }*/


    private String getResStatus() {
    return resStatus;
    }
    public String getBillAmount() {
        return String.valueOf(billAmount);
    }
    public float totalRevenue(float billAmount){
        float totalRev = 0;
        totalRev += billAmount;
        return totalRev;
    }



    public String toString() {
        String date;

        if(getDate()==null)
            date = "No date of birth specified"; //this will never execute based on logic in EmployeeDetailsGUI but still good code
        else {

            if (this.date.get(Calendar.DATE) < 10)
                date = "0" + this.date.get(Calendar.DATE);
            else
                date = "" + this.date.get(Calendar.DATE);

            if (this.date.get(Calendar.MONTH)+1 < 10)
                date += "-0" + (this.date.get(Calendar.MONTH)+1);
            else
                date += "-" + (this.date.get(Calendar.MONTH)+1);

            date += "-" + this.date.get(Calendar.YEAR);
        }
        return "\nReservation id: " + getResID() +
                "\nPeople: " + getPeople() +
                "\nDate: " + date +
                "\nTable no: " + getTableNo() +
                "\nReservation status: " + getResStatus() +
                "\nBill amount: " + getBillAmount();
    }

}


