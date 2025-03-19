package com.github.Garden.Model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;

@MappedSuperclass
public class Tree extends BaseEntity {

    @Column(name = "specie_name")
    @NotBlank
    private String specie;

    @Column(name = "tree_height")
    @NotBlank
    private Integer height;  // like 3m, Integer wrapper to init as null

}
