/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

;
import java.io.Serializable;

/**
 *
 * @author jcatl
 */


public class Cliente implements Serializable {

    private int id;
    private String nombre;
    private int edad;
    private String estadoCivil;
    private String sexo;
    private boolean trabaja;
    private int puntaje;

    public Cliente() {
    }

    public Cliente(String nombre, int edad, String estadoCivil, String sexo, boolean trabaja) {
        this.nombre = nombre;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.trabaja = trabaja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public boolean isTrabaja() {
        return trabaja;
    }

    public void setTrabaja(boolean trabaja) {
        this.trabaja = trabaja;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void calcularPuntaje() {
        if (this.edad < 36) {
            this.puntaje = this.puntaje + 5;
        }
        if (this.edad > 35) {
            this.puntaje = this.puntaje + 2;
        }
        if ("Soltero".equals(this.estadoCivil)) {
            this.puntaje = this.puntaje + 5;
        }
        if ("Casado".equals(this.estadoCivil)) {
            this.puntaje = this.puntaje + 2;
        }
        if (this.trabaja) {
            this.puntaje = this.puntaje + 5;
        }if (this.trabaja==false) {
            this.puntaje = this.puntaje + 1;
        }
    }

}
