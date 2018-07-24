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

/**
 *
 * @author mel_e
 */
@Embeddable
public class DatasetInvestigacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_investigacion")
    private int idInvestigacion;
    @Basic(optional = false)
    @Column(name = "id_dataset")
    private int idDataset;

    public DatasetInvestigacionPK() {
    }

    public DatasetInvestigacionPK(int idInvestigacion, int idDataset) {
        this.idInvestigacion = idInvestigacion;
        this.idDataset = idDataset;
    }

    public int getIdInvestigacion() {
        return idInvestigacion;
    }

    public void setIdInvestigacion(int idInvestigacion) {
        this.idInvestigacion = idInvestigacion;
    }

    public int getIdDataset() {
        return idDataset;
    }

    public void setIdDataset(int idDataset) {
        this.idDataset = idDataset;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idInvestigacion;
        hash += (int) idDataset;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatasetInvestigacionPK)) {
            return false;
        }
        DatasetInvestigacionPK other = (DatasetInvestigacionPK) object;
        if (this.idInvestigacion != other.idInvestigacion) {
            return false;
        }
        if (this.idDataset != other.idDataset) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.DatasetInvestigacionPK[ idInvestigacion=" + idInvestigacion + ", idDataset=" + idDataset + " ]";
    }
    
}
