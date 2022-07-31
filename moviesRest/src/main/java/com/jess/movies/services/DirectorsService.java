/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jess.movies.services;

import com.jess.movies.model.Director;
import com.jess.movies.repositories.DirectorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jessica-22
 */
@Service
public class DirectorsService {
    private final DirectorRepository directorRepo;
    
    @Autowired
    DirectorsService(DirectorRepository d){
        directorRepo=d;
    }
    
    
    public List<Director> getAllDirectors(){
        return directorRepo.findAll();
    }
    
}
