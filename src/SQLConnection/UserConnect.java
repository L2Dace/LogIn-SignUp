/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLConnection;

import doiTuong.User;
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
public class UserConnect {
    
    
    /**
     *
     * @param user
     */
    public void addUser (User user){
            Connection connection = ServerConnect.getConnection();
            
            String sql = "INSERT INTO NguoiDung (Ten,Sdt,TenTK,Matkhau,GioiThieu,VaiTro,SoThich) "
                    + "values (?,?,?,?,?,?,?) "
                    ;
            
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getTen());
                preparedStatement.setString(2, user.getSdt());
                preparedStatement.setString(3, user.getTenTK());
                preparedStatement.setString(4, user.getMatKhau());
                preparedStatement.setString(5, user.getGioiThieu());
                preparedStatement.setString(6, user.getVaiTro());
                preparedStatement.setString(7, user.getSoThich());
                
//                int rs = preparedStatement.executeUpdate();
//                System.out.println(rs);
                preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    
    public void deleteUser(int id){
        Connection connection = ServerConnect.getConnection();
        
        String sql = "delete from NguoiDung where ID = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public User checkUser(User check )
    {
        User user= new User();
        Connection connection = ServerConnect.getConnection();
        
        String sql = "SELECT * FROM NguoiDung "
                + "WHERE tenTK=? and matKhau=?";
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, check.getTenTK());
            preparedStatement.setString(2, check.getMatKhau());
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();      
            user.setId(rs.getInt("ID"));// tên cột
            user.setTen(rs.getString("ten"));
            user.setSdt(rs.getString("sdt"));
            user.setTenTK(rs.getString("tenTK"));
            user.setMatKhau(rs.getString("matKhau"));
            user.setGioiThieu(rs.getString("gioiThieu"));
            user.setVaiTro(rs.getString("vaiTro"));
            user.setSoThich(rs.getString("soThich"));
            return user;
        } catch(SQLException e){
            System.out.println("Tai khoan va mat khau sai");
            return null;
        }
    }
    
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        Connection connection = ServerConnect.getConnection();
        
        String sql = "SELECT * FROM NguoiDung";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while( rs.next()) {
                User user = new User();
                
                user.setId(rs.getInt("id"));
                user.setTen(rs.getString("ten"));
                user.setSdt(rs.getString("sdt"));
                user.setTenTK(rs.getString("tenTK"));
                user.setMatKhau(rs.getString("matKhau"));
                user.setGioiThieu(rs.getString("gioiThieu"));
                user.setVaiTro(rs.getString("vaiTro"));
                user.setSoThich(rs.getString("soThich"));
                
                users.add(user);
            }
        } catch(SQLException e){
            System.out.println("Lay du lieu user bi loi");
            e.printStackTrace();
        }
        return users;
    }
}
