/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.beans;

import com.repo.uca.conf.ApplicationContextProvider;
import com.repo.uca.conf.MessagesView;
import com.repo.uca.entities.Departamento;
import com.repo.uca.entities.Estado;
import com.repo.uca.entities.Rol;
import com.repo.uca.entities.Usuario;
import com.repo.uca.repositories.DepartamentoRepository;
import com.repo.uca.repositories.EstadoRepository;
import com.repo.uca.repositories.RolRepository;
import com.repo.uca.repositories.UserRepository;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mel_e
 */
@ManagedBean(name = "functionsUser")
@SessionScoped
public class UsuarioBean implements Serializable {

    private Usuario newUser;
    private String cod_dpto;
    private String cod_estado;
    private String cod_rol;
    private Usuario details;

    @Autowired
    UserRepository urr;

    @Autowired
    EstadoRepository estadorepo;

    @Autowired
    DepartamentoRepository dpto_repo;

    @Autowired
    RolRepository rol_repo;

    public void requestNewUser() {

        try {
            Estado estate = new Estado();
            //Se setea a cero porque es tabla catalogo y en la tabla catalogo "0" es pendiente
            estate = estadorepo.getOne(0);

            Rol rol = new Rol();
            rol = rol_repo.getOne(Integer.parseInt(cod_rol));

            Departamento dpto = new Departamento();
            dpto = dpto_repo.getOne(Integer.parseInt(cod_dpto));

            //newUser.setCodEstado(estate);
            newUser.setRol(rol);
            newUser.setCodDepartamento(dpto);

            urr.save(newUser);
            //1 - info //2 - war //3 - err //4 - fatal
            MessagesView.verMensajes("Gracias por crear su cuenta. Espere confirmacion en su correo para acceder.", 2);
        } catch (Exception e) {
            System.out.println("ERROR# UsuarioBean.class: " + e.getMessage());
        }
    }

    public Usuario recuperarDatos() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario u = (Usuario) context.getExternalContext().getSessionMap().get("u_sel");
            details = u;
            System.out.println("Selecciono user_: "+details.getNombre());
            
        } catch (Exception e) {
            System.out.println("#ERROR UsuarioBean.class(recuperarDatos): No se pudieron recuperar datos del usuario seleccionado");
        }

        
        return details;
    }

    public void load() {
        newUser = new Usuario();
    }

    //GETTERS Y SETTERS
    public Usuario getNewUser() {
        return newUser;
    }

    public void setNewUser(Usuario newUser) {
        this.newUser = newUser;
    }

    public String getCod_dpto() {
        return cod_dpto;
    }

    public void setCod_dpto(String cod_dpto) {
        this.cod_dpto = cod_dpto;
    }

    public String getCod_estado() {
        return cod_estado;
    }

    public void setCod_estado(String cod_estado) {
        this.cod_estado = cod_estado;
    }

    public String getCod_rol() {
        return cod_rol;
    }

    public void setCod_rol(String cod_rol) {
        this.cod_rol = cod_rol;
    }

    public UserRepository getUrr() {
        return urr;
    }

    public void setUrr(UserRepository urr) {
        this.urr = urr;
    }

    public Usuario getDetails() {
        return details;
    }

    public void setDetails(Usuario details) {
        this.details = details;
    }

    public UsuarioBean() {
        urr = ApplicationContextProvider.getApplicationContext().getBean(UserRepository.class);
        estadorepo = ApplicationContextProvider.getApplicationContext().getBean(EstadoRepository.class);
        dpto_repo = ApplicationContextProvider.getApplicationContext().getBean(DepartamentoRepository.class);
        rol_repo = ApplicationContextProvider.getApplicationContext().getBean(RolRepository.class);
        //recuperarDatos();
       recuperarDatos();
        load();
    }
}
