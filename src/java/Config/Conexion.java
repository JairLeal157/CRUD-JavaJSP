/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import Modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jcatl
 */
public class Conexion {
    Connection con;
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/crud?autoReconnect=true&useSSL=false";
    private static String user = "user";
    private static String password = "root";

    public Conexion() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            String ed = e.getMessage();
            System.out.println(ed);
        }
    }
    
    public Connection getConnection(){
        return con;
   }
}