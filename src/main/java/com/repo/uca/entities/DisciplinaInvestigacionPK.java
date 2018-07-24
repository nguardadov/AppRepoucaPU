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
public class DisciplinaInvestigacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_investigacion")
    private int idInvestigacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_disciplina")
    private int codDisciplina;

    public DisciplinaInvestigacionPK() {
    }

    public DisciplinaInvestigacionPK(int idInvestigacion, int codDisciplina) {
        this.idInvestigacion = idInvestigacion;
        this.codDisciplina = codDisciplina;
    }

    public int getIdInvestigacion() {
        return idInvestigacion;
    }

    public void setIdInvestigacion(int idInvestigacion) {
        this.idInvestigacion = idInvestigacion;
    }

    public int getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idInvestigacion;
        hash += (int) codDisciplina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaInvestigacionPK)) {
            return false;
        }
        DisciplinaInvestigacionPK other = (DisciplinaInvestigacionPK) object;
        if (this.idInvestigacion != other.idInvestigacion) {
            return false;
        }
        if (this.codDisciplina != other.codDisciplina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.DisciplinaInvestigacionPK[ idInvestigacion=" + idInvestigacion + ", codDisciplina=" + codDisciplina + " ]";
    }
    
}
