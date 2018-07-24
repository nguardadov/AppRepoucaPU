package com.repo.uca.security;

import com.repo.uca.conf.MessagesView;
import com.repo.uca.ubs.UsuarioValidacion;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author mel_e
 */
public class AuthenticationProviderRepUca implements AuthenticationProvider {

    public AuthenticationProviderRepUca() {
        super();
    }

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UsuarioValidacion sec = (UsuarioValidacion) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "userValidationRepo");
        Authentication authRet = null;
        List<GrantedAuthority> roles = new ArrayList<>();
        GrantedAuthority role = null;
        String usuario = a.getPrincipal().toString().trim();
        String password = a.getCredentials().toString().trim();
        System.out.println(sec.getUserLogin().getCorreo() + "->" + sec.getUserLogin().getPsswd());
        try {
            if (usuario.isEmpty() && password.isEmpty()) {
                sec.setLogueado(false);
                //facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Infomación", "Su cuenta aún no ha sido aprobada"));
                throw new BadCredentialsException("Campos Usuario o Contraseña vacios.");
            } 
            else 
            {
                System.out.println("ACCEDIENDO CON CREDENCIALES DE FORMULARIO... ");
                //Leer de la base de datos los datos del usuario
                if (sec.getFcorreo().equals(sec.getUserLogin().getCorreo()) && sec.getFcontrasenia().equals(sec.getUserLogin().getPsswd())) 
                {
                    String id_rol = sec.getUserLogin().getRol().getIdRol().toString();
                    System.out.println("Rol de usuario encontrado: " + id_rol);
                    switch (id_rol) {
                        case "10":
                            System.out.println("CASO 10");
                            role = new SimpleGrantedAuthority("ROLE_ADMIN");
                            System.out.println("Bienvenido ADMIN");
                            break;

                        case "20":
                            System.out.println("CASO 20");
                            role = new SimpleGrantedAuthority("ROLE_UCA");
                            System.out.println("Bienvenido INVESTIGADOR UCA");
                            break;
                        case "30":
                            System.out.println("CASO 3");

                            System.out.println("Bienvenido INVESTIGADOR INVITADO");
                            break;

                        default:
                            System.out.println("OTRO");
                            role = new SimpleGrantedAuthority("ROLE_OTROS");
                            break;

                    }
                    roles.add(role);
                    authRet = new UsernamePasswordAuthenticationToken(usuario, password, roles);
                    sec.setLogueado(true);
                } 
                else 
                {
                    sec.setLogueado(false);
                    throw new BadCredentialsException("Usuario o Contrasenia Invalidos");
                }
            }
        } catch (Exception e) {
            System.out.println("#ERROR: AuthenticationProviderRepUca.authenticate.class: "+e.getMessage());
        }

        System.out.println("Retornando autenticate: ");
        return authRet;
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }

}
