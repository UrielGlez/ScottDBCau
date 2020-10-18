/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.Cl_connection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

/**
 * @author Carlos Tomás García Martínez 320605
 * @author Uriel Omar González jimenez 320736
 * @author Alejandro Aguirre Baeza 320646
 */
public class Cl_controller_dept {

    public static Connection connection = null;

    public Cl_controller_dept() {
        if (connection == null) {
            connection = new Cl_connection().getConnection();
        }
    }

    public DefaultTableModel listDept() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("Department");
            table.addColumn("Name");
            table.addColumn("Localization");
            CallableStatement cstmt = connection.prepareCall("{ ? = call FN_LISTAR_DEPT}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = ((OracleCallableStatement) cstmt).getCursor(1);

            String data[] = new String[3];
            while (rs.next()) {
                data[0] = String.valueOf(rs.getInt("deptno"));
                data[1] = rs.getString("dname");
                data[2] = rs.getString("loc");

                table.addRow(data);
            }
            return table;
        } catch (Exception e) {
            DefaultTableModel table = new DefaultTableModel();
            String data[] = new String[1];
            data[0] = "Error en la query";
            table.addColumn("Error");
            table.addRow(data);
            return table;
        }
    }

    public boolean insertDept(int depno, String dname, String loc) {
        try {
            CallableStatement cstmt = connection.prepareCall("{ call PR_add_Deptno( ? , ? , ? )}");

            //IN values 
            cstmt.setInt(1, depno);
            cstmt.setString(2, dname);
            cstmt.setString(3, loc);

            cstmt.execute();

            System.out.println("Insertado correctamente");
            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return false;
        }
    }

    public boolean updateDept(int depno, int newdepno, String dname, String loc) {
        try {
            CallableStatement cstmt = connection.prepareCall("{ call PR_update_Deptno ( ? , ? , ? , ? )}");

            cstmt.setInt(1, depno);
            cstmt.setInt(2, newdepno);
            cstmt.setString(3, dname);
            cstmt.setString(4, loc);

            cstmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return false;
        }
    }

    public ArrayList<String> getDept(int depno) {
        ArrayList<String> data = new ArrayList<String>();
        try {
            CallableStatement cstmt = connection.prepareCall("{ ? = call FN_show_Dept ( ? )}");

            //IN data
            cstmt.setInt(2, depno);

            //OUT data
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();

            ResultSet rs = ((OracleCallableStatement) cstmt).getCursor(1);
            while (rs.next()) {
                data.add(String.valueOf(rs.getInt("deptno")));
                data.add(rs.getString("dname"));
                data.add(rs.getString("loc"));
            }
            return data;
        } catch (Exception e) {
            data.add("Error");
            data.add("Error");
            data.add("Error");
            return data;
        }
    }

    public boolean deleteDept(int depno) {
        try {
            CallableStatement cstmt = connection.prepareCall("{ call PR_delete_Deptno( ? )}");
            //cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setInt(1, depno);
            cstmt.execute();
            System.out.println("Department " + depno + " deleted");
            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return false;
        }
    }

}
