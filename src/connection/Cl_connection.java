/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cl_connection {

    /*
     * Instance from connection class from sql library
     */
    Connection conn = null;

    /**
     * Default constructor wich call the openConnection method class
     */
    public Cl_connection() {
        openConnection();
    }

    /**
     * This method is used to initialize a sql database connection to CAU
     * connection
     */
    private void openConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cau", "cau");
            if (conn != null) {
                System.out.println("Succsessfully connection to CAU");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error, couldn't connect to CAU");
        }
    }

    /**
     * This method is used to return the connection instance
     * 
     * @return Connection This returns connection intance
     */
    public Connection getConnection() {
        return conn;
    }
    
    /**
     * This method is used to close the connection
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cl_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
