/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gto;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Tedy
 */
public class Transaksi extends javax.swing.JFrame {

private Object dateFormat;
private Connection con;
private Statement stat;
private ResultSet res;
private String sql="";


private String idpenyewa,namapenyewa,platmobil,namamobil,tglpinjam,tglkembali,lamahari,hargarental;


    public String getIdpenyewa() {
        return idpenyewa;
    }

    public void setIdpenyewa(String idpenyewa) {
        this.idpenyewa = idpenyewa;
    }

    public String getNamapenyewa() {
        return namapenyewa;
    }

    public void setNamapenyewa(String namapenyewa) {
        this.namapenyewa = namapenyewa;
    }

    public String getPlatmobil() {
        return platmobil;
    }

    public void setPlatmobil(String platmobil) {
        this.platmobil = platmobil;
    }

    public String getNamamobil() {
        return namamobil;
    }

    public void setNamamobil(String namamobil) {
        this.namamobil = namamobil;
    }

    public String getTglpinjam() {
        return tglpinjam;
    }

    public void setTglpinjam(String tglpinjam) {
        this.tglpinjam = tglpinjam;
    }

    public String getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }
    public String getLamahari() {
        return lamahari;
    }

    public void setLamahari(String lamahari) {
        this.lamahari = lamahari;
    }

    public String getHargarental() {
        return hargarental;
    }

    public void setHargarental(String hargarental) {
        this.hargarental = hargarental;
    }

    /**
     * Creates new form Transaksi
     */
    public Transaksi() {
        initComponents();
        koneksi();
       // kosongkan();
        TampilData(sql);       
        combobok1();
        combobok2();
        
    }
    
    private void combobok1(){
        try {
            stat=con.createStatement();
            String sql = "SELECT * FROM penyewa";
            res = stat.executeQuery(sql);
            while(res.next()){  
                
                comboboxid.addItem(res.getString("id_penyewa"));
            }
        }catch (Exception e){
            
        }
    }
    private void combobok2(){
        try {
            stat=con.createStatement();
            String sql = "SELECT * FROM mobil";
            res = stat.executeQuery(sql);
            while(res.next()){  
                comboboxplat.addItem(res.getString("plat_mobil"));
                
            }
        }catch (Exception e){
            
        }
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
    
    private void kosongkan(){
    
    comboboxid.setSelectedIndex(0);
    comboboxplat.setSelectedIndex(0);
    nama_penyewa.setText("");
    //tgl_sebentar.setText("");
    harga_hasil.setText("");
    //hitung.setText("");
    }
    
    private void TampilData(String sql){
     DefaultTableModel t = new DefaultTableModel();
    
    t.addColumn("ID Penyewa");
    t.addColumn("Nama Penyewa");
    t.addColumn("Plat Mobil");
    t.addColumn("Nama Mobil");
    t.addColumn("Tanggal Pinjam");
    t.addColumn("Lama Hari");
    t.addColumn("Tanggal Kembali");
    t.addColumn("Harga Rental");
    
   
    //t.addColumn("Hitung");
    Table.setModel(t);
    try {
        int i = 1;
        stat=con.createStatement();
        res=stat.executeQuery("SELECT transaksi.id_penyewa, mobil.nama_mobil, penyewa.nama_penyewa, transaksi.plat_mobil, transaksi.tgl_pinjam, transaksi.lama_hari, transaksi.tgl_kembali, transaksi.harga_rental FROM transaksi JOIN mobil ON transaksi.plat_mobil = mobil.plat_mobil JOIN penyewa ON transaksi.id_penyewa = penyewa.id_penyewa");

        while (res.next()) {
            t.addRow(new Object[]{
            res.getString("id_penyewa"),
            res.getString("nama_penyewa"),
            res.getString("plat_mobil"),
            res.getString("nama_mobil"),
            res.getString("tgl_pinjam"),
            res.getString("lama_hari"),
            res.getString("tgl_kembali"),
            res.getString("harga_rental"),
           
           
            //res.getString("hitung"),
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
    // </editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nama_penyewa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        harga_hasil = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        comboboxid = new javax.swing.JComboBox<>();
        comboboxplat = new javax.swing.JComboBox<>();
        nama_mobil = new javax.swing.JTextField();
        tampil_harga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lama_hari = new javax.swing.JTextField();
        hitung = new javax.swing.JButton();
        setruk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Transaction");

        nama_penyewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nama_penyewaMouseClicked(evt);
            }
        });
        nama_penyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_penyewaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Id Penyewa");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Plat Mobil");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tgl Pinjam");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tgl Kembali");

        harga_hasil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                harga_hasilMouseClicked(evt);
            }
        });
        harga_hasil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harga_hasilActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Harga");

        edit.setText("Refresh");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        simpan.setBackground(new java.awt.Color(0, 0, 153));
        simpan.setForeground(new java.awt.Color(255, 255, 255));
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        batal.setBackground(new java.awt.Color(0, 0, 0));
        batal.setForeground(new java.awt.Color(255, 255, 255));
        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(255, 0, 51));
        hapus.setForeground(new java.awt.Color(255, 255, 255));
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

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

        jLabel9.setText("Pengisisan data penyewaan mobil");

        comboboxid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboboxidItemStateChanged(evt);
            }
        });
        comboboxid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboboxidFocusLost(evt);
            }
        });
        comboboxid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboboxidMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comboboxidMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboboxidMousePressed(evt);
            }
        });
        comboboxid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxidActionPerformed(evt);
            }
        });

        comboboxplat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboboxplatFocusLost(evt);
            }
        });

        nama_mobil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nama_mobilFocusLost(evt);
            }
        });
        nama_mobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nama_mobilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nama_mobilMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nama_mobilMousePressed(evt);
            }
        });
        nama_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_mobilActionPerformed(evt);
            }
        });

        tampil_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampil_hargaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Lama Pinjam(Hari)");

        hitung.setText("Hitung");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });

        setruk.setText("Setruk");
        setruk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setrukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(kembali)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(simpan)
                                .addGap(12, 12, 12)
                                .addComponent(batal))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hapus)
                        .addGap(12, 12, 12)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setruk))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboboxid, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboboxplat, javax.swing.GroupLayout.Alignment.LEADING, 0, 196, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nama_mobil, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nama_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(tampil_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(hitung)
                                .addComponent(harga_hasil, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lama_hari, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboboxid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nama_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboboxplat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(nama_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tampil_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lama_hari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(harga_hasil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hitung)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kembali)
                    .addComponent(simpan)
                    .addComponent(batal)
                    .addComponent(edit)
                    .addComponent(hapus)
                    .addComponent(setruk))
                .addGap(76, 76, 76)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void harga_hasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harga_hasilActionPerformed
        // TODO add your handling code here:
        harga_hasil.setEnabled(false);
       
        
    }//GEN-LAST:event_harga_hasilActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        try{
            PreparedStatement st = con.prepareStatement("insert into transaksi (id_penyewa,plat_mobil,tgl_pinjam,lama_hari,tgl_kembali, harga_rental) values (?,?,?,?,?,?)");
            st.setString(1,comboboxid.getSelectedItem().toString());
            st.setString(2,comboboxplat.getSelectedItem().toString());
            st.setString(3,tgl_pinjam.getDate().toString());
            st.setString(4,lama_hari.getText());
            st.setString(5,tgl_kembali.getDate().toString());
            st.setString(6,harga_hasil.getText());
            //st.setString(6,hitung.getText());
            st.executeUpdate();
            kosongkan();
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Perintah Salah : "+e);
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        kosongkan();
    }//GEN-LAST:event_batalActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        if (comboboxid.getSelectedIndex() != -2) {
    int ok = JOptionPane.showConfirmDialog(null, "Apakah Yakin Menghapus Data Ini???", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
    if (ok == 0) {
        idpenyewa = String.valueOf(comboboxid.getSelectedItem());
        try {
            sql = "DELETE FROM transaksi"
                + " where id_penyewa='" + idpenyewa + "'";
            stat = con.createStatement();
            stat.execute(sql);
            kosongkan();
            TampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n" + e.getMessage());
        }
    }
} else {
    JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus");
}

    }//GEN-LAST:event_hapusActionPerformed

    private void nama_penyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_penyewaActionPerformed
         nama_penyewa.setEditable(false);
    }//GEN-LAST:event_nama_penyewaActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        int row = Table.getSelectedRow();
        int col = Table.getSelectedColumn();
        setIdpenyewa(Table.getValueAt(row, 0).toString());
        setNamapenyewa(Table.getValueAt(row, 1).toString());
        setPlatmobil(Table.getValueAt(row, 2).toString());
        setNamamobil(Table.getValueAt(row, 3).toString());
        setTglpinjam(Table.getValueAt(row, 4).toString());
        setTglkembali(Table.getValueAt(row, 5).toString());
        setLamahari(Table.getValueAt(row, 6).toString());
        setHargarental(Table.getValueAt(row, 7).toString());
    }//GEN-LAST:event_TableMouseClicked

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new dashboard().setVisible(true);
    }//GEN-LAST:event_kembaliActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        new Transaksi().setVisible(true);
    }//GEN-LAST:event_editActionPerformed

    private void comboboxidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxidActionPerformed
        
    }//GEN-LAST:event_comboboxidActionPerformed

    private void comboboxidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboboxidMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
           // TODO add your handling code here:
         
    }//GEN-LAST:event_comboboxidMouseClicked

    private void nama_penyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nama_penyewaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nama_penyewaMouseClicked

    private void comboboxidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboboxidItemStateChanged
        // TODO add your handling code here: 
    }//GEN-LAST:event_comboboxidItemStateChanged

    private void comboboxidMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboboxidMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboboxidMousePressed

    private void comboboxidMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboboxidMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboboxidMouseEntered

    private void comboboxidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboboxidFocusLost
        // TODO add your handling code here:
        handlerNama();
    }//GEN-LAST:event_comboboxidFocusLost

    private void nama_mobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nama_mobilMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_mobilMouseClicked

    private void nama_mobilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nama_mobilFocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_nama_mobilFocusLost

    private void nama_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_mobilActionPerformed
        // TODO add your handling code here:
        nama_mobil.setEditable(false);
        
    }//GEN-LAST:event_nama_mobilActionPerformed

    private void nama_mobilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nama_mobilMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_mobilMousePressed

    private void nama_mobilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nama_mobilMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_mobilMouseEntered

    private void comboboxplatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboboxplatFocusLost
        // TODO add your handling code here:
       handlermobil();
       handlerharga();
    }//GEN-LAST:event_comboboxplatFocusLost

    private void harga_hasilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_harga_hasilMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_harga_hasilMouseClicked

    private void tampil_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampil_hargaActionPerformed
        // TODO add your handling code here:
         handlerharga();
        tampil_harga.setEditable(false);
    }//GEN-LAST:event_tampil_hargaActionPerformed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
    try {
        // TODO add your handling code here:
        stat=con.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
    }
        String sql = "SELECT harga_rental FROM mobil where plat_mobil ='"+ comboboxplat.getSelectedItem().toString() +"'";

        int a = Integer.parseInt(lama_hari.getText());
        int b = Integer.parseInt(tampil_harga.getText());
        int hasil = a*b;
        harga_hasil.setText(""+hasil);
        
    }//GEN-LAST:event_hitungActionPerformed

    private void setrukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setrukActionPerformed
        // TODO add your handling code here:
            BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();

            g2d.setFont(new Font("Arial", Font.PLAIN, 20));

            g2d.drawString("Struk Pemasanan Rental Mobil\n", 50, 25);
            g2d.drawString("ID Penyewa: " + getIdpenyewa() , 50, 50);
            g2d.drawString("Nama Penyewa: " + getNamapenyewa(), 50, 75);
            g2d.drawString("Plat Mobil: " + getPlatmobil(), 50, 100);
            g2d.drawString("Nama Mobil: " + getNamamobil(), 50, 125);
            g2d.drawString("Tanggal Pinjam: " + getTglpinjam(), 50, 150);
            g2d.drawString("Tanggal Kembali: " + getTglkembali(), 50, 175);
            g2d.drawString("Lama Hari: " + getLamahari(), 50, 200);
            g2d.drawString("Harga Rental: " + getHargarental(), 50, 225);
            
            g2d.drawString("\n-------------------------------", 50, 250);

            g2d.dispose();

            try {
              ImageIO.write(image, "png", new File("struk.png"));
            } catch (Exception e) {
              e.printStackTrace();
       
            }
        
    }//GEN-LAST:event_setrukActionPerformed

    void handlerNama(){
        try {
            stat=con.createStatement();
            String sql = "SELECT nama_penyewa FROM penyewa where id_penyewa ='"+ comboboxid.getSelectedItem().toString() +"'";
            res = stat.executeQuery(sql);
            while(res.next()){  
                nama_penyewa.setText(res.getString("nama_penyewa"));
                System.out.print(res.getString("nama_penyewa"));
            }
        }catch (Exception e){
            System.out.print(e);
        }
         nama_penyewa.setEditable(false);
    }
    
    void handlermobil(){
         try {
            stat=con.createStatement();
            String sql = "SELECT nama_mobil FROM mobil where plat_mobil ='"+ comboboxplat.getSelectedItem().toString() +"'";
            res = stat.executeQuery(sql);
            while(res.next()){  
                nama_mobil.setText(res.getString("nama_mobil"));
                System.out.print(res.getString("nama_mobil"));
            }
        }catch (Exception e){
            System.out.print(e);
        }
         nama_mobil.setEditable(false);
    }
    
    void handlerharga(){
        try {
            stat=con.createStatement();
            String sql = "SELECT harga_rental FROM mobil where plat_mobil ='"+ comboboxplat.getSelectedItem().toString() +"'";
            res = stat.executeQuery(sql);
            while(res.next()){  
                tampil_harga.setText(res.getString("harga_rental"));
                System.out.print(res.getString("harga_rental"));
            }
        }catch (Exception e){
            System.out.print(e);
        }
         nama_mobil.setEditable(true);
    }
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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton batal;
    private javax.swing.JComboBox<String> comboboxid;
    private javax.swing.JComboBox<String> comboboxplat;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField harga_hasil;
    private javax.swing.JButton hitung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField lama_hari;
    private javax.swing.JTextField nama_mobil;
    private javax.swing.JTextField nama_penyewa;
    private javax.swing.JButton setruk;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField tampil_harga;
    // End of variables declaration//GEN-END:variables

    
}
