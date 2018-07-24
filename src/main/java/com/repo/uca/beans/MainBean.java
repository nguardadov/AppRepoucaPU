package com.repo.uca.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mel_e
 */

@ManagedBean(name = "main")
public class MainBean {
    
    @Autowired
    //private PuserRepository urr;
    
    public void probar()
    {
       /* try
        {*/
        Animal a1 = new Animal("Perro", "mamifero");
        Animal a2 = new Animal("Perico", "ave");
        Animal a3 = new Animal("tiburon", "pez");
        
        List<Animal> listaanimales = new ArrayList<>();
        listaanimales.add(a1);
        listaanimales.add(a2);
        listaanimales.add(a3);
        
        /*String result = new Gson().toJson(listaanimales);
        System.out.println(result);
        System.out.println(urr.findAll().size());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }*/
    }
    
    /*public MainBean()
    {
        
    }*/
}
