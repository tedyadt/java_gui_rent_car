/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gto;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tedy
 */
public class Penyewaan extends javax.swing.JFrame {
private Connection con;
private Statement stat;
private ResultSet res;
private String sql="";

private String id,nama,hp,ktp,alamat,status;

    /**
     * Creates new form Penyewaan
     */
    public Penyewaan() {
        initComponents();
        koneksi();
        kosongkan();
        TampilData(sql);
    }
    private void koneksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/rental_mobil", "root", "");
        stat=con.createStatement();
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }
    private void kosongkan()
{
    id_penyewa.setText("");
    nama_penyewa.setText("");
    no_hp.setText("");
    no_ktp.setText("");
    alamat_penyewa.setText("");
    id_penyewa.requestFocus();
    
}
    
    private void TampilData (String sql){
    DefaultTableModel t = new DefaultTableModel();
    
    t.addColumn("ID Penyewa");
    t.addColumn("Nama ");
    t.addColumn("No Hp");
    t.addColumn("No KTP");
    t.addColumn("Alamat");
    
    Table.setModel(t);
    try {
        int i = 1;
        stat=con.createStatement();
        res=stat.executeQuery("select * from penyewa ");
        while (res.next()) {
            t.addRow(new Object[]{
            res.getString("id_penyewa"),
            res.getString("nama_penyewa"),
            res.getString("no_hp"),
            res.getString("no_ktp"),
            res.getString("alamat"),
            
            });
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
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

        id_penyewa = new javax.swing.JTextField();
        nama_penyewa = new javax.swing.JTextField();
        no_hp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        no_ktp = new javax.swing.JTextField();
        edit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        batal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        hapus = new javax.swing.JButton();
        alamat_penyewa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        kembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        id_penyewa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_penyewaKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Id Penyewa");

        no_ktp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_ktpActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nama Penyewa");

        simpan.setBackground(new java.awt.Color(0, 0, 153));
        simpan.setForeground(new java.awt.Color(255, 255, 255));
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("No Hp");

        batal.setBackground(new java.awt.Color(0, 0, 0));
        batal.setForeground(new java.awt.Color(255, 255, 255));
        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("No Ktp");

        hapus.setBackground(new java.awt.Color(204, 0, 0));
        hapus.setForeground(new java.awt.Color(255, 255, 255));
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Alamat");

        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Profile");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jLabel8.setText("Pengisian data diri pelanggan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(id_penyewa)
                                    .addComponent(nama_penyewa)
                                    .addComponent(no_hp)
                                    .addComponent(no_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(edit)
                                        .addGap(18, 18, 18)
                                        .addComponent(simpan)
                                        .addGap(18, 18, 18)
                                        .addComponent(batal))
                                    .addComponent(alamat_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(hapus)
                        .addGap(18, 18, 18)
                        .addComponent(kembali))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nama_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(no_hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(no_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit)
                    .addComponent(simpan)
                    .addComponent(batal)
                    .addComponent(hapus)
                    .addComponent(kembali))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void no_ktpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_ktpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_ktpActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Mendelete Record Ini???", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0)
        id=String.valueOf(id_penyewa.getText());
        try{
            sql="DELETE FROM penyewa"
                    +" where id_penyewa='"+ id +"'";
            stat=con.createStatement();
            stat.execute(sql);
            kosongkan();
            TampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n"+e.getMessage());
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void id_penyewaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_penyewaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_penyewaKeyPressed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
          // TODO add your handling code here:
        id=String.valueOf(id_penyewa.getText());
        nama=String.valueOf(nama_penyewa.getText());
        hp=String.valueOf(no_hp.getText());
        ktp=String.valueOf(no_ktp.getText());
        alamat=String.valueOf(alamat_penyewa.getText());
        
        try{
            sql="INSERT INTO penyewa(id_penyewa, nama_penyewa, "
                    + "no_hp, no_ktp, alamat)value "
                    + "('"+ id +"','"+ nama +"','"+ hp +"','"+ ktp +"',"
                    + "'"+ alamat +"')";
            stat=con.createStatement();
            stat.execute(sql);
            kosongkan();
            TampilData(sql);
            JOptionPane.showMessageDialog(null,
                    "Data Berhasil Disimpan");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,
                    "Data Gagal Disimpan\n"+e.getMessage());
        }

    }//GEN-LAST:event_simpanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        id=String.valueOf(id_penyewa.getText());
        nama=String.valueOf(nama_penyewa.getText());
        hp=String.valueOf(no_hp.getText());
        ktp=String.valueOf(no_ktp.getText());
        alamat=String.valueOf(alamat_penyewa.getText());
       
        try{
            sql="update penyewa set nama_penyewa='"+ nama +"',no_hp='"+ hp +"',no_ktp='"+ ktp +"',alamat='"+ alamat +"' where id_penyewa = '"+ id +"'";
            stat=con.createStatement();
            stat.execute(sql);
            kosongkan();
            TampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Edit");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Edit \n"+e.getMessage());
        }
    }//GEN-LAST:event_editActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        kosongkan();
    }//GEN-LAST:event_batalActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
            // TODO add your handling code here:
        this.dispose();
        new dashboard().setVisible(true);
    }//GEN-LAST:event_kembaliActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        int i = Table.getSelectedRow();
        if(i==-1){
        return;
        }
        String code = (String)Table.getValueAt(i,0);
        String code1 = (String)Table.getValueAt(i,1);
        String code2 = (String)Table.getValueAt(i,2);
        String code3 = (String)Table.getValueAt(i,3);
        String code4 = (String)Table.getValueAt(i,4);
       
        id_penyewa.setText(code);
        nama_penyewa.setText(code1);
        no_hp.setText(code2);
        no_ktp.setText(code3);
        alamat_penyewa.setText(code4);
       
    }//GEN-LAST:event_TableMouseClicked

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
            java.util.logging.Logger.getLogger(Penyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penyewaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JTextField alamat_penyewa;
    private javax.swing.JButton batal;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField id_penyewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField nama_penyewa;
    private javax.swing.JTextField no_hp;
    private javax.swing.JTextField no_ktp;
    private javax.swing.JButton simpan;
    // End of variables declaration//GEN-END:variables

}
