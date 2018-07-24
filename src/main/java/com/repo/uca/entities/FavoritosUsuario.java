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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mel_e
 */
@Entity
@Table(name = "repo.favoritos_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FavoritosUsuario.findAll", query = "SELECT f FROM FavoritosUsuario f")
    , @NamedQuery(name = "FavoritosUsuario.findByIdInvestigacion", query = "SELECT f FROM FavoritosUsuario f WHERE f.favoritosUsuarioPK.idInvestigacion = :idInvestigacion")
    , @NamedQuery(name = "FavoritosUsuario.findByIdUsuario", query = "SELECT f FROM FavoritosUsuario f WHERE f.favoritosUsuarioPK.idUsuario = :idUsuario")
    , @NamedQuery(name = "FavoritosUsuario.findByFechaAgrega", query = "SELECT f FROM FavoritosUsuario f WHERE f.fechaAgrega = :fechaAgrega")
    , @NamedQuery(name = "FavoritosUsuario.findByStatus", query = "SELECT f FROM FavoritosUsuario f WHERE f.status = :status")})
public class FavoritosUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FavoritosUsuarioPK favoritosUsuarioPK;
    @Column(name = "fecha_agrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAgrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "id_investigacion", referencedColumnName = "id_investigacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Investigacion investigacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public FavoritosUsuario() {
    }

    public FavoritosUsuario(FavoritosUsuarioPK favoritosUsuarioPK) {
        this.favoritosUsuarioPK = favoritosUsuarioPK;
    }

    public FavoritosUsuario(FavoritosUsuarioPK favoritosUsuarioPK, boolean status) {
        this.favoritosUsuarioPK = favoritosUsuarioPK;
        this.status = status;
    }

    public FavoritosUsuario(int idInvestigacion, int idUsuario) {
        this.favoritosUsuarioPK = new FavoritosUsuarioPK(idInvestigacion, idUsuario);
    }

    public FavoritosUsuarioPK getFavoritosUsuarioPK() {
        return favoritosUsuarioPK;
    }

    public void setFavoritosUsuarioPK(FavoritosUsuarioPK favoritosUsuarioPK) {
        this.favoritosUsuarioPK = favoritosUsuarioPK;
    }

    public Date getFechaAgrega() {
        return fechaAgrega;
    }

    public void setFechaAgrega(Date fechaAgrega) {
        this.fechaAgrega = fechaAgrega;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Investigacion getInvestigacion() {
        return investigacion;
    }

    public void setInvestigacion(Investigacion investigacion) {
        this.investigacion = investigacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (favoritosUsuarioPK != null ? favoritosUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoritosUsuario)) {
            return false;
        }
        FavoritosUsuario other = (FavoritosUsuario) object;
        if ((this.favoritosUsuarioPK == null && other.favoritosUsuarioPK != null) || (this.favoritosUsuarioPK != null && !this.favoritosUsuarioPK.equals(other.favoritosUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.FavoritosUsuario[ favoritosUsuarioPK=" + favoritosUsuarioPK + " ]";
    }
    
}
