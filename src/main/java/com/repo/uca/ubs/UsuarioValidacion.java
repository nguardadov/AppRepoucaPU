package com.repo.uca.ubs;

import com.repo.uca.conf.ApplicationContextProvider;
import com.repo.uca.conf.MessagesView;
import com.repo.uca.entities.Usuario;
import com.repo.uca.repositories.UserRepository;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mel_e
 */
//user bean security
@ManagedBean(name = "userValidationRepo")
@RequestScoped
public class UsuarioValidacion implements Serializable {

    @Autowired
    UserRepository urrlogin;

    // f significa de formulario
    private String fcorreo;
    private String fcontrasenia;
    private String fidrol;
    private boolean logueado = false;
    private Usuario userLogin;
    private List<Usuario> listuser;
    private Usuario userSelect;
    int idusuario;

    @PostConstruct
    public void init(){
        findAllUser();
    }
    
    public String loginRepo() {
        try {
            int ExisteCuenta = urrlogin.ExisteCuenta(fcorreo);

            if (ExisteCuenta == 1) {
                System.out.println("Existe cuenta... ACCEDIENDO");
                Usuario requestUser;
                requestUser = urrlogin.UserbyCorreo(fcorreo);
                if (requestUser.getCodEstado().getCodEstado() == 0) {
                    MessagesView.verMensajes("Su cuenta aún no ha sido activada. Por favor espere mensaje de confirmacion.", 3);
                } else {
                    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                    HttpServletRequest request = (HttpServletRequest) context.getRequest();
                    HttpServletResponse response = (HttpServletResponse) context.getResponse();
                    userLogin = urrlogin.UserbyCorreo(fcorreo);
                    findAllUser();
                    System.out.println("UsuarioValidacion.class");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
                    dispatcher.forward(request, response);
                    idusuario = userLogin.getIdUsuario();
                    context.getSessionMap().put("iduserlogin",userLogin.getIdUsuario());
                    System.out.println("temrino de retornar credenciales: "+userLogin.getIdUsuario()+"->"+userLogin.getNombre());
                }
            }
            if (ExisteCuenta == 0) {
                MessagesView.verMensajes("No exite cuenta asociada. Por favor Crear una cuenta.", 3);
            }

        } catch (Exception e) {
            System.out.println("#ERROR UsuarioValidacion.class(loginRepo): " + e.getMessage());
        }
        return null;
    }

  public void logOutRepo() throws ServletException, IOException 
    {
       
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/logout");

        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());

        FacesContext.getCurrentInstance().responseComplete();               
    }

    public void findAllUser() {
        listuser = urrlogin.findAll();
    }
    /*
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }*/
    public String getFcorreo() {
        return fcorreo;
    }

    public void setFcorreo(String fcorreo) {
        this.fcorreo = fcorreo;
    }

    public String getFcontrasenia() {
        return fcontrasenia;
    }

    public void setFcontrasenia(String fcontrasenia) {
        this.fcontrasenia = fcontrasenia;
    }

    public String getFidrol() {
        return fidrol;
    }

    public void setFidrol(String fidrol) {
        this.fidrol = fidrol;
    }

    public boolean isLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }

    public Usuario getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(Usuario userLogin) {
        this.userLogin = userLogin;
    }

    public UsuarioValidacion() {
        urrlogin = ApplicationContextProvider.getApplicationContext().getBean(UserRepository.class);
    }

    public List<Usuario> getListuser() {
        return listuser;
    }

    public void setListuser(List<Usuario> listuser) {
        this.listuser = listuser;
    }

    public Usuario getUserSelect() {
        return userSelect;
    }

    public void setUserSelect(Usuario userSelect) {
        this.userSelect = userSelect;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    
}
