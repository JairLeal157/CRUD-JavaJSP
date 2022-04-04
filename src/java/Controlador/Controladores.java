/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import ModeloDAO.ClienteDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author jcatl
 */
public class Controladores extends HttpServlet {

    String index = "index.jsp";
    String agregar = "vistas/Agregar.jsp";
    String buscar = "vistas/Buscar.jsp";
    String editar = "vistas/EditarEliminar.jsp";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso ="";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("agregar")){
            acceso = agregar;
        }
        if (action.equalsIgnoreCase("index")){
            acceso = index;
        }
        if (action.equalsIgnoreCase("editar")){
            request.setAttribute("idPersona", request.getParameter("id"));
            acceso = editar;
        }
        if(action.equalsIgnoreCase("add")){
            Cliente cl = new Cliente();
            ClienteDAO dao = new ClienteDAO();
            cl.setNombre(request.getParameter("Nombre"));
            cl.setEdad(Integer.parseInt(request.getParameter("Edad")));
            cl.setEstadoCivil(request.getParameter("Civil"));
            cl.setSexo(request.getParameter("Sexo"));
            boolean trabaja = false;
            if("SI".equals(request.getParameter("Trabaja"))){
               trabaja = true;
            }
            cl.setTrabaja(trabaja);
            cl.calcularPuntaje();
            dao.add(cl);
            acceso = index;
        }
        if(action.equalsIgnoreCase("actualizar")){
            Cliente cl = new Cliente();
            ClienteDAO dao = new ClienteDAO();
            cl.setNombre(request.getParameter("Nombre"));
            cl.setEdad(Integer.parseInt(request.getParameter("Edad")));
            cl.setEstadoCivil(request.getParameter("Civil"));
            cl.setSexo(request.getParameter("Sexo"));
            cl.setId(Integer.parseInt(request.getParameter("Identificacion")));
            boolean trabaja = false;
            if("SI".equals(request.getParameter("Trabaja"))){
               trabaja = true;
            }
            cl.setTrabaja(trabaja);
            cl.calcularPuntaje();
            dao.edit(cl);
            acceso = index;
        }
        if(action.equalsIgnoreCase("eliminar")){
            ClienteDAO dao = new ClienteDAO();
            int id = Integer.parseInt(request.getParameter("Identificacion"));
            dao.delete(id);
        }
        if(action.equalsIgnoreCase("buscar")){
            request.setAttribute("id", request.getParameter("idbuscar"));
            acceso = buscar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
