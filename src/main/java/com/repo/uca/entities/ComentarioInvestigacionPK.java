/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mel_e
 */
@Embeddable
public class ComentarioInvestigacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_investigacion")
    private int idInvestigacion;
    @Basic(optional = false)
    @Column(name = "id_comentario")
    private int idComentario;

    public ComentarioInvestigacionPK() {
    }

    public ComentarioInvestigacionPK(int idInvestigacion, int idComentario) {
        this.idInvestigacion = idInvestigacion;
        this.idComentario = idComentario;
    }

    public int getIdInvestigacion() {
        return idInvestigacion;
    }

    public void setIdInvestigacion(int idInvestigacion) {
        this.idInvestigacion = idInvestigacion;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idInvestigacion;
        hash += (int) idComentario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioInvestigacionPK)) {
            return false;
        }
        ComentarioInvestigacionPK other = (ComentarioInvestigacionPK) object;
        if (this.idInvestigacion != other.idInvestigacion) {
            return false;
        }
        if (this.idComentario != other.idComentario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.ComentarioInvestigacionPK[ idInvestigacion=" + idInvestigacion + ", idComentario=" + idComentario + " ]";
    }
    
}
