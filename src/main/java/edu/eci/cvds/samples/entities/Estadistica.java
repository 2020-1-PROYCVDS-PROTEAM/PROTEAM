/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

/**
 *
 * @author Gonzalez-Gutierrez-Jimenez-Pulido
 */
public class Estadistica {
    private String nombre;
    private java.lang.Long cantidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Estatisticas{" + "nombre=" + nombre + ", cantidad=" + cantidad + '}';
    }
    
    
    
}

