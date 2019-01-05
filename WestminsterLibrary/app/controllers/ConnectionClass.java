package controllers;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    private static Connection connection;
    //Method for get Connection
    public static Connection getConnection() {
        //Variables
        String dbName="westlibrary";
        String userName="root";
        String password="";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

}
