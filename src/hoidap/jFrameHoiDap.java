/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoidap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.lucene.queryparser.classic.ParseException;


/**
 *
 * @author VietDuc
 */
public class jFrameHoiDap extends javax.swing.JFrame {

    /**
     * Creates new form jFrameHoiDap
     */
        public jFrameHoiDap() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField_CauHoi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_DapAn = new javax.swing.JTextArea();
        jButton_Thoat = new javax.swing.JButton();
        jButton_TimKiem = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField_FileCauHoi = new javax.swing.JTextField();
        jTextField_FileDapAn = new javax.swing.JTextField();
        jTextField_FileDuLieu = new javax.swing.JTextField();
        jButton_FileCauHoi = new javax.swing.JButton();
        jButton_FileDapAn = new javax.swing.JButton();
        jButton_DuLieu = new javax.swing.JButton();
        jButton_ChamTuDong = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_MRR = new javax.swing.JTextField();
        jTextField_CWS = new javax.swing.JTextField();
        jButton_DapAnHeThong = new javax.swing.JButton();
        jTextField_DapAnHeThong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField_CauHoi.setText("Nhập câu hỏi");
        jTextField_CauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CauHoiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Câu hỏi");

        jTextArea_DapAn.setColumns(20);
        jTextArea_DapAn.setRows(5);
        jScrollPane1.setViewportView(jTextArea_DapAn);

