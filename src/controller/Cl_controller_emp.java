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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

/**
 * @author Carlos Tomás García Martínez 320605
 * @author Uriel Omar González jimenez 320736
 * @author Alejandro Aguirre Baeza 320646
 */
public class Cl_controller_emp {

    /*
     * Instance from connection class from sql library
     */
    public static Connection connection = null;

    /**
     * Default constructor wich gets a conection instance from Cl_connection 
     * class
     */
    public Cl_controller_emp() {
        if (connection == null) {
            connection = new Cl_connection().getConnection();
        }
    }

    /**
     * This method is used to create a table with the employee data found in the
     * SQL database.
     *
     * @return DefaultTableModel This returns a table model with the employees
     * data
     */
    public DefaultTableModel listEmp() {
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
            ResultSet rs = ((OracleCallableStatement) cstmt).getCursor(1);

            String data[] = new String[8];
            while (rs.next()) {
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

    /**
     * This method is used to get a specific employee from the SQL database
     *
     * @param empno This is the first paramter wich contains the employee id to
     * find
     * @return ArrayList This returns an array list wich contains the column
     * values of a record
     */
    public ArrayList getEmp(int empno) {
        ArrayList<String> data = new ArrayList<String>();
        try {
            CallableStatement cstmt = connection.prepareCall("{ ? = call FN_show_Emp ( ? )}");
            //IN values
            cstmt.setInt(2, empno);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = ((OracleCallableStatement) cstmt).getCursor(1);

            while (rs.next()) {
                data.add(String.valueOf(rs.getInt("EMPNO")));
                data.add(String.valueOf(rs.getString("ENAME")));
                data.add(String.valueOf(rs.getString("JOB")));
                data.add(String.valueOf(rs.getInt("MGR")));
                data.add(String.valueOf(rs.getDate("HIREDATE")));
                data.add(String.valueOf(rs.getInt("SAL")));
                data.add(String.valueOf(rs.getInt("COMM")));
                data.add(String.valueOf(rs.getInt("DEPTNO")));
            }
            return data;
        } catch (Exception e) {
            data.add("Error");
            data.add("Error");
            data.add("Error");
            data.add("Error");
            data.add("Error");
            data.add("Error");
            data.add("Error");
            data.add("Error");
            return data;
        }
    }

    /**
     * This method is used to insert an employee to be saved within the database
     *
     * @param empno This is the first paramter wich contains the employee id
     * @param ename This is the paramter wich contains the employee name
     * @param job This is the paramter wich contains the employee job
     * @param hiredate This is the paramter wich contains the employee hide date
     * @param managerId This is the paramter wich contains the employee boss
     * @param salary This is the paramter wich contains the employee salary
     * @param commission This is the paramter wich contains the employee
     * commission
     * @param deptno This is the paramter wich contains the employee department
     * id
     * @return a boolean This returns a true if employee was saved successfully
     */
    public boolean insertEmp(int empno, String ename, String job, String hiredate,
            int managerId, int salary, int commission, int deptno) {
        try {
            Date parsedHireDate = new java.sql.Date(((java.util.Date) new SimpleDateFormat("dd/MM/yyyy").parse(hiredate)).getTime());
            CallableStatement cstmt = connection.prepareCall("{ call PR_add_Emp( ? , ? , ? , ? , ? , ? , ? , ? ) }");
            //IN values
            cstmt.setInt(1, empno);
            cstmt.setString(2, ename);
            cstmt.setString(3, job);
            cstmt.setInt(4, managerId);
            cstmt.setDate(5, (java.sql.Date) parsedHireDate);
            cstmt.setInt(6, salary);
            cstmt.setInt(7, commission);
            cstmt.setInt(8, deptno);

            cstmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * This method is used to update an existing employee to be saved within the
     * database
     *
     * @param empno This is the first paramter wich contains the employee id
     * @param newEmpno This is the paramter wich contains the the new employee
     * id
     * @param ename This is the paramter wich contains the employee name
     * @param job This is the paramter wich contains the employee job
     * @param hiredate This is the paramter wich contains the employee hide date
     * @param managerId This is the paramter wich contains the employee boss
     * @param salary This is the paramter wich contains the employee salary
     * @param commission This is the paramter wich contains the employee
     * commission
     * @param deptno This is the paramter wich contains the employee department
     * id
     * @return a boolean This returns a true if employee was updated
     * successfully
     */
    public boolean updateEmp(int empno, int newEmpno, String ename, String job, String hiredate,
            int managerId, int salary, int commission, int deptno) {
        try {
            System.out.println(hiredate);
            Date parsedHireDate = new java.sql.Date(((java.util.Date) new SimpleDateFormat("dd/MM/yyyy").parse(hiredate)).getTime());
            CallableStatement cstmt = connection.prepareCall("{ call PR_update_Emp( ? , ? , ? , ? , ? , ? , ? , ? , ? ) }");
            //IN values
            cstmt.setInt(1, empno);
            cstmt.setInt(2, newEmpno);
            cstmt.setString(3, ename);
            cstmt.setString(4, job);
            cstmt.setInt(5, managerId);
            cstmt.setDate(6, (java.sql.Date) parsedHireDate);
            cstmt.setInt(7, salary);
            cstmt.setInt(8, commission);
            cstmt.setInt(9, deptno);

            cstmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * This method is used to delete an existing employee to be saved within the
     * database
     *
     * @param empno This is the first paramter wich contains the employee id
     * @return a boolean This returns a true if employee was deleted
     * successfully
     */
    public boolean deleteEmp(int empno) {
        try {
            CallableStatement cstmt = connection.prepareCall("{ call PR_delete_Emp( ? )}");
            cstmt.setInt(1, empno);
            cstmt.execute();
            System.out.println("Empleado " + empno + " eliminado");
            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return false;
        }
    }
}
