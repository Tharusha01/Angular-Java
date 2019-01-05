package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import play.libs.Json;
import play.mvc.*;

import java.sql.*;
import java.util.ArrayList;
import static play.mvc.Controller.request;
import static play.mvc.Results.ok;


public class WestminsterLibraryManager implements LibraryManager{

    private ArrayList books = new ArrayList<>();
    private ArrayList dvds = new ArrayList<>();
    private ArrayList readers = new ArrayList<>();

    //create connection
    ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.getConnection();

    public Result addNewBook() throws SQLException {

        //get data from front end as string
        String bookData = request().body().asText();

        //create string array
        String[]bookDetails;

        //split and store front end data
        bookDetails = bookData.split("@");
        String bookISBN = bookDetails[0];
        String bookTitle = bookDetails[1];
        String bookSector = bookDetails[2];
        String bookAuthor =  bookDetails[3];
        String bookPublisher = bookDetails[4];
        String bookPublishedDate = bookDetails[5];
        String bookNumberOfPage = bookDetails[6];
        String status = "Available";

        LibraryItem l1 = new Book(bookISBN,bookTitle,bookSector,bookAuthor,bookPublisher,bookPublishedDate,bookNumberOfPage,status);
        books.add(l1);

        //create connection
        Statement statement = connection.createStatement();


        //SQL query for insert details to database
        try {
            statement.executeUpdate("INSERT INTO book (bISBN,bTitle,bSector,bAuthor,bPublisher,bPubDAte,bNumberOFPage,Availability)" +
                    " values('" + bookISBN + "','" + bookTitle + "','" + bookSector + "','" + bookAuthor + "','" + bookPublisher + "','"
                    + bookPublishedDate + "','" + bookNumberOfPage + "','" + status + "')");
        } catch (SQLException e) {
            JsonNode jsonNode = Json.toJson(new AppSummary("ISBN is already entered.Please enter valid ISBN"));
            return ok(jsonNode).as("application/json");
        }


        //return message to front end
        JsonNode jsonNode = Json.toJson(new AppSummary("New Book successfully added"));
        return ok(jsonNode).as("application/json");

    }
    public Result addNewDVD() throws SQLException {

        //get data from front end as string
        String dvdData = request().body().asText();

        //String array
        String[]DVDDetails;

        //split and store front end data
        DVDDetails = dvdData.split("@");
        String dvdISBN = DVDDetails[0];
        String dvdTitle = DVDDetails[1];
        String dvdSector = DVDDetails[2];
        String dvdLanguages =  DVDDetails[3];
        String dvdSub =  DVDDetails[4];
        String dvdProduser = DVDDetails[5];
        String dvdActor = DVDDetails[6];
        String status = "Available";

        LibraryItem l2 = new DVD(dvdISBN,dvdTitle,dvdSector,dvdLanguages,dvdSub,dvdProduser,dvdActor,status);
        dvds.add(l2);

        //create connection
        Statement statement = connection.createStatement();

        //SQL query for insert details to database
        try {
        statement.executeUpdate("INSERT INTO dvd (dISBN,dTitle,dSector,dLanguages,dSub,dProduser,dActor,Availability)" +
                " values('" + dvdISBN + "','" + dvdTitle + "','" + dvdSector + "','" + dvdLanguages + "','" + dvdSub + "','" + dvdProduser
                + "','" + dvdActor + "','" + status + "')");
        } catch (SQLException e) {

            JsonNode jsonNode = Json.toJson(new AppSummary("ISBN is already entered.Please enter valid ISBN"));
            return ok(jsonNode).as("application/json");
        }

        //return message to front end
        JsonNode jsonNode = Json.toJson(new AppSummary("New DVD successfully added"));
        return ok(jsonNode).as("application/json");

    }

