/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.beans;

/**
 *
 * @author mel_e
 */
public class Investigacionprueba {
    private String nombreinvestigacion;
    private String Autor;
    private String fechapublicacion;

    public Investigacionprueba(String nombreinvestigacion, String Autor, String fechapublicacion) {
        this.nombreinvestigacion = nombreinvestigacion;
        this.Autor = Autor;
        this.fechapublicacion = fechapublicacion;
    }

    
    
    public String getNombreinvestigacion() {
        return nombreinvestigacion;
    }

    public void setNombreinvestigacion(String nombreinvestigacion) {
        this.nombreinvestigacion = nombreinvestigacion;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(String fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }
    
    
    
}
