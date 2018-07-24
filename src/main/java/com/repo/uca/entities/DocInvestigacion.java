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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "repo.doc_investigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocInvestigacion.findAll", query = "SELECT d FROM DocInvestigacion d")
    , @NamedQuery(name = "DocInvestigacion.findByIdDocumento", query = "SELECT d FROM DocInvestigacion d WHERE d.idDocumento = :idDocumento")
    , @NamedQuery(name = "DocInvestigacion.findByNombreDocumento", query = "SELECT d FROM DocInvestigacion d WHERE d.nombreDocumento = :nombreDocumento")
    , @NamedQuery(name = "DocInvestigacion.findByDescripcion", query = "SELECT d FROM DocInvestigacion d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "DocInvestigacion.findByUrl", query = "SELECT d FROM DocInvestigacion d WHERE d.url = :url")
    , @NamedQuery(name = "DocInvestigacion.findByStatus", query = "SELECT d FROM DocInvestigacion d WHERE d.status = :status")})
public class DocInvestigacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento")
    private Integer idDocumento;
    @Size(max = 2147483647)
    @Column(name = "nombre_documento")
    private String nombreDocumento;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(mappedBy = "idDocumento")
    private List<LogDescarga> logDescargaList;
    @JoinColumn(name = "id_investigacion", referencedColumnName = "id_investigacion")
    @ManyToOne
    private Investigacion idInvestigacion;

    public DocInvestigacion() {
    }

    public DocInvestigacion(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public DocInvestigacion(Integer idDocumento, boolean status) {
        this.idDocumento = idDocumento;
        this.status = status;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    @JsonIgnore
    public List<LogDescarga> getLogDescargaList() {
        return logDescargaList;
    }

    public void setLogDescargaList(List<LogDescarga> logDescargaList) {
        this.logDescargaList = logDescargaList;
    }

    public Investigacion getIdInvestigacion() {
        return idInvestigacion;
    }

    public void setIdInvestigacion(Investigacion idInvestigacion) {
        this.idInvestigacion = idInvestigacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocInvestigacion)) {
            return false;
        }
        DocInvestigacion other = (DocInvestigacion) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.DocInvestigacion[ idDocumento=" + idDocumento + " ]";
    }
    
}
