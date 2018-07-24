/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mel_e
 */
@Entity
@Table(name = "repo.log_descarga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogDescarga.findAll", query = "SELECT l FROM LogDescarga l")
    , @NamedQuery(name = "LogDescarga.findByFechaDescarga", query = "SELECT l FROM LogDescarga l WHERE l.fechaDescarga = :fechaDescarga")
    , @NamedQuery(name = "LogDescarga.findByIdLogdescarga", query = "SELECT l FROM LogDescarga l WHERE l.idLogdescarga = :idLogdescarga")})
public class LogDescarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "fecha_descarga")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDescarga;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_logdescarga")
    private Integer idLogdescarga;
    @JoinColumn(name = "id_documento", referencedColumnName = "id_documento")
    @ManyToOne
    private DocInvestigacion idDocumento;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;

    public LogDescarga() {
    }

    public LogDescarga(Integer idLogdescarga) {
        this.idLogdescarga = idLogdescarga;
    }

    public Date getFechaDescarga() {
        return fechaDescarga;
    }

    public void setFechaDescarga(Date fechaDescarga) {
        this.fechaDescarga = fechaDescarga;
    }

    public Integer getIdLogdescarga() {
        return idLogdescarga;
    }

    public void setIdLogdescarga(Integer idLogdescarga) {
        this.idLogdescarga = idLogdescarga;
    }

    public DocInvestigacion getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(DocInvestigacion idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogdescarga != null ? idLogdescarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogDescarga)) {
            return false;
        }
        LogDescarga other = (LogDescarga) object;
        if ((this.idLogdescarga == null && other.idLogdescarga != null) || (this.idLogdescarga != null && !this.idLogdescarga.equals(other.idLogdescarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.LogDescarga[ idLogdescarga=" + idLogdescarga + " ]";
    }
    
}
