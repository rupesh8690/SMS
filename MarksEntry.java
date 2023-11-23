/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SMS;

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
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Bina Computer
 */
public class MarksEntry extends javax.swing.JFrame {

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
        
    public MarksEntry() {
        
        initComponents();

        classes();
        eng.requestFocus();
        setResizable(false);
        setTitle("Marks Entry");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Bina Computer\\Desktop\\project icon\\sms1.png");    
        setIconImage(icon); 
        getMark();
        eng.setEnabled(false);
        nep.setEnabled(false);
        mat.setEnabled(false);
        sci.setEnabled(false);
        soc.setEnabled(false);
        com.setEnabled(false);
        
        
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


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        eng = new javax.swing.JTextField();
        nep = new javax.swing.JTextField();
        mat = new javax.swing.JTextField();
        sci = new javax.swing.JTextField();
        soc = new javax.swing.JTextField();
        com = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtroll = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtclass = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel9.setText("English");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Mark Entry Form");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setText("Nepali");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setText("Maths");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel8.setText("Science");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel10.setText("Social");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel11.setText("English");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel12.setText("Computer");

        eng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engActionPerformed(evt);
            }
        });
        eng.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                engKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                engKeyTyped(evt);
            }
        });

        nep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nepActionPerformed(evt);
            }
        });
        nep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nepKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nepKeyTyped(evt);
            }
        });

        mat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                matKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                matKeyTyped(evt);
            }
        });

        sci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sciKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sciKeyTyped(evt);
            }
        });

        soc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                socKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                socKeyTyped(evt);
            }
        });

        com.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eng)
                    .addComponent(com, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(soc)
                    .addComponent(sci)
                    .addComponent(mat)
                    .addComponent(nep))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(eng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Bina Computer\\Desktop\\project icon\\icons8-add-new-30.png")); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtroll.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtrollItemStateChanged(evt);
            }
        });
        txtroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtrollMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel13.setText("Class");

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

        jButton2.setText("Get Available Roll");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Bina Computer\\Desktop\\project icon\\icons8-logout-rounded-down-30.png")); // NOI18N
        jButton3.setText("EXIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("* If absent then write 'a'");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(38, 38, 38)
                        .addComponent(jButton3)
                        .addGap(194, 194, 194))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtclass, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jButton2)
                    .addComponent(txtroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void engActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engActionPerformed
        
//        if(Float.parseFloat(eng.getText())>fen)
//        {
//            //nep.setEditable(false);
//            JOptionPane.showMessageDialog(this,"Marks must be less than or equal");
//            eng.requestFocus();
//        }
        
         
        
        
    }//GEN-LAST:event_engActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int roll=Integer.parseInt(txtroll.getSelectedItem().toString());
       String grade=txtclass.getSelectedItem().toString();
        String en,ne,ma,sc,so,co;
        
        float sum=0;
        float perc;
        int counter=0;
        //Float cen,cne,cma,csc,cso,cco,tot,perc;
        
        
             if(eng.getText().length()==0||nep.getText().length()==0||mat.getText().length()==0||sci.getText().length()==0||soc.getText().length()==0||com.getText().length()==0)
            {
                JOptionPane.showMessageDialog(this,"Enter marks in all field");
            }
        
        if(eng.getText().startsWith("a")) 
        {
          en="Abs";
          a=false;
          
          
        }
        else
        {
        en=eng.getText();
        sum=sum+Float.parseFloat(en);
        counter=counter+1;
        a=true;
        
        if(Float.parseFloat(en)>pen)
        {
            engstatus="Pass";
        }
        

        
        }
        
         if(nep.getText().startsWith("a")) 
        {
          ne="Abs";
          b=false;
        }
        else
        {
        ne=nep.getText();
        sum=sum+Float.parseFloat(ne);
        counter=counter+1;
        b=true;
      
        if(Float.parseFloat(ne)>pn)
        {
            nepstatus="Pass";
        }
        }
         
        if(mat.getText().startsWith("a")) 
        {
          ma="Abs";
          c=false;
        }
        else
        {
        ma=mat.getText();
        sum=sum+Float.parseFloat(ma);
        counter=counter+1;
        c=true;
        
        if(Float.parseFloat(ma)>pm)
        {
            matstatus="Pass";
        }
        }
        
        if(sci.getText().startsWith("a")) 
        {
          sc="Abs";
          d=false;
        }
        else
        {
         sc=sci.getText();
         sum=sum+Float.parseFloat(sc);
         counter=counter+1;
         d=true;
        
         if(Float.parseFloat(sc)>ps)
        {
            scistatus="Pass";
        }
        }
        
        if(soc.getText().startsWith("a")) 
        {
          so="Abs";
          e=false;
        }
        else
        {
        so=soc.getText();
        sum=sum+Float.parseFloat(so);
        counter=counter+1;
        e=true;
        
        if(Float.parseFloat(so)>pso)
        {
            socstatus="Pass";
        }
        }
        
        if(com.getText().startsWith("a")) 
        {
           co="Abs";
           f=false;
        }
        else
        {
         co=com.getText();
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
        //System.out.println("status"+status);
//         if(Float.parseFloat(en)>fen||Float.parseFloat(ne)>fn||Float.parseFloat(ma)>fm||Float.parseFloat(sc)>fs||Float.parseFloat(so)>fso||Float.parseFloat(co)>fc)
//                {
//                  JOptionPane.showMessageDialog(this,"Marks must be less than or equal to full mark");  
//                }
        
//        else
//         {
// fen,fn,fm,fs,fso,fc;
//        if(!"aa".equals(eng.getText())||nep.getText()!="aa"||mat.getText()!="aa"||sci.getText()!="aa"||soc.getText()!="aa"||com.getText()!="aa")
//        {
//            if(a>fen||b>fn||c>fm||d>fs||e>fso||f>fc)
//        {
//           JOptionPane.showMessageDialog(this,"Marks must be less than or equal to full mark"); 
//        }
//        }
//        
//        else
//        {
           try
        {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
         if(a==true&&Float.parseFloat(eng.getText())>fen)
         {
           JOptionPane.showMessageDialog(this,"Marks must be less than or equal");  
         }
         else if(b==true&&Float.parseFloat(nep.getText())>fen)
         {
           JOptionPane.showMessageDialog(this,"Marks must be less than or equal");  
         }
         else if(c==true&&Float.parseFloat(mat.getText())>fm)
         {
           JOptionPane.showMessageDialog(this,"Marks must be less than or equal");  
         }
         else if(d==true&&Float.parseFloat(sci.getText())>fs)
         {
           JOptionPane.showMessageDialog(this,"Marks must be less than or equal");  
         }
         else if(e==true&&Float.parseFloat(soc.getText())>fso)
         {
           JOptionPane.showMessageDialog(this,"Marks must be less than or equal");  
         }
         else if(f==true&&Float.parseFloat(com.getText())>fc)
         {
           JOptionPane.showMessageDialog(this,"Marks must be less than or equal");  
         }
         else
         {
         pst=con.prepareStatement("insert into markdetail(roll,class,english,nepali,maths,science,social,computer,total,status,perc)values(?,?,?,?,?,?,?,?,?,?,?)");
         pst.setInt(1,roll);
         pst.setString(2,grade);
         pst.setString(3,en);
         pst.setString(4,ne);
         pst.setString(5,ma);
         pst.setString(6,sc);
         pst.setString(7,so);
         pst.setString(8,co);//
         
         pst.setFloat(9, sum);
         pst.setString(10,status);
         pst.setFloat(11, perc);
         
         pst.executeUpdate();
         JOptionPane.showMessageDialog(null,"Mark Added....");
         eng.setText("");
         nep.setText("");
         mat.setText("");
         sci.setText("");
         soc.setText("");
         com.setText("");
         }
           
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,"error due to "+ex);
        }
       
