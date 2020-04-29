/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;
/**
 *
 * @author 
 */

 
public class Iniciativa implements Serializable {
    private int id;
    private int votos;
    private String palabraClave;
    private String nombre;
    private String estado;
    private String descripcion;
    private String area;
    private String usuario_i;
    private String correo_i;
    private Date fechar_ini;
    private java.lang.Long cantidad;
    private String area2;
    
    public Iniciativa (int id,int votos,String palabraclave,String nombre, String estado, String area,String descripcion,String usuarioProponente,String correoProponente,Date fecha){
        this.id=id;
        this.votos=votos;
        this.palabraClave = palabraclave;
        this.nombre= nombre;
        this.estado= estado;
        this.area=area;
        this.descripcion=descripcion;
        this.usuario_i=usuarioProponente;
        this.correo_i=correoProponente;
        this.fechar_ini=fecha;
            
    }
	
	public Iniciativa(String area2, java.lang.Long cantidad){
            
		this.area2=area2;
		this.cantidad=cantidad;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getVotos() {
        return votos;
    }

    public void setVotos(int voto) {
        this.votos = voto;
    }
    public String getPalabraClave() {
        return palabraClave;
    }

    public void setPalabraClave(String palabraclave) {
        this.palabraClave = palabraclave;
    }
    public String getNombreIniciativa() {
        return nombre;
    }

    public java.lang.Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(java.lang.Long cantidad) {
        this.cantidad = cantidad;
    }

    public String getArea2() {
        return area2;
    }

    public void setArea2(String area2) {
        this.area2 = area2;
    }

    public void setNombreIniciativa(String nombre) {
        this.nombre = nombre;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    public String getUsuarioProponente() {
        return usuario_i;
    }

    public void setUsuarioProponente(String usuarioProponente) {
        this.usuario_i = usuarioProponente;
    }
    public String getcorreoProponente() {
        return correo_i;
    }

    public void setCorreoProponente(String correoProponente) {
        this.correo_i= correoProponente;
    }
    
    public Date getFecha() {
        return fechar_ini;
    }

    public void setFecha(Date fecha) {
        this.fechar_ini = fecha;
    }

    @Override
    public String toString() {
        return "Iniciativa{" + "id=" + id + ", votos=" + votos + ", palabraClave=" + palabraClave + ", nombre=" + nombre + ", estado=" + estado + ", descripcion=" + descripcion + ", area=" + area + ", usuario_i=" + usuario_i + ", correo_i=" + correo_i + ", fechar_ini=" + fechar_ini + ", cantidad=" + cantidad + ", area2=" + area2 + '}';
    }


    
    
}
