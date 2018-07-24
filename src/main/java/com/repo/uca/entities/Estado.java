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
@Table(name = "repo.estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
    , @NamedQuery(name = "Estado.findByCodEstado", query = "SELECT e FROM Estado e WHERE e.codEstado = :codEstado")
    , @NamedQuery(name = "Estado.findByDescripcion", query = "SELECT e FROM Estado e WHERE e.descripcion = :descripcion")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_estado")
    private Integer codEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "codEstado")
    private List<Investigacion> investigacionList;
    @OneToMany(mappedBy = "codEstado")
    private List<DatasetInvestigacion> datasetInvestigacionList;
    @OneToMany(mappedBy = "codEstado")
    private List<Usuario> usuarioList;

    public Estado() {
    }

    public Estado(Integer codEstado) {
        this.codEstado = codEstado;
    }

    public Estado(Integer codEstado, String descripcion) {
        this.codEstado = codEstado;
        this.descripcion = descripcion;
    }

    public Integer getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Integer codEstado) {
        this.codEstado = codEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    @JsonIgnore
    public List<Investigacion> getInvestigacionList() {
        return investigacionList;
    }

    public void setInvestigacionList(List<Investigacion> investigacionList) {
        this.investigacionList = investigacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<DatasetInvestigacion> getDatasetInvestigacionList() {
        return datasetInvestigacionList;
    }

    public void setDatasetInvestigacionList(List<DatasetInvestigacion> datasetInvestigacionList) {
        this.datasetInvestigacionList = datasetInvestigacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstado != null ? codEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.codEstado == null && other.codEstado != null) || (this.codEstado != null && !this.codEstado.equals(other.codEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.Estado[ codEstado=" + codEstado + " ]";
    }
    
}
