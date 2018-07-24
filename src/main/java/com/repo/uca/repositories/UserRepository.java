/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.repositories;

import com.repo.uca.entities.Estado;
import com.repo.uca.entities.Rol;
import com.repo.uca.entities.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mel_e
 */

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer>
{
    
    public Usuario findByCorreoAndPsswd(String correo, String psswd);
   
    //Obteniedo todos los usuarios que desean crear cuenta
    @Query(nativeQuery = true,value = "select * from repo.usuario where repo.usuario.rol in(20,30) and repo.usuario.cod_estado = 0")
    public List<Usuario> findByCodl();
    
    
    @Query(nativeQuery = true,value = "select count(*) from repo.usuario where repo.usuario.correo = ?")
    public int ExisteCuenta(String correo);
    
    @Query(nativeQuery = true,value = "select * from repo.usuario where repo.usuario.correo = ?")
    public Usuario UserbyCorreo(String correo);
    
    @Query(nativeQuery = true,value ="SELECT * FROM REPO.USUARIO WHERE COD_ESTADO = 2 AND STATUS = false;")
    public List<Usuario> findUserResetPassword();
    
}
