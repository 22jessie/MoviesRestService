/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jess.movies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author jessica-22
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="native")
    @GenericGenerator(name="native",strategy="native")
    @Column(name="movie_id")
    private int id;
    
    @NotBlank(message="Title cannot be blank")
    @Size(max=150,message="Title cannot exceed 150 characters")
    private String title;
    
    @NotBlank(message="Duration cannot be blank")
    @Pattern(regexp="(^$|[0-9]{5})",message="Too many minutes")
    private int duration;
    
    @NotBlank(message="Language cannot be blank")
    @Size(max=50,message="Language cannot exceed 50 characters")
    private String language;
    
    @NotBlank(message="Country cannot be blank")
    @Size(max=50,message="Country cannot exceed 50 characters")
    private String country;
    
    @NotBlank(message="Color cannot be blank")
    @Size(max=50,message="Color cannot exceed 50 characters")
    private String color;
    
    @NotBlank(message="Year cannot be blank")
    @Pattern(regexp="(^$|[0-9]{4})",message="Long is too long")
    private int year; 
    
    @ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinTable(name="movie_genre",
            joinColumns={
                @JoinColumn(name="movie_id",referencedColumnName = "movie_id")
            },
            inverseJoinColumns={
                @JoinColumn(name="genre_id",referencedColumnName = "genre_id")
            }
    )
    private Set<Genre> genres=new HashSet<Genre>();
    
    @ManyToOne(fetch=FetchType.EAGER, optional=true)
    @JoinColumn(name="director_id_fk",referencedColumnName="director_id",nullable=true)
    private Director director;
    
}
