/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jess.movies.repositories;

import com.jess.movies.model.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jessica-22
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
    
    public List<Movie> getMoviesByYear(int year);
    
    public List<Movie> getMoviesByCountry(String country);
    
    public List<Movie> getMoviesByLanguage(String lang);
    
    public boolean deleteById(int id);
    
    public boolean deleteByTitle(String name);
    
    public List<Movie> getMoviesByYearGreaterThan(int y);
    
    public List<Movie> getMoviesByYearLessThan(int y);
    
    
    
    
}
