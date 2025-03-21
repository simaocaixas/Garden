package com.github.Garden.Model;

import jakarta.persistence.*;
//import jakarta.persistence.MappedSuperclass;


@Entity
@Table(name = "tree_table")
public class Tree extends PhysicEntity {


    @Column(name = "specie_name")
    private String specie;

    @Column(name = "tree_height")
    private Integer height;  // like 3m, Integer wrapper to init as null

    @Column(name = "tree_age")
    private Integer age;

    @Column(name = "leaf_type")
    @Enumerated(EnumType.STRING)
    private LeafType leafType;

    public Tree() {}

    public Tree(String specie, Integer height, Integer age, LeafType leafType) {
        this.specie = specie;
        this.height = height;
        this.age = age;
        this.leafType = leafType;
        this.findPosition();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LeafType getLeafType() {
        return leafType;
    }

    public void setLeafType(LeafType leafType) {
        this.leafType = leafType;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
