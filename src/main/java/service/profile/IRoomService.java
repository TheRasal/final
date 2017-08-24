package service.profile;


import entity.RoomEntity;

import java.util.List;

/**
 * Created by Redlaw on 10.09.2016.
 */


public interface IRoomService {

    RoomEntity getRoomById(Long room_id);

    RoomEntity getRoomByName(String room_name);

    List<RoomEntity> getAllRooms();

}
