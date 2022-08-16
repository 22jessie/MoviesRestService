/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jess.movies.repositories;

import com.jess.movies.model.Director;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jessica-22
 */

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer>{

    public Optional<Director> findByName(String name);
    public void deleteById(int id);
    
}
