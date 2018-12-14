/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


 import Config.koneksi; 
import java.sql.*; 
public class Product {
      
        koneksi kon = new koneksi();
         String IDProd, Nama;     
         int Stok, Price;
         
          public String getIDProd(){return IDProd;}  
          public String getNama(){return Nama;}   
          public int getStok(){return Stok;}   
          public int getPrice(){return Price;} 
          
               public void setIDProd(String IDProd){this.IDProd=IDProd;} 
               public void setNama(String Nama){this.Nama=Nama;}     
               public void setStok(int Stok){this.Stok=Stok;}   
               public void setPrice(int Price){this.Price=Price;} 
               
                public ResultSet readAll() { 
                     try 
                     {
                           Connection con = kon.openConnection();            
                           String sql = "select * from produk";          
                           Statement state = con.createStatement();      
                           ResultSet rs = state.executeQuery(sql);       
                           return rs; 
                            } catch (Exception e) { 
                                 System.err.println(e);             
                                 return null;   
                     }
    }
                 public int store() { 
                      try
                      {
                           Connection con = kon.openConnection();       
                           String sql = "insert produk values(?,?,?,?)";         
                           PreparedStatement ps = con.prepareStatement(sql);         
                           ps.setString(1, this.IDProd);          
                           ps.setString(2, this.Nama);       
                           ps.setInt(3, this.Stok);        
                           ps.setInt(4, this.Price);          
                           int res = ps.executeUpdate();        
                           return res;   
                      } catch (Exception e) {   
                           System.err.println(e);         
                           return 0; 
                       }
                  }
                 public ResultSet readByID() { 
                       try
                       {     
                            Connection con = kon.openConnection();      
                            String sql = "select * from produk where idprod = ?";       
                            PreparedStatement ps = con.prepareStatement(sql);        
                            ps.setString(1, this.IDProd);           
                            ResultSet rs = ps.executeQuery();         
                            return rs;   
                      } catch (Exception e) {
                           System.err.println(e);          
                           return null; 
                       }
                 }
                 
                 public int update() { 
                     try
                     {
                          Connection con = kon.openConnection();        
                          String sql = "update produk set nama=?, stok=?, price=? where idprod=?";         
                          PreparedStatement ps = con.prepareStatement(sql);        
                          ps.setString(1, this.Nama);        
                          ps.setInt(2, this.Stok);         
                          ps.setInt(3, this.Price);          
                          ps.setString(4, this.IDProd);        
                          int res = ps.executeUpdate();         
                          return res;   
                      } catch (Exception e) { 
                           System.err.println(e);            
                           return 0; 
                     }
                 }
                 
                 public int destroy() { 
                     try
                     {
                          Connection con = kon.openConnection();          
                          String sql = "delete from produk where idprod = ?";      
                          PreparedStatement ps = con.prepareStatement(sql);         
                          ps.setString(1, this.IDProd);         
                          int res = ps.executeUpdate();        
                          return res;   
                     } catch (Exception e) { 
                          System.err.println(e);            
                          return 0; 
                          
                     }
                     
                 }
                 
}


