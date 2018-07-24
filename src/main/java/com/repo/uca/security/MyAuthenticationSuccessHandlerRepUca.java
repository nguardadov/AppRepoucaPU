package com.repo.uca.security;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author mel_e
 */
public class MyAuthenticationSuccessHandlerRepUca implements AuthenticationSuccessHandler {

    //paginas despues del login segun el rol: 
    // adm: /faces/admin/adm_index.xhtml
    // inv: /faces/invinvitado/inv_index.html
    // uca: /faces/inuca/uca_index.html
    // otr: /faces/otros/otr_index.html
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) throws IOException, ServletException {
        try {
                Set<String> roles = AuthorityUtils.authorityListToSet(a.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) 
        {
            hsr1.sendRedirect("/AppRepoucaPU/faces/admin/adm_index.xhtml");
            System.out.println( hsr1.getHeaderNames());
        }
        if (roles.contains("ROLE_UCA")) 
        {
            hsr1.sendRedirect("/AppRepoucaPU/faces/invuca/uca_index.xhtml");
        }
        if (roles.contains("ROLE_INVITADO")) 
        {
            hsr1.sendRedirect("/AppRepoucaPU/faces/invinvitado/inv_index.xhtml");
        }
        if (roles.contains("ROLE_OTROS")) 
        {
            hsr1.sendRedirect("/AppRepoucaPU/faces/view/ver_index.xhtml");
        }
        } catch (IOException e) {
            System.out.println("#ERROR: MyAuthenticationSuccessHandlerRepUca.class(onAuthenticationSuccess): "+e.getMessage());
        }

    }
}