    //Method for Borrow Book
    public Result borrowBook() throws SQLException {

        //creating connection
        Statement statement = connection.createStatement();

        //get data from front end as string
        String borrowBookDetail = request().body().asText();

        //creating string array
        String[]borrowBookDetails;

        //split and store front end data in an array
        borrowBookDetails = borrowBookDetail.split("@");
        String bBookISBN = borrowBookDetails[0];
        String bBookReaderName = borrowBookDetails[1];
        String bBookDate = borrowBookDetails[2];
        String bBookTime = borrowBookDetails[3];

        String status = "Borrowed";

        //split and store date in an array
        String[]dateDetails = bBookDate.split("-");

        int year = Integer.parseInt(dateDetails[0]);
        int month = Integer.parseInt(dateDetails[1]);
        int date = Integer.parseInt(dateDetails[2]);

        String[]timeDetails = bBookTime.split(":");

        int hours = Integer.parseInt(timeDetails[0]);
        int minute = Integer.parseInt(timeDetails[1]);

        System.out.println(bBookDate);
        DateTime dateTime = new DateTime(date,month,year,hours,minute);

        String returnDate = dateTime.getBookReturnDate(7);

        //SQL query for insert details to database
        try {
            statement.executeUpdate("INSERT INTO borrowBook (bBookISBN,bBookReaderName,bBookDate,bBookTime,returnDate)" +
                    " values('" + bBookISBN + "','" + bBookReaderName + "','" + bBookDate + "','" + bBookTime + "','" + returnDate + "')");

            statement.executeUpdate("UPDATE book SET Availability = '"+status+"' WHERE bISBN = '"+bBookISBN+"'");
        } catch (SQLException e) {
            JsonNode jsonNode = Json.toJson(new AppSummary(bBookISBN+" Book currently unavailable"));
            return ok(jsonNode).as("application/json");
        }

        //return message to front end
        JsonNode jsonNode = Json.toJson(new AppSummary(bBookISBN+" Book Successfully borrowed by "+bBookReaderName +"\n " +
                ", Can be used until "+ dateTime.getBookReturnDate(7)+"\t"+ dateTime.getReturnTime()));
        return ok(jsonNode).as("application/json");

    }

    //Method for Borrow DVD
    public Result borrowDVD() throws SQLException {

        //creating connection
        Statement statement = connection.createStatement();

        //get data from front end as string
        String borrowDVDDetail = request().body().asText();

        //create string array
        String[]borrowDVDDetails;

        //split and store front end data in an array
        borrowDVDDetails = borrowDVDDetail.split("@");
        String bDVDISBN = borrowDVDDetails[0];
        String bDVDReaderName = borrowDVDDetails[1];
        String bDVDDate = borrowDVDDetails[2];
        String bDVDTime = borrowDVDDetails[3];

        String status = "Borrowed";

        //split and store date in an array
        String[]dateDetails = bDVDDate.split("-");

        int year = Integer.parseInt(dateDetails[0]);
        int month = Integer.parseInt(dateDetails[1]);
        int date = Integer.parseInt(dateDetails[2]);

        String[]timeDetails = bDVDTime.split(":");

        int hours = Integer.parseInt(timeDetails[0]);
        int minute = Integer.parseInt(timeDetails[1]);

        DateTime dateTime = new DateTime(date,month,year,hours,minute);

        String returnDate = dateTime.getDVDReturnDate(3);

        //SQL query for insert details to database
        try {
            statement.executeUpdate("INSERT INTO borrowDVD (bDVDISBN,bDVDReaderName,bDVDDate,bDVDTime,returnDate)" +
                    " values('" + bDVDISBN + "','" + bDVDReaderName + "','" + bDVDDate + "','" + bDVDTime + "','" + returnDate + "')");
            statement.executeUpdate("UPDATE dvd SET Availability = '"+status+"' WHERE dISBN = '"+bDVDISBN+"'");
        } catch (SQLException e) {
            JsonNode jsonNode = Json.toJson(new AppSummary(bDVDISBN+ " DVD currently unavailable"));
            return ok(jsonNode).as("application/json");
        }

        //return message to front end
        JsonNode jsonNode = Json.toJson(new AppSummary(bDVDISBN+" DVD Successfully borrowed by "+bDVDReaderName +"\n " +
                ", Can be used until " + dateTime.getDVDReturnDate(3)+"\t"+ dateTime.getReturnTime()));
        return ok(jsonNode).as("application/json");

    }

