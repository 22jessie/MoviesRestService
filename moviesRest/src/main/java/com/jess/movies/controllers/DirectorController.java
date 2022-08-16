/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jess.movies.controllers;

import com.jess.movies.model.Director;
import com.jess.movies.services.DirectorsService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jessica-22
 */

@RequestMapping(path="/api", produces={
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
    
    @GetMapping("/directors")
    public List<Director> getDirectors(){
        return directorServ.getAllDirectors();
    }
    
    @GetMapping("/directors/{id}")
    public Director getDirectorById(@PathVariable int id){
        return directorServ.getDirectorById(id).get();
    }
    
    @GetMapping("/directors/all")
    public Director getDirectorById(@RequestParam(value="name") String name){
        return directorServ.getDirectorByName(name).get();  
    }
    
    @PostMapping("directors")
    public ResponseEntity<String> addDirector(@Valid @RequestBody Director d){
        directorServ.save(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Director Saved!");
    }
    
    @DeleteMapping("directors/{id}")
    public void deleteDirector(@PathVariable int id){
        Optional<Director> d = directorServ.getDirectorById(id);
        if(d.isPresent()){
            directorServ.deleteById(d.get().getId());
        }
    }
    

    
}
