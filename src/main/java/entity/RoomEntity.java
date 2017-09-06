package entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "rooms")
public class RoomEntity implements Serializable {

    public RoomEntity() {
    }

    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_id;

    @Column(name = "room_name")
    private String room_name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roomID")
    private List<MessagesEntity> sentMessages;

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public List<MessagesEntity> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<MessagesEntity> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(long room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((room_id == null) ?0 : room_id.hashCode());
        result = prime * result + ((room_name == null) ? 0 : room_name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof RoomEntity))
            return false;
        RoomEntity other = (RoomEntity) obj;
        if (room_id == null) {
            if (other.room_id != null)
                return false;
        } else if (!room_id.equals(other.room_id))
            return false;
        if (room_name == null) {
            if (other.room_name != null)
                return false;
        } else if (!room_name.equals(other.room_name))
            return false;
        return true;
    }

//    @Override
//    public String toString() {
//        return "RoomEntity{" +
//                "room_id=" + room_id +
//                ", room_name='" + room_name + '\'' +
//                '}';
//    }
}
