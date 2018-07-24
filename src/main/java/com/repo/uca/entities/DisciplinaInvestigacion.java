/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mel_e
 */
@Entity
@Table(name = "repo.disciplina_investigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisciplinaInvestigacion.findAll", query = "SELECT d FROM DisciplinaInvestigacion d")
    , @NamedQuery(name = "DisciplinaInvestigacion.findByIdInvestigacion", query = "SELECT d FROM DisciplinaInvestigacion d WHERE d.disciplinaInvestigacionPK.idInvestigacion = :idInvestigacion")
    , @NamedQuery(name = "DisciplinaInvestigacion.findByCodDisciplina", query = "SELECT d FROM DisciplinaInvestigacion d WHERE d.disciplinaInvestigacionPK.codDisciplina = :codDisciplina")
    , @NamedQuery(name = "DisciplinaInvestigacion.findByStatus", query = "SELECT d FROM DisciplinaInvestigacion d WHERE d.status = :status")})
public class DisciplinaInvestigacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DisciplinaInvestigacionPK disciplinaInvestigacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "cod_disciplina", referencedColumnName = "cod_disciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    @JoinColumn(name = "id_investigacion", referencedColumnName = "id_investigacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Investigacion investigacion;

    public DisciplinaInvestigacion() {
    }

    public DisciplinaInvestigacion(DisciplinaInvestigacionPK disciplinaInvestigacionPK) {
        this.disciplinaInvestigacionPK = disciplinaInvestigacionPK;
    }

    public DisciplinaInvestigacion(DisciplinaInvestigacionPK disciplinaInvestigacionPK, boolean status) {
        this.disciplinaInvestigacionPK = disciplinaInvestigacionPK;
        this.status = status;
    }

    public DisciplinaInvestigacion(int idInvestigacion, int codDisciplina) {
        this.disciplinaInvestigacionPK = new DisciplinaInvestigacionPK(idInvestigacion, codDisciplina);
    }

    public DisciplinaInvestigacionPK getDisciplinaInvestigacionPK() {
        return disciplinaInvestigacionPK;
    }

    public void setDisciplinaInvestigacionPK(DisciplinaInvestigacionPK disciplinaInvestigacionPK) {
        this.disciplinaInvestigacionPK = disciplinaInvestigacionPK;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Investigacion getInvestigacion() {
        return investigacion;
    }

    public void setInvestigacion(Investigacion investigacion) {
        this.investigacion = investigacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disciplinaInvestigacionPK != null ? disciplinaInvestigacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaInvestigacion)) {
            return false;
        }
        DisciplinaInvestigacion other = (DisciplinaInvestigacion) object;
        if ((this.disciplinaInvestigacionPK == null && other.disciplinaInvestigacionPK != null) || (this.disciplinaInvestigacionPK != null && !this.disciplinaInvestigacionPK.equals(other.disciplinaInvestigacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.DisciplinaInvestigacion[ disciplinaInvestigacionPK=" + disciplinaInvestigacionPK + " ]";
    }
    
}
