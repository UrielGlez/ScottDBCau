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
    
    /**
   * This is the main method which create an instance of Cl_connection class
   * @param args Unused.
   * @return Nothing.
   * @exception Exception On connection error.
   */
    public static void main(String[] args) {
        try {
            Cl_connection conn = new Cl_connection();
        } catch (Exception e) {
            System.err.println("Error");
        }
    }
    
}
