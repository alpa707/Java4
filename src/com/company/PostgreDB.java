package com.company;

import com.company.data.interfaces.IDB;

import java.sql.*;

public class PostgreDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/SimpleDB";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "Alpa101p");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}