//        eng.setEnabled(false);
//        nep.setEnabled(false);
//        mat.setEnabled(false);
//        sci.setEnabled(false);
//        soc.setEnabled(false);
//        com.setEnabled(false);   
        
        
         
        
       
        
        
        
        
        
        

//        float sum,avg;
//        String status;
//        String result;
//         if(eng.getText().length()==0||nep.getText().length()==0||mat.getText().length()==0||sci.getText().length()==0||soc.getText().length()==0||com.getText().length()==0)
//            {
//                JOptionPane.showMessageDialog(this,"Enter marks in all field");
//            } 
//         else
//         {     
//        int roll=Integer.parseInt(txtroll.getSelectedItem().toString());
//        String grade=txtclass.getSelectedItem().toString();
//        float en,ne,maths,sc,so,co,perc;
//        
//        en=Float.parseFloat(eng.getText());
//        ne=Float.parseFloat(nep.getText());
//        maths=Float.parseFloat(mat.getText());
//        sc=Float.parseFloat(sci.getText());
//        so=Float.parseFloat(soc.getText());
//        co=Float.parseFloat(com.getText());
//        
//        if(en>=30&&en<=75 && ne>=30&&ne<=75 &&maths>=30&&maths<=75 &&sc>=30&&sc<=75 &&so>=30&&so<=75 &&co>=30&&co<=75 )
//        {
//            status="Pass";
//        }
//        else
//        {
//            status="Fail";
//        }
//        
//        if(en>=0&&en<=75 && ne>=0&&ne<=75 &&maths>=0&&maths<=75 &&sc>=0&&sc<=75 &&so>=0&&so<=75 &&co>=0&&co<=75 )
//        {
//            sum=en+ne+maths+sc+so+co;
//            perc=(sum/450)*100;
//            
//          try
//        {
//         Class.forName("com.mysql.cj.jdbc.Driver");
//         con=DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
//         pst=con.prepareStatement("insert into markdetail(roll,class,english,nepali,maths,science,social,computer,total,status,perc)values(?,?,?,?,?,?,?,?,?,?,?)");
//         pst.setInt(1,roll);
//         pst.setString(2,grade);
//         pst.setFloat(3,en);
//         pst.setFloat(4,ne);
//         pst.setFloat(5,maths);
//         pst.setFloat(6,sc);
//         pst.setFloat(7,so);
//         pst.setFloat(8,co);//
//         
//         pst.setFloat(9, sum);
//         pst.setString(10,status);
//         pst.setFloat(11, perc);
//         
//         pst.executeUpdate();
//         JOptionPane.showMessageDialog(null,"Mark Added....");
//         eng.setText("");
//         nep.setText("");
//         mat.setText("");
//         sci.setText("");
//         soc.setText("");
//         com.setText("");
//           
//        }
//        catch(Exception ex)
//        {
//            JOptionPane.showMessageDialog(this,"error due to "+ex);
//        }
//        }
//        else
//        {
//            
//          JOptionPane.showMessageDialog(this,"please Enter vlaid marks");
//        
//        }
//         }
       

        
        

        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void engKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_engKeyTyped
     char c=evt.getKeyChar();
         if(c==KeyEvent.VK_ENTER)
         {
             nep.requestFocus();
         }   
         
        
        
   
    }//GEN-LAST:event_engKeyTyped

    private void nepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nepKeyTyped
        char c=evt.getKeyChar();
         if(c==KeyEvent.VK_ENTER)
         {
             mat.requestFocus();
         }
    }//GEN-LAST:event_nepKeyTyped

    private void engKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_engKeyPressed
            if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE||evt.getKeyChar()==VK_ENTER||evt.getKeyChar()=='a') {
               eng.setEditable(true);
            } else {
               eng.setEditable(false);
               JOptionPane.showMessageDialog(this," Mark must be Integer");
               eng.setEditable(true);
           }        // TODO add your handling code here:
    }//GEN-LAST:event_engKeyPressed

    private void nepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nepKeyPressed
                    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE||evt.getKeyChar()==VK_ENTER||evt.getKeyChar()=='a') {
               nep.setEditable(true);
            } else {
               nep.setEditable(false);
               JOptionPane.showMessageDialog(this,"mark must be Integer");
                nep.setEditable(true);
            }        // TODO add your handling code here:
    }//GEN-LAST:event_nepKeyPressed

    private void matKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matKeyPressed
                    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE||evt.getKeyChar()==VK_ENTER||evt.getKeyChar()=='a') {
               mat.setEditable(true);
            } else {
               mat.setEditable(false);
               JOptionPane.showMessageDialog(this,"mark must be Integer");
                mat.setEditable(true);
            }        // TODO add your handling code here:
    }//GEN-LAST:event_matKeyPressed

    private void sciKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sciKeyPressed
                    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE||evt.getKeyChar()==VK_ENTER||evt.getKeyChar()=='a') {
               sci.setEditable(true);
            } else {
               sci.setEditable(false);
               JOptionPane.showMessageDialog(this,"mark must be Integer");
                sci.setEditable(true);
            }        // TODO add your handling code here:
    }//GEN-LAST:event_sciKeyPressed

    private void socKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_socKeyPressed
                        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE||evt.getKeyChar()==VK_ENTER||evt.getKeyChar()=='a') {
               soc.setEditable(true);
            } else {
               soc.setEditable(false);
               JOptionPane.showMessageDialog(this,"mark must be Integer");
                soc.setEditable(true);
            }        // TODO add your handling code here:
    }//GEN-LAST:event_socKeyPressed

    private void comKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comKeyPressed
                    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar()==VK_BACK_SPACE || evt.getKeyChar()==VK_DELETE||evt.getKeyChar()==VK_ENTER||evt.getKeyChar()=='a') {
               com.setEditable(true);
            } else {
              com.setEditable(false);
               JOptionPane.showMessageDialog(this,"mark must be Integer");
                com.setEditable(true);
            }        // TODO add your handling code here:
    }//GEN-LAST:event_comKeyPressed

    private void txtrollMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrollMouseClicked
        
    }//GEN-LAST:event_txtrollMouseClicked

    private void txtclassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtclassItemStateChanged
