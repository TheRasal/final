package service.user;


import dto.UserDTO;
import entity.UserEntity;



public interface IUserService {

    UserEntity getUserByLogin(String login);

    void createUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(UserEntity user);

    boolean isPasswpodlCorrect(UserDTO user);

    boolean isLoginExists(String login);

    boolean isEmailExists(String email);
}
