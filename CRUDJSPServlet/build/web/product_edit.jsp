<%-- 
    Document   : product_edit
    Created on : Dec 14, 2018, 10:27:25 PM
    Author     : GIBRAN
--%>
<%@page import="com.oracle.webservices.api.databinding.DatabindingModeFeature.ID"%>
<%@page import="java.sql.ResultSet"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
    </head>
    <body>
        <h1>>Edit Product</h1>
         <form action="Product_Update" method="POST">     
             <%           
                 ResultSet rs = (ResultSet) request.getAttribute("data");        
                 if (rs.next()) {  
                         ID Prod : <input readonly type="text" name="idprod" value="<% out.println(rs.getString(1)); %>"><br><br>    
                                                  
                                 Nama : <input type="text" name="nama" value="<% out.println(rs.getString(2)); %>"><br><br>   
                                 Stok : <input type="text" name="stok" value="<% out.println(rs.getInt(3)); %>"><br><br>   
                                 Price : <input type="text" name="price" value="<% out.println(rs.getInt(4)); %>"><br><br>  
                       %>"><br><br> 
                       <%
                           }    
%> 
<input type="submit" value="Simpan"> 
                         %>
    }          
    </form> 
    </body>
</html>
