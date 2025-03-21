package com.github.Garden.Model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "Room")
public class Room extends BaseEntity{

    @OneToMany
    @JoinColumn(name = "room_id")
    private List<Tree> treeList;

    @Column(name = "room_name")
    private String name;

    @Column(name = "room_capacity")
    private int capacity;

    public List<Tree> getTreeList() {
        return treeList;
    }

    public void setTreeList(List<Tree> treeList) {
        this.treeList = treeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
