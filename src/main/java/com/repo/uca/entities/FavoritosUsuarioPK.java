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
public class FavoritosUsuarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_investigacion")
    private int idInvestigacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;

    public FavoritosUsuarioPK() {
    }

    public FavoritosUsuarioPK(int idInvestigacion, int idUsuario) {
        this.idInvestigacion = idInvestigacion;
        this.idUsuario = idUsuario;
    }

    public int getIdInvestigacion() {
        return idInvestigacion;
    }

    public void setIdInvestigacion(int idInvestigacion) {
        this.idInvestigacion = idInvestigacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idInvestigacion;
        hash += (int) idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoritosUsuarioPK)) {
            return false;
        }
        FavoritosUsuarioPK other = (FavoritosUsuarioPK) object;
        if (this.idInvestigacion != other.idInvestigacion) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.FavoritosUsuarioPK[ idInvestigacion=" + idInvestigacion + ", idUsuario=" + idUsuario + " ]";
    }
    
}
