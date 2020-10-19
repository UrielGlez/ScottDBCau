/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * @author Carlos Tomás García Martínez 320605
 * @author Uriel Omar González jimenez 320736
 * @author Alejandro Aguirre Baeza 320646
 */
public class Cl_dept {
    /*
    * department class attributes
    */
    private int deptno;
    private String dname;
    private String loc;

    /*
    * Default constructor
    */
    public Cl_dept() {
    }
    
    /**
    * This is the constructor with multiple params
    * @param deptno is used for save employee id
    * @param dname is used for save employee name
    * @param loc is used for save employee job
    */
    public Cl_dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
    
    /**
    * getter's and setter's block
    */
    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

}
