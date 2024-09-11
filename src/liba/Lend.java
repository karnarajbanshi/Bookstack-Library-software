/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liba;

//import com.sun.glass.events.KeyEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karnarajbanshi
 */
public final class Lend extends javax.swing.JFrame {

    /**
     * Creates new form Book
     */
    public Lend() {
        initComponents();
        Connect();

        Book();

        table_update();
    }
    Connection con;
    PreparedStatement pst;

    public class BookItem {

        int id;
        String name;

        public BookItem(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    @SuppressWarnings("unchecked")

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/slibr", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Book() {

        try {

            pst = con.prepareStatement("select * from book");
            ResultSet rs = pst.executeQuery();
            txtbook.removeAllItems();

            while (rs.next()) {
                txtbook.addItem(new BookItem(rs.getInt(1), rs.getString(3)));    // because in our database table 1 index has id and 3 has bname
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void table_update() {

        int c;
        try {

            pst = con.prepareStatement("SELECT l.id,m.name,b.bname,l.issuedate,l.returndate FROM lend l JOIN member m ON l.memberid = m.id JOIN book b ON b.id = l.bookid ");
            ResultSet rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            DefaultTableModel d;
            d = (DefaultTableModel) JTable1.getModel();
            d.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("l.id"));
                    v2.add(rs.getString("m.name"));
                    v2.add(rs.getString("b.bname"));
                    v2.add(rs.getString("l.issuedate"));
                    v2.add(rs.getString("l.returndate"));

                }
                d.addRow(v2);

            }
        } catch (SQLException ex) {
            Logger.getLogger(author.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel_memid = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable1 = new javax.swing.JTable();
        jLabel_book = new javax.swing.JLabel();
        jLabel_issdate = new javax.swing.JLabel();
        jLabel_rtdate = new javax.swing.JLabel();
        txtbook = new javax.swing.JComboBox();
        txtid = new javax.swing.JTextField();
        txttdate = new com.toedter.calendar.JDateChooser();
        txtrdate = new com.toedter.calendar.JDateChooser();
        txtname = new javax.swing.JTextField();
        jLabel_memname = new javax.swing.JLabel();
        jLabel_IssueBook = new javax.swing.JLabel();
        issueBtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lend");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true), "Book", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Nova Light", 1, 14), new java.awt.Color(153, 0, 255))); // NOI18N

        jLabel_memid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_memid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_identification_documents_16.png"))); // NOI18N
        jLabel_memid.setText("Member ID");

        JTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Member ", "Book", "Issue Date", "Return Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(JTable1);

        jLabel_book.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_book.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_book_16.png"))); // NOI18N
        jLabel_book.setText("Book");

        jLabel_issdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_issdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_calendar_16.png"))); // NOI18N
        jLabel_issdate.setText("Date");

        jLabel_rtdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_rtdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_return_16.png"))); // NOI18N
        jLabel_rtdate.setText("Return");

        txtbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbookActionPerformed(evt);
            }
        });

        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidKeyPressed(evt);
            }
        });

        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnameKeyPressed(evt);
            }
        });

        jLabel_memname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_memname.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_user_16.png"))); // NOI18N
        jLabel_memname.setText("Member Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_memid)
                    .addComponent(jLabel_issdate)
                    .addComponent(jLabel_rtdate)
                    .addComponent(jLabel_book)
                    .addComponent(jLabel_memname))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtid)
                    .addComponent(txttdate, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(txtrdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtname)
                    .addComponent(txtbook, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_memid)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_memname))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_book)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtbook)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_issdate)
                    .addComponent(txttdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_rtdate)
                    .addComponent(txtrdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(243, 243, 243))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel_IssueBook.setFont(new java.awt.Font("Arial Nova Light", 0, 36)); // NOI18N
        jLabel_IssueBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_return_book_64.png"))); // NOI18N
        jLabel_IssueBook.setToolTipText("");

        issueBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        issueBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_visa_stamp_32.png"))); // NOI18N
        issueBtn.setText("Issue");
        issueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBtnActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_cancel_32.png"))); // NOI18N
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ISSUE BOOK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(issueBtn)
                        .addGap(68, 68, 68)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(508, 508, 508)
                .addComponent(jLabel_IssueBook)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(476, 476, 476))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_IssueBook)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String id = txtid.getText();

            try {
                pst = con.prepareStatement("select * from member where id=?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(this, "Member ID not Found");
                } else {
                    String productname = rs.getString("name");

                    txtname.setText(productname.trim());

                }
            } catch (SQLException ex) {
                Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_txtidKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void issueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBtnActionPerformed
        // TODO add your handling code here:
        String id = txtid.getText();

        BookItem book = (BookItem) txtbook.getSelectedItem();

        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
        String date = Date_Format.format(txttdate.getDate());

        SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = Date_Format1.format(txtrdate.getDate());

        try {
            pst = con.prepareStatement("insert into lend(memberid,bookid,issuedate,returndate)values(?,?,?,?)");
            pst.setString(1, id);
            pst.setInt(2, book.id);
            pst.setString(3, date);
            pst.setString(4, date1);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Book ISSUED");
            table_update();
            txtid.setText("");
            txtbook.setSelectedIndex(-1);
            txtname.requestFocus();
            table_update();

        } catch (SQLException ex) {
            Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_issueBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyPressed
        // TODO add your handling code here:
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

              String name = txtname.getText();

            try {
                pst = con.prepareStatement("select id from member where name=?");
                pst.setString(1,name);
                ResultSet rs = pst.executeQuery();

                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(this, "Member name not Found");
                } else {
                    String memid = rs.getString("id");

                    txtid.setText(memid);

                }
            } catch (SQLException ex) {
                Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_txtnameKeyPressed

    private void txtbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookActionPerformed

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
            java.util.logging.Logger.getLogger(Lend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> { //lambda expression 
            new Lend().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable1;
    private javax.swing.JButton issueBtn;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_IssueBook;
    private javax.swing.JLabel jLabel_book;
    private javax.swing.JLabel jLabel_issdate;
    private javax.swing.JLabel jLabel_memid;
    private javax.swing.JLabel jLabel_memname;
    private javax.swing.JLabel jLabel_rtdate;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox txtbook;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private com.toedter.calendar.JDateChooser txtrdate;
    private com.toedter.calendar.JDateChooser txttdate;
    // End of variables declaration//GEN-END:variables
}
