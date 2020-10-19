/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;

/**
 *
 * @author Uriel
 */
public class Cl_emp {
    /*
    * employee class attributes
    */
    private int empno;
    private String ename;
    private String job;
    private String mgr;
    private Date hiredate;
    private int salary;
    private int commission;
    private int deptno;
    
    /*
    * Default constructor
    */
    public Cl_emp() { }
    
    /**
    * This is the constructor with multiple params
    * @param empno is used for save employee id
    * @param ename is used for save employee name
    * @param job is used for save employee job
    * @param mgr is used for save employee manager
    * @param hiredate is used for save employee hire date
    * @param salary is used for save employee salary
    * @param commission is used for save employee commission
    * @param deptno is used for save employee department id
    * @exception Exception On connection error.
    */
    public Cl_emp(int empno, String ename, String job, String mgr, Date hiredate, int salary, int commision, int deptno) {
        this.deptno = deptno;
        this.empno = empno;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.salary = salary;
        this.ename = ename;
    }
    
    /**
    * getter's and setter's block
    */
    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMgr() {
        return mgr;
    }

    public void setMgr(String mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
    
}
