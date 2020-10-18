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

    public boolean insertDept() {
        try {
            CallableStatement cstmt = connection.prepareCall("{ ? = call FN_LISTAR_DEPT}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateDept() {
        try {
            CallableStatement cstmt = connection.prepareCall("{ ? = call FN_LISTAR_DEPT}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteDept() {
        try {
            CallableStatement cstmt = connection.prepareCall("{ ? = call FN_LISTAR_DEPT}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
