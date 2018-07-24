/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "repo.departamento_lugar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartamentoLugar.findAll", query = "SELECT d FROM DepartamentoLugar d")
    , @NamedQuery(name = "DepartamentoLugar.findByCodDptoLugar", query = "SELECT d FROM DepartamentoLugar d WHERE d.codDptoLugar = :codDptoLugar")
    , @NamedQuery(name = "DepartamentoLugar.findByNombreDpto", query = "SELECT d FROM DepartamentoLugar d WHERE d.nombreDpto = :nombreDpto")
    , @NamedQuery(name = "DepartamentoLugar.findByStatus", query = "SELECT d FROM DepartamentoLugar d WHERE d.status = :status")})
public class DepartamentoLugar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_dpto_lugar")
    private String codDptoLugar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_dpto")
    private String nombreDpto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(mappedBy = "codDptoLugar")
    private List<MunicipioLugar> municipioLugarList;

    public DepartamentoLugar() {
    }

    public DepartamentoLugar(String codDptoLugar) {
        this.codDptoLugar = codDptoLugar;
    }

    public DepartamentoLugar(String codDptoLugar, String nombreDpto, boolean status) {
        this.codDptoLugar = codDptoLugar;
        this.nombreDpto = nombreDpto;
        this.status = status;
    }

    public String getCodDptoLugar() {
        return codDptoLugar;
    }

    public void setCodDptoLugar(String codDptoLugar) {
        this.codDptoLugar = codDptoLugar;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    @JsonIgnore
    public List<MunicipioLugar> getMunicipioLugarList() {
        return municipioLugarList;
    }

    public void setMunicipioLugarList(List<MunicipioLugar> municipioLugarList) {
        this.municipioLugarList = municipioLugarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDptoLugar != null ? codDptoLugar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartamentoLugar)) {
            return false;
        }
        DepartamentoLugar other = (DepartamentoLugar) object;
        if ((this.codDptoLugar == null && other.codDptoLugar != null) || (this.codDptoLugar != null && !this.codDptoLugar.equals(other.codDptoLugar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.DepartamentoLugar[ codDptoLugar=" + codDptoLugar + " ]";
    }
    
}
