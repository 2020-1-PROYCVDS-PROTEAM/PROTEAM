
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

/**
 *
 * @author 
 */
public class Usuario {
	private String usuario;
    private String contra;
    private String correo;
    private String nombre;
    private String apellido;
    private Rol rol;
    
    public Usuario(String usuario,String contra,String correo,String nombre,String apellido,Rol rol){
    	this.usuario=usuario;
    	this.contra=contra;
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


    public String getContra() {
        return contra;
    }

    public void setContra(String contrase�a) {
        this.contra = contrase�a;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    

   
}