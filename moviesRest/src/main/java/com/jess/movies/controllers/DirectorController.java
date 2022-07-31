/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jess.movies.controllers;

import com.jess.movies.model.Director;
import com.jess.movies.services.DirectorsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jessica-22
 */

@RequestMapping(path="dir", produces={
    MediaType.APPLICATION_JSON_VALUE,
    MediaType.APPLICATION_XML_VALUE
    
})
@RestController
public class DirectorController {
    private final DirectorsService directorServ;
    
    @Autowired
    public DirectorController(DirectorsService ds){
        this.directorServ=ds;
    }
    
    
    @GetMapping("/get-directors")
    public List<Director> getDirectors(){
        List<Director> list = directorServ.getAllDirectors();
        list.forEach(d->{
            System.out.println(d);
        });   
        return list;
    }
    
    @PostMapping("new-director")
    public void addDirector(Director d){
        
    }
    
    @DeleteMapping("delete-director")
    public void deleteDirector(){
    
    }
    
    
}
