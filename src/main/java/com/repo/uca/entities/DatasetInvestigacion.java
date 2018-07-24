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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mel_e
 */
@Entity
@Table(name = "repo.dataset_investigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatasetInvestigacion.findAll", query = "SELECT d FROM DatasetInvestigacion d")
    , @NamedQuery(name = "DatasetInvestigacion.findByIdInvestigacion", query = "SELECT d FROM DatasetInvestigacion d WHERE d.datasetInvestigacionPK.idInvestigacion = :idInvestigacion")
    , @NamedQuery(name = "DatasetInvestigacion.findByIdDataset", query = "SELECT d FROM DatasetInvestigacion d WHERE d.datasetInvestigacionPK.idDataset = :idDataset")
    , @NamedQuery(name = "DatasetInvestigacion.findByNombreDataset", query = "SELECT d FROM DatasetInvestigacion d WHERE d.nombreDataset = :nombreDataset")
    , @NamedQuery(name = "DatasetInvestigacion.findByDescripcion", query = "SELECT d FROM DatasetInvestigacion d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "DatasetInvestigacion.findByCompatibleGis", query = "SELECT d FROM DatasetInvestigacion d WHERE d.compatibleGis = :compatibleGis")
    , @NamedQuery(name = "DatasetInvestigacion.findByStatus", query = "SELECT d FROM DatasetInvestigacion d WHERE d.status = :status")})
public class DatasetInvestigacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatasetInvestigacionPK datasetInvestigacionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_dataset")
    private String nombreDataset;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Lob
    @Column(name = "datos")
    private String datos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "compatible_gis")
    private boolean compatibleGis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "cod_estado", referencedColumnName = "cod_estado")
    @ManyToOne
    private Estado codEstado;
    @JoinColumn(name = "id_investigacion", referencedColumnName = "id_investigacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Investigacion investigacion;

    public DatasetInvestigacion() {
    }

    public DatasetInvestigacion(DatasetInvestigacionPK datasetInvestigacionPK) {
        this.datasetInvestigacionPK = datasetInvestigacionPK;
    }

    public DatasetInvestigacion(DatasetInvestigacionPK datasetInvestigacionPK, String nombreDataset, String descripcion, boolean compatibleGis, boolean status) {
        this.datasetInvestigacionPK = datasetInvestigacionPK;
        this.nombreDataset = nombreDataset;
        this.descripcion = descripcion;
        this.compatibleGis = compatibleGis;
        this.status = status;
    }

    public DatasetInvestigacion(int idInvestigacion, int idDataset) {
        this.datasetInvestigacionPK = new DatasetInvestigacionPK(idInvestigacion, idDataset);
    }

    public DatasetInvestigacionPK getDatasetInvestigacionPK() {
        return datasetInvestigacionPK;
    }

    public void setDatasetInvestigacionPK(DatasetInvestigacionPK datasetInvestigacionPK) {
        this.datasetInvestigacionPK = datasetInvestigacionPK;
    }

    public String getNombreDataset() {
        return nombreDataset;
    }

    public void setNombreDataset(String nombreDataset) {
        this.nombreDataset = nombreDataset;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public boolean getCompatibleGis() {
        return compatibleGis;
    }

    public void setCompatibleGis(boolean compatibleGis) {
        this.compatibleGis = compatibleGis;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Estado getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Estado codEstado) {
        this.codEstado = codEstado;
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
        hash += (datasetInvestigacionPK != null ? datasetInvestigacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatasetInvestigacion)) {
            return false;
        }
        DatasetInvestigacion other = (DatasetInvestigacion) object;
        if ((this.datasetInvestigacionPK == null && other.datasetInvestigacionPK != null) || (this.datasetInvestigacionPK != null && !this.datasetInvestigacionPK.equals(other.datasetInvestigacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.DatasetInvestigacion[ datasetInvestigacionPK=" + datasetInvestigacionPK + " ]";
    }
    
}
