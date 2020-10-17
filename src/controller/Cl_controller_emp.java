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
 * @author Uriel Omar González jimenez  320736
 * @author Alejandro Aguirre Baeza      320646
 */

public class Cl_controller_emp {
        
    public static Connection connection = null;
    public Cl_controller_emp() {
        if (connection == null ) {
            connection = new Cl_connection().getConnection();
        }
    }
    
    public DefaultTableModel listEmp(){
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("Employee id");
            table.addColumn("Name");
            table.addColumn("Job");
            table.addColumn("Manager");
            table.addColumn("Hire date");
            table.addColumn("Salary");
            table.addColumn("Comission");
            table.addColumn("Department");
            
            
            CallableStatement cstmt = connection.prepareCall("{ ? = call FN_LISTAR_EMP}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = ((OracleCallableStatement)cstmt).getCursor(1);
            
            String data[] = new String[8];
            while(rs.next()){
                data[0] = String.valueOf(rs.getInt("EMPNO"));
                data[1] = rs.getString("ENAME");
                data[2] = rs.getString("JOB");
                data[3] = String.valueOf(rs.getInt("MGR"));
                data[4] = String.valueOf(rs.getDate("HIREDATE"));
                data[5] = String.valueOf(rs.getInt("SAL"));
                data[6] = String.valueOf(rs.getInt("COMM"));
                data[7] = String.valueOf(rs.getInt("DEPTNO"));
                
                table.addRow(data);
            }
            return table;
        } catch (Exception e) {
            return null;
        }
    }
}
