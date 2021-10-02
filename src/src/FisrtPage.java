/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Novel VM
 */
public class FisrtPage extends javax.swing.JFrame {

    /**
     * Creates new form FisrtPage
     */
    public FisrtPage() {
        initComponents();
        refereshTable();
    }
    
    public void refereshTable()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection con=DBConnect.getConnection();
            
            String sql= "SELECT * FROM Movies";
            
            PreparedStatement pst=con.prepareStatement(sql);
            
            ResultSet rs= pst.executeQuery();
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void insertValues()
    {
        String MovieName=movieName.getText();
        String Actor=actor.getText();
        String Actress=actress.getText();
        String YOR=yor.getText();
        String director=dname.getText();
        
        if(MovieName.equals("") || Actor.equals("") || Actress.equals("") || YOR.equals("") || director.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty");
        }
        else
        {
            try
            {
            Class.forName("org.sqlite.JDBC");
            Connection con=DBConnect.getConnection();
            
                String sql="INSERT INTO Movies (MovieName,Actor,Actress,Year,Director) VALUES (?,?,?,?,?)";
            
                PreparedStatement pst=con.prepareStatement(sql);
            
                pst.setString(1,MovieName);
                pst.setString(2,Actor);
                pst.setString(3,Actress);
                pst.setString(4,YOR);
                pst.setString(5,director);
                
            
                pst.executeUpdate();
            
                JOptionPane.showMessageDialog(null, "Inserted Successfully");
            
          
                pst.close();
                con.close();
            
            
                refereshTable();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        movieName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        actor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        actress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        yor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 343, 1098, 360));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel1.setText("Movie Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 21, 129, 32));

        movieName.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        movieName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieNameActionPerformed(evt);
            }
        });
        getContentPane().add(movieName, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 21, 236, 32));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel2.setText("Actor:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 71, -1, -1));

        actor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        actor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actorActionPerformed(evt);
            }
        });
        getContentPane().add(actor, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 72, 236, 32));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel3.setText("Actress:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 80, 32));

        actress.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        actress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actressActionPerformed(evt);
            }
        });
        getContentPane().add(actress, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 122, 236, 32));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel4.setText("Year Of release:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 172, 150, 32));

        yor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        yor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yorActionPerformed(evt);
            }
        });
        getContentPane().add(yor, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 172, 236, 32));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel5.setText("Director Name:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 230, 150, 32));

        dname.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        dname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnameActionPerformed(evt);
            }
        });
        getContentPane().add(dname, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 230, 236, 32));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("INSERT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 150, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void movieNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movieNameActionPerformed

    private void actorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actorActionPerformed

    private void actressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actressActionPerformed

    private void yorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yorActionPerformed

    private void dnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertValues();
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FisrtPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FisrtPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FisrtPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FisrtPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FisrtPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actor;
    private javax.swing.JTextField actress;
    private javax.swing.JTextField dname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField movieName;
    private javax.swing.JTable table;
    private javax.swing.JTextField yor;
    // End of variables declaration//GEN-END:variables
}
