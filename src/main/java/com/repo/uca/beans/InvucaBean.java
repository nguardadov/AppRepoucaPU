/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.beans;

import com.repo.uca.conf.ApplicationContextProvider;
import com.repo.uca.entities.Investigacion;
import com.repo.uca.entities.Usuario;
import com.repo.uca.repositories.TagsRepository;
import com.repo.uca.repositories.UserRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mel_e
 */
@ManagedBean(name = "investigadoruca")
@SessionScoped
public class InvucaBean implements Serializable {

    @Autowired
    UserRepository userepo;
    
    @Autowired
    TagsRepository tagrepo;

    Usuario profileuser;
    List<Investigacionprueba> listinvestigacion;
    Investigacionprueba invselect;
    Investigacion investigacionusuario;
    
    private String idiomaselectmenuone;
    private String disciplinaselectmenuone;
    private String dptolugarselectmenuone;
    private String munilugarselectmenuone;
    private String tags;
    

    @PostConstruct
    public void init() {
        listinvestigacion = new ArrayList<>();
        listinvestigacion.add(new Investigacionprueba("Analisis del uso de redes sociales", "Dr. Jose Martinez", "2015"));
        listinvestigacion.add(new Investigacionprueba("Debate sobre la evaluación en carreras artísticas", "Ing. Mario Mendez", "2017"));
        listinvestigacion.add(new Investigacionprueba("Estudio Teórico sobre Acompañamiento en Educación Superior", "Lic. Noel Vidal ", "2018"));
        listinvestigacion.add(new Investigacionprueba("Modelo de Formación Docente del IDU", "Lic. Eduardo Galdamez", "2018"));
        listinvestigacion.add(new Investigacionprueba("Prácticas Docentes en Artes Escénicas", "Lic. Ernesto Melendez", "2017"));
        listinvestigacion.add(new Investigacionprueba("Investigación teórica: Pedagogía Universitaria", "Lic. Melvin Meza", "2017"));
        listinvestigacion.add(new Investigacionprueba("Prácticas docentes en la PUCP", "Lic. Julio Gomez", "2017"));
        investigacionusuario = new Investigacion();
    }
    //userValidationRepo.userLogin.

    
    //userValidationRepo.userLogin.

    public void llenarPerfil() {
        FacesContext cntxt = FacesContext.getCurrentInstance();
        int iduserlogin = (int) cntxt.getExternalContext().getSessionMap().get("iduserlogin");
        System.out.println(iduserlogin);
        profileuser = userepo.getOne(iduserlogin);
    }
    
    public void guardardatosProfile()
    {
        try 
        {
            userepo.saveAndFlush(profileuser);
            System.out.println("Guardar todo con exito");
        } catch (Exception e) {
            System.out.println("#ERROR InvucaBean.class(guardardatosProfile): "+e.getMessage());
        }
        
    }
    
    public void guardarInvestigacion()
    {
        try 
        {
            System.out.println("Titulo: "+investigacionusuario.getTitulo());
            System.out.println("Resumen: "+investigacionusuario.getResumen());
            System.out.println("Fecha: "+investigacionusuario.getFechaPublicacion());
            System.out.println("Colaboradores: "+investigacionusuario.getColaboradores());
            System.out.println("Tags: "+tags);
            System.out.println("idioma: "+idiomaselectmenuone);
            System.out.println("Departamento lugar: "+dptolugarselectmenuone);
            System.out.println("Municipio lugar: "+munilugarselectmenuone);
            System.out.println("Disciplina: "+disciplinaselectmenuone);
            
            
        } catch (Exception e) 
        {
            System.out.println("#ERROR InvucaBean.class(guardarInvestigacion): "+e.getMessage());
        }
    }
    

    public Usuario getProfileuser() {
        return profileuser;
    }

    public void setProfileuser(Usuario profileuser) {
        this.profileuser = profileuser;
    }

    public List<Investigacionprueba> getListinvestigacion() {
        return listinvestigacion;
    }

    public void setListinvestigacion(List<Investigacionprueba> listinvestigacion) {
        this.listinvestigacion = listinvestigacion;
    }

    public Investigacionprueba getInvselect() {
        return invselect;
    }

    public void setInvselect(Investigacionprueba invselect) {
        this.invselect = invselect;
    }

    public Investigacion getInvestigacionusuario() {
        return investigacionusuario;
    }

    public void setInvestigacionusuario(Investigacion investigacionusuario) {
        this.investigacionusuario = investigacionusuario;
    }

    public String getIdiomaselectmenuone() {
        return idiomaselectmenuone;
    }

    public void setIdiomaselectmenuone(String idiomaselectmenuone) {
        this.idiomaselectmenuone = idiomaselectmenuone;
    }

    public String getDisciplinaselectmenuone() {
        return disciplinaselectmenuone;
    }

    public void setDisciplinaselectmenuone(String disciplinaselectmenuone) {
        this.disciplinaselectmenuone = disciplinaselectmenuone;
    }

    public String getDptolugarselectmenuone() {
        return dptolugarselectmenuone;
    }

    public void setDptolugarselectmenuone(String dptolugarselectmenuone) {
        this.dptolugarselectmenuone = dptolugarselectmenuone;
    }

    public String getMunilugarselectmenuone() {
        return munilugarselectmenuone;
    }

    public void setMunilugarselectmenuone(String munilugarselectmenuone) {
        this.munilugarselectmenuone = munilugarselectmenuone;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    
    
    public InvucaBean() {
        userepo = ApplicationContextProvider.getApplicationContext().getBean(UserRepository.class);
        tagrepo = ApplicationContextProvider.getApplicationContext().getBean(TagsRepository.class);
    }
    
    
}
