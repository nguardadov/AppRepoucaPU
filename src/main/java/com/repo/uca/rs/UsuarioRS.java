
package com.repo.uca.rs;

import com.repo.uca.conf.ApplicationContextProvider;
import com.repo.uca.entities.Usuario;
import com.repo.uca.repositories.UserRepository;
import java.io.Serializable;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mel_e
 */

@Path("/vfusuario")
public class UsuarioRS implements Serializable
{    
    @Autowired
    private UserRepository urr;
    
    @POST
    @Path("/viewuserbycorreo")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List< Usuario> vPropertiesUsuario()
    {
        return urr.findAll();
    }
    
    @POST
    @Path("/viewpropertiesu/{correo}/{psswd}")
    @Consumes({MediaType.APPLICATION_JSON})
   @Produces({MediaType.APPLICATION_JSON})
    public Usuario vPropertiesUsuarios(@PathParam("correo") String correo,@PathParam("psswd") String psswd)
    {
       
        return urr.findByCorreoAndPsswd(correo,psswd);
    }
    
    
    @POST
    @Path("/userrequest")
    @Consumes({MediaType.APPLICATION_JSON})
   @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> userRequest()
    {
       
        return urr.findByCodl();
    }
    
    public UsuarioRS()
    {
         urr = ApplicationContextProvider.getApplicationContext().getBean(UserRepository.class);
    }
}
