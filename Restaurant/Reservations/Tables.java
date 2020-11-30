package Reservations;

public class Tables extends AddTableGUI{
    private int tableNo;
    private int tableSize;
    private String description;
    private String status;

    public Tables(int tableNo,int tableSize,String description,String status){
        setTableNo(tableNo);
        setTableSize(tableSize);
        setDescription(description);
        setStatus(status);

    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        if (tableNo>0&&tableNo<30)
            this.tableNo = tableNo;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String toString() {
        return"Table no: " + getTableNo() + "\nTable size: " +  getTableSize()+
                "\nTable description: " + getDescription()+
                "\nTablestatus: " +getStatus();
    }
}
