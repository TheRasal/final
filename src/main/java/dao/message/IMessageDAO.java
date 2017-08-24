package dao.message;


import entity.MessagesEntity;
import entity.RoomEntity;

import java.util.List;

public interface IMessageDAO {


    MessagesEntity createMessage(MessagesEntity message);

    MessagesEntity getMessageById(Long messageID);

    void updateMessage(MessagesEntity message);

    void deleteMessage(MessagesEntity message);

    List<MessagesEntity> getAllMessages();


}
