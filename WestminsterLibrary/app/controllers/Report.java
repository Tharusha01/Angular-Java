package controllers;

public class Report {
    private String isbn,rederName,bDate,dueDate,dueTime;

    //constructor
    public Report(String isbn, String rederName, String bDate, String dueDate, String dueTime) {
        this.isbn = isbn;
        this.rederName = rederName;
        this.bDate = bDate;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
    }

    //getter and setters
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getRederName() {
        return rederName;
    }

    public void setRederName(String rederName) {
        this.rederName = rederName;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }
}
