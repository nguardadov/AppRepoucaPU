package com.repo.uca.beans;

import com.repo.uca.conf.ApplicationContextProvider;
import com.repo.uca.conf.MessagesView;
import com.repo.uca.conf.Seguridad;
import com.repo.uca.entities.Estado;
import com.repo.uca.entities.Rol;
import com.repo.uca.entities.Usuario;
import com.repo.uca.repositories.EstadoRepository;
import com.repo.uca.repositories.RolRepository;
import com.repo.uca.repositories.UserRepository;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "administracionBean")
@SessionScoped
//@ViewScoped
public  class AdminBean implements Serializable {

    @Autowired
    UserRepository admrepo;

    @Autowired
    EstadoRepository estadorepo;

    @Autowired
    RolRepository rolrepository;

    List<Usuario> listausuariosPendientes;
    List<Usuario> listaResetPassword;
    
    Estado findestado;
    Rol findrol;
    Usuario userRequestAcount;
    Usuario userResetPassword;
    Usuario userSelectDetails;
    private int dato;
    int conteocreacion;
    int conteoReset;
    Date fechaExpiracion;
    Date today;

    public String valueRadioButton;
    public String textEditor;
    private boolean switchPermisoApp;
    

    @PostConstruct
    public void init() 
    {
        userRequest();
        conteocreacion = listausuariosPendientes.size();
        
        listaResetPassword = admrepo.findUserResetPassword();
        conteoReset = listaResetPassword.size();
        today = new java.util.Date();
        userSelectDetails = new Usuario();
    }
    

    public List<Usuario> userRequest() {
        listausuariosPendientes = admrepo.findByCodl();
        for(Usuario i : listausuariosPendientes)
        {
         //   System.out.println(i.getNombre());
        }
        return listausuariosPendientes;
    }
    public int contar(List<Usuario> lista){
        int i=0;
        return i = lista.size();
    }

    public void handlerChangeRadioButton() {
        System.out.println("Valor de RadioButton: " + valueRadioButton);
    }

