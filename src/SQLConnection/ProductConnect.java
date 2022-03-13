/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLConnection;

import doiTuong.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ProductConnect {
    public List<Product> getAllProduct(){
        List<Product> products = new ArrayList<>();
        Connection connection = ServerConnect.getConnection();
        String sql = "SELECT * FROM SanPham";
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            
            while( rs.next()) {
                Product product = new Product();
                
                product.setMaSP(rs.getString("maSP"));
                product.setTenSP(rs.getString("tenSP"));
                product.setDonGiaBan(rs.getFloat("donGiaBan"));
                product.setTenNSX(rs.getString("tenNSX"));
                product.setSoLuongHienCon(rs.getInt("soLuongHienCon"));
                
                products.add(product);
            }
        } catch(SQLException e){
            System.out.println("lay du lieu Product loi");
        }
        return products;
    }
    
    public Product searchSanPham(String id)
    {
        Product product= new Product();
        Connection connect = ServerConnect.getConnection();
        
        try {
            String sql=  "select * from SanPham where maSP=?";
            
            PreparedStatement pstmt = connect.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            product.setMaSP(rs.getString("maSP"));
            product.setTenSP(rs.getString("tenSP"));
            product.setDonGiaBan(rs.getFloat("donGiaBan"));
            product.setTenNSX(rs.getString("tenNSX"));
            product.setSoLuongHienCon(rs.getInt("soLuongHienCon"));
            
            return product;
            
        }
        catch(SQLException e)
        {
            System.out.println("khong thay ma sp");
            return null;
        }      
    }
    
    public void deteleProduct(String id)
    {
        Connection connection = ServerConnect.getConnection();
        String sql = "delete SanPham "
                + "where maSP=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);        
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("xoa loi");
        }
    }
    
    
//    public Product getdataProduct(String productid)
//    {
//        Product product= new Product();
//        Connection connect = ServerConnect.getConnection();
//        
//        try {
//            String sql=  "select * " +
//                         "from SanPham " +
//                         "where maSP=? ";
//            PreparedStatement pstmt = connect.prepareStatement(sql);
//            pstmt.setString(1,productid);
//            ResultSet rs = pstmt.executeQuery();
//            rs.next();
//            product.setMaSP(rs.getString("maSP"));
//            product.setTenSP(rs.getString("tenSP"));
//            product.setDonGiaBan(rs.getFloat("donGiaBan"));
//            product.setTenNSX(rs.getString("tenNSX"));
//            product.setSoLuongHienCon(rs.getInt("soLuongHienCon"));
//            
//            return product;
//            
//        }
//        catch(SQLException e)
//        {
//            System.out.println("tim theo ma sp that bai");
//            return null;
//        }      
//    }
    
    public void updateDataProduct(Product product)
    {
        Connection connect = ServerConnect.getConnection();
        try {
            String sql=  "UPDATE SanPham "
                    + "SET tenSP=?,donGiaBan=?,tenNSX=? ,soLuongHienCon=? "
                    + "WHERE maSP=?";
            PreparedStatement pstmt = connect.prepareStatement(sql);
            
            pstmt.setString(1, product.getTenSP());
            pstmt.setFloat(2, product.getDonGiaBan());
            pstmt.setString(3, product.getTenNSX());
            pstmt.setInt(4, product.getSoLuongHienCon());
            pstmt.setString(5, product.getMaSP());
            
            pstmt.execute();
        }
        catch(SQLException e)
        {
            System.out.println("update sp that bai");
        }      
    }
    
    public void addProduct(Product product)
    {
            Connection connection = ServerConnect.getConnection();
            
            String sql = "INSERT INTO SanPham "
                    + "values(dbo.FN_idTiepSanPham(),?,?,?,?)";
            
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, product.getTenSP());
                preparedStatement.setFloat(2, product.getDonGiaBan());
                preparedStatement.setString(3, product.getTenNSX());
                preparedStatement.setInt(4, product.getSoLuongHienCon());
                
                preparedStatement.execute();
        } catch (SQLException e) {
                System.out.println("Them sp that bai");
        }
    }
}
