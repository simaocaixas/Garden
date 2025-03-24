package com.github.Garden.Model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
    public class PhysicEntity extends BaseEntity {

        private Integer x, y;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
