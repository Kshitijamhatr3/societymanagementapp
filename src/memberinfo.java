
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kshit
 */
public class memberinfo extends javax.swing.JFrame {

    /**
     * Creates new form memberinfo
     */
   
   
    public memberinfo() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        displayInJtable();

    }
         public Connection getConnection()
    {
        Connection con;
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","hazzaforever");
        return con;
        }
        catch(Exception e){
         e.printStackTrace();
         System.out.println("saku");
         return null;
        }
    }
    public ArrayList<memberd> getUList(){
     ArrayList<memberd> usersList=new ArrayList<memberd>();
     Connection con=getConnection();
     String query="SELECT * FROM `memberinformation`";
     Statement st;
     ResultSet rs;
     try{
         st=con.createStatement();
         rs=st.executeQuery(query);
         memberd mem;
         while(rs.next()){
             mem=new memberd(rs.getInt("rommno"),rs.getString("fname"),rs.getString("lname"),rs.getLong("phone"),rs.getString("email"),rs.getInt("areasqft"));
             usersList.add(mem);
         }
    }
     catch(Exception e){
       e.printStackTrace();
       System.out.println("siddo");
     }
     return usersList;
    }
    //display data in jtable
    public void displayInJtable(){
      ArrayList<memberd> list =getUList();
      DefaultTableModel m=(DefaultTableModel)jTable1.getModel();
      Object[] row=new Object[6];
      for(int i=0;i<list.size();i++){
          row[0]=list.get(i).getId();
          row[1]=list.get(i).getFirstName();
          row[2]=list.get(i).getLastName();
          row[3]=list.get(i).getMobileNo();
          row[4]=list.get(i).getEmail();
          row[5]=list.get(i).getAreasqft();
          m.addRow(row);
      }
    }
    public void sqlQuery(String query,String msg)
    {
      Connection con=getConnection();
      Statement s;
      try{
         s=con.createStatement();
         if((s.executeUpdate(query))==1){
             
             DefaultTableModel m=(DefaultTableModel)jTable1.getModel();
             m.setRowCount(0);
             displayInJtable();
             
             JOptionPane.showMessageDialog(null,"Data "+msg+"Successfull");
         }
         else{
            JOptionPane.showMessageDialog(null,"Data  Not"+msg); 
         }
      }
      catch(Exception e){
         JOptionPane.showMessageDialog(null,"no duplicate value");
       
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3_lname = new javax.swing.JTextField();
        jTextField5_email = new javax.swing.JTextField();
        jTextField4_mobno = new javax.swing.JTextField();
        jButton_save = new javax.swing.JButton();
        jTextField6_areasqft = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton_back = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField2_fname = new javax.swing.JTextField();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jtf_rno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(72, 124, 141));
        jPanel1.setPreferredSize(new java.awt.Dimension(1454, 668));

        jLabel1.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MEMBER INFORMATION");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("PROVIDE DETAILS");

        jLabel3.setText("LAST NAME :");

        jLabel5.setText("MOBILE NO :");

        jLabel6.setText("EMAIL :");

        jTextField3_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3_lnameActionPerformed(evt);
            }
        });

        jTextField5_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5_emailActionPerformed(evt);
            }
        });

        jButton_save.setBackground(new java.awt.Color(204, 255, 0));
        jButton_save.setText("SAVE");
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jTextField6_areasqft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6_areasqftActionPerformed(evt);
            }
        });

        jLabel7.setText("AREA SQ FT :");

        jButton_back.setBackground(new java.awt.Color(0, 255, 51));
        jButton_back.setText("<<<BACK");
        jButton_back.setToolTipText("");
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });

        jLabel9.setText("FIRST NAME :");

        jTextField2_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2_fnameActionPerformed(evt);
            }
        });

        jButton_update.setBackground(new java.awt.Color(0, 51, 255));
        jButton_update.setText("UPDATE");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jButton_delete.setBackground(new java.awt.Color(255, 0, 51));
        jButton_delete.setText("DELETE");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jLabel4.setText("ROOM NO :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ROOM NO ", "FIRST NAME", "LAST NAME", "MOBILE NO", "EMAIL", "AREA SQ FT"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(0, 255, 153));
        jButton2.setText("REFRESH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1))
                    .addComponent(jButton_back, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton_update)
                        .addGap(48, 48, 48)
                        .addComponent(jButton_delete)
                        .addGap(91, 91, 91)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(105, 105, 105)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtf_rno, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(jTextField2_fname)
                                    .addComponent(jTextField3_lname)
                                    .addComponent(jTextField4_mobno, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField5_email, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField6_areasqft)))
                            .addComponent(jLabel2))
                        .addGap(66, 66, 66)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtf_rno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField2_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4_mobno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField6_areasqft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_update)
                    .addComponent(jButton_delete)
                    .addComponent(jButton_save)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton_back, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5_emailActionPerformed

    private void jTextField3_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3_lnameActionPerformed

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
         home form=new home();
               form.setVisible(true);
               form.pack();
               form.setLocationRelativeTo(null);
               this.dispose();
    }//GEN-LAST:event_jButton_backActionPerformed

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        if(jtf_rno.getText().trim().equals("") || jTextField2_fname.getText().trim().equals("") || jTextField3_lname.getText().trim().equals("") || jTextField4_mobno.getText().trim().equals("") || jTextField5_email.getText().trim().equals("") || jTextField6_areasqft.getText().trim().equals("") ) {
            JOptionPane.showMessageDialog(null,"Fields cannot be empty  !"," WARNING ",2); 
        }
        else{
        String txt=jTextField6_areasqft.getText();
        boolean incorrect =true;
        while(incorrect){
        try{
            Double.parseDouble(txt);
          
            incorrect=false;
        }
        catch(NumberFormatException e){
                 txt=JOptionPane.showInputDialog("invalid input ! please enter correct area sqft rate");
                 jTextField6_areasqft.setText(txt);
                 
                
                }}
        String txt1=jTextField4_mobno.getText();
        boolean incorrect1 =true;
        while(incorrect1){
        try{
            Double.parseDouble(txt1);
          
            incorrect1=false;
        }
        catch(NumberFormatException e){
                 txt1=JOptionPane.showInputDialog("Enter valid mobile number ");
                 jTextField4_mobno.setText(txt1);
        } }
         String txt2=jTextField2_fname.getText();
         String txt4=jTextField3_lname.getText();
         String txt3=jtf_rno.getText();
        
          EmailValidator ev=new EmailValidator();
        
        if(jtf_rno.getText().trim().equals("") || jTextField2_fname.getText().trim().equals("") || jTextField3_lname.getText().trim().equals("") || jTextField4_mobno.getText().trim().equals("") || jTextField5_email.getText().trim().equals("") || jTextField6_areasqft.getText().trim().equals("") ) {
            JOptionPane.showMessageDialog(null,"Fields cannot be empty  !"," WARNING ",2); 
        }
        else if(txt1.length()!=10){
            JOptionPane.showMessageDialog(null,"Invalid mobile number  !"," WARNING ",2); 
        }
        else if(!ev.validate(jTextField5_email.getText().trim())){
            JOptionPane.showMessageDialog(null,"Invalid email id  !"," WARNING ",2); 
      
        }
        else if(!jtf_rno.getText().matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Enter a valid room number  !"," WARNING ",2);  
        }

        else if(txt2.matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Don't enter numeric valuse for first name  !"," WARNING ",2);  
        }
         else if(txt4.matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Don't enter numeric valuse for last name  !"," WARNING ",2);  
        }
        else{
        String query1= "INSERT INTO `memberinformation`(`rommno`, `fname`, `lname`, `phone`, `email`, `areasqft`) VALUES ('"+jtf_rno.getText()+"','"+jTextField2_fname.getText()+"','"+jTextField3_lname.getText()+"','"+jTextField4_mobno.getText()+"','"+jTextField5_email.getText()+"','"+jTextField6_areasqft.getText()+"')";
        sqlQuery(query1,"Value Inserted ! ");
        }}
         
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jTextField6_areasqftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6_areasqftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6_areasqftActionPerformed

    private void jTextField2_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2_fnameActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int jt=jTable1.getSelectedRow();
        TableModel m=jTable1.getModel();
        jtf_rno.setText(m.getValueAt(jt,0).toString());
        jTextField2_fname.setText(m.getValueAt(jt,1).toString());
        jTextField3_lname.setText(m.getValueAt(jt,2).toString());
        jTextField4_mobno.setText(m.getValueAt(jt,3).toString());
        jTextField5_email.setText(m.getValueAt(jt,4).toString());      
        jTextField6_areasqft.setText(m.getValueAt(jt,5).toString());        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        if(jtf_rno.getText().trim().equals("") || jTextField2_fname.getText().trim().equals("") || jTextField3_lname.getText().trim().equals("") || jTextField4_mobno.getText().trim().equals("") || jTextField5_email.getText().trim().equals("") || jTextField6_areasqft.getText().trim().equals("") ) {
            JOptionPane.showMessageDialog(null,"Fields cannot be empty  !"," WARNING ",2); 
        }
        else{
        String txt=jTextField6_areasqft.getText();
        boolean incorrect =true;
        while(incorrect){
        try{
            Double.parseDouble(txt);
          
            incorrect=false;
        }
        catch(NumberFormatException e){
                 txt=JOptionPane.showInputDialog("invalid input ! please enter correct area sqft rate");
                 jTextField6_areasqft.setText(txt);
                 
                
                }}
        String txt1=jTextField4_mobno.getText();
        boolean incorrect1 =true;
        while(incorrect1){
        try{
            Double.parseDouble(txt1);
          
            incorrect1=false;
        }
        catch(NumberFormatException e){
                 txt1=JOptionPane.showInputDialog("Enter valid mobile number ");
                 jTextField4_mobno.setText(txt1);
        }
        }
         String txt2=jTextField2_fname.getText();
         String txt3=jtf_rno.getText();
         String txt4=jTextField3_lname.getText();
          EmailValidator ev=new EmailValidator();
        
        if(jtf_rno.getText().trim().equals("") || jTextField2_fname.getText().trim().equals("") || jTextField3_lname.getText().trim().equals("") || jTextField4_mobno.getText().trim().equals("") || jTextField5_email.getText().trim().equals("") || jTextField6_areasqft.getText().trim().equals("") ) {
            JOptionPane.showMessageDialog(null,"Fields cannot be empty  !"," WARNING ",2); 
        }
        else if(txt1.length()!=10){
            JOptionPane.showMessageDialog(null,"Invalid mobile number  !"," WARNING ",2); 
        }
        else if(!ev.validate(jTextField5_email.getText().trim())){
            JOptionPane.showMessageDialog(null,"Invalid email id  !"," WARNING ",2); 
        }
         else if(!jtf_rno.getText().matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Enter a valid room number  !"," WARNING ",2);  
        }
        else if(txt2.matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Don't enter numeric valuse for first name  !"," WARNING ",2);  
        }
         else if(txt4.matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Don't enter numeric valuse for last name  !"," WARNING ",2);  
        }
      else{
      String query2="UPDATE `memberinformation` SET `fname`='"+jTextField2_fname.getText()+"',`lname`='"+jTextField3_lname.getText()+"',`phone`='"+jTextField4_mobno.getText()+"',`email`='"+jTextField5_email.getText()+"',`areasqft`="+jTextField6_areasqft.getText()+" WHERE `rommno`= "+jtf_rno.getText() ;
      sqlQuery(query2,"Value Updated ! ");
      }}
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
     if(jtf_rno.getText().trim().equals("") ) {
            JOptionPane.showMessageDialog(null,"Room number Cannot be  !"," WARNING ",2); 
        }
     else{
        String query3="DELETE FROM `memberinformation` WHERE `rommno`="+jtf_rno.getText()+"";
      sqlQuery(query3,"Value Deleted ! ");
     }
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jtf_rno.setText(null);
        jTextField2_fname.setText(null);
        jTextField3_lname.setText(null);
        jTextField4_mobno.setText(null);
        jTextField5_email.setText(null);
        jTextField6_areasqft.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed
   
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
            java.util.logging.Logger.getLogger(memberinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(memberinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(memberinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(memberinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new memberinfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_save;
    private javax.swing.JButton jButton_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2_fname;
    private javax.swing.JTextField jTextField3_lname;
    private javax.swing.JTextField jTextField4_mobno;
    private javax.swing.JTextField jTextField5_email;
    private javax.swing.JTextField jTextField6_areasqft;
    private javax.swing.JTextField jtf_rno;
    // End of variables declaration//GEN-END:variables
}
