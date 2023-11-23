/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SMS;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import static java.awt.event.KeyEvent.VK_DELETE;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bina Computer
 */
public class markEdit extends javax.swing.JFrame {
  Connection con=null;
   Connection con1=null;
    PreparedStatement pst;
    PreparedStatement pst1;
    ResultSet rs;
    ResultSet rs1;
    float fen,fn,fm,fs,fso,fc;
    float pen,pn,pm,ps,pso,pc;
    float total;
    boolean a,b,c,d,e,f;
    String status,engstatus,nepstatus,matstatus,scistatus,socstatus,comstatus;
    
    public markEdit() {
        initComponents();
        classes();
        setTitle("Mark Edit ");
        setResizable(false);
        setLocationRelativeTo(null);
        jButton5.setEnabled(false);
        jButton1.setEnabled(false);
        jButton6.setEnabled(false);
        getMark();
        setSize(850,450);
        setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Bina Computer\\Desktop\\project icon\\sms1.png");    
        setIconImage(icon); 
        jTable1.setBorder(BorderFactory.createLineBorder(Color.black));
        
    }
     public void getMark()
    {
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
         Statement st=con.createStatement();
          rs=st.executeQuery("select fm,pm from subDetail where subject='english'");//where subject='english'");
         while(rs.next())
         {
             fen=Float.parseFloat(rs.getString("fm"));
             pen=Float.parseFloat(rs.getString("pm"));
            
         }
         
        rs=st.executeQuery("select fm,pm from subDetail where subject='nepali'");//where subject='english'");
         while(rs.next())
         {
             fn=Float.parseFloat(rs.getString("fm"));
             pn=Float.parseFloat(rs.getString("pm"));
            
         }
         rs=st.executeQuery("select fm,pm from subDetail where subject='maths'");//where subject='english'");
         while(rs.next())
         {
             fm=Float.parseFloat(rs.getString("fm"));
             pm=Float.parseFloat(rs.getString("pm"));
            
         }
         
         rs=st.executeQuery("select fm,pm from subDetail where subject='science'");//where subject='english'");
         while(rs.next())
         {
             fs=Float.parseFloat(rs.getString("fm"));
             ps=Float.parseFloat(rs.getString("pm"));
            
         }
         
         rs=st.executeQuery("select fm,pm from subDetail where subject='social'");//where subject='english'");
         while(rs.next())
         {
             fso=Float.parseFloat(rs.getString("fm"));
             pso=Float.parseFloat(rs.getString("pm"));
            
         }
         
         rs=st.executeQuery("select fm,pm from subDetail where subject='computer'");//where subject='english'");
         while(rs.next())
         {
             fc=Float.parseFloat(rs.getString("fm"));
             pc=Float.parseFloat(rs.getString("pm"));
            
         }
         //System.out.println("computer passmark="+pc);
         
         total=fen+fn+fm+fs+fso+fc;
         //System.out.println("Total marks is="+total);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(this,"error due to "+e);
        }
       
    }
        public void getRoll()
    {  
        String grade=txtclass.getSelectedItem().toString();
       try
       {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
         pst=con.prepareStatement("select *from personaldetail where class=?");
         pst.setString(1,grade);
         rs=pst.executeQuery();
         txtroll.removeAllItems();
         while(rs.next())
         {
             txtroll.addItem(rs.getString(1));
         }   
         
       }
       
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(this,"error due to "+e);
        }  
        
        

    }
    

    
    public void classes()
    {
    try
    {
    Class.forName("com.mysql.cj.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
    pst=con.prepareStatement("select *from classname");
    rs=pst.executeQuery();
    txtclass.removeAllItems();
    while(rs.next())
    {
    txtclass.addItem(rs.getString(1));
    }
    }
    
    catch(ClassNotFoundException | SQLException e)
    {
    JOptionPane.showMessageDialog(this,"error due to "+e);
    }
    }
    
     private void table_update()
    {
        int c;
        String roll=txtroll.getSelectedItem().toString();
        String grade=txtclass.getSelectedItem().toString();
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
            pst=con.prepareStatement("select *from markdetail where class=? and roll=?");
            pst.setString(1, grade);
            pst.setString(2, roll);
            
            rs=pst.executeQuery();
            ResultSetMetaData rss=rs.getMetaData();
            c=rss.getColumnCount();
            
            DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next())
            {
                Vector v2=new Vector();
                for(int a=1;a<=c;a++)
                {   v2.add(rs.getInt("roll"));
                    v2.add(rs.getString("class"));
                    v2.add(rs.getString("english"));
                    v2.add(rs.getString("nepali"));
                    v2.add(rs.getString("maths"));
                    v2.add(rs.getString("science"));
                    v2.add(rs.getString("social"));
                    v2.add(rs.getString("computer"));
                    v2.add(rs.getString("total"));
                    //v2.add(rs.getString("dob"));
                    
                }
                df.addRow(v2);
                
            }
            
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(staffDetail.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        eng2 = new javax.swing.JTextField();
        nep2 = new javax.swing.JTextField();
        mat2 = new javax.swing.JTextField();
        sci2 = new javax.swing.JTextField();
        soc2 = new javax.swing.JTextField();
        com2 = new javax.swing.JTextField();
        txtroll = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        txtclass = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel18.setText("Nepali");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel19.setText("Maths");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel20.setText("Science");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel21.setText("Social");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel22.setText("English");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel23.setText("Computer");

        eng2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eng2ActionPerformed(evt);
            }
        });
        eng2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                eng2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                eng2KeyTyped(evt);
            }
        });

        nep2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nep2ActionPerformed(evt);
            }
        });
        nep2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nep2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nep2KeyTyped(evt);
            }
        });

        mat2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mat2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mat2KeyTyped(evt);
            }
        });

        sci2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sci2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sci2KeyTyped(evt);
            }
        });

        soc2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                soc2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soc2KeyTyped(evt);
            }
        });

        com2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                com2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eng2)
                    .addComponent(com2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(soc2)
                    .addComponent(sci2)
                    .addComponent(mat2)
                    .addComponent(nep2))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eng2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nep2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sci2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        txtroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtrollMouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Class");

        txtclass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtclassItemStateChanged(evt);
            }
        });
        txtclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclassActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("ROLL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Fetch Data");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Bina Computer\\Desktop\\project icon\\icons8-edit-16.png")); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Bina Computer\\Desktop\\project icon\\icons8-logout-rounded-down-35.png")); // NOI18N
        jButton3.setText("EXIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Bina Computer\\Desktop\\project icon\\icons8-remove-20.png")); // NOI18N
        jButton6.setText("DELETE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Roll", "Class", "Eng.", "Nep.", "Maths.", "Sci.", "Soc.", "Com.", "Tot."
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtclass, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2016, 2016, 2016))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txtclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        boolean a=jTable1.isEditing();
        if(a==false)
        {
            JOptionPane.showMessageDialog(this,"You cant edit the table from here");
        }
        DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
        int selectedIndex=jTable1.getSelectedRow();
        eng2.setText(df.getValueAt(selectedIndex, 2).toString());
        nep2.setText(df.getValueAt(selectedIndex, 3).toString());
        mat2.setText(df.getValueAt(selectedIndex, 4).toString());
        sci2.setText(df.getValueAt(selectedIndex, 5).toString());
        soc2.setText(df.getValueAt(selectedIndex, 6).toString());
        com2.setText(df.getValueAt(selectedIndex, 7).toString());
        String cl=df.getValueAt(selectedIndex,1).toString();
        jButton1.setEnabled(true);
        jButton6.setEnabled(true);
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void eng2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eng2ActionPerformed
        //marksonstraint();
    }//GEN-LAST:event_eng2ActionPerformed

    private void eng2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eng2KeyPressed
      if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE||evt.getKeyChar()==VK_ENTER||evt.getKeyChar()=='a') {
               eng2.setEditable(true);
            } else {
               eng2.setEditable(false);
               JOptionPane.showMessageDialog(this," Mark must be Integer");
               eng2.setEditable(true);
           }         
    }//GEN-LAST:event_eng2KeyPressed

    private void eng2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eng2KeyTyped
        char c=evt.getKeyChar();
        if(c==KeyEvent.VK_ENTER)
        {
            nep2.requestFocus();
        }

    }//GEN-LAST:event_eng2KeyTyped

    private void nep2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nep2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nep2ActionPerformed

    private void nep2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nep2KeyPressed
       if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE||evt.getKeyChar()==VK_ENTER||evt.getKeyChar()=='a') {
               nep2.setEditable(true);
            } else {
               nep2.setEditable(false);
               JOptionPane.showMessageDialog(this," Mark must be Integer");
               nep2.setEditable(true);
           }      
    }//GEN-LAST:event_nep2KeyPressed

    private void nep2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nep2KeyTyped
        char c=evt.getKeyChar();
        if(c==KeyEvent.VK_ENTER)
        {
            mat2.requestFocus();
        }
    }//GEN-LAST:event_nep2KeyTyped

    private void mat2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mat2KeyPressed
            if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE||evt.getKeyChar()==VK_ENTER||evt.getKeyChar()=='a') {
               mat2.setEditable(true);
            } else {
               mat2.setEditable(false);
               JOptionPane.showMessageDialog(this," Mark must be Integer");
               mat2.setEditable(true);
           } 
    }//GEN-LAST:event_mat2KeyPressed

    private void mat2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mat2KeyTyped
        char c=evt.getKeyChar();
        if(c==KeyEvent.VK_ENTER)
        {
            sci2.requestFocus();
        }
    }//GEN-LAST:event_mat2KeyTyped

    private void sci2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sci2KeyPressed
            if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE||evt.getKeyChar()==VK_ENTER||evt.getKeyChar()=='a') {
               sci2.setEditable(true);
            } else {
               sci2.setEditable(false);
               JOptionPane.showMessageDialog(this," Mark must be Integer");
               sci2.setEditable(true);
           } 
    }//GEN-LAST:event_sci2KeyPressed

    private void sci2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sci2KeyTyped
        char c=evt.getKeyChar();
        if(c==KeyEvent.VK_ENTER)
        {
            soc2.requestFocus();
        }
    }//GEN-LAST:event_sci2KeyTyped

    private void soc2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soc2KeyPressed
             if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE||evt.getKeyChar()==VK_ENTER||evt.getKeyChar()=='a') {
               soc2.setEditable(true);
            } else {
               soc2.setEditable(false);
               JOptionPane.showMessageDialog(this," Mark must be Integer");
               soc2.setEditable(true);
           } 
    }//GEN-LAST:event_soc2KeyPressed

    private void soc2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soc2KeyTyped
        char c=evt.getKeyChar();
        if(c==KeyEvent.VK_ENTER)
        {
            com2.requestFocus();
        }
    }//GEN-LAST:event_soc2KeyTyped

    private void com2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_com2KeyPressed
          if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE||evt.getKeyChar()==VK_ENTER||evt.getKeyChar()=='a') {
               com2.setEditable(true);
            } else {
               com2.setEditable(false);
               JOptionPane.showMessageDialog(this," Mark must be Integer");
               com2.setEditable(true);
           } 
    }//GEN-LAST:event_com2KeyPressed

    private void txtrollMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrollMouseClicked

    }//GEN-LAST:event_txtrollMouseClicked

    private void txtclassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtclassItemStateChanged

    }//GEN-LAST:event_txtclassItemStateChanged

    private void txtclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclassActionPerformed

    }//GEN-LAST:event_txtclassActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        getRoll();
        jButton5.setEnabled(true);
       

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        
        
           table_update(); 
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
        int selectedIndex=jTable1.getSelectedRow();
        String grade=txtclass.getSelectedItem().toString();
        int roll=Integer.parseInt(df.getValueAt(selectedIndex,0).toString());
        String en,ne,ma,sc,so,co;
        
        float sum=0;
        float perc;
        int counter=0;
        //Float cen,cne,cma,csc,cso,cco,tot,perc;
        
        
             if(eng2.getText().length()==0||nep2.getText().length()==0||mat2.getText().length()==0||sci2.getText().length()==0||soc2.getText().length()==0||com2.getText().length()==0)
            {
                JOptionPane.showMessageDialog(this,"Enter marks in all field");
            }
        
        if(eng2.getText().startsWith("a")||eng2.getText().startsWith("A")) 
        {
          en="Abs";
          a=false;
          
          
        }
        else
        {
        en=eng2.getText();
        sum=sum+Float.parseFloat(en);
        counter=counter+1;
        a=true;
        
        if(Float.parseFloat(en)>pen)
        {
            engstatus="Pass";
        }
        

        
        }
        
         if(nep2.getText().startsWith("a")||nep2.getText().startsWith("A")) 
        {
          ne="Abs";
          b=false;
        }
        else
        {
        ne=nep2.getText();
        sum=sum+Float.parseFloat(ne);
        counter=counter+1;
        b=true;
      
        if(Float.parseFloat(ne)>pn)
        {
            nepstatus="Pass";
        }
        }
         
        if(mat2.getText().startsWith("a")||mat2.getText().startsWith("A")) 
        {
          ma="Abs";
          c=false;
        }
        else
        {
        ma=mat2.getText();
        sum=sum+Float.parseFloat(ma);
        counter=counter+1;
        c=true;
        
        if(Float.parseFloat(ma)>pm)
        {
            matstatus="Pass";
        }
        }
        
        if(sci2.getText().startsWith("a")||sci2.getText().startsWith("A")) 
        {
          sc="Abs";
          d=false;
        }
        else
        {
         sc=sci2.getText();
         sum=sum+Float.parseFloat(sc);
         counter=counter+1;
         d=true;
        
         if(Float.parseFloat(sc)>ps)
        {
            scistatus="Pass";
        }
        }
        
        if(soc2.getText().startsWith("a")||soc2.getText().startsWith("A")) 
        {
          so="Abs";
          e=false;
        }
        else
        {
        so=soc2.getText();
        sum=sum+Float.parseFloat(so);
        counter=counter+1;
        e=true;
        
        if(Float.parseFloat(so)>pso)
        {
            socstatus="Pass";
        }
        }
        
        if(com2.getText().startsWith("a")||com2.getText().startsWith("A")) 
        {
           co="Abs";
           f=false;
        }
        else
        {
         co=com2.getText();
         sum=sum+Float.parseFloat(co);
         counter=counter+1;
         f=true;
         
         if(Float.parseFloat(co)>pen)
        {
            comstatus="Pass";
        }
        }
        perc=Math.round((sum/total)*100);
        
        if(counter!=6)
        {
            status="Fail";
        }
        else if(engstatus=="Pass" &&nepstatus=="Pass"&&matstatus=="Pass" &&scistatus=="Pass"&&socstatus=="Pass" &&comstatus=="Pass")
        {
            status="Pass";
        }
        else
        {
            status="Fail";
        }
          try
        {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
         if(a==true&&Float.parseFloat(eng2.getText())>fen)
         {
           JOptionPane.showMessageDialog(this,"Marks must be less than or equal");  
         }
         else if(b==true&&Float.parseFloat(nep2.getText())>fn)
         {
           JOptionPane.showMessageDialog(this,"Marks must be less than or equal");  
         }
         else if(c==true&&Float.parseFloat(mat2.getText())>fm)
         {
           JOptionPane.showMessageDialog(this,"Marks must be less than or equal");  
         }
         else if(d==true&&Float.parseFloat(sci2.getText())>fs)
         {
           JOptionPane.showMessageDialog(this,"Marks must be less than or equal");  
         }
         else if(e==true&&Float.parseFloat(soc2.getText())>fso)
         {
           JOptionPane.showMessageDialog(this,"Marks must be less than or equal");  
         }
         else if(f==true&&Float.parseFloat(com2.getText())>fc)
         {
           JOptionPane.showMessageDialog(this,"Marks must be less than or equal");  
         }
         else
         {
        pst=con.prepareStatement("update markdetail set english=?,nepali=?,maths=?,science=?,social=?,computer=? ,total=?,status=?,perc=? where roll=? and class=?");     
        // pst=con.prepareStatement("insert into markdetail(roll,class,english,nepali,maths,science,social,computer,total,status,perc)values(?,?,?,?,?,?,?,?,?,?,?)");
         
         pst.setString(1,en);
         pst.setString(2,ne);
         pst.setString(3,ma);
         pst.setString(4,sc);
         pst.setString(5,so);
         pst.setString(6,co);//
         
         pst.setFloat(7, sum);
         pst.setString(8,status);
         pst.setFloat(9, perc);
         pst.setInt(10,roll);
         pst.setString(11,grade);
         
         pst.executeUpdate();
         
 pst.executeUpdate();
         JOptionPane.showMessageDialog(null,"Mark Added....");
         eng2.setText("");
         nep2.setText("");
         mat2.setText("");
         sci2.setText("");
         soc2.setText("");
         com2.setText("");
         table_update();
         }
           
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,"error due to "+ex);
        }
          
        
        
