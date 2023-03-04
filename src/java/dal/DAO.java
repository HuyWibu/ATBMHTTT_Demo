/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.User;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from tbl_products";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString(1),
                                        rs.getString(2),
                                        rs.getDouble(3),
                                        rs.getString(4),
                                        rs.getString(5));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product> getProductBySearch(String search){
        List<Product> list = new ArrayList<>();
        String sql = "select * from tbl_products where name like '%" + search + "%'";
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Product p = new Product(rs.getString(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getString(4),
                            rs.getString(5));
                    list.add(p);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        return list;
    }

    public static void main(String[] args) {
        DAO d = new DAO();
        List<Product> list = d.getProductBySearch("denim");
        for(Product p : list){
            System.out.println(p);
        }
    }
}
