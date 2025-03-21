package com.github.Garden.Model;

import com.github.Garden.Tree.Position;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
    public class PhysicEntity extends BaseEntity {

    private Position position;

    public Position findPosition() {

        return position;
    }
}