//        float en,ne,maths,sc,so,co,sum,perc;
//        String status;
//        en=Float.parseFloat(eng2.getText());
//        ne=Float.parseFloat(nep2.getText());
//        maths=Float.parseFloat(mat2.getText());
//        sc=Float.parseFloat(sci2.getText());
//        so=Float.parseFloat(soc2.getText());
//        co=Float.parseFloat(com2.getText());
//        
//        if(en>=30&&en<=75 && ne>=30&&ne<=75 &&maths>=30&&maths<=75 &&sc>=30&&sc<=75 &&so>=30&&so<=75 &&co>=30&&co<=75 )
//        {
//            status="Pass";
//        }
//        else
//        {
//            status="Fail";
//        }
//        if(en>=0&&en<=75 && ne>=0&&ne<=75 &&maths>=0&&maths<=75 &&sc>=0&&sc<=75 &&so>=0&&so<=75 &&co>=0&&co<=75 )
//        {
//            sum=en+ne+maths+sc+so+co;
//            perc=(sum/450)*100;
//          try
//        {
//         Class.forName("com.mysql.cj.jdbc.Driver");
//         con=DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
//         pst=con.prepareStatement("update markdetail set english=?,nepali=?,maths=?,science=?,social=?,computer=? ,total=?,status=?,perc=? where roll=? and class=?");
//         pst.setFloat(1,en);
//         pst.setFloat(2,ne);
//         pst.setFloat(3,maths);
//         pst.setFloat(4,sc);
//         pst.setFloat(5,so);
//         pst.setFloat(6,co);
//         pst.setFloat(7, sum);
//         pst.setString(8,status);
//         pst.setFloat(9, perc);
//         pst.setInt(10, roll);
//         pst.setString(11, grade);
//         
//         pst.executeUpdate();
//         JOptionPane.showMessageDialog(null,"Mark Updated successfully...");
//          table_update();
//         eng2.setText("");
//         nep2.setText("");
//         mat2.setText("");
//         sci2.setText("");
//         soc2.setText("");
//         com2.setText("");
//           
//        }
//        catch(Exception ex)
//        {
//            JOptionPane.showMessageDialog(this,"error due to "+ex);
//        }
//          
//        jButton1.setEnabled(false);
//        jButton6.setEnabled(false);
//        }
//        else
//        {
//            
//          JOptionPane.showMessageDialog(this,"please Enter vlaid marks");
//        
//        }

                
               
           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       String grade=txtclass.getSelectedItem().toString();
        DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
       int selectedIndex=jTable1.getSelectedRow(); 
       
         try {
            int dialogResult=JOptionPane.showConfirmDialog(null,"Do you want to Delete the Record?","Warning",JOptionPane.YES_NO_OPTION);
            int id=Integer.parseInt(df.getValueAt(selectedIndex,0).toString());
            if(dialogResult==JOptionPane.YES_OPTION)
            {
              Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
            pst=con.prepareStatement("delete from markdetail where roll=? and class=?");
            
            pst.setInt(1, id);
            pst.setString(2,grade);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Deleted successfully");
            table_update();
            
            eng2.setText("");
            nep2.setText("");
            mat2.setText("");
            sci2.setText("");
            soc2.setText("");
            com2.setText("");
            
            }   
            
          jButton1.setEnabled(false);
        jButton6.setEnabled(false); 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(staffDetail.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(markEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(markEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(markEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(markEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new markEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField com2;
    private javax.swing.JTextField eng2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField mat2;
    private javax.swing.JTextField nep2;
    private javax.swing.JTextField sci2;
    private javax.swing.JTextField soc2;
    private javax.swing.JComboBox<String> txtclass;
    private javax.swing.JComboBox<String> txtroll;
    // End of variables declaration//GEN-END:variables
}
