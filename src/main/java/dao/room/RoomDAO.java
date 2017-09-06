package dao.room;

import entity.RoomEntity;

import java.util.List;

public interface RoomDAO {


    RoomEntity getRoomById(Long room_id );

    RoomEntity getRoomByName(String room_name);

    List<RoomEntity> getAllRooms();
}
