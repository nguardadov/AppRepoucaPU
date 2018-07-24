/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.beans;

import com.repo.uca.conf.ApplicationContextProvider;
import com.repo.uca.entities.Departamento;
import com.repo.uca.entities.DepartamentoLugar;
import com.repo.uca.entities.Disciplina;
import com.repo.uca.entities.Idioma;
import com.repo.uca.entities.MunicipioLugar;
import com.repo.uca.entities.Rol;
import com.repo.uca.repositories.DepartamentoLugarRepository;
import com.repo.uca.repositories.DepartamentoRepository;
import com.repo.uca.repositories.DisciplinaRepository;
import com.repo.uca.repositories.IdiomaRepository;
import com.repo.uca.repositories.MunicipioLugarRepository;
import com.repo.uca.repositories.RolRepository;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mel_e
 */

@ManagedBean(name = "catalogobean")
@SessionScoped
@ViewScoped
public class CatalogosBean implements Serializable
{
    private List<Rol> roles;
    private List<Departamento> dpto;
    private List<DepartamentoLugar> listdptolugar;
    private List<MunicipioLugar> listmunilugar;
    private List<Idioma> listidioma;
    private List<Disciplina> listdisciplina;
    
    
    @Autowired
    RolRepository rolrepo;
    
    @Autowired
    DepartamentoRepository dptorepo;
        
    @Autowired
    DisciplinaRepository discirepo;
    
    @Autowired
    IdiomaRepository idiorepo;
    
    @Autowired
    DepartamentoLugarRepository dptolugarrepo;
    
    @Autowired
    MunicipioLugarRepository munilugarrepo;
    
    
    @PostConstruct
    public void load()
    {
        roles = rolrepo.findAll();
        roles.remove(0);
        dpto = dptorepo.findAll();
        listdisciplina = discirepo.findAll();
        listdptolugar = dptolugarrepo.findAll();
        listmunilugar = munilugarrepo.findAll();
        listidioma = idiorepo.findAll();

    }

    public void addDepto(){
        dpto.add(new Departamento());
    }
    
    public void saveDpto()
    {
        //el id no es serial por eso se pregunta si es nulo antes de guardar
        for(Departamento d : dpto)
        {
            if(d.getCodDepartamento() != null && d.getNombre() != null)
            {
                System.out.println(d.getCodDepartamento()+", "+d.getNombre()+", "+d.getStatus());
                dptorepo.saveAndFlush(d);
            }
        }
        dpto=dptorepo.findAll();
    }
    
   
    
    public void addMateria(){
        //cmateria.add(new Materia());
    }
    
    public void saveMateria()
    { /*
        for(Materia m : cmateria)
        {
            if(m.getNombreMateria()!= null)
            {
                System.out.println(m.getNombreMateria() + ", "+m.getStatus());
                materiarepo.saveAndFlush(m);
            }
        }
        cmateria = materiarepo.findAll();*/
    }
    
    public void addTema(){
       // ctema.add(new Tema());
    }
    
    public void saveTema()
    {/*
        for(Tema t : ctema)
        {
            if(t.getNombreTema() != null)
            {
                
                System.out.println(t.getNombreTema() +", " +t.getStatus());
                temarepo.saveAndFlush(t);
            }
        }
        ctema = temarepo.findAll();*/
    }
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edited", "Campo Editado con exito.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", "Edición cancelada.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Departamento> getDpto() {
        return dpto;
    }

    public void setDpto(List<Departamento> dpto) {
        this.dpto = dpto;
    }

    public List<DepartamentoLugar> getListdptolugar() {
        return listdptolugar;
    }

    public void setListdptolugar(List<DepartamentoLugar> listdptolugar) {
        this.listdptolugar = listdptolugar;
    }

    public List<MunicipioLugar> getListmunilugar() {
        return listmunilugar;
    }

    public void setListmunilugar(List<MunicipioLugar> listmunilugar) {
        this.listmunilugar = listmunilugar;
    }

    public List<Idioma> getListidioma() {
        return listidioma;
    }

    public void setListidioma(List<Idioma> listidioma) {
        this.listidioma = listidioma;
    }

    public List<Disciplina> getListdisciplina() {
        return listdisciplina;
    }

    public void setListdisciplina(List<Disciplina> listdisciplina) {
        this.listdisciplina = listdisciplina;
    }

    

    
    public CatalogosBean(){
        rolrepo = ApplicationContextProvider.getApplicationContext().getBean(RolRepository.class);
        dptorepo = ApplicationContextProvider.getApplicationContext().getBean(DepartamentoRepository.class);
        discirepo =ApplicationContextProvider.getApplicationContext().getBean(DisciplinaRepository.class);
        dptolugarrepo = ApplicationContextProvider.getApplicationContext().getBean(DepartamentoLugarRepository.class);
        munilugarrepo = ApplicationContextProvider.getApplicationContext().getBean(MunicipioLugarRepository.class);
        idiorepo =ApplicationContextProvider.getApplicationContext().getBean(IdiomaRepository.class);
        
    }
}
