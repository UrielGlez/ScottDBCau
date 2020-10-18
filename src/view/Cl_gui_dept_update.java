/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Cl_controller_dept;
import static controller.Cl_controller_dept.connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author carlo
 */
public class Cl_gui_dept_update extends javax.swing.JFrame {

    Cl_controller_dept cdept = new Cl_controller_dept();

    /**
     * Creates new form Cl_gui_update
     */
    public Cl_gui_dept_update() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDeptTittle = new javax.swing.JLabel();
        lblDeptNum = new javax.swing.JLabel();
        lblDeptName = new javax.swing.JLabel();
        lblDeptLoc = new javax.swing.JLabel();
        fldDeptNum = new javax.swing.JTextField();
        fldDeptName = new javax.swing.JTextField();
        fldDeptLoc = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDeptSearch = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        fldDeptNumNew = new javax.swing.JTextField();
        lblDeptNumNew = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDeptTittle.setText("Update Department");

        lblDeptNum.setText("Department number");

        lblDeptName.setText("Department name");

        lblDeptLoc.setText("Department location");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDeptSearch.setText("Buscar");
        btnDeptSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeptSearchActionPerformed(evt);
            }
        });

        lblDeptNumNew.setText("New dept number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(lblDeptTittle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDeptNum)
                                .addComponent(lblDeptName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDeptLoc, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(lblDeptNumNew))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fldDeptName)
                            .addComponent(fldDeptLoc)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fldDeptNum, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(btnDeptSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(fldDeptNumNew)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDeptTittle)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeptNum)
                    .addComponent(fldDeptNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeptSearch))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeptNumNew)
                    .addComponent(fldDeptNumNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeptName)
                    .addComponent(fldDeptName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeptLoc)
                    .addComponent(fldDeptLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeptSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeptSearchActionPerformed
        ArrayList<String> data;
        data = cdept.getDept(Integer.parseInt(fldDeptNum.getText()));
        fldDeptNumNew.setText(data.get(0));
        fldDeptName.setText(data.get(1));
        fldDeptLoc.setText(data.get(2));
    }//GEN-LAST:event_btnDeptSearchActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        cdept.updateDept(Integer.parseInt(fldDeptNum.getText()), Integer.parseInt(fldDeptNumNew.getText()), fldDeptName.getText(), fldDeptLoc.getText());
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cl_gui_dept_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cl_gui_dept_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cl_gui_dept_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cl_gui_dept_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cl_gui_dept_update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeptSearch;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField fldDeptLoc;
    private javax.swing.JTextField fldDeptName;
    private javax.swing.JTextField fldDeptNum;
    private javax.swing.JTextField fldDeptNumNew;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDeptLoc;
    private javax.swing.JLabel lblDeptName;
    private javax.swing.JLabel lblDeptNum;
    private javax.swing.JLabel lblDeptNumNew;
    private javax.swing.JLabel lblDeptTittle;
    // End of variables declaration//GEN-END:variables
}
