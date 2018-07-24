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
@Table(name = "repo.usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByPsswd", query = "SELECT u FROM Usuario u WHERE u.psswd = :psswd")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuario.findByStatus", query = "SELECT u FROM Usuario u WHERE u.status = :status")
    , @NamedQuery(name = "Usuario.findByPsswdTempToken", query = "SELECT u FROM Usuario u WHERE u.psswdTempToken = :psswdTempToken")
    , @NamedQuery(name = "Usuario.findByPsswdTempExpira", query = "SELECT u FROM Usuario u WHERE u.psswdTempExpira = :psswdTempExpira")
    , @NamedQuery(name = "Usuario.findByUrlFoto", query = "SELECT u FROM Usuario u WHERE u.urlFoto = :urlFoto")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 2147483647)
    @Column(name = "correo")
    private String correo;
    @Size(max = 2147483647)
    @Column(name = "psswd")
    private String psswd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Size(max = 2147483647)
    @Column(name = "psswd_temp_token")
    private String psswdTempToken;
    @Column(name = "psswd_temp_expira")
    @Temporal(TemporalType.TIMESTAMP)
    private Date psswdTempExpira;
    @Size(max = 2147483647)
    @Column(name = "url_foto")
    private String urlFoto;
    @OneToMany(mappedBy = "usuarioAprueba")
    private List<Investigacion> investigacionList;
    @OneToMany(mappedBy = "usuarioCarga")
    private List<Investigacion> investigacionList1;
    @OneToMany(mappedBy = "idUsuario")
    private List<LogDescarga> logDescargaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<FavoritosUsuario> favoritosUsuarioList;
    @OneToMany(mappedBy = "idUsuario")
    private List<ComentarioInvestigacion> comentarioInvestigacionList;
    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento")
    @ManyToOne
    private Departamento codDepartamento;
    @JoinColumn(name = "cod_estado", referencedColumnName = "cod_estado")
    @ManyToOne
    private Estado codEstado;
    @JoinColumn(name = "rol", referencedColumnName = "id_rol")
    @ManyToOne
    private Rol rol;
    @OneToMany(mappedBy = "idUsuario")
    private List<LogVisita> logVisitaList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombre, String telefono, boolean status) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.status = status;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPsswd() {
        return psswd;
    }

    public void setPsswd(String psswd) {
        this.psswd = psswd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPsswdTempToken() {
        return psswdTempToken;
    }

    public void setPsswdTempToken(String psswdTempToken) {
        this.psswdTempToken = psswdTempToken;
    }

    public Date getPsswdTempExpira() {
        return psswdTempExpira;
    }

    public void setPsswdTempExpira(Date psswdTempExpira) {
        this.psswdTempExpira = psswdTempExpira;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @XmlTransient
    @JsonIgnore
    public List<Investigacion> getInvestigacionList() {
        return investigacionList;
    }

    public void setInvestigacionList(List<Investigacion> investigacionList) {
        this.investigacionList = investigacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Investigacion> getInvestigacionList1() {
        return investigacionList1;
    }

    public void setInvestigacionList1(List<Investigacion> investigacionList1) {
        this.investigacionList1 = investigacionList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<LogDescarga> getLogDescargaList() {
        return logDescargaList;
    }

    public void setLogDescargaList(List<LogDescarga> logDescargaList) {
        this.logDescargaList = logDescargaList;
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

    public Departamento getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Departamento codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public Estado getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Estado codEstado) {
        this.codEstado = codEstado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.repo.uca.entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