    //Method for delete items
    public Result deleteItem() throws SQLException {

        //creating connection
        Statement statement = connection.createStatement();

        //get data from front end as string
        String iSBN = request().body().asText();

        String isbn[];

        isbn = iSBN.split("@");

        String data = isbn[0];

        //SQL statement for delete book
        int deleteBook = statement.executeUpdate("delete from book where bISBN" +
                " = '" + data +"'");

        //if deleteBook query is executed return message
        if(deleteBook > 0){
            JsonNode jsonNode = Json.toJson(new AppSummary("ISBN : "+ data +  " Book successfully deleted"));
            return ok(jsonNode).as("application/json");
        }

        //SQL statement for delete DVD in table
        int deleteDVD = statement.executeUpdate("DELETE from dvd where dISBN" +
                " = '" + data +"'");

        //if deleteDVD query is executed return message
        if (deleteDVD > 0){
           JsonNode jsonNode = Json.toJson(new AppSummary(data + " DVD successfully deleted"));
           return ok(jsonNode).as("application/json");

       }else{
           JsonNode jsonNode = Json.toJson(new AppSummary(data + " delete failed \n Please enter valid ISBN"));
           return ok(jsonNode).as("application/json");
       }
    }

    //Method for display books
    public Result displayBook() throws SQLException {

        //creating connection
        Statement statement = connection.createStatement();

        //create array list for store book details
        ArrayList<Book> bookList = new ArrayList<>();

        //SQL query for get details from database
        String query = "select * from book;";
        ResultSet rs = statement.executeQuery(query);

        while(rs.next()) {
            Book bTable = new Book(rs.getString("bISBN"), rs.getString("bTitle"), rs.getString("bSector"),
                    rs.getString("bAuthor"), rs.getString("bPublisher"), rs.getString("bPubDAte"),
                    rs.getString("bNumberOFPage"), rs.getString("Availability"));
                    //new Reader(rs.getInt("bBookISBN"),null,null,null);
            bookList.add(bTable);
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        //System.out.println(bookList);
        String jsonObject = gson.toJson(bookList);
        return ok(jsonObject).as("application/json");
    }

    //method for display DVD
    public Result displayDVD() throws SQLException {

        //creating connection
        Statement statement = connection.createStatement();

        //create array list to store DVD details
        ArrayList<DVD> dvdList = new ArrayList<>();

        //SQL query for get DVD details from database
        String query = "select * from dvd;";
        ResultSet rs = statement.executeQuery(query);

        while(rs.next()) {
            DVD dTable = new DVD(rs.getString("dISBN"), rs.getString("dTitle"), rs.getString("dSector"),
                    rs.getString("dLanguages"),rs.getString("dSub"), rs.getString("dProduser"), rs.getString("dActor"),
                    rs.getString("Availability"));
            dvdList.add(dTable);
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        //returning arrayList to front end
        String jsonObject = gson.toJson(dvdList);
        return ok(jsonObject).as("application/json");

    }

    //method for generate report
    public Result generateReport() throws SQLException {

        //creating connection
        Statement statement = connection.createStatement();

        //create Array list for store report details
        ArrayList<Report> report = new ArrayList<>();

        String query = "select * from borrowbook;";
        ResultSet rs = statement.executeQuery(query);

        while(rs.next()) {
            Report rTable = new Report(rs.getString("bBookIsbn"), rs.getString("bBookReaderName"), rs.getString("bBookDate")
            , rs.getString("returnDate"), rs.getString("bBookTime"));
            //new Reader(rs.getInt("bBookISBN"),null,null,null);
            report.add(rTable);
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        //returning arrayList to front end
        String jsonObject = gson.toJson(report);
        return ok(jsonObject).as("application/json");


    }

    //method for ad reader
    public Result addReader() throws SQLException {

        //get data from front end as string
        String readerData = request().body().asText();

        //create string array
        String[]readerDetails;

        //split and store front end data in an array
        readerDetails = readerData.split("@");
        String rId = readerDetails[0];
        String rName = readerDetails[1];
        String rMobile = readerDetails[2];
        String rEmail =  readerDetails[3];

        int id = Integer.parseInt(rId);
        Reader r1 = new Reader(id,rName,rMobile,rEmail);
        readers.add(r1);

        //creating connection
        Statement statement = connection.createStatement();

        //SQL query for insert details to database
        try {
            statement.executeUpdate("INSERT INTO readers (rId,rName,rMobile,rEmail)" +
                    " values('" + rId + "','" + rName + "','" + rMobile + "','" + rEmail+ "')");
        } catch (SQLException e) {
            JsonNode jsonNode = Json.toJson(new AppSummary("Reader added Failed"));
            return ok(jsonNode).as("application/json");
        }

        JsonNode jsonNode = Json.toJson(new AppSummary("New Reader successfully added"));
        return ok(jsonNode).as("application/json");

    }

    //method for return item
    public Result returnItem() throws SQLException {

        Statement statement = connection.createStatement();

        //get data from front end as string
        String data = request().body().asText();

        //create string array
        String returnDetails[];

        //split and store front end data in an array
        returnDetails = data.split("@");
        String rISBN = returnDetails[0];
        String rDate = returnDetails[1];
        String rTime = returnDetails[2];

        String status = "Available";


        //split and store date in an array
        String[]dateDetails = rDate.split("-");

        int year = Integer.parseInt(dateDetails[0]);
        int month = Integer.parseInt(dateDetails[1]);
        int date = Integer.parseInt(dateDetails[2]);

        String[]timeDetails = rTime.split(":");

        int hours = Integer.parseInt(timeDetails[0]);
        int minute = Integer.parseInt(timeDetails[1]);

        int bookDueDate = 0;
        int bookFineDate = 0;

            String query = "select * from borrowbook WHERE bBookISBN = '" + rISBN + "'";
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                String dueDAte = rs.getString("returnDate");
                //System.out.println(dueDAte);
                String[] dueDateDetails = dueDAte.split("-");

                bookDueDate = Integer.parseInt(dueDateDetails[2]);
            }

            if(bookDueDate == 0){
                JsonNode jsonNode = Json.toJson(new AppSummary(rISBN + " returned failed \n Please enter valid ISBN"));
                return ok(jsonNode).as("application/json");
        }
        System.out.println(bookDueDate);

        bookFineDate = date - bookDueDate;
        System.out.println(bookFineDate);

        DateTime dateTime = new DateTime(date,month,year,hours,minute);

        if(bookFineDate>0){
            System.out.println("£ "+dateTime.getFine(bookFineDate));
            statement.executeUpdate("delete from borrowbook where bBookISBN" +
                    " = '" + rISBN + "'");
            statement.executeUpdate("UPDATE book SET Availability = '"+status+"' WHERE bISBN = '"+rISBN+"'");
            JsonNode jsonNode = Json.toJson(new AppSummary("Your item return late "+ bookFineDate +" days.Your fine is" +
                    " £ "+dateTime.getFine(bookFineDate)));
            return ok(jsonNode).as("application/json");
        }

        else if(bookFineDate<0){
            //SQL statement for delete book in table
            int deleteBook = statement.executeUpdate("delete from borrowbook where bBookISBN" +
                    " = '" + rISBN + "'");

            //if deleteBook query is executed return message
            if (deleteBook > 0){
                statement.executeUpdate("UPDATE book SET Availability = '"+status+"' WHERE bISBN = '"+rISBN+"'");
                JsonNode jsonNode = Json.toJson(new AppSummary("ISBN : "+ rISBN +  " Book successfully returned"));
                return ok(jsonNode).as("application/json");
            }
        }

        //SQL statement for delete DVD in table
        int deleteDVD = statement.executeUpdate("DELETE from borrowdvd where bDVDISBN" +
                " = '" + rISBN +"'");


        //if deleteDVD query is executed return message
        if (deleteDVD > 0){
            statement.executeUpdate("UPDATE dvd SET Availability = '"+status+"' WHERE dISBN = '"+rISBN+"'");
            JsonNode jsonNode = Json.toJson(new AppSummary(rISBN + " DVD successfully returned"));
            return ok(jsonNode).as("application/json");

        }else {
            JsonNode jsonNode = Json.toJson(new AppSummary(rISBN + " returned failed \n Please enter valid ISBN"));
            return ok(jsonNode).as("application/json");
        }

    }

    //create method for post DVD count to front end
    public Result postDVD() throws SQLException {

        //create connection
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        Statement statement = connection.createStatement();

        ArrayList<DVD> dvdList = new ArrayList<>();

        String query = "select * from dvd;";
        ResultSet rs = statement.executeQuery(query);

        while(rs.next()) {
            DVD dTable = new DVD(rs.getString("dISBN"), rs.getString("dTitle"), rs.getString("dSector"),
                    rs.getString("dLanguages"),rs.getString("dSub"), rs.getString("dProduser"), rs.getString("dActor"),
                    rs.getString("Availability"));
            dvdList.add(dTable);
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String jsonObject = gson.toJson(dvdList.size());

        JsonNode jsonNode = Json.toJson(new AppSummary(jsonObject));
        return ok(jsonNode).as("application/json");
    }

    //create method for post Book count to front end
    public Result postBook() throws SQLException {

        //create connection
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        Statement statement = connection.createStatement();

        ArrayList<Book> bookList = new ArrayList<>();

        String query = "select * from book;";
        ResultSet rs = statement.executeQuery(query);

        while(rs.next()) {
            Book bTable = new Book(rs.getString("bISBN"), rs.getString("bTitle"), rs.getString("bSector"),
                    rs.getString("bAuthor"), rs.getString("bPublisher"), rs.getString("bPubDAte"),
                    rs.getString("bNumberOFPage"), rs.getString("Availability"));
            bookList.add(bTable);
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String jsonObject = gson.toJson(bookList.size());

        JsonNode jsonNode = Json.toJson(new AppSummary(jsonObject));
        return ok(jsonNode).as("application/json");

    }

    //Method for search item from database
    public Result searchItem() throws SQLException {

        Statement statement = connection.createStatement();

        String data = request().body().asText();

        String searchDetails[];

        searchDetails = data.split("@");

        String sTitle = searchDetails[0];

        //SQL statement for delete book in table
        ResultSet searchBook = statement.executeQuery("SELECT * from book where bTitle" +
                " = '" + sTitle +"'");

        //if search query is executed return message
        if(searchBook.next()){
            JsonNode jsonNode = Json.toJson(new AppSummary( sTitle +  " Book is Available in library"));
            return ok(jsonNode).as("application/json");
        }

        //SQL statement for search DVD in table
        ResultSet searchDVD = statement.executeQuery("SELECT * from dvd where dTitle" +
                " = '" + sTitle +"'");

        //if searchDVD query is executed return message
        if (searchDVD.next()){
            JsonNode jsonNode = Json.toJson(new AppSummary(sTitle + " DVD is Available in library"));
            return ok(jsonNode).as("application/json");

        }else{
            JsonNode jsonNode = Json.toJson(new AppSummary(sTitle + " Item unavailable in library"));
            return ok(jsonNode).as("application/json");
        }
    }
}