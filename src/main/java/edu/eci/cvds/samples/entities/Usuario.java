
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;

/**
 *
 * @author 
 */
public class Usuario implements Serializable {
	private String usuario;
    private String passw;
    private String correo;
    private String nombre;
    private String apellido;
    private String rol;
    
    public Usuario(String usuario,String passw,String correo,String nombre,String apellido,String rol){
    	this.usuario=usuario;
    	this.passw=passw;
        this.correo=correo;
        this.nombre=nombre;
        this.apellido=apellido;
        this.rol=rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getpassw() {
        return passw;
    }

    public void setpassw(String passw) {
        this.passw = passw;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    @Override
    public String toString() {
        return "Usuario {nombre de usuario: " + usuario + ",Contraseña: " + passw+ " ,correo : " + correo + ",nombre: " + nombre + ", apellido: " + apellido + ",rol: " + rol + "}";
    }

   
}