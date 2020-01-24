/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bayarzakat;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 *
 * @author USER
 */
public class muzaki extends javax.swing.JFrame {
    public static Connection conn = null;
    public static Statement stmt = null;
    public static final String USER = "root";
    public static final String PASS = "";
    private int hargaLogam = 0;
    private int idZakatHarta;
    private int idMuzaki;
    private int idPerhitungan;

    /**
     * Creates new form muzaki
     */
    public muzaki(int id) {
        initComponents();
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        this.setLocation(x, y);
        emas(); 
        idZakatHarta = id;
        tampil();
//        mBersih.setText(String.valueOf(id));
    }
    
    private void tampil(){
        try{
            String select = "SELECT * FROM `zakat_harta` WHERE `id` = "+idZakatHarta;
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet rs=stm.executeQuery(select);
            while(rs.next()){
                double hartaTab = rs.getDouble("harta_tab");
                double hartaLogam = rs.getDouble("harta_logam");
                double hartaSurat = rs.getDouble("harta_surat");
                double hartaProp = rs.getDouble("harta_properti");
                double hartaKendaraan = rs.getDouble("harta_kendaraan");
                double hartaKoleksi = rs.getDouble("harta_koleksi");
                double hartaStock = rs.getDouble("harta_stock_dagang");
                double hartaLain = rs.getDouble("harta_lainnya");
                double hartaPiutang = rs.getDouble("harta_piutang_lancar");
                double jmlHarta = rs.getDouble("jumlah_harta");
                double hartaTempo = rs.getDouble("harta_jatuh_tempo");
                double pengBersih = rs.getDouble("penghasilan_bersih");
                double zPertahun = rs.getDouble("zakat_pertahun");
                double zPerbulan = rs.getDouble("zakat_perbulan");
                mTabungan.setText(String.valueOf(hartaTab));
                mLogam.setText(String.valueOf(hartaLogam));
                mSurat.setText(String.valueOf(hartaSurat));
                mProperti.setText(String.valueOf(hartaProp));
                mKendaraan.setText(String.valueOf(hartaKendaraan));
                mKoleksi.setText(String.valueOf(hartaKoleksi));
                mDagang.setText(String.valueOf(hartaStock));
                mLain.setText(String.valueOf(hartaLain));
                mPiutang.setText(String.valueOf(hartaPiutang));
                mHarta.setText(String.valueOf(jmlHarta));
                mTempo.setText(String.valueOf(hartaTempo));
                mBersih.setText(String.valueOf(pengBersih));
                mPertahun.setText(String.valueOf(zPertahun));
                mPerbulan.setText(String.valueOf(zPerbulan));
            }
        } catch (Exception e){
           System.out.println("Error"); 
        }      
    }
    
