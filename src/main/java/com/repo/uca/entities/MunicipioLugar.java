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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "repo.municipio_lugar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MunicipioLugar.findAll", query = "SELECT m FROM MunicipioLugar m")
    , @NamedQuery(name = "MunicipioLugar.findByCodMunicipioLugar", query = "SELECT m FROM MunicipioLugar m WHERE m.codMunicipioLugar = :codMunicipioLugar")
    , @NamedQuery(name = "MunicipioLugar.findByNombreMunicipio", query = "SELECT m FROM MunicipioLugar m WHERE m.nombreMunicipio = :nombreMunicipio")
    , @NamedQuery(name = "MunicipioLugar.findByStatus", query = "SELECT m FROM MunicipioLugar m WHERE m.status = :status")})
public class MunicipioLugar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_municipio_lugar")
    private String codMunicipioLugar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_municipio")
    private String nombreMunicipio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(mappedBy = "codMunicipioLugar")
    private List<Investigacion> investigacionList;
    @JoinColumn(name = "cod_dpto_lugar", referencedColumnName = "cod_dpto_lugar")
    @ManyToOne
    private DepartamentoLugar codDptoLugar;

    public MunicipioLugar() {
    }

    public MunicipioLugar(String codMunicipioLugar) {
        this.codMunicipioLugar = codMunicipioLugar;
    }

    public MunicipioLugar(String codMunicipioLugar, String nombreMunicipio, boolean status) {
        this.codMunicipioLugar = codMunicipioLugar;
        this.nombreMunicipio = nombreMunicipio;
        this.status = status;
    }

    public String getCodMunicipioLugar() {
        return codMunicipioLugar;
    }

    public void setCodMunicipioLugar(String codMunicipioLugar) {
        this.codMunicipioLugar = codMunicipioLugar;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    @JsonIgnore
    public List<Investigacion> getInvestigacionList() {
        return investigacionList;
    }

    public void setInvestigacionList(List<Investigacion> investigacionList) {
        this.investigacionList = investigacionList;
    }

    public DepartamentoLugar getCodDptoLugar() {
        return codDptoLugar;
    }

    public void setCodDptoLugar(DepartamentoLugar codDptoLugar) {
        this.codDptoLugar = codDptoLugar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMunicipioLugar != null ? codMunicipioLugar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipioLugar)) {
            return false;
        }
        MunicipioLugar other = (MunicipioLugar) object;
        if ((this.codMunicipioLugar == null && other.codMunicipioLugar != null) || (this.codMunicipioLugar != null && !this.codMunicipioLugar.equals(other.codMunicipioLugar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.MunicipioLugar[ codMunicipioLugar=" + codMunicipioLugar + " ]";
    }
    
}
