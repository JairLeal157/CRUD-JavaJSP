/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Modelo.Cliente;
import java.util.List;

/**
 *
 * @author jcatl
 */
public interface CRUD {

    /**
     *
     * @return
     */
    public List listas();
    public Cliente list(int id);
    public boolean edit(Cliente cl);
    public boolean add(Cliente cl);
    public boolean delete(int id);
}
