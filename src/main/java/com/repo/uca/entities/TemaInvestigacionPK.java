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
public class TemaInvestigacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tema")
    private int codTema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_investigacion")
    private int idInvestigacion;

    public TemaInvestigacionPK() {
    }

    public TemaInvestigacionPK(int codTema, int idInvestigacion) {
        this.codTema = codTema;
        this.idInvestigacion = idInvestigacion;
    }

    public int getCodTema() {
        return codTema;
    }

    public void setCodTema(int codTema) {
        this.codTema = codTema;
    }

    public int getIdInvestigacion() {
        return idInvestigacion;
    }

    public void setIdInvestigacion(int idInvestigacion) {
        this.idInvestigacion = idInvestigacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codTema;
        hash += (int) idInvestigacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemaInvestigacionPK)) {
            return false;
        }
        TemaInvestigacionPK other = (TemaInvestigacionPK) object;
        if (this.codTema != other.codTema) {
            return false;
        }
        if (this.idInvestigacion != other.idInvestigacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.TemaInvestigacionPK[ codTema=" + codTema + ", idInvestigacion=" + idInvestigacion + " ]";
    }
    
}
