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

 
public class Comentario implements Serializable {
    private int id;
    private String idUsuario;
    private int idIniciativa;
    private String contenido;
    private Date fecha;
	private Voto voto;
	
	public Comentario(){
	}
    
    public Comentario (int id, String idUsuario, int idIniciativa, String contenido, Date fecha){
        this.id=id;
        this.idUsuario=idUsuario;
        this.idIniciativa = idIniciativa;
        this.contenido= contenido;
        this.fecha=fecha;
            
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdIniciativa() {
        return idIniciativa;
    }

    public void setIdIniciativa(int idIniciativa) {
        this.idIniciativa = idIniciativa;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", idUsuario=" + idUsuario + ", idIniciativa=" + idIniciativa + ", contenido=" + contenido + ", fecha=" + fecha + '}';
    }


 
    
    
}
