/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import SQLConnection.ProductConnect;
import doiTuong.Product;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class productService {
    private ProductConnect prodLink;
    
    public productService(){
        prodLink = new ProductConnect();
    }
    
    public List<Product> getAllProduct(){
        return prodLink.getAllProduct();
    }
    
    public void addProduct(Product product){
        prodLink.addProduct(product);
    }
    public void deleteProduct(String id){
        prodLink.deteleProduct(id);
    }
    public void searchProduct(String id){
        prodLink.searchSanPham(id);
    }
    public void updateProduct(Product product){
        prodLink.updateDataProduct(product);
    }
}
