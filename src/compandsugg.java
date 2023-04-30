/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kshit
 */
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class compandsugg extends javax.swing.JFrame {
 
    /**
     * Creates new form compandsugg
     */
    public compandsugg() {
        initComponents();
        this.setLocationRelativeTo(null);
         displayInJtable();
         displayInJtable1();

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
         return null;
        }
    }
     public ArrayList<comp> getUList(){
     ArrayList<comp> usersList=new ArrayList<comp>();
     Connection con=getConnection();
     String query="SELECT * FROM `complaints`";
     Statement st;
     ResultSet rs;
     try{
         st=con.createStatement();
         rs=st.executeQuery(query);
         comp mem;
         while(rs.next()){
             mem=new comp(rs.getInt("roomno"),rs.getString("comp"));
             usersList.add(mem);
         }
    }
     catch(Exception e){
       e.printStackTrace();
     }
     return usersList;
    }
     public ArrayList<sugg> getUList1(){
     ArrayList<sugg> usersList1=new ArrayList<sugg>();
     Connection con=getConnection();
     String query="SELECT * FROM `suggestions`";
     Statement st;
     ResultSet rs;
     try{
         st=con.createStatement();
         rs=st.executeQuery(query);
         sugg mem;
         while(rs.next()){
             mem=new sugg(rs.getInt("roomno"),rs.getString("sugg"));
             usersList1.add(mem);
         }
    }
     catch(Exception e){
       e.printStackTrace();
     }
     return usersList1;
    }

        //display data in jtable
    public void displayInJtable(){
      ArrayList<comp> list =getUList();
      DefaultTableModel m=(DefaultTableModel)jTable1.getModel();
      Object[] row=new Object[2];
      for(int i=0;i<list.size();i++){
          row[0]=list.get(i).getId();
          row[1]=list.get(i).getComp();
          m.addRow(row);
      }
    }
     //display data in jtable
    public void displayInJtable1(){
      ArrayList<sugg> list =getUList1();
      DefaultTableModel m=(DefaultTableModel)jTable2.getModel();
      Object[] row=new Object[2];
      for(int i=0;i<list.size();i++){
          row[0]=list.get(i).getId();
          row[1]=list.get(i).getSugg();
          m.addRow(row);
      }
    }
    //connection
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
         e.printStackTrace(); 
      }
    }
     //connection
     public void sqlQuery1(String query,String msg)
    {
      Connection con=getConnection();
      Statement s;
      try{
         s=con.createStatement();
         if((s.executeUpdate(query))==1){
             
             DefaultTableModel m=(DefaultTableModel)jTable2.getModel();
             m.setRowCount(0);
             displayInJtable1();
             
             JOptionPane.showMessageDialog(null,"Data "+msg+"Successfull");
         }
         else{
            JOptionPane.showMessageDialog(null,"Data  Not"+msg); 
         }
      }
      catch(Exception e){
         e.printStackTrace(); 
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtf_comp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_sugg = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        addcomp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jtf_rno = new javax.swing.JTextField();
        updatecomp = new javax.swing.JButton();
        deletecomp = new javax.swing.JButton();
        addsugg = new javax.swing.JButton();
        updatesugg = new javax.swing.JButton();
        deletesugg = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(166, 64, 64));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("COMPLAINTS :");

        jtf_comp.setBackground(new java.awt.Color(204, 255, 204));
        jtf_comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_compActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SUGGESTIONS :");

        jLabel4.setBackground(new java.awt.Color(204, 255, 204));

        jtf_sugg.setBackground(new java.awt.Color(204, 255, 204));

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        addcomp.setBackground(new java.awt.Color(255, 204, 204));
        addcomp.setText("ADD COMPLAINTS");
        addcomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcompActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ROOM NO ", "COMPLAINT"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ROOM NO :");

        jtf_rno.setBackground(new java.awt.Color(204, 255, 204));
        jtf_rno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_rnoActionPerformed(evt);
            }
        });

        updatecomp.setText("UPDATE COMPLAINTS");
        updatecomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatecompActionPerformed(evt);
            }
        });

        deletecomp.setText("DELETE COMPLAINTS");
        deletecomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletecompActionPerformed(evt);
            }
        });

        addsugg.setText("ADD SUGGESTION");
        addsugg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsuggActionPerformed(evt);
            }
        });

        updatesugg.setText("UPDATE SUGGESTION");
        updatesugg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatesuggActionPerformed(evt);
            }
        });

        deletesugg.setText("DELETE SUGGESTION");
        deletesugg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletesuggActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ROOM NO ", "SUGGESTIONS"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton7.setBackground(new java.awt.Color(204, 255, 204));
        jButton7.setText("RESET");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(204, 255, 204));
        jButton8.setText("RESET");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtf_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(77, 77, 77)
                                .addComponent(jtf_rno, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(deletecomp, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(updatecomp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addcomp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jtf_sugg, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(158, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(deletesugg)
                                            .addComponent(updatesugg)
                                            .addComponent(addsugg))
                                        .addGap(0, 0, Short.MAX_VALUE))))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jtf_rno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_comp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(addcomp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updatecomp)
                .addGap(18, 18, 18)
                .addComponent(deletecomp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jtf_sugg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(addsugg)
                .addGap(18, 18, 18)
                .addComponent(updatesugg)
                .addGap(18, 18, 18)
                .addComponent(deletesugg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(79, 79, 79)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel1.setText("COMPLAINTS AND SUGGESTIONS ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       home form=new home();
               form.setVisible(true);
               form.pack();
               form.setLocationRelativeTo(null);
               this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addcompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcompActionPerformed
         if(jtf_rno.getText().trim().equals("") || jtf_comp.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null,"Fields cannot be empty  !"," WARNING ",2); 
        }
         else if(!jtf_rno.getText().matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Enter proper room number  !"," WARNING ",2);  
        }
         else if(jtf_comp.getText().matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Enter proper complaints !"," WARNING ",2);  
        }
        else{
        String ka=jtf_rno.getText();
        int ka1=Integer.parseInt(ka);
        try{
         Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","hazzaforever");
                String s="select * from memberinformation where rommno='"+jtf_rno.getText()+"'";
                PreparedStatement pstmt=con.prepareStatement(s);
                ResultSet rs=pstmt.executeQuery(); 
                if(rs.next()==true){
                 String query= "INSERT INTO `complaints`(`roomno`, `comp`) VALUES ('"+jtf_rno.getText()+"','"+jtf_comp.getText()+"')";
                 sqlQuery(query," Inserted ! ");  
                }
                else{
                   JOptionPane.showMessageDialog(null,"No such room number exist !"," WARNING ",2);   
                }
                pstmt.close();
            }
        catch(Exception e){
            System.out.println(e);
        }
        }
        
    }//GEN-LAST:event_addcompActionPerformed

    private void jtf_compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_compActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_compActionPerformed

    private void jtf_rnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_rnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_rnoActionPerformed

    private void deletecompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletecompActionPerformed
       if(jtf_rno.getText().trim().equals("") ) {
            JOptionPane.showMessageDialog(null,"Room number Cannot be  !"," WARNING ",2); 
        }
     else{
        String query="DELETE FROM `complaints` WHERE `roomno`="+jtf_rno.getText()+"";
      sqlQuery(query," Deleted ! ");
       }
    }//GEN-LAST:event_deletecompActionPerformed

    private void updatecompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatecompActionPerformed
       if(jtf_rno.getText().trim().equals("") || jtf_comp.getText().trim().equals("")  ) {
            JOptionPane.showMessageDialog(null,"Fields cannot be empty  !"," WARNING ",2); 
        }
       else if(!jtf_rno.getText().matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Enter proper room number  !"," WARNING ",2);  
        }
         else if(jtf_comp.getText().matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Enter proper complaints !"," WARNING ",2);  
        }
      else{
       String ka=jtf_rno.getText();
        int ka1=Integer.parseInt(ka);
        try{
         Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","hazzaforever");
                String s="select * from memberinformation where rommno='"+jtf_rno.getText()+"'";
                PreparedStatement pstmt=con.prepareStatement(s);
                ResultSet rs=pstmt.executeQuery(); 
                if(rs.next()==true){
                 String query="UPDATE complaints SET comp='"+jtf_comp.getText()+"' WHERE roomno= "+jtf_rno.getText() ;
      sqlQuery(query,"Value Updated ! ");

                }
                else{
                   JOptionPane.showMessageDialog(null,"No such room number exist !"," WARNING ",2);   
                }
                pstmt.close();
            }
        catch(Exception e){
            System.out.println(e);
        }
            }
    }//GEN-LAST:event_updatecompActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int jt=jTable1.getSelectedRow();
        TableModel m=jTable1.getModel();
        jtf_rno.setText(m.getValueAt(jt,0).toString());
        jtf_comp.setText(m.getValueAt(jt,1).toString());      
    }//GEN-LAST:event_jTable1MouseClicked

    private void addsuggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsuggActionPerformed
       if(jtf_rno.getText().trim().equals("") || jtf_sugg.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null,"Fields cannot be empty  !"," WARNING ",2); 
        }
       else if(!jtf_rno.getText().matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Enter proper room number  !"," WARNING ",2);  
        }
         else if(jtf_sugg.getText().matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Enter proper suggestion !"," WARNING ",2);  
        }
        else{
           String ka=jtf_rno.getText();
        int ka1=Integer.parseInt(ka);
        try{
         Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","hazzaforever");
                String s="select * from memberinformation where rommno='"+jtf_rno.getText()+"'";
                PreparedStatement pstmt=con.prepareStatement(s);
                ResultSet rs=pstmt.executeQuery(); 
                if(rs.next()==true){
                 String query= "INSERT INTO `suggestions`(`roomno`, `sugg`) VALUES ('"+jtf_rno.getText()+"','"+jtf_sugg.getText()+"')";
                 sqlQuery1(query," Inserted ! ");  
                }
                else{
                   JOptionPane.showMessageDialog(null,"No such room number exist !"," WARNING ",2);   
                }
                pstmt.close();
            }
        catch(Exception e){
            System.out.println(e);
        }
        }
        
    }//GEN-LAST:event_addsuggActionPerformed

    private void updatesuggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatesuggActionPerformed
      if(jtf_rno.getText().trim().equals("") || jtf_sugg.getText().trim().equals("")  ) {
            JOptionPane.showMessageDialog(null,"Fields cannot be empty  !"," WARNING ",2); 
        }
      else if(!jtf_rno.getText().matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Enter proper room number  !"," WARNING ",2);  
        }
         else if(jtf_sugg.getText().matches("-?\\d+(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Enter proper suggestion !"," WARNING ",2);  
        }
      else{
      String ka=jtf_rno.getText();
        int ka1=Integer.parseInt(ka);
        try{
         Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","hazzaforever");
                String s="select * from memberinformation where rommno='"+jtf_rno.getText()+"'";
                PreparedStatement pstmt=con.prepareStatement(s);
                ResultSet rs=pstmt.executeQuery(); 
                if(rs.next()==true){
                   String query="UPDATE suggestions SET sugg='"+jtf_sugg.getText()+"' WHERE roomno= "+jtf_rno.getText() ;
                   sqlQuery1(query,"Value Updated ! ");
                }
                else{
                   JOptionPane.showMessageDialog(null,"No such room number exist !"," WARNING ",2);   
                }
                pstmt.close();
            }
        catch(Exception e){
            System.out.println(e);
        }
     
      } 
    }//GEN-LAST:event_updatesuggActionPerformed

    private void deletesuggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletesuggActionPerformed
       if(jtf_rno.getText().trim().equals("") ) {
            JOptionPane.showMessageDialog(null,"Room number Cannot be  !"," WARNING ",2); 
        }
     else{
        String query="DELETE FROM `suggestions` WHERE `roomno`="+jtf_rno.getText()+"";
      sqlQuery1(query," Deleted ! ");
       }
    }//GEN-LAST:event_deletesuggActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jtf_comp.setText(null);
        jtf_rno.setText(null);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jtf_sugg.setText(null);
        jtf_rno.setText(null);
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(compandsugg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(compandsugg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(compandsugg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(compandsugg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new compandsugg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addcomp;
    private javax.swing.JButton addsugg;
    private javax.swing.JButton deletecomp;
    private javax.swing.JButton deletesugg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jtf_comp;
    private javax.swing.JTextField jtf_rno;
    private javax.swing.JTextField jtf_sugg;
    private javax.swing.JButton updatecomp;
    private javax.swing.JButton updatesugg;
    // End of variables declaration//GEN-END:variables
}
