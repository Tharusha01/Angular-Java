package controllers;

import play.mvc.Result;

import java.sql.SQLException;

interface LibraryManager {

    Result addNewBook() throws SQLException;
    Result addNewDVD() throws SQLException;
    Result addReader() throws SQLException;
    Result borrowBook() throws SQLException;
    Result borrowDVD() throws SQLException;
    Result deleteItem() throws SQLException;
    Result displayBook() throws SQLException;
    Result displayDVD() throws SQLException;
    Result generateReport() throws SQLException;
    Result returnItem() throws SQLException;
    Result searchItem() throws SQLException;
}
