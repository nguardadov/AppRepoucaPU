/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "repo.investigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investigacion.findAll", query = "SELECT i FROM Investigacion i")
    , @NamedQuery(name = "Investigacion.findByIdInvestigacion", query = "SELECT i FROM Investigacion i WHERE i.idInvestigacion = :idInvestigacion")
    , @NamedQuery(name = "Investigacion.findByTitulo", query = "SELECT i FROM Investigacion i WHERE i.titulo = :titulo")
    , @NamedQuery(name = "Investigacion.findByResumen", query = "SELECT i FROM Investigacion i WHERE i.resumen = :resumen")
    , @NamedQuery(name = "Investigacion.findByFechaPublicacion", query = "SELECT i FROM Investigacion i WHERE i.fechaPublicacion = :fechaPublicacion")
    , @NamedQuery(name = "Investigacion.findByFechaCarga", query = "SELECT i FROM Investigacion i WHERE i.fechaCarga = :fechaCarga")
    , @NamedQuery(name = "Investigacion.findByFechaResolucion", query = "SELECT i FROM Investigacion i WHERE i.fechaResolucion = :fechaResolucion")
    , @NamedQuery(name = "Investigacion.findByComentario", query = "SELECT i FROM Investigacion i WHERE i.comentario = :comentario")
    , @NamedQuery(name = "Investigacion.findByStatus", query = "SELECT i FROM Investigacion i WHERE i.status = :status")})
public class Investigacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_investigacion")
    private Integer idInvestigacion;
    @Size(max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 2147483647)
    @Column(name = "resumen")
    private String resumen;
    @Size(max = 2147483647)
    @Column(name = "colaboradores")
    private String colaboradores;
    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @Column(name = "fecha_carga")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCarga;
    @Column(name = "fecha_resolucion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaResolucion;
    @Size(max = 2147483647)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "cod_estado", referencedColumnName = "cod_estado")
    @ManyToOne
    private Estado codEstado;
    @JoinColumn(name = "idioma", referencedColumnName = "id_idioma")
    @ManyToOne
    private Idioma idioma;
    @JoinColumn(name = "cod_municipio_lugar", referencedColumnName = "cod_municipio_lugar")
    @ManyToOne
    private MunicipioLugar codMunicipioLugar;
    @JoinColumn(name = "usuario_aprueba", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioAprueba;
    @JoinColumn(name = "usuario_carga", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioCarga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investigacion")
    private List<DisciplinaInvestigacion> disciplinaInvestigacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investigacion")
    private List<TemaInvestigacion> temaInvestigacionList;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investigacion")
    private List<TagInvestigacion> tagInvestigacionList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investigacion")
    private List<FavoritosUsuario> favoritosUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investigacion")
    private List<ComentarioInvestigacion> comentarioInvestigacionList;
    @OneToMany(mappedBy = "idInvestigacion")
    private List<DocInvestigacion> docInvestigacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investigacion")
    private List<DatasetInvestigacion> datasetInvestigacionList;
    @OneToMany(mappedBy = "idInvestigacion")
    private List<LogVisita> logVisitaList;

    public Investigacion() {
    }

    public Investigacion(Integer idInvestigacion) {
        this.idInvestigacion = idInvestigacion;
    }

    public Investigacion(Integer idInvestigacion, boolean status) {
        this.idInvestigacion = idInvestigacion;
        this.status = status;
    }

    public Integer getIdInvestigacion() {
        return idInvestigacion;
    }

    public void setIdInvestigacion(Integer idInvestigacion) {
        this.idInvestigacion = idInvestigacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public MunicipioLugar getCodMunicipioLugar() {
        return codMunicipioLugar;
    }

    public void setCodMunicipioLugar(MunicipioLugar codMunicipioLugar) {
        this.codMunicipioLugar = codMunicipioLugar;
    }

    public Usuario getUsuarioAprueba() {
        return usuarioAprueba;
    }

    public void setUsuarioAprueba(Usuario usuarioAprueba) {
        this.usuarioAprueba = usuarioAprueba;
    }

    public Usuario getUsuarioCarga() {
        return usuarioCarga;
    }

    public void setUsuarioCarga(Usuario usuarioCarga) {
        this.usuarioCarga = usuarioCarga;
    }

    public String getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(String colaboradores) {
        this.colaboradores = colaboradores;
    }
    

    @XmlTransient
    @JsonIgnore
    public List<DisciplinaInvestigacion> getDisciplinaInvestigacionList() {
        return disciplinaInvestigacionList;
    }

    public void setDisciplinaInvestigacionList(List<DisciplinaInvestigacion> disciplinaInvestigacionList) {
        this.disciplinaInvestigacionList = disciplinaInvestigacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TemaInvestigacion> getTemaInvestigacionList() {
        return temaInvestigacionList;
    }

    public void setTemaInvestigacionList(List<TemaInvestigacion> temaInvestigacionList) {
        this.temaInvestigacionList = temaInvestigacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TagInvestigacion> getTagInvestigacionList() {
        return tagInvestigacionList;
    }

    public void setTagInvestigacionList(List<TagInvestigacion> tagInvestigacionList) {
        this.tagInvestigacionList = tagInvestigacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<FavoritosUsuario> getFavoritosUsuarioList() {
        return favoritosUsuarioList;
    }

    public void setFavoritosUsuarioList(List<FavoritosUsuario> favoritosUsuarioList) {
        this.favoritosUsuarioList = favoritosUsuarioList;
    }

    @XmlTransient
    @JsonIgnore
    public List<ComentarioInvestigacion> getComentarioInvestigacionList() {
        return comentarioInvestigacionList;
    }

    public void setComentarioInvestigacionList(List<ComentarioInvestigacion> comentarioInvestigacionList) {
        this.comentarioInvestigacionList = comentarioInvestigacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<DocInvestigacion> getDocInvestigacionList() {
        return docInvestigacionList;
    }

    public void setDocInvestigacionList(List<DocInvestigacion> docInvestigacionList) {
        this.docInvestigacionList = docInvestigacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<DatasetInvestigacion> getDatasetInvestigacionList() {
        return datasetInvestigacionList;
    }

    public void setDatasetInvestigacionList(List<DatasetInvestigacion> datasetInvestigacionList) {
        this.datasetInvestigacionList = datasetInvestigacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<LogVisita> getLogVisitaList() {
        return logVisitaList;
    }

    public void setLogVisitaList(List<LogVisita> logVisitaList) {
        this.logVisitaList = logVisitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvestigacion != null ? idInvestigacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investigacion)) {
            return false;
        }
        Investigacion other = (Investigacion) object;
        if ((this.idInvestigacion == null && other.idInvestigacion != null) || (this.idInvestigacion != null && !this.idInvestigacion.equals(other.idInvestigacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.Investigacion[ idInvestigacion=" + idInvestigacion + " ]";
    }
    
}
