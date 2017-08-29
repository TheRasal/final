package entity;




import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class UserEntity implements Serializable {

    public UserEntity() {
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "users_rooms",
//            joinColumns = { @JoinColumn(name = "user_id") },
//            inverseJoinColumns = { @JoinColumn(name = "room_id") })
//    private Set<RoomEntity> roomEntitySet = new HashSet<RoomEntity>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userID")
    private List<MessagesEntity> sentMessages;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "usersID")



    public List<MessagesEntity> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<MessagesEntity> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((user_id == null) ?0 : user_id.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserEntity))
            return false;
        UserEntity other = (UserEntity) obj;
        if (user_id == null) {
            if (other.user_id != null)
                return false;
        } else if (!user_id.equals(other.user_id))
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        return true;
    }

//    @Override
//    public String toString() {
//        return "UserEntity{" +
//                "user_id=" + user_id +
//                ", login='" + login + '\'' +
//                ", password='" + password + '\'' +
//                ", email='" + email + '\'' +
//                ", name='" + name + '\'' +
//                ", age=" + age +'}';
//    }
}