    private void emas() {
        try {
            String select = "SELECT * FROM master_perhitungan";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet rs=stm.executeQuery(select);
    //        ResultSet rs = stm.executeQuery(select);
            while(rs.next()){
                double harga = rs.getDouble("harga");
//                System.out.println(harga);
                mEmas.setText(String.valueOf(harga));
                idPerhitungan = rs.getInt("id");
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    public void getLastData_muzaki () {
        try {
            String select = "SELECT * FROM `muzaki` ORDER BY `id` DESC limit 1";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet rs=stm.executeQuery(select);
            while(rs.next()){
                idMuzaki = rs.getInt("id");
//                return idMuzaki;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    public void data_muzaki() {
        try{   
            String sql = "INSERT INTO muzaki (nama_muzaki,no_telepon,alamat,email) "
                    + "VALUES ('" + nama.getText() + "','"
                    + telp.getText() + "','"
                    + alamat.getText() + "','"
                    + email.getText() + "')";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Tambah Data Berhasil");
         } catch (SQLException a){
             JOptionPane.showMessageDialog(this, "Tambah Data Gagal");
             a.printStackTrace();
         }
    }
    
    public void data_transaksi() {
        try{   
            String sql = "INSERT INTO transaksi_zakat (id_zakat, id_master_perhitungan, harga_emas, penghasilan_bersih, jumlah_pertahun, jumlah_perbulan, id_muzaki) "
                    + "VALUES ('" + idZakatHarta + "','"
                    + idPerhitungan + "','"
                    + mEmas.getText()+ "','"
                    + mBersih.getText() + "','"
                    + mPertahun.getText() + "','"
                    + mPerbulan.getText() + "','"
                    + idMuzaki + "')";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Tambah Data Berhasil");
            new formBayarZakat().setVisible(true);
            dispose();
         } catch (SQLException a){
             JOptionPane.showMessageDialog(this, "Tambah Data Gagal");
             a.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        alamat = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        mEmas = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        mBersih = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        mTabungan = new javax.swing.JLabel();
        mLogam = new javax.swing.JLabel();
        mSurat = new javax.swing.JLabel();
        mProperti = new javax.swing.JLabel();
        mKendaraan = new javax.swing.JLabel();
        mKoleksi = new javax.swing.JLabel();
        mDagang = new javax.swing.JLabel();
        mLain = new javax.swing.JLabel();
        mPiutang = new javax.swing.JLabel();
        mHarta = new javax.swing.JLabel();
        mTempo = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        mPerbulan = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        mPertahun = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Isi Data Muzaki");

        jLabel2.setText("Nama");

        jLabel3.setText("Nomer Telepon");

        jLabel4.setText("Alamat");

        jLabel5.setText("Email");

        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        mEmas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mEmas.setText("0");

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel67.setText("Harga Emas");

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel68.setText("Penghasilan Bersih");

        mBersih.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mBersih.setText("0");

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel69.setText("Harta jatuh tempo");

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel71.setText("Harta surat");

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel72.setText("Harta Stock dagang");

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel73.setText("Harta Logam");

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel74.setText("Harta Lainnya");

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel75.setText("Harta properti");

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel76.setText("Harta Koleksi");

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel77.setText("Harta kendaraan");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Harta Tabungan");

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel78.setText("Harta piutang lancar");

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel79.setText("Jumlah Harta");

        mTabungan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mTabungan.setText("0");

        mLogam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mLogam.setText("0");

        mSurat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mSurat.setText("0");

        mProperti.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mProperti.setText("0");

        mKendaraan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mKendaraan.setText("0");

        mKoleksi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mKoleksi.setText("0");

        mDagang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mDagang.setText("0");

        mLain.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mLain.setText("0");

        mPiutang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mPiutang.setText("0");

        mHarta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mHarta.setText("0");

        mTempo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mTempo.setText("0");

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel92.setText("Jumlah Perbulan");

        mPerbulan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mPerbulan.setText("0");

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel93.setText("Jumlah Pertahun");

        mPertahun.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mPertahun.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel92)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mPerbulan))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel68)
                            .addComponent(jLabel71)
                            .addComponent(jLabel73)
                            .addComponent(jLabel75)
                            .addComponent(jLabel77)
                            .addComponent(jLabel76)
                            .addComponent(jLabel72)
                            .addComponent(jLabel74)
                            .addComponent(jLabel78)
                            .addComponent(jLabel79)
                            .addComponent(jLabel69))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mTabungan)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mBersih)
                                .addComponent(mEmas))
                            .addComponent(mLogam)
                            .addComponent(mSurat)
                            .addComponent(mProperti)
                            .addComponent(mKendaraan)
                            .addComponent(mKoleksi)
                            .addComponent(mDagang)
                            .addComponent(mLain)
                            .addComponent(mPiutang)
                            .addComponent(mHarta)
                            .addComponent(mTempo)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel93)
                        .addGap(196, 196, 196)
                        .addComponent(mPertahun)))
                .addGap(50, 50, 50))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jLabel67)
                    .addContainerGap(282, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(mEmas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(mBersih))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(mTabungan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mLogam)
                    .addComponent(jLabel73))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mSurat)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mProperti)
                    .addComponent(jLabel75))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mKendaraan)
                    .addComponent(jLabel77))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mKoleksi)
                    .addComponent(jLabel76))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mDagang)
                    .addComponent(jLabel72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mLain)
                    .addComponent(jLabel74))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mPiutang)
                    .addComponent(jLabel78))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mHarta)
                    .addComponent(jLabel79))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mTempo)
                    .addComponent(jLabel69))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(mPerbulan))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mPertahun)
                    .addComponent(jLabel93))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jLabel67)
                    .addContainerGap(421, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(telp, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(110, 110, 110)
                                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(simpan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(simpan)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:        
        data_muzaki();
        getLastData_muzaki();
        data_transaksi();
    }//GEN-LAST:event_simpanActionPerformed

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
            java.util.logging.Logger.getLogger(muzaki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(muzaki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(muzaki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(muzaki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muzaki(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel mBersih;
    private javax.swing.JLabel mDagang;
    private javax.swing.JLabel mEmas;
    private javax.swing.JLabel mHarta;
    private javax.swing.JLabel mKendaraan;
    private javax.swing.JLabel mKoleksi;
    private javax.swing.JLabel mLain;
    private javax.swing.JLabel mLogam;
    private javax.swing.JLabel mPerbulan;
    private javax.swing.JLabel mPertahun;
    private javax.swing.JLabel mPiutang;
    private javax.swing.JLabel mProperti;
    private javax.swing.JLabel mSurat;
    private javax.swing.JLabel mTabungan;
    private javax.swing.JLabel mTempo;
    private javax.swing.JTextField nama;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField telp;
    // End of variables declaration//GEN-END:variables
}
