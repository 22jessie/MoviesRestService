/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jess.movies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author jessica-22
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Director implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="native")
    @GenericGenerator(name="native",strategy="native")
    @Column(name="director_id")
    @JsonIgnore
    private int id;
    
    @NotBlank(message="Name cannot be blank")
    @Size(max=50,message="Name cannot be longer than 50 characters")
    private String name;
    
    @JsonIgnore 
    @OneToMany(mappedBy="director",fetch=FetchType.EAGER,
            cascade=CascadeType.PERSIST,targetEntity=Movie.class)
    private Set<Movie> movies=new HashSet<>();
}
