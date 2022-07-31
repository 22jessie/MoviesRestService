/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jess.movies.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
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
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="native")
    @GenericGenerator(name="native",strategy="native")
    @Column(name="genre_id")
    private int id;
    
    @NotBlank(message="Genre cannot be blank")
    @Size(max=18,message="Genre cannot be longer than 18 characters")
    private String genre;
    
    @ManyToMany(mappedBy="genres",fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    private Set<Movie> movies=new HashSet<>();
    
}
