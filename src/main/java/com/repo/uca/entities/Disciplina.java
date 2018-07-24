/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author mel_e
 */
@Entity
@Table(name = "repo.disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d")
    , @NamedQuery(name = "Disciplina.findByCodDisciplina", query = "SELECT d FROM Disciplina d WHERE d.codDisciplina = :codDisciplina")
    , @NamedQuery(name = "Disciplina.findByNombreDisciplina", query = "SELECT d FROM Disciplina d WHERE d.nombreDisciplina = :nombreDisciplina")
    , @NamedQuery(name = "Disciplina.findByStatus", query = "SELECT d FROM Disciplina d WHERE d.status = :status")})
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_disciplina")
    private Integer codDisciplina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_disciplina")
    private String nombreDisciplina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<DisciplinaInvestigacion> disciplinaInvestigacionList;

    public Disciplina() {
    }

    public Disciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public Disciplina(Integer codDisciplina, String nombreDisciplina, boolean status) {
        this.codDisciplina = codDisciplina;
        this.nombreDisciplina = nombreDisciplina;
        this.status = status;
    }

    public Integer getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public String getNombreDisciplina() {
        return nombreDisciplina;
    }

    public void setNombreDisciplina(String nombreDisciplina) {
        this.nombreDisciplina = nombreDisciplina;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    @JsonIgnore
    public List<DisciplinaInvestigacion> getDisciplinaInvestigacionList() {
        return disciplinaInvestigacionList;
    }

    public void setDisciplinaInvestigacionList(List<DisciplinaInvestigacion> disciplinaInvestigacionList) {
        this.disciplinaInvestigacionList = disciplinaInvestigacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDisciplina != null ? codDisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.codDisciplina == null && other.codDisciplina != null) || (this.codDisciplina != null && !this.codDisciplina.equals(other.codDisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.Disciplina[ codDisciplina=" + codDisciplina + " ]";
    }
    
}
