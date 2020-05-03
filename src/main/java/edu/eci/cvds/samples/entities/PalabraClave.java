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

 
public class PalabraClave implements Serializable {
    private int id;
    private int idiniciativa;
    private String palabraclave;


    public PalabraClave (int id,int idIniciativa,String palabraclave){
        this.id=id;
        this.idiniciativa=idIniciativa;
        this.palabraclave = palabraclave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdIniciativa() {
        return idiniciativa;
    }

    public void setIdIniciativa(int idIniciativa) {
        this.idiniciativa = idIniciativa;
    }

    public String getPalabraClave() {
        return palabraclave;
    }

    public void setPalabraClave(String palabraClave) {
        this.palabraclave = palabraClave;
    }

    @Override
    public String toString() {
        return "PalabraClave{" + "id=" + id + ", idiniciativa=" + idiniciativa + ", palabraclave=" + palabraclave + '}';
    }

  
    
}
