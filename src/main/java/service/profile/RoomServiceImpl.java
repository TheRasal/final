package service.profile;


import dao.room.RoomDAO;
import entity.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  Created by Redlaw on 10.09.2016.
 */

@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDAO iroomDAO;


    @Transactional
    public RoomEntity getRoomById(Long room_id) {
        return iroomDAO.getRoomById(room_id);
    }


    @Transactional
    public RoomEntity getRoomByName(String room_name){
        return iroomDAO.getRoomByName(room_name);
    }

    @Transactional
    public List<RoomEntity> getAllRooms() {
        return iroomDAO.getAllRooms();
    }


}