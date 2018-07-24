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
@Table(name = "repo.log_visita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogVisita.findAll", query = "SELECT l FROM LogVisita l")
    , @NamedQuery(name = "LogVisita.findByFechaVisita", query = "SELECT l FROM LogVisita l WHERE l.fechaVisita = :fechaVisita")
    , @NamedQuery(name = "LogVisita.findByIdLogvisita", query = "SELECT l FROM LogVisita l WHERE l.idLogvisita = :idLogvisita")})
public class LogVisita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "fecha_visita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_logvisita")
    private Integer idLogvisita;
    @JoinColumn(name = "id_investigacion", referencedColumnName = "id_investigacion")
    @ManyToOne
    private Investigacion idInvestigacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;

    public LogVisita() {
    }

    public LogVisita(Integer idLogvisita) {
        this.idLogvisita = idLogvisita;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Integer getIdLogvisita() {
        return idLogvisita;
    }

    public void setIdLogvisita(Integer idLogvisita) {
        this.idLogvisita = idLogvisita;
    }

    public Investigacion getIdInvestigacion() {
        return idInvestigacion;
    }

    public void setIdInvestigacion(Investigacion idInvestigacion) {
        this.idInvestigacion = idInvestigacion;
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
        hash += (idLogvisita != null ? idLogvisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogVisita)) {
            return false;
        }
        LogVisita other = (LogVisita) object;
        if ((this.idLogvisita == null && other.idLogvisita != null) || (this.idLogvisita != null && !this.idLogvisita.equals(other.idLogvisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.LogVisita[ idLogvisita=" + idLogvisita + " ]";
    }
    
}
