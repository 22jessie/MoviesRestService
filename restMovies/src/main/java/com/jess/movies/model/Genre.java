/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jess.movies.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author jessica-22
 */
public class Genre {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="native")
    @GenericGenerator(name="native",strategy="native")
    @Column(name="genre_id")
    private int id;
    
    @NotBlank(message="Genre cannot be blank")
    @Size(max=18,message="Genre cannot be longer than 18 characters")
    private String genre;
    
}
