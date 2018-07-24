/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mel_e
 */
@Entity
@Table(name = "repo.tag_investigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TagInvestigacion.findAll", query = "SELECT t FROM TagInvestigacion t")
    , @NamedQuery(name = "TagInvestigacion.findByIdInvestigacion", query = "SELECT t FROM TagInvestigacion t WHERE t.tagInvestigacionPK.idInvestigacion = :idInvestigacion")
    , @NamedQuery(name = "TagInvestigacion.findByTag", query = "SELECT t FROM TagInvestigacion t WHERE t.tagInvestigacionPK.tag = :tag")
    , @NamedQuery(name = "TagInvestigacion.findByStatus", query = "SELECT t FROM TagInvestigacion t WHERE t.status = :status")})
public class TagInvestigacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TagInvestigacionPK tagInvestigacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "id_investigacion", referencedColumnName = "id_investigacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Investigacion investigacion;

    public TagInvestigacion() {
    }

    public TagInvestigacion(TagInvestigacionPK tagInvestigacionPK) {
        this.tagInvestigacionPK = tagInvestigacionPK;
    }

    public TagInvestigacion(TagInvestigacionPK tagInvestigacionPK, boolean status) {
        this.tagInvestigacionPK = tagInvestigacionPK;
        this.status = status;
    }

    public TagInvestigacion(int idInvestigacion, String tag) {
        this.tagInvestigacionPK = new TagInvestigacionPK(idInvestigacion, tag);
    }

    public TagInvestigacionPK getTagInvestigacionPK() {
        return tagInvestigacionPK;
    }

    public void setTagInvestigacionPK(TagInvestigacionPK tagInvestigacionPK) {
        this.tagInvestigacionPK = tagInvestigacionPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagInvestigacionPK != null ? tagInvestigacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TagInvestigacion)) {
            return false;
        }
        TagInvestigacion other = (TagInvestigacion) object;
        if ((this.tagInvestigacionPK == null && other.tagInvestigacionPK != null) || (this.tagInvestigacionPK != null && !this.tagInvestigacionPK.equals(other.tagInvestigacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.TagInvestigacion[ tagInvestigacionPK=" + tagInvestigacionPK + " ]";
    }
    
}
