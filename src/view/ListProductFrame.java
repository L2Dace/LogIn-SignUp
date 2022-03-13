/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import SQLConnection.ProductConnect;
import Services.productService;
import doiTuong.Product;
import doiTuong.User;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ListProductFrame extends javax.swing.JFrame {

    productService productService;
    ProductConnect productConnect;
    DefaultTableModel defaultTableModel;
    User usercode;
    /**
     * Creates new form ListProductFrame
     */
    public ListProductFrame() {
        initComponents();
        productService = new productService();
        productConnect = new ProductConnect();
    }

    public ListProductFrame(User user) {
        initComponents();
        productService = new productService();
        tentaikhoan.setText(user.getTenTK());
        tenvaitro.setText(user.getVaiTro());
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }    
        };
        tabledata.setModel(defaultTableModel);
        
        defaultTableModel.addColumn("Mã SP");
        defaultTableModel.addColumn("Tên SP");
        defaultTableModel.addColumn("Đơn giá");
        defaultTableModel.addColumn("Tên NSX");
        defaultTableModel.addColumn("Số lượng");
        
        setTableData(productService.getAllProduct());
        
        if (user.getVaiTro().equals("User"))
        {
            AddProductButton.setEnabled(false);
            EditProdButton.setEnabled(false);
            ExitButton.setEnabled(false);
            DeleteProductButton.setEnabled(false);
        }
        
        usercode = new User(user);
        
    }

    private void setTableData(List<Product> products)
    {
        for (Product i : products) {
            defaultTableModel.addRow(new Object[]{i.getMaSP(),i.getTenSP(),i.getDonGiaBan(),
                i.getTenNSX(),i.getSoLuongHienCon()});
        }; 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tenvaitro = new javax.swing.JTextField();
        signoutbutton = new javax.swing.JButton();
        UserButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledata = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tentaikhoan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        AddProductButton = new javax.swing.JButton();
        EditProdButton = new javax.swing.JButton();
        DeleteProductButton = new javax.swing.JButton();
        SearchProdButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tenvaitro.setEditable(false);
        tenvaitro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tenvaitro.setText("User");

        signoutbutton.setBackground(new java.awt.Color(255, 51, 51));
        signoutbutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signoutbutton.setForeground(new java.awt.Color(255, 255, 255));
        signoutbutton.setText("Log Out");
        signoutbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signoutbuttonActionPerformed(evt);
            }
        });

        UserButton.setBackground(new java.awt.Color(0, 204, 255));
        UserButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserButton.setForeground(new java.awt.Color(255, 255, 255));
        UserButton.setText("Users");
        UserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserButtonActionPerformed(evt);
            }
        });

        tabledata.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabledata);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý sản phẩm");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên tài khoản :");

        tentaikhoan.setEditable(false);
        tentaikhoan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Vai trò :");

        jPanel2.setLayout(new java.awt.GridLayout(1, 5, 20, 20));

        AddProductButton.setBackground(new java.awt.Color(51, 255, 51));
        AddProductButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AddProductButton.setForeground(new java.awt.Color(255, 255, 255));
        AddProductButton.setText("Thêm");
        AddProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductButtonActionPerformed(evt);
            }
        });
        jPanel2.add(AddProductButton);

        EditProdButton.setBackground(new java.awt.Color(0, 255, 204));
        EditProdButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        EditProdButton.setForeground(new java.awt.Color(255, 255, 255));
        EditProdButton.setText("Sửa");
        EditProdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProdButtonActionPerformed(evt);
            }
        });
        jPanel2.add(EditProdButton);

        DeleteProductButton.setBackground(new java.awt.Color(255, 51, 51));
        DeleteProductButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DeleteProductButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteProductButton.setText("Xóa");
        DeleteProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteProductButtonActionPerformed(evt);
            }
        });
        jPanel2.add(DeleteProductButton);

        SearchProdButton.setBackground(new java.awt.Color(255, 204, 0));
        SearchProdButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SearchProdButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchProdButton.setText("Tìm kiếm");
        SearchProdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchProdButtonActionPerformed(evt);
            }
        });
        jPanel2.add(SearchProdButton);

        ExitButton.setBackground(new java.awt.Color(204, 204, 204));
        ExitButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ExitButton.setForeground(new java.awt.Color(255, 255, 255));
        ExitButton.setText("Thoát");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        jPanel2.add(ExitButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(UserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tentaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tenvaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(signoutbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(UserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tentaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tenvaitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signoutbutton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signoutbuttonActionPerformed
        new SignInFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signoutbuttonActionPerformed

    private void UserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserButtonActionPerformed
        new ListUserFrame(usercode).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UserButtonActionPerformed

    private void AddProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductButtonActionPerformed
        new AddProductFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddProductButtonActionPerformed

    private void DeleteProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteProductButtonActionPerformed
        int row = tabledata.getSelectedRow();
        String id="";
        if (row == -1) {
            String x=JOptionPane.showInputDialog(null,"Nhập mã sản phẩm cần xóa");
            if (x==null) System.out.print("");
            else {
                id=x;
                productService.deleteProduct(x);
            }
        }
        else
        {
            id+=String.valueOf(tabledata.getValueAt (row, 0));
            int confirm = JOptionPane.showConfirmDialog(this, "Ban chac chan muon xoa khong?");
            if (confirm == JOptionPane. YES_OPTION)
            {
                String userId =String.valueOf(tabledata.getValueAt (row, 0));
                productService.deleteProduct(userId);
            }
        }
        defaultTableModel.setRowCount(0);
        setTableData(productService.getAllProduct());
    }//GEN-LAST:event_DeleteProductButtonActionPerformed

    private void EditProdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProdButtonActionPerformed
        int row = tabledata.getSelectedRow();
        if (row == -1) {
            String x=JOptionPane.showInputDialog(null,"Nhập mã tài liệu cần sửa");
            if (x==null || x.equals(""));
            else if (productConnect.searchSanPham(x)==null)
            {
                JOptionPane.showMessageDialog(this, "Không có mã"+ x +" trong danh sách", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                new UpdateProductFrame(x,usercode).setVisible(true);
                this.dispose();
            }
        }
        else
        {
            String userId =String.valueOf(tabledata.getValueAt (row, 0));
            new UpdateProductFrame(userId,usercode).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_EditProdButtonActionPerformed

    private void SearchProdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchProdButtonActionPerformed
        String x=JOptionPane.showInputDialog(null,"Nhập mã sản phẩm cần tìm");
        if (x==null) ;
        else if (productConnect.searchSanPham(x)==null)
        {
            JOptionPane.showMessageDialog(this, "Không có mã"+ x +" trong danh sách", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            new SearchProductFrame(productConnect.searchSanPham(x),usercode).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_SearchProdButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ListProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ListProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ListProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ListProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        User user = new User();
//        user.setVaiTro("Admin");
//        user.setTenTK("Duy");
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ListProductFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProductButton;
    private javax.swing.JButton DeleteProductButton;
    private javax.swing.JButton EditProdButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton SearchProdButton;
    private javax.swing.JButton UserButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton signoutbutton;
    private javax.swing.JTable tabledata;
    private javax.swing.JTextField tentaikhoan;
    private javax.swing.JTextField tenvaitro;
    // End of variables declaration//GEN-END:variables
}
