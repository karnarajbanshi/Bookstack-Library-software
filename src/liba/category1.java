/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karnarajbanshi
 */
public final class category1 extends javax.swing.JFrame {

    /**
     * Creates new form category
     */
    public category1() {
        initComponents();
        Connect();
        table_update();
    }
Connection con;
PreparedStatement pst;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtcat = new javax.swing.JTextField();
        txtsubcategory = new javax.swing.JComboBox<>();
        addcat = new javax.swing.JButton();
        jButton_edit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Book Category");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true), "Category", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Nova Light", 1, 14), new java.awt.Color(102, 0, 255))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_category_16.png"))); // NOI18N
        jLabel9.setText("Category");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_toggle_indeterminate_16.png"))); // NOI18N
        jLabel10.setText("Sub-category");

        txtcat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtsubcategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsubcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Story", "Poem", "Novel", "Autobiography", "Biography", "Magazine", "Journal", "IT", "Engineering", "Atlas", "Finance", "Economics", "Politics", "Law", "Jokes", "Satire", "Humor", "Tragredy", "thriller", "horror", "suspense ", "drama", "music", " ", " " }));

        addcat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addcat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_add_32.png"))); // NOI18N
        addcat.setText("ADD");
        addcat.setToolTipText("ADD CATEGORY");
        addcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcatActionPerformed(evt);
            }
        });

        jButton_edit.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jButton_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_edit_32.png"))); // NOI18N
        jButton_edit.setText("EDIT");
        jButton_edit.setToolTipText("EDIT CATEGORY");
        jButton_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_minus_32.png"))); // NOI18N
        jButton3.setText("DELETE");
        jButton3.setToolTipText("DELETE CATEGORY");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Category", "Sub_category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_cancel_32.png"))); // NOI18N
        jButton4.setText("CANCEL");
        jButton4.setToolTipText("CANCEL OPERATION");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtsubcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcat, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(addcat, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_edit)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtsubcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addcat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 36, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial Nova Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_category_128.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setAutoscrolls(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CATEGORY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slibr","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(category1.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }
    
    
    
    
     private void table_update()
    {
       
            int c;
            try {
               
                 pst = con.prepareStatement("select * from category");
                 ResultSet rs = pst.executeQuery();
                 
                 ResultSetMetaData rsd = rs.getMetaData();
                 c = rsd.getColumnCount();
                 
                 DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
                 d.setRowCount(0);
                                 
                 while(rs.next())
                 {
                     Vector v2 = new Vector();
                     
                     for(int i=1; i<=c; i++)
                     {
                         v2.add(rs.getString("id"));
                         v2.add(rs.getString("category"));
                         v2.add(rs.getString("subcategory"));                         
                     }             
                     d.addRow(v2);
                     
                 }
  
                
         
                 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(category1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
    private void addcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcatActionPerformed
        // TODO add your handling code here:

        String category = txtcat.getText();
        String subcategory = txtsubcategory.getSelectedItem().toString();

     
      
          
        try {
            pst = con.prepareStatement("insert into category(category,subcategory)values(?,?) ");
             pst.setString(1, category);
            pst.setString(2, subcategory);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Category Added");
            table_update();
            txtcat.setText("");
            txtsubcategory.setSelectedIndex(-1);
            txtcat.requestFocus();
            
        } catch (SQLException ex) {
            Logger.getLogger(category1.class.getName()).log(Level.SEVERE, null, ex);
        }
           
         

    }//GEN-LAST:event_addcatActionPerformed

    private void jButton_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        String category = txtcat.getText();
        String subcategory = txtsubcategory.getSelectedItem().toString();

        try {
           
            pst = con.prepareStatement("update category set category=?,subcategory=? where id= ?");
            pst.setString(1, category);
            pst.setString(2, subcategory);
            pst.setInt(3, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Category Updated");
            table_update();
            txtcat.setText("");
            txtsubcategory.setSelectedIndex(-1);
            txtcat.requestFocus();
            addcat.setEnabled(true);

        } 
        catch (SQLException ex) {
            Logger.getLogger(category1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton_editActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the Record","Warning",JOptionPane.YES_NO_OPTION);

        if(dialogResult == JOptionPane.YES_OPTION)
        {
          
            try {
                pst = con.prepareStatement("delete from category where id =?");
                  pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Category Deleted");
                table_update();
                txtcat.setText("");
                txtsubcategory.setSelectedIndex(-1);
                txtcat.requestFocus();
            } catch (SQLException ex) {
                Logger.getLogger(category1.class.getName()).log(Level.SEVERE, null, ex);
            }
              

         

        }
       addcat.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        txtcat.setText(d1.getValueAt(selectIndex, 1).toString());
        txtsubcategory.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
        
        addcat.setEnabled(false);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(category1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(category1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(category1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(category1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new category1().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addcat;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcat;
    private javax.swing.JComboBox<String> txtsubcategory;
    // End of variables declaration//GEN-END:variables

    void setvisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
