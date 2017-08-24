package converter;

import dto.MessagesDTO;
import entity.MessagesEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;



public class PostToPostDTOConverter {

    public static MessagesDTO convertoEntityToDTO(MessagesEntity messagesEntity) {

        MessagesDTO messagesDTO = new MessagesDTO();
        messagesDTO.setMessageID(messagesEntity.getMessageID());
        messagesDTO.setUser_id(messagesEntity.getUserID());
        messagesDTO.setPostDate(messagesEntity.getPostDate());
        messagesDTO.setRoom_id(messagesEntity.getRoomID());

        if (messagesEntity.getText() != null)
            messagesDTO.setText(messagesEntity.getText());

        if (messagesEntity.getImage() != null) {
            MultipartFile multipartFile = new MockMultipartFile("imageFile", "filename", "image/png", messagesEntity.getImage());
            messagesDTO.setImage(multipartFile);
        }

        return messagesDTO;
    }
}
