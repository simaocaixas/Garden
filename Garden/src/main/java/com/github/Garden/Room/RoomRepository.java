package com.github.Garden.Room;


import com.github.Garden.Model.PhysicEntity;
import com.github.Garden.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
