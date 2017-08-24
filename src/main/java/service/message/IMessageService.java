package service.message;


import dto.MessagesDTO;
import entity.MessagesEntity;
import entity.RoomEntity;

import java.util.List;

/**
 * Created by Walder on 10.09.2016.
 */

public interface IMessageService {

    MessagesEntity createMessage(MessagesEntity message);

    MessagesEntity getMessageById(Long message_id);

    void updateMessage(MessagesEntity message);

    void deleteMessage(MessagesEntity message);

    List<MessagesEntity> getAllMessage();

    void messageEdit(MessagesDTO messagesDTO);



}