        jButton_Thoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_Thoat.setText("Thoát");
        jButton_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThoatActionPerformed(evt);
            }
        });

        jButton_TimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_TimKiem.setText("Tìm kiếm");
        jButton_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField_CauHoi)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField_CauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField_FileCauHoi.setText("Chọn đường dẫn câu hỏi");

        jTextField_FileDapAn.setText("Chọn đường dẫn đáp án");

        jTextField_FileDuLieu.setText("Chọn đường dẫn dữ liệu");

        jButton_FileCauHoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_FileCauHoi.setText("File Câu hỏi");
        jButton_FileCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FileCauHoiActionPerformed(evt);
            }
        });

        jButton_FileDapAn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_FileDapAn.setText("File Đáp Án");
        jButton_FileDapAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FileDapAnActionPerformed(evt);
            }
        });

        jButton_DuLieu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_DuLieu.setText("Dữ liệu");
        jButton_DuLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DuLieuActionPerformed(evt);
            }
        });

        jButton_ChamTuDong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ChamTuDong.setText("Chấm tự động");
        jButton_ChamTuDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChamTuDongActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("MRR");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("CWS");
        jLabel5.setToolTipText("");

        jTextField_MRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MRRActionPerformed(evt);
            }
        });

        jButton_DapAnHeThong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_DapAnHeThong.setText("Đáp Án Hệ Thống");
        jButton_DapAnHeThong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DapAnHeThongActionPerformed(evt);
            }
        });

        jTextField_DapAnHeThong.setText("Chọn đường dẫn lưu đáp án của hệ thống");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(314, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_CWS, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(jTextField_MRR)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton_DapAnHeThong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_FileCauHoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_DuLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_FileDapAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_ChamTuDong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField_FileDuLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_FileDapAn)
                                    .addComponent(jTextField_FileCauHoi)
                                    .addComponent(jTextField_DapAnHeThong, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))))
                        .addGap(19, 19, 19))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_FileCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_FileCauHoi, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_FileDapAn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_FileDapAn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_DapAnHeThong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_DapAnHeThong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_DuLieu)
                    .addComponent(jTextField_FileDuLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton_ChamTuDong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_MRR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_CWS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("CÁC HỆ THỐNG HỎI ĐÁP - CS323.H11");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(470, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void jTextField_CauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_CauHoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_CauHoiActionPerformed

    //Nút tìm kiếm ở giao diện chính
    private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemActionPerformed
      
        String CauHoi = jTextField_CauHoi.getText();
        CauHoi = CauHoi.replace("?", "");
        if (CauHoi.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa nhập câu hỏi !!!");
        } else {
            try {
                String pathDuLieu = jTextField_FileDuLieu.getText();
                if (pathDuLieu.equalsIgnoreCase("Chọn đường dẫn dữ liệu") || pathDuLieu.trim().isEmpty()) {
                    pathDuLieu = "Dulieucauhoi";
                }
                System.out.println("Đường dẫn : " + pathDuLieu);
                
                int LoaiCauHoi = clsPhanTichCauHoi.PhanLoaiCauHoi(CauHoi);
                List<String> KetQua = clsXuLy.XuLy(CauHoi, LoaiCauHoi, pathDuLieu);
                String strKetQua = "";
                for (int i = 0; i < 5; i++) {
                    String temp = (i + 1) + ") " + KetQua.get(i) + "\r\n";
                    strKetQua += temp;
                }
                jTextArea_DapAn.setText(clsLucene.f);
                JOptionPane.showMessageDialog(null, "Đã tìm kiếm xong !!");

            } catch (IOException ex) {
                Logger.getLogger(jFrameHoiDap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(jFrameHoiDap.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton_TimKiemActionPerformed

    //Làm mới text hỏi và text trả lời
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextField_CauHoi.setText("");
        jTextArea_DapAn.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    //Thoát chương trình
    private void jButton_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton_ThoatActionPerformed

    private void jTextField_MRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_MRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_MRRActionPerformed

    //Chấm kết quả tự động
    private void jButton_ChamTuDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChamTuDongActionPerformed
        // TODO add your handling code here:
        try {
            //Lấy đường dẫn file câu hỏi
            String pathCauHoi = jTextField_FileCauHoi.getText();
            if (pathCauHoi.equalsIgnoreCase("Chọn đường dẫn câu hỏi") || pathCauHoi.trim().isEmpty()) {
                pathCauHoi = "CauHoi.txt";
            }
            
            //Lấy đường dẫn folder chứa dữ liệu
            String pathDuLieu = jTextField_FileDuLieu.getText();
            if (pathDuLieu.equalsIgnoreCase("Chọn đường dẫn dữ liệu") || pathDuLieu.trim().isEmpty()) {
                pathDuLieu = "Dulieucauhoi";
            }
            
            // Danh sách kết quả trả lời của hệ thống
            List<String> KetQua = new ArrayList(); 
            KetQua = clsXuLy.XuLyFileCauHoi(pathCauHoi , pathDuLieu);
            double SoLuongCauHoi = clsXuLy.SoLuongCauHoi;     
            
            //Lấy đường dẫn đáp án của hệ thống
            String pathDapAnHeThong = jTextField_DapAnHeThong.getText();
            if (pathDapAnHeThong.equalsIgnoreCase("Chọn đường dẫn lưu đáp án của hệ thống") || pathDapAnHeThong.trim().isEmpty()) {
                pathDapAnHeThong = "DapAnHeThong.txt";
            }
            
            //Ghi kết quả xuống File
            clsRutTrichCauTraLoi.GhiKetQuaRaFile(KetQua, pathDapAnHeThong);

            //Tính MRR
            System.out.println("Số lượng câu hỏi : " + SoLuongCauHoi);
            String pathDapAn = jTextField_FileDapAn.getText();
            if (pathDapAn.equalsIgnoreCase("Chọn đường dẫn đáp án") || pathDapAn.trim().isEmpty()) {
                pathDapAn = "DapAn.txt";
            }
            double ResultMRR = 0;
            ResultMRR = clsMRR.TinhMRR(KetQua, pathDapAn, SoLuongCauHoi);
            System.out.println("===> MRR : " + String.valueOf(ResultMRR));
            jTextField_MRR.setText(String.valueOf(ResultMRR));
           
            //Tính CWS           
            double ResultCWS = 0;
            ResultCWS = clsCWS.TinhCWS(KetQua, pathDapAn, SoLuongCauHoi);
            System.out.println("===> CWS : " + String.valueOf(ResultCWS));
            jTextField_CWS.setText(String.valueOf(ResultCWS));

            JOptionPane.showMessageDialog(null, "Đã chấm xong !!!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(jFrameHoiDap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(jFrameHoiDap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(jFrameHoiDap.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (ParseException ex) { 
                Logger.getLogger(jFrameHoiDap.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }//GEN-LAST:event_jButton_ChamTuDongActionPerformed

    //Load dữ liệu
    private void jButton_DuLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DuLieuActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            jTextField_FileDuLieu.setText(chooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_jButton_DuLieuActionPerformed

    //Load đáp án
    private void jButton_FileDapAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FileDapAnActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int select = chooser.showOpenDialog(null);
        if (select == chooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            jTextField_FileDapAn.setText(filename);
        }
    }//GEN-LAST:event_jButton_FileDapAnActionPerformed

    //Load câu hỏi
    private void jButton_FileCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FileCauHoiActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int select = chooser.showOpenDialog(null);
        if (select == chooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            jTextField_FileCauHoi.setText(filename);
        }
    }//GEN-LAST:event_jButton_FileCauHoiActionPerformed

    //Save đáp án của hệ thống
    private void jButton_DapAnHeThongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DapAnHeThongActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int select = chooser.showSaveDialog(null);
        if (select == chooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            jTextField_DapAnHeThong.setText(filename);
        }

    }//GEN-LAST:event_jButton_DapAnHeThongActionPerformed

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
            java.util.logging.Logger.getLogger(jFrameHoiDap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameHoiDap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameHoiDap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameHoiDap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrameHoiDap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_ChamTuDong;
    private javax.swing.JButton jButton_DapAnHeThong;
    private javax.swing.JButton jButton_DuLieu;
    private javax.swing.JButton jButton_FileCauHoi;
    private javax.swing.JButton jButton_FileDapAn;
    private javax.swing.JButton jButton_Thoat;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_DapAn;
    private javax.swing.JTextField jTextField_CWS;
    private javax.swing.JTextField jTextField_CauHoi;
    private javax.swing.JTextField jTextField_DapAnHeThong;
    private javax.swing.JTextField jTextField_FileCauHoi;
    private javax.swing.JTextField jTextField_FileDapAn;
    private javax.swing.JTextField jTextField_FileDuLieu;
    private javax.swing.JTextField jTextField_MRR;
    // End of variables declaration//GEN-END:variables
}
