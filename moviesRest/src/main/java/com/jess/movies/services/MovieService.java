/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jess.movies.services;

import com.jess.movies.model.Movie;
import com.jess.movies.repositories.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jessica-22
 */

@Service
public class MovieService {
    
    private final MovieRepository movieRepo;
    
    @Autowired
    MovieService(MovieRepository mr){
        movieRepo=mr;
    }
    
    public List<Movie> getAll(){
        return movieRepo.findAll();
    }
    
    public List<Movie> getMoviesByYear(int year){
        return movieRepo.getMoviesByYear(year);
    }
    
    public List<Movie> getMoviesByCountry(String c){
        return movieRepo.getMoviesByCountry(c);
    }
    
    public List<Movie> getMoviesByLanguage(String l){
        return movieRepo.getMoviesByLanguage(l);
    }
    
    public List<Movie> getMoviesBeforeYear(int y){
        return movieRepo.getMoviesByYearLessThan(y);
    }
    
    public List<Movie> getMoviesAfterYear(int y){
        return movieRepo.getMoviesByYearLessThan(y);
    }

    public boolean deleteByName(String name) {
        return movieRepo.deleteByTitle(name);
    }

    public boolean deleteById(int id) {
        return movieRepo.deleteById(id);
    }

    public boolean createMovie(Movie movie) {
        return  movieRepo.save(movie) != null;
    }

    public List<Movie> getMovieByTitle(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
