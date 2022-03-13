/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import SQLConnection.UserConnect;
import doiTuong.User;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class userService {
    private UserConnect userLink;
    
    public userService() {
        userLink = new UserConnect();
        
    }
    
    public List<User> getAllUsers(){
        return userLink.getAllUsers();
    }
    
    public void addUser(User user){
        userLink.addUser(user);
    }
    
    public void deleteUser(int id){
        userLink.deleteUser(id);
    }
}