//      String grade=txtclass.getSelectedItem().toString();
//       try
//       {
//         Class.forName("com.mysql.cj.jdbc.Driver");
//         con=DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
//         pst=con.prepareStatement("select *from personaldetail where class=?");
//         pst.setString(1,grade);
//         rs=pst.executeQuery();
//         txtroll.removeAllItems();
//         while(rs.next())
//         {
//             txtroll.addItem(rs.getString(1));
//         }   
//         
//       }
//       
//        catch(ClassNotFoundException | SQLException e)
//        {
//            JOptionPane.showMessageDialog(this,"error due to "+e);
//        }           
        
        
        

    
    }//GEN-LAST:event_txtclassItemStateChanged

    private void txtclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclassActionPerformed
           
    }//GEN-LAST:event_txtclassActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        getRoll();
//        eng.setEnabled(true);
//        nep.setEnabled(true);
//        mat.setEnabled(true);
//        sci.setEnabled(true);
//        soc.setEnabled(true);
//        com.setEnabled(true);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nepActionPerformed
        
    }//GEN-LAST:event_nepActionPerformed

    private void matKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matKeyTyped
       char c=evt.getKeyChar();
         if(c==KeyEvent.VK_ENTER)
         {
             sci.requestFocus();
         }
    }//GEN-LAST:event_matKeyTyped

    private void sciKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sciKeyTyped
        char c=evt.getKeyChar();
         if(c==KeyEvent.VK_ENTER)
         {
             soc.requestFocus();
         }
    }//GEN-LAST:event_sciKeyTyped

    private void socKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_socKeyTyped
        char c=evt.getKeyChar();
         if(c==KeyEvent.VK_ENTER)
         {
            com.requestFocus();
         }
    }//GEN-LAST:event_socKeyTyped

    private void comKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comKeyTyped
      
    }//GEN-LAST:event_comKeyTyped

    private void txtrollItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtrollItemStateChanged
     
      
                // TODO add your handling code here:
    }//GEN-LAST:event_txtrollItemStateChanged

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        eng.setEnabled(true);
        nep.setEnabled(true);
        mat.setEnabled(true);
        sci.setEnabled(true);
        soc.setEnabled(true);
        com.setEnabled(true);
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(MarksEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarksEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarksEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarksEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarksEntry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField com;
    private javax.swing.JTextField eng;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mat;
    private javax.swing.JTextField nep;
    private javax.swing.JTextField sci;
    private javax.swing.JTextField soc;
    private javax.swing.JComboBox<String> txtclass;
    private javax.swing.JComboBox<String> txtroll;
    // End of variables declaration//GEN-END:variables
}
