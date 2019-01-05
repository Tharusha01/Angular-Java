package controllers;

abstract class LibraryItem {

    //declaring variables
    private int isbn;
    private String title,sector;
    Reader currentReader;
    private DateTime borrowDate;
    private DateTime issueDate;



    //Getters and Setters
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public DateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(DateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public DateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(DateTime issueDate) {
        this.issueDate = issueDate;
    }

    public Reader getCurrentReader() {
        return currentReader;
    }

    public void setCurrentReader(Reader currentReader) {
        this.currentReader = currentReader;
    }

    //Constructor
    /*public LibraryItem(int isbn, String title, String sector, Reader currentReader, DateTime borrowDate, DateTime issueDate) {
        this.isbn = isbn;
        this.title = title;
        this.sector = sector;
        this.currentReader = currentReader;
        this.borrowDate = borrowDate;
        this.issueDate = issueDate;
    }*/
}

