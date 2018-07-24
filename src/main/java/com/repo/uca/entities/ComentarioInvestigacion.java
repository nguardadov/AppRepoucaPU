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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mel_e
 */
@Entity
@Table(name = "repo.comentario_investigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComentarioInvestigacion.findAll", query = "SELECT c FROM ComentarioInvestigacion c")
    , @NamedQuery(name = "ComentarioInvestigacion.findByIdInvestigacion", query = "SELECT c FROM ComentarioInvestigacion c WHERE c.comentarioInvestigacionPK.idInvestigacion = :idInvestigacion")
    , @NamedQuery(name = "ComentarioInvestigacion.findByIdComentario", query = "SELECT c FROM ComentarioInvestigacion c WHERE c.comentarioInvestigacionPK.idComentario = :idComentario")
    , @NamedQuery(name = "ComentarioInvestigacion.findByFechaComentario", query = "SELECT c FROM ComentarioInvestigacion c WHERE c.fechaComentario = :fechaComentario")
    , @NamedQuery(name = "ComentarioInvestigacion.findByTextoComentario", query = "SELECT c FROM ComentarioInvestigacion c WHERE c.textoComentario = :textoComentario")
    , @NamedQuery(name = "ComentarioInvestigacion.findByStatus", query = "SELECT c FROM ComentarioInvestigacion c WHERE c.status = :status")})
public class ComentarioInvestigacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComentarioInvestigacionPK comentarioInvestigacionPK;
    @Column(name = "fecha_comentario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaComentario;
    @Size(max = 2147483647)
    @Column(name = "texto_comentario")
    private String textoComentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "id_investigacion", referencedColumnName = "id_investigacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Investigacion investigacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;

    public ComentarioInvestigacion() {
    }

    public ComentarioInvestigacion(ComentarioInvestigacionPK comentarioInvestigacionPK) {
        this.comentarioInvestigacionPK = comentarioInvestigacionPK;
    }

    public ComentarioInvestigacion(ComentarioInvestigacionPK comentarioInvestigacionPK, boolean status) {
        this.comentarioInvestigacionPK = comentarioInvestigacionPK;
        this.status = status;
    }

    public ComentarioInvestigacion(int idInvestigacion, int idComentario) {
        this.comentarioInvestigacionPK = new ComentarioInvestigacionPK(idInvestigacion, idComentario);
    }

    public ComentarioInvestigacionPK getComentarioInvestigacionPK() {
        return comentarioInvestigacionPK;
    }

    public void setComentarioInvestigacionPK(ComentarioInvestigacionPK comentarioInvestigacionPK) {
        this.comentarioInvestigacionPK = comentarioInvestigacionPK;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
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

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comentarioInvestigacionPK != null ? comentarioInvestigacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioInvestigacion)) {
            return false;
        }
        ComentarioInvestigacion other = (ComentarioInvestigacion) object;
        if ((this.comentarioInvestigacionPK == null && other.comentarioInvestigacionPK != null) || (this.comentarioInvestigacionPK != null && !this.comentarioInvestigacionPK.equals(other.comentarioInvestigacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.ComentarioInvestigacion[ comentarioInvestigacionPK=" + comentarioInvestigacionPK + " ]";
    }
    
}
