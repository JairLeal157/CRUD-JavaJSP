/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.Conexion;
import Modelo.Cliente;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcatl
 */
public class ClienteDAO implements CRUD {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conex = new Conexion();
    @Override
    public List listas() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String sql = "select * from clientes";
        try { 
           con = conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("Id"));
                cl.setNombre(rs.getString("Nombre"));
                cl.setEdad(rs.getInt("Edad"));
                cl.setEstadoCivil(rs.getString("EstadoCivil"));
                cl.setSexo(rs.getString("Sexo"));
                cl.setTrabaja(rs.getBoolean("trabaja"));
                cl.setPuntaje(rs.getInt("Puntaje"));
                listaClientes.add(cl);
            }   
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaClientes;
    }
    

    @Override
    public Cliente list(int id) {
        Cliente cl = new Cliente();
        String sql = "select * from clientes where id = "+id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cl.setId(rs.getInt("Id"));
                cl.setNombre(rs.getString("Nombre"));
                cl.setEdad(rs.getInt("Edad"));
                cl.setEstadoCivil(rs.getString("EstadoCivil"));
                cl.setSexo(rs.getString("Sexo"));
                cl.setTrabaja(rs.getBoolean("trabaja"));
                cl.setPuntaje(rs.getInt("Puntaje"));
            }
        } catch (Exception e) {
        }
        return cl;
    }

    @Override
    public boolean add(Cliente cl) {
       int trabaja = 1;
       if(cl.isTrabaja() == false){
           trabaja = 0;
       }
       
       String sql = "insert into clientes(Nombre, Edad, EstadoCivil, Sexo, Trabaja, Puntaje)values('"+cl.getNombre()+"', '"+cl.getEdad()+"','"+cl.getEstadoCivil()+"', '"+cl.getSexo()+"', '"+trabaja+"', '"+cl.getPuntaje()+"')";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       return false;
    }

    @Override
    public boolean delete(int id) {
        String sql ="delete from clientes where id = " + id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
   

    @Override
    public boolean edit(Cliente cl) {
       int trabaja = 1;
       if(cl.isTrabaja() == false){
           trabaja = 0;
       }
       String sql = "update clientes set Nombre='"+cl.getNombre()+"', Edad = '"+cl.getEdad()+"', EstadoCivil = '"+cl.getEstadoCivil()+"', Sexo = '"+cl.getSexo()+"', Trabaja = '"+trabaja+"', Puntaje =  '"+cl.getPuntaje()+"' where id = "+cl.getId();
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       return false;
    }
    
    public static void main(String[] args){
    }
}
