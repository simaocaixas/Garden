package com.github.Garden.Room;

import com.github.Garden.Model.Room;
import com.github.Garden.Model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void newRoom(Room room) {
        roomRepository.save(room);
    }

}
