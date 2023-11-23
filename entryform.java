package SMS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Bina Computer
 */

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import static java.awt.event.KeyEvent.VK_DELETE;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class entryform extends javax.swing.JFrame {
    Connection con=null;
    PreparedStatement pst;
    PreparedStatement pst1;
    ResultSet rs;
    
    public entryform() {
        initComponents();
        setTitle("Registration Form");
        classes();
        setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Bina Computer\\Desktop\\project icon\\sms1.png");    
        setIconImage(icon);  
        
        
        
    }

    public void classes()
    {
    try
    {
    Class.forName("com.mysql.cj.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
    pst1=con.prepareStatement("select *from classname");
    rs=pst1.executeQuery();
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfn = new javax.swing.JTextField();
        tfm = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        n = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        ph = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        troll = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtclass = new javax.swing.JComboBox<>();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Data Entry Form");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setText("First Name");

        tn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnActionPerformed(evt);
            }
        });
        tn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tnKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setText("Last Name");

        tl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tlKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setText("Class");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setText("Father's name");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setText("Mother's name");

        tfn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfnKeyTyped(evt);
            }
        });

        tfm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfmKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setText("Nationality");

        n.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nepalese", "Indian", "Chinese", "Srilankan" }));
        n.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nItemStateChanged(evt);
            }
        });
        n.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nMouseReleased(evt);
            }
        });
        n.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel8.setText("Phone number");

        ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel9.setText("Address");

        ad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                adKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel10.setText("Gender");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jRadioButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jRadioButton1KeyTyped(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        jRadioButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jRadioButton2KeyTyped(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Other");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });
        jRadioButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jRadioButton3KeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel11.setText("Roll No");

        troll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trollActionPerformed(evt);
            }
        });
        troll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                trollKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                trollKeyTyped(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Bina Computer\\Desktop\\project icon\\icons8-logout-rounded-down-30.png")); // NOI18N
        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Bina Computer\\Desktop\\project icon\\icons8-add-new-30.png")); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jButton1)
                .addGap(89, 89, 89)
                .addComponent(jButton2)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel12.setText("Date of Birth");

        txtclass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        txtclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tn)
                                        .addComponent(tl)
                                        .addComponent(tfn)
                                        .addComponent(tfm)
                                        .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ph)
                                        .addComponent(ad, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(troll, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtclass, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(troll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   if(tn.getText().length()==0)
     {
         JOptionPane.showMessageDialog(this,"Please Type the first Name");
     }
     else if(tl.getText().length()==0)
     {
         JOptionPane.showMessageDialog(this,"Please Type the last name");
     }
       else if(tfn.getText().length()==0)
     {
         JOptionPane.showMessageDialog(this,"Please Enter Father's name");
     }
         else if(tfm.getText().length()==0)
     {
         JOptionPane.showMessageDialog(this,"Please enter mother's name");
     }
       else if(ph.getText().length()==0)
     {
         JOptionPane.showMessageDialog(this,"please Enter phone number");
     }
       
       else if(ad.getText().length()==0)
     {
         JOptionPane.showMessageDialog(this,"Please Enter Address");
     }

     else 
       {
                int roll=Integer.parseInt(troll.getText());
                String fname=tn.getText();
                String lname=tl.getText();
                
                String father=tfn.getText();
                String mother=tfm.getText();
                String nationality=n.getSelectedItem().toString();
                String phone=ph.getText();
                String address=ad.getText();
                
                String gender;
                 if(jRadioButton1.isSelected())
                    {
                        gender="Male";
                    }
                 else if(jRadioButton2.isSelected())
                    {
                        gender="Female";
                    }
                 else
                    {
                        gender="Other";
                    }
                SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
                String dte=sdf.format(jDateChooser3.getDate());
                 
                String grade=txtclass.getSelectedItem().toString();
               
                   try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
                    String sql="insert into personaldetail(roll,firstname,lastname,fathersname,mothersname,nationality,phone,address,gender,dob,class)values(?,?,?,?,?,?,?,?,?,?,?)";
                    pst=con.prepareStatement(sql);
                    pst.setInt(1,roll);
                    pst.setString(2,fname);
                    pst.setString(3,lname);
                    
                    pst.setString(4,father);
                    pst.setString(5,mother);
                    pst.setString(6,nationality);
                    pst.setString(7,phone);
                    pst.setString(8,address);
                    pst.setString(9,gender);
                    pst.setString(10,dte);
                    pst.setString(11,grade);
                    
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this,"data inserted successfully");
                    tn.setText("");
                    tl.setText("");
                   tfn.setText("");
                   txtclass.setSelectedIndex(-1);
                   ph.setText("");
                   ad.setText("");
                    tfn.setText("");
                    tfm.setText("");
                    troll.setText("");
                    sdf.setCalendar(null);
                    tn.requestFocus();
                    classes();

                }  
                catch(HeadlessException | ClassNotFoundException | SQLException e)
                {
                    JOptionPane.showMessageDialog(this,"error due to "+e);
                }  
                
               
                  
         }

    
                        
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void phKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phKeyReleased
      
    }//GEN-LAST:event_phKeyReleased

    private void phKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phKeyPressed
        String phone=ph.getText();
        int len=phone.length();
        char c=evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
        if(len<10)
        {
        ph.setEditable(true);
        }
        else
        {
        ph.setEditable(false);
        JOptionPane.showMessageDialog(this,"please enter valid phone number");
        }
        }
        else
        {
        if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
        {
     if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE) {
               troll.setEditable(true);
            } else {
               troll.setEditable(false);
               JOptionPane.showMessageDialog(this,"Roll number must be Integer");
                troll.setEditable(true);
            }   ph.setEditable(true);
        }
        else
        {
        ph.setEditable(false);
        }
        }
    }//GEN-LAST:event_phKeyPressed

    private void trollKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trollKeyPressed
       
            if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE) {
               troll.setEditable(true);
            } else {
               troll.setEditable(false);
               //JOptionPane.showMessageDialog(this,"Roll number must be Integer");
                troll.setEditable(true);
            }   
            
            if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            {
                 if(tn.getText().length()==0)
     {
         JOptionPane.showMessageDialog(this,"Please Type the first Name");
     }
     else if(tl.getText().length()==0)
     {
         JOptionPane.showMessageDialog(this,"Please Type the last name");
     }
       else if(tfn.getText().length()==0)
     {
         JOptionPane.showMessageDialog(this,"Please Enter Father's name");
     }
         else if(tfm.getText().length()==0)
     {
         JOptionPane.showMessageDialog(this,"Please enter mother's name");
     }
       else if(ph.getText().length()==0)
     {
         JOptionPane.showMessageDialog(this,"please Enter phone number");
     }
       
       else if(ad.getText().length()==0)
     {
         JOptionPane.showMessageDialog(this,"Please Enter Address");
     }

     else 
       {
                int roll=Integer.parseInt(troll.getText());
                String fname=tn.getText();
                String lname=tl.getText();
                
                String father=tfn.getText();
                String mother=tfm.getText();
                String nationality=n.getSelectedItem().toString();
                String phone=ph.getText();
                String address=ad.getText();
                
                String gender;
                 if(jRadioButton1.isSelected())
                    {
                        gender="Male";
                    }
                 else if(jRadioButton2.isSelected())
                    {
                        gender="Female";
                    }
                 else
                    {
                        gender="Other";
                    }
                SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
                String dte=sdf.format(jDateChooser3.getDate());
                 
                String grade=txtclass.getSelectedItem().toString();
               
                   try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
                    String sql="insert into personaldetail(roll,firstname,lastname,fathersname,mothersname,nationality,phone,address,gender,dob,class)values(?,?,?,?,?,?,?,?,?,?,?)";
                    pst=con.prepareStatement(sql);
                    pst.setInt(1,roll);
                    pst.setString(2,fname);
                    pst.setString(3,lname);
                    
                    pst.setString(4,father);
                    pst.setString(5,mother);
                    pst.setString(6,nationality);
                    pst.setString(7,phone);
                    pst.setString(8,address);
                    pst.setString(9,gender);
                    pst.setString(10,dte);
                    pst.setString(11,grade);
                    
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this,"data inserted successfully");
                    tn.setText("");
                    tl.setText("");
                   tfn.setText("");
                   txtclass.setSelectedIndex(-1);
                   ph.setText("");
                   ad.setText("");
                    tfn.setText("");
                    tfm.setText("");
                    troll.setText("");
                    sdf.setCalendar(null);
                    tn.requestFocus();
                    classes();

                }  
                catch(HeadlessException | ClassNotFoundException | SQLException e)
                {
                    JOptionPane.showMessageDialog(this,"error due to "+e);
                }  
                
               
                  
         }
            }
    }//GEN-LAST:event_trollKeyPressed

    private void trollKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trollKeyTyped
        /*  char c=evt.getKeyChar();
        int r=Character.getNumericValue(c);
        
        if(!Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))
        {
        
        
        evt.consume();
        if(r>30)
        {
        evt.consume();
        }
        //JOptionPane.showMessageDialog(this,"Roll number must be between 1-30");
        
        
        }*/
    }//GEN-LAST:event_trollKeyTyped

    private void tnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
         if(c==KeyEvent.VK_ENTER)
         {
             tl.requestFocus();
         }
         
         if(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))
         {
            evt.consume();
           
         }
    }//GEN-LAST:event_tnKeyTyped

    private void tlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tlKeyTyped
         char c=evt.getKeyChar();
         if(c==KeyEvent.VK_ENTER)
         {
             txtclass.requestFocus();
         }
         
         if(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))
         {
            evt.consume();
           
         }        // TODO add your handling code here:
    }//GEN-LAST:event_tlKeyTyped

    private void tfnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfnKeyTyped
     char c=evt.getKeyChar();
     if(c==KeyEvent.VK_ENTER)
     {
         tfm.requestFocus();
     }
         
         if(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))
         {
            evt.consume();
           
         }        // TODO add your handling code here:
    }//GEN-LAST:event_tfnKeyTyped

    private void tfmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfmKeyTyped
         char c=evt.getKeyChar();
         if(c==KeyEvent.VK_ENTER)
         {
             n.requestFocus();
         }
         
         if(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))
         {
            evt.consume();
           
         }        // TODO add your handling code here:
    }//GEN-LAST:event_tfmKeyTyped

    private void adKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adKeyTyped
     char c=evt.getKeyChar();
        if(c==KeyEvent.VK_ENTER)
        {
            jRadioButton1.requestFocus();
        }
         
         if(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))
         {
            evt.consume();
           
         }        // TODO add your handling code here:
    }//GEN-LAST:event_adKeyTyped

    private void trollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trollActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trollActionPerformed

    private void nKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nKeyTyped
                char c=evt.getKeyChar();
        if(c==KeyEvent.VK_ENTER)
        {
            ph.requestFocus();
        }
    }//GEN-LAST:event_nKeyTyped

    private void phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phKeyTyped
        char c=evt.getKeyChar();
        if(c==KeyEvent.VK_ENTER)
        {
            ad.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_phKeyTyped

    private void jRadioButton1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton1KeyTyped
        char c=evt.getKeyChar();
        if(c==KeyEvent.VK_ENTER)
        {
            troll.requestFocus();
        }
    }//GEN-LAST:event_jRadioButton1KeyTyped

    private void jRadioButton2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton2KeyTyped
        char c=evt.getKeyChar();
        if(c==KeyEvent.VK_ENTER)
        {
            troll.requestFocus();
        }
    }//GEN-LAST:event_jRadioButton2KeyTyped

    private void jRadioButton3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton3KeyTyped
        char c=evt.getKeyChar();
        if(c==KeyEvent.VK_ENTER)
        {
            troll.requestFocus();
        }
    }//GEN-LAST:event_jRadioButton3KeyTyped

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        JOptionPane.showMessageDialog(this,"Male Selected");
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
         JOptionPane.showMessageDialog(this,"Female Selected");
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
         JOptionPane.showMessageDialog(this,"Other Selected");
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void nMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nMouseClicked
       
    }//GEN-LAST:event_nMouseClicked

    private void nMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_nMouseEntered

    private void nMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nMousePressed

    private void nMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nMouseReleased
       // TODO add your handling code here:
    }//GEN-LAST:event_nMouseReleased

    private void nItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nItemStateChanged
    String a=n.getSelectedItem().toString();
    JOptionPane.showMessageDialog(this,"Selected country is "+a);          // TODO add your handling code here:
    }//GEN-LAST:event_nItemStateChanged

    private void txtclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclassActionPerformed

    private void tnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new entryform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ad;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JComboBox<String> n;
    private javax.swing.JTextField ph;
    private javax.swing.JTextField tfm;
    private javax.swing.JTextField tfn;
    private javax.swing.JTextField tl;
    private javax.swing.JTextField tn;
    private javax.swing.JTextField troll;
    private javax.swing.JComboBox<String> txtclass;
    // End of variables declaration//GEN-END:variables

    private boolean range(int r, int top, int bot) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
