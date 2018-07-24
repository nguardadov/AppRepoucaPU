package com.repo.uca.conf;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("repoucav2")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) 
    {
        resources.add(com.repo.uca.rs.UsuarioRS.class);
        /*resources.add(com.jap.catalogo.service.CAlmacenService.class);
        resources.add(com.jap.proceso.service.PComprasService.class);
        resources.add(com.jap.seguridad.service.SUsuarioService.class);*/
        //resources.add(com.repo.uca.restservice.UsuarioService.class);
        
    }
}
