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
 * @author kobinath
 */
public final class Book1 extends javax.swing.JFrame {

  
    /**
     * Creates new form Book
     */         
    public Book1() { 
        initComponents();
        Connect();//loading components and integrating
        Author();
        Category();
        Publisher();
        Book_Load();
    }
     Connection con;
    PreparedStatement pst;

    
      public class CategoryItem 
{ 
int id; 
String name; 

public CategoryItem( int id, String name ) 
{ 
this.id = id; 
this.name = name; 
} 

@Override
public String toString() 
{ 
return name; 
} 
}
      
      
   public class Authoritem
{ 
int id; 
String name; 

public Authoritem( int id, String name ) 
{ 
this.id = id; 
this.name = name; 
} 

@Override
public String toString() 
{ 
return name; 
} 
} 
   
   
   public class Publisheritem
{ 
int id; 
String name; 

public Publisheritem( int id, String name ) 
{ 
this.id = id; 
this.name = name; 
} 

@Override
public String toString() 
{ 
return name; 
} 
} 
   
   
   
   
   
   
   
    
    
    @SuppressWarnings("unchecked")
    
    
     public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slibr","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Book1.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        private void Author()
    {

        try {
           
            pst = con.prepareStatement("select * from author");
            ResultSet rs = pst.executeQuery();
            txtauthor.removeAllItems();
            
            while(rs.next())
            {                
                txtauthor.addItem(new Authoritem(rs.getInt(1),rs.getString(2)) );    
            }             
        } 
        catch (SQLException ex) {
            Logger.getLogger(Book1.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
        private void Category()
    {

        try {
          
            pst = con.prepareStatement("select * from category");
            ResultSet rs = pst.executeQuery();
            txtcategory.removeAllItems();
            
            while(rs.next())
            {                
                txtcategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)) );    
            }             
        }  catch (SQLException ex) {
            Logger.getLogger(Book1.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
     private void Publisher()
    {

        try {
           
            pst = con.prepareStatement("select * from publisher");
            ResultSet rs = pst.executeQuery();
            txtpub.removeAllItems();
            
            while(rs.next())
            {                
                txtpub.addItem(new Publisheritem(rs.getInt(1),rs.getString(2)) );    
            }             
        }  catch (SQLException ex) {
            Logger.getLogger(Book1.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
     private void Book_Load() //This part display book table
    {
       
            int c;
            try {
                // b is object of book table and bname is field, c is of category, p for publisher are the new objects created
                 pst = con.prepareStatement("SELECT b.id,b.bname,c.category,a.name,p.name,b.contents,b.pages,b.edition,b.block,b.row FROM book b JOIN category c ON b.category = c.id JOIN author a ON b.author = a.id JOIN publisher p ON b.publisher = p.id");
                 ResultSet rs = pst.executeQuery();
                 
                 ResultSetMetaData rsd = rs.getMetaData();
                 c = rsd.getColumnCount();
                 
                 DefaultTableModel d = (DefaultTableModel)Book_Info.getModel();
                 d.setRowCount(0);
                                 
                 while(rs.next())
                 {
                     Vector v2 = new Vector(); 
                     for(int i=1; i<=c; i++)
                     {
                         v2.add(rs.getString("b.id"));
                         v2.add(rs.getString("b.bname"));
                         v2.add(rs.getString("c.category"));
                         v2.add(rs.getString("a.name"));  
                         v2.add(rs.getString("p.name"));
                         v2.add(rs.getString("b.contents"));  
                         v2.add(rs.getString("b.pages"));
                         v2.add(rs.getString("b.edition")); 
                          v2.add(rs.getString("b.block"));
                         v2.add(rs.getString("b.row"));
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
        jLabel9 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        addBook = new javax.swing.JButton();
        editBook = new javax.swing.JButton();
        deleteBook = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Book_Info = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtcontents = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtcategory = new javax.swing.JComboBox();
        txtauthor = new javax.swing.JComboBox();
        txtpub = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txtpages = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtedition = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtblock = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtrow = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel_addauthor = new javax.swing.JLabel();
        jLabel_addpublisher = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton_refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Books");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 3, true), "Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Nova Light", 1, 14), new java.awt.Color(153, 0, 255))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\colorful icon\\New folder\\icons8_book_16.png")); // NOI18N
        jLabel9.setText("Book Name");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        addBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addBook.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\colorful icon\\New folder\\icons8_add_32.png")); // NOI18N
        addBook.setText("Add");
        addBook.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                addBookComponentMoved(evt);
            }
        });
        addBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookActionPerformed(evt);
            }
        });

        editBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editBook.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\colorful icon\\New folder\\icons8_edit_32.png")); // NOI18N
        editBook.setText("Edit");
        editBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBookActionPerformed(evt);
            }
        });

        deleteBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteBook.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\colorful icon\\New folder\\icons8_minus_32.png")); // NOI18N
        deleteBook.setText("Delete");
        deleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookActionPerformed(evt);
            }
        });

        Book_Info.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        Book_Info.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Book_Info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "BookName", "Category", "Author", "Publisher", "Contents", "No of Pages", "Edition", "Block", "Row"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Book_Info.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Book_Info.setGridColor(new java.awt.Color(255, 255, 255));
        Book_Info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Book_InfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Book_Info);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_category_16.png"))); // NOI18N
        jLabel11.setText("Category");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_terms_and_conditions_16.png"))); // NOI18N
        jLabel12.setText("No of Pages");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_oscar_wilde_16.png"))); // NOI18N
        jLabel13.setText("Author");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_bookshop_16.png"))); // NOI18N
        jLabel14.setText("Publisher");

        txtcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcategoryActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_index_16.png"))); // NOI18N
        jLabel15.setText("Contents");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_versions_16.png"))); // NOI18N
        jLabel16.setText("Edition");

        txtedition.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txteditionFocusGained(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\colorful icon\\New folder\\icons8_cancel_32.png")); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_select_right_column_16.png"))); // NOI18N
        jLabel2.setText("Block ");

        txtblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtblockActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_rows_16.png"))); // NOI18N
        jLabel3.setText("Row");

        txtrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrowActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 255));
        jLabel4.setText("+");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel_addauthor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_addauthor.setForeground(new java.awt.Color(153, 0, 255));
        jLabel_addauthor.setText("+");
        jLabel_addauthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_addauthorMouseClicked(evt);
            }
        });

        jLabel_addpublisher.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_addpublisher.setForeground(new java.awt.Color(153, 0, 255));
        jLabel_addpublisher.setText("+");
        jLabel_addpublisher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_addpublisherMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel15)
                                .addComponent(jLabel14))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(addBook, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtpages, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(txtedition)
                            .addComponent(txtcontents)
                            .addComponent(txtname)
                            .addComponent(txtcategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtpub, 0, 194, Short.MAX_VALUE)
                            .addComponent(txtblock)
                            .addComponent(txtrow)
                            .addComponent(txtauthor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_addauthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel_addpublisher))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(editBook)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBook)
                        .addGap(18, 18, 18)
                        .addComponent(cancel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(txtauthor)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel_addauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtpub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_addpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtcontents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtblock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBook)
                    .addComponent(editBook)
                    .addComponent(deleteBook)
                    .addComponent(cancel))
                .addGap(31, 31, 31))
        );

        jLabel1.setFont(new java.awt.Font("Arial Nova Light", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_book_64.png"))); // NOI18N
        jLabel1.setText("BOOKS");

        jButton_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liba/icons8_refresh_32.png"))); // NOI18N
        jButton_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookActionPerformed
        // TODO add your handling code here:
        String bname = txtname.getText();       
        CategoryItem citem = (CategoryItem) txtcategory.getSelectedItem(); //loading from category table
        
         Authoritem  aitem = (Authoritem) txtauthor.getSelectedItem(); //loading from author table
        
        
        Publisheritem  pitem = (Publisheritem) txtpub.getSelectedItem(); //loading from publisher table
        
        
        String contents = txtcontents.getText(); //input by user
        String pages = txtpages.getText(); 
         String editon = txtedition.getText();
         String block =txtblock.getText();
         String row = txtrow.getText();


        try {
          pst = con.prepareStatement("insert into book(bname,category,author,publisher,contents,pages,edition,block,row)values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, bname); //bname is table field name of db
            pst.setInt(2, citem.id);
            pst.setInt(3, aitem.id);
            pst.setInt(4, pitem.id);
            pst.setString(5, contents);
            pst.setString(6, pages);
            pst.setString(7, editon);
            pst.setString(8,block);
            pst.setString(9,row);
            
           int k= pst.executeUpdate();
            
            if(k==1)
            {
            JOptionPane.showMessageDialog(null,"Book Added Successfully!");
             Book_Load();
            txtname.setText("");
            txtcategory.setSelectedIndex(-1);
            txtauthor.setSelectedIndex(-1);
            txtpub.setSelectedIndex(-1);
            txtcontents.setText("");
            txtpages.setText("");
            txtedition.setText("");
            txtblock.setText("");
            txtrow.setText("");
            }
            else{
                JOptionPane.showMessageDialog(this,"Error");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_addBookActionPerformed

    private void editBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookActionPerformed

        // TODO add your handling code here:
        DefaultTableModel d1;
        d1 = (DefaultTableModel)Book_Info.getModel();
       int selectIndex = Book_Info.getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        String bname = txtname.getText();
         
        CategoryItem citem = (CategoryItem) txtcategory.getSelectedItem(); //loading from category table
        
         Authoritem  aitem = (Authoritem) txtauthor.getSelectedItem(); //loading from author table
        
        
        Publisheritem  pitem = (Publisheritem) txtpub.getSelectedItem(); //loading from publisher table
        
      
        String contents; //input by user
        contents = txtcontents.getText();
        String pages; 
        pages = txtpages.getText();
         String editon;
        editon = txtedition.getText();
         String block;
        block = txtblock.getText();
         String row = txtrow.getText();
         
     try {
          pst = con.prepareStatement("update book set bname=?,category=?,author=?,publisher=?,contents=?,pages=?,edition=?,block=? ,row=? where id=?");
            pst.setString(1, bname); //bname is table field name of db
            pst.setInt(2, citem.id);
            pst.setInt(3, aitem.id);
            pst.setInt(4, pitem.id);
            pst.setString(5, contents);
            pst.setString(6, pages);
            pst.setString(7, editon);
            pst.setString(8,block);
            pst.setString(9,row);
            pst.setInt(10, id);
            
           int k;
            k = pst.executeUpdate();
            
            if(k==1)
            {
            JOptionPane.showMessageDialog(null,"Book updated Successfully!");
             Book_Load();
            txtname.setText("");
            txtcategory.setSelectedIndex(-1);
            txtauthor.setSelectedIndex(-1);
            txtpub.setSelectedIndex(-1);
            txtcontents.setText("");
            txtpages.setText("");
            txtedition.setText("");
            txtblock.setText("");
            txtrow.setText("");
            }
           else{
                JOptionPane.showMessageDialog(this,"Error with the insertion");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_editBookActionPerformed
                          
    private void deleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)Book_Info.getModel();
        int selectIndex = Book_Info.getSelectedRow();

        int id;
        id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

        int dialogResult;
        dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the Record","Warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION)
        {

            try {
                pst = con.prepareStatement("delete from book where id =?");
                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Book Deleted");
                Book_Load();
            txtname.setText("");
            txtcategory.setSelectedIndex(-1);
            txtauthor.setSelectedIndex(-1);
            txtpub.setSelectedIndex(-1);
            txtcontents.setText("");
            txtpages.setText("");
            txtedition.setText("");
            txtblock.setText("");
            txtrow.setText("");

                txtname.requestFocus();

                           } catch (SQLException ex) {
                Logger.getLogger(author.class.getName()).log(Level.SEVERE, null, ex)
                        ;
            }
            addBook.setEnabled(true);

        }
    }//GEN-LAST:event_deleteBookActionPerformed

    private void Book_InfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Book_InfoMouseClicked
        // TODO add your handling code here:
DefaultTableModel d1 = (DefaultTableModel)Book_Info.getModel();
        int selectIndex = Book_Info.getSelectedRow();
// Here clicked on row the field containing the data at clicked row is set to the input fields
        txtname.setText(d1.getValueAt(selectIndex, 1).toString());
        txtcategory.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
        txtauthor.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());  // set Selected Item is used for the drop item selection
        txtpub.setSelectedItem(d1.getValueAt(selectIndex, 4).toString());
        txtcontents.setText(d1.getValueAt(selectIndex, 5).toString());
        txtpages.setText(d1.getValueAt(selectIndex, 6).toString());
        txtedition.setText(d1.getValueAt(selectIndex, 7).toString());
        txtblock.setText(d1.getValueAt(selectIndex, 8).toString());
        txtrow.setText(d1.getValueAt(selectIndex, 9).toString());
        
        addBook.setEnabled(false); // this is set false so that when data from table is clicked it allows updation such as:edit,delete but not insertion
      

    }//GEN-LAST:event_Book_InfoMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcategoryActionPerformed

    private void txtblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtblockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtblockActionPerformed

    private void txtrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrowActionPerformed

    private void addBookComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_addBookComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_addBookComponentMoved

    private void txteditionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txteditionFocusGained
       
    }//GEN-LAST:event_txteditionFocusGained

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        category1 c = new category1();
        c.setVisible(true);

    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel_addauthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_addauthorMouseClicked
        // TODO add your handling code here:
        // this.setVisible(false);
        author b=new author();
        b.setVisible(true);
    }//GEN-LAST:event_jLabel_addauthorMouseClicked

    private void jLabel_addpublisherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_addpublisherMouseClicked
        // TODO add your handling code here:
        Publisher p=new Publisher();
        p.setVisible(true);
        
    }//GEN-LAST:event_jLabel_addpublisherMouseClicked

    private void jButton_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_refreshActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Book1 b=new Book1();
        b.setVisible(true);

    }//GEN-LAST:event_jButton_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(Book1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Book1().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Book_Info;
    private javax.swing.JButton addBook;
    private javax.swing.JButton cancel;
    private javax.swing.JButton deleteBook;
    private javax.swing.JButton editBook;
    private javax.swing.JButton jButton_refresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_addauthor;
    private javax.swing.JLabel jLabel_addpublisher;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox txtauthor;
    private javax.swing.JTextField txtblock;
    private javax.swing.JComboBox txtcategory;
    private javax.swing.JTextField txtcontents;
    private javax.swing.JTextField txtedition;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpages;
    private javax.swing.JComboBox txtpub;
    private javax.swing.JTextField txtrow;
    // End of variables declaration//GEN-END:variables
}
