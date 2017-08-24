package dto;

import entity.RoomEntity;
import entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public class MessagesDTO {

    public MessagesDTO() {
    }

    private Long messageID;
    private UserEntity user_id;
    private String text;
    private MultipartFile image;
    private RoomEntity room_id;
    private Date postDate;

    public RoomEntity getRoom_id() {
        return room_id;
    }

    public void setRoom_id(RoomEntity room_id) {
        this.room_id = room_id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Long getMessageID() {
        return messageID;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserEntity getUser_id() {
        return user_id;
    }

    public void setUser_id(UserEntity user_id) {
        this.user_id = user_id;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

//    public RoomEntity getRoom_name() {
//        return room_name;
//    }
//
//    public void setRoom_name(RoomEntity room_name) {
//        this.room_name = room_name;
//    }
}
