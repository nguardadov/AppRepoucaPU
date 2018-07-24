/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mel_e
 */
@Entity
@Table(name = "repo.tema_investigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TemaInvestigacion.findAll", query = "SELECT t FROM TemaInvestigacion t")
    , @NamedQuery(name = "TemaInvestigacion.findByStatus", query = "SELECT t FROM TemaInvestigacion t WHERE t.status = :status")
    , @NamedQuery(name = "TemaInvestigacion.findByCodTema", query = "SELECT t FROM TemaInvestigacion t WHERE t.temaInvestigacionPK.codTema = :codTema")
    , @NamedQuery(name = "TemaInvestigacion.findByIdInvestigacion", query = "SELECT t FROM TemaInvestigacion t WHERE t.temaInvestigacionPK.idInvestigacion = :idInvestigacion")})
public class TemaInvestigacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TemaInvestigacionPK temaInvestigacionPK;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "id_investigacion", referencedColumnName = "id_investigacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Investigacion investigacion;

    public TemaInvestigacion() {
    }

    public TemaInvestigacion(TemaInvestigacionPK temaInvestigacionPK) {
        this.temaInvestigacionPK = temaInvestigacionPK;
    }

    public TemaInvestigacion(int codTema, int idInvestigacion) {
        this.temaInvestigacionPK = new TemaInvestigacionPK(codTema, idInvestigacion);
    }

    public TemaInvestigacionPK getTemaInvestigacionPK() {
        return temaInvestigacionPK;
    }

    public void setTemaInvestigacionPK(TemaInvestigacionPK temaInvestigacionPK) {
        this.temaInvestigacionPK = temaInvestigacionPK;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        hash += (temaInvestigacionPK != null ? temaInvestigacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemaInvestigacion)) {
            return false;
        }
        TemaInvestigacion other = (TemaInvestigacion) object;
        if ((this.temaInvestigacionPK == null && other.temaInvestigacionPK != null) || (this.temaInvestigacionPK != null && !this.temaInvestigacionPK.equals(other.temaInvestigacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.TemaInvestigacion[ temaInvestigacionPK=" + temaInvestigacionPK + " ]";
    }
    
}
