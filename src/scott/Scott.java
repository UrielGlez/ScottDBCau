/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scott;

import connection.Cl_connection;
import java.sql.Connection;
/**
 * @author Carlos Tomás García Martínez 320605
 * @author Uriel Omar González jimenez  320736
 * @author Alejandro Aguirre Baeza      320646
 */
public class Scott {

    public static Connection conecction = null;
    
    public static void main(String[] args) {
        try {
            Cl_connection conn = new Cl_connection();
        } catch (Exception e) {
            System.err.println("Error");
        }
    }
    
}
