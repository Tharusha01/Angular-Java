package controllers;

public class Book extends LibraryItem {

    private String bookISBN;
    private String bookTitle;
    private String bookSector;
    private String bookAuthor;
    private String bookPublisher;
    private String bookPublishedDate;
    private String bookNumberOfPage;
    private String status;

    //Constructor
    public Book(String bookISBN, String bookTitle, String bookSector, String bookAuthor, String bookPublisher, String bookPublishedDate, String bookNumberOfPage, String status) {
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.bookSector = bookSector;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookPublishedDate = bookPublishedDate;
        this.bookNumberOfPage = bookNumberOfPage;
        this.status = status;
    }

    //Getter and Setters
    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookSector() {
        return bookSector;
    }

    public void setBookSector(String bookSector) {
        this.bookSector = bookSector;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookPublishedDate() {
        return bookPublishedDate;
    }

    public void setBookPublishedDate(String bookPublishedDate) {
        this.bookPublishedDate = bookPublishedDate;
    }

    public String getBookNumberOfPage() {
        return bookNumberOfPage;
    }

    public void setBookNumberOfPage(String bookNumberOfPage) {
        this.bookNumberOfPage = bookNumberOfPage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
