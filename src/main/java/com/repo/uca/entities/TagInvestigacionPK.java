/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mel_e
 */
@Embeddable
public class TagInvestigacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_investigacion")
    private int idInvestigacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tag")
    private String tag;

    public TagInvestigacionPK() {
    }

    public TagInvestigacionPK(int idInvestigacion, String tag) {
        this.idInvestigacion = idInvestigacion;
        this.tag = tag;
    }

    public int getIdInvestigacion() {
        return idInvestigacion;
    }

    public void setIdInvestigacion(int idInvestigacion) {
        this.idInvestigacion = idInvestigacion;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idInvestigacion;
        hash += (tag != null ? tag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TagInvestigacionPK)) {
            return false;
        }
        TagInvestigacionPK other = (TagInvestigacionPK) object;
        if (this.idInvestigacion != other.idInvestigacion) {
            return false;
        }
        if ((this.tag == null && other.tag != null) || (this.tag != null && !this.tag.equals(other.tag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.TagInvestigacionPK[ idInvestigacion=" + idInvestigacion + ", tag=" + tag + " ]";
    }
    
}
