/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.repositories;

import com.repo.uca.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mel_e
 */

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina,Integer>{
    
}