    public void aprobarSolicitudCuenta(Usuario userSelect) {
        try 
        {
            if (valueRadioButton.equals("1")) 
            {
                findestado = estadorepo.getOne(2);
                userSelect.setCodEstado(findestado);
                admrepo.saveAndFlush(userSelect);
                MessagesView.verMensajes("Usuario aceptado exitosamente", 1);
                listausuariosPendientes = admrepo.findByCodl();
                conteocreacion = listausuariosPendientes.size();
                System.out.println(conteocreacion);
                
                
            } else {
                File log = new File("logcuentasrechazadas.txt");
                if (log.exists() == false) {
                    System.out.println("Se creara un arhivo en el servidor");
                    log.createNewFile();
                }
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new java.util.Date());
                PrintWriter out = new PrintWriter(new FileWriter(log, true));
                //out.append("****************************************");
                out.append("NOMBRE: " + userSelect.getNombre() + "\n");
                out.append("CORREO: " + userSelect.getCorreo() + "\n");
                out.append("ROL: " + userSelect.getRol().getNombre() + "\n");
                out.append("MOTIVO: " + textEditor + "\n");
                out.append("FECHA Y HORA: " + timeStamp + "\n");
                out.append("****************************************\n");
                out.close();
                MessagesView.verMensajes("Se ha enviado un correo de notificacion al usuario.", 2);
            }

        } catch (Exception e) {
            MessagesView.verMensajes("Ha ocurrido un error por favor intente mas tarde.", 4);
            System.out.println("#ERROR AdminBean.class(aprobarSolicitudCuenta): " + e.getMessage());
        }
    }

    public void verficarUserSelect(Usuario user_select) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            //Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("user_select");
            //MessagesView.verMensajes("Primero Seleccione un Usuario", 2);
            if (user_select == null) {
                System.out.println("->AdminBean.class(verficarUserSelect): No se seleccionó un usuario para ver detaller y redireccionar");
                MessagesView.verMensajes("Primero Seleccione un Usuario", 2);
            } else {
                System.out.println("AdminBean.class(verficarUserSelect): Selecciono usuario con id: " + user_select.getIdUsuario() + " -> " + user_select.getNombre() + "\n\n\nREDIRECCIONANDO...");
                userSelectDetails = new Usuario();
                userSelectDetails = admrepo.getOne(user_select.getIdUsuario());
                dato = 2018;
                context.getExternalContext().getSessionMap().put("u_sel", userSelectDetails);
                context.getExternalContext().redirect("./user_select.xhtml");                
                
                System.out.println("iniciando...: "+userSelectDetails.getNombre());
            }
        } catch (Exception e) {
            System.out.println("#ERROr AdminBean.class(verficarUserSelect): " + e.getMessage());
        }
    }

    public void verFecha()
    {
       // userResetPassword.setPsswdTempExpira(fechaExpiracion);
        userResetPassword.setPsswdTempToken(Seguridad.obtenerToken());
        admrepo.save(userResetPassword);
    }
    
    /*
    public void redireccionar(Usuario user_select) throws IOException 
    {
        try 
        {
            if(user_select == null)
            {
                MessagesView.verMensajes("Primero Seleccione un Usuario", 2);
            }else
            {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user_select", user_select);
                System.out.println(user_select.getNombre());
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().redirect("/AppRepoucaPU/faces/admin/investigacion_selct.xhtml");
            }
        } catch (Exception e) 
        {
            System.out.println("#ERROR AdminBean.class(redireccionar): "+e.getMessage());
        }
    }*/
    
    public boolean convertEstadouserSelectDetails(int valor)
    {
        if(valor == 2){
            return true;
        }else{
            return false;
        }
            
        
    }
    
    public void guardarCambios()
    {
        try 
        {
            admrepo.saveAndFlush(userSelectDetails);
            System.out.println("Se ha guardado Usuario con exito...");
        } catch (Exception e) {
            System.out.println("#ERROR AdminBean.class((guardarCambios):  "+e.getMessage());
        }
    }
    
    public void guardarCambiosPermisos()
    {
        System.out.println(switchPermisoApp);
    }
    
    public AdminBean() 
    {
        admrepo = ApplicationContextProvider.getApplicationContext().getBean(UserRepository.class);
        rolrepository = ApplicationContextProvider.getApplicationContext().getBean(RolRepository.class);
        estadorepo = ApplicationContextProvider.getApplicationContext().getBean(EstadoRepository.class);
        listausuariosPendientes = new ArrayList<>();
        listausuariosPendientes = userRequest();
        conteocreacion = listausuariosPendientes.size();   
        
    }

    public String timeStamp(Date fecha)
    {
        if(fecha == null){
        return "--"      ;
        }
        else {return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fecha);   }
    }
    
    public String getValueRadioButton() {
        return valueRadioButton;
    }

    public void setValueRadioButton(String valueRadioButton) {
        this.valueRadioButton = valueRadioButton;
    }

    public String getTextEditor() {
        return textEditor;
    }

    public void setTextEditor(String textEditor) {
        this.textEditor = textEditor;
    }

    public List<Usuario> getListausuariosPendientes() {
        return listausuariosPendientes;
    }

    public void setListausuariosPendientes(List<Usuario> listausuariosPendientes) {
        this.listausuariosPendientes = listausuariosPendientes;
    }

    public Usuario getUserRequestAcount() {
        return userRequestAcount;
    }

    public void setUserRequestAcount(Usuario userRequestAcount) {
        this.userRequestAcount = userRequestAcount;
    }

    public int getConteocreacion() {
        return conteocreacion;
    }

    public void setConteocreacion(int conteocreacion) {
        this.conteocreacion = conteocreacion;
    }

    public List<Usuario> getListaResetPassword() {
        return listaResetPassword;
    }

    public void setListaResetPassword(List<Usuario> listaResetPassword) {
        this.listaResetPassword = listaResetPassword;
    }

    public Usuario getUserResetPassword() {
        return userResetPassword;
    }

    public void setUserResetPassword(Usuario userResetPassword) {
        this.userResetPassword = userResetPassword;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public int getConteoReset() {
        return conteoReset;
    }

    public void setConteoReset(int conteoReset) {
        this.conteoReset = conteoReset;
    }

    public Usuario getUserSelectDetails() {
        return userSelectDetails;
    }

    public void setUserSelectDetails(Usuario userSelectDetails) {
        this.userSelectDetails = userSelectDetails;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public boolean isSwitchPermisoApp() {
        return switchPermisoApp;
    }

    public void setSwitchPermisoApp(boolean switchPermisoApp) {
        this.switchPermisoApp = switchPermisoApp;
    }

    
}
