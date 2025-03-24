package com.github.Garden.Model;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PostLoad;

@MappedSuperclass
    public class PhysicEntity extends BaseEntity {

    @Embedded
    private Point point;

    public Point getPoint() {
        return point;
    }

    @PostLoad
    public void ensurePointIsInitialized() {
        if (this.point == null) {
            this.point = new Point();
        }
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
