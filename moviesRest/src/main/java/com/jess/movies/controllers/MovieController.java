/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jess.movies.controllers;

import com.jess.movies.model.Movie;
import com.jess.movies.services.MovieService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jessica-22
 */

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    
    private final MovieService moviesServ;
    
    @Autowired
    MovieController(MovieService ms){
        moviesServ=ms;
    }
    
    @GetMapping("/all")
    public List<Movie> getAllMovies(){
        return moviesServ.getAll();
    }
    
    @GetMapping("/year/{year}")
    public List<Movie> getMoviesByYear(@PathVariable("year") int year){
        return moviesServ.getMoviesByYear(year);
    }
    
    @GetMapping("/country/{country}")
    public List<Movie> getMoviesByCountry(@PathVariable("country") String country){
        return moviesServ.getMoviesByCountry(country);
    }
    
    @GetMapping("/lang/{lang}")
    public List<Movie> getMoviesByLanguage(@PathVariable("lang") String lang){
        return moviesServ.getMoviesByLanguage(lang);
    }
    
    
    @GetMapping("/name/{name}")
    public List<Movie> getMovieByName(@PathVariable("name")String name){
        return moviesServ.getMovieByName(name);
    }
    
    @DeleteMapping("/delete-id/{id}")
    public boolean deleteById(@PathVariable("id") int id){
        return moviesServ.deleteById(id);
    }
    
    @DeleteMapping("/delete-name/{name}")
    public boolean deleteByName(@PathVariable("name") String name){
        return moviesServ.deleteByName(name);
    }
    
    @GetMapping("/before/{year}")
    public List<Movie> getMoviesBeforeYear(@PathVariable("year") int year){
        return moviesServ.getMoviesBeforeYear(year);
    }
    
    @GetMapping("/after/{year}")
    public List<Movie> getMoviesAfterYear(@PathVariable("year") int year){
        return moviesServ.getMoviesAfterYear(year);
    }
    
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean addMovie(@Valid @RequestBody Movie movie){
        return moviesServ.createMovie(movie);
    }

}
