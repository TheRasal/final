package service.message;


import dao.message.IMessageDAO;
import dao.room.IRoomDAO;
import dto.MessagesDTO;
import entity.MessagesEntity;
import entity.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * Created by Walder on 10.09.2016.
 */

@Service("messageServise")
public class MessageServiceImpl implements IMessageService {

    @Autowired
    IMessageDAO imessageDAO;



//    @Override
    @Transactional
    public MessagesEntity createMessage(MessagesEntity message) {
        return imessageDAO.createMessage(message);
    }

//    @Override
    @Transactional
    public MessagesEntity getMessageById(Long message_id) {
        return imessageDAO.getMessageById(message_id);
    }

//    @Override
    @Transactional
    public void updateMessage(MessagesEntity message) {
        imessageDAO.updateMessage(message);
    }

//    @Override
    @Transactional
    public void deleteMessage(MessagesEntity message) {
        imessageDAO.deleteMessage(message);
    }

//    @Override
    @Transactional
    public List<MessagesEntity> getAllMessage() {
        return imessageDAO.getAllMessages();
    }
//    @Override


//    @Override
    public void messageEdit(MessagesDTO messagesDTO) {
            MessagesEntity oldMessage = this.getMessageById(messagesDTO.getMessageID());

            MessagesEntity newMessage = new MessagesEntity();
            //getting user_id from the current post_object inside the DB
            newMessage.setUserID(oldMessage.getUserID()); //временный велосипед
            //getting postDate from the current post_object inside the DB
            newMessage.setMessageID(messagesDTO.getMessageID());
            newMessage.setText(messagesDTO.getText());
            try {
                if (messagesDTO.getImage().getBytes().length > 0)
                    newMessage.setImage(messagesDTO.getImage().getBytes());
                else
                    newMessage.setImage(oldMessage.getImage());
            } catch (IOException e) {
                e.printStackTrace();
            }

            this.updateMessage(newMessage);
    }

}
