package dao.user;

import dto.UserDTO;
import entity.UserEntity;

public interface UserDAO {

    UserEntity createUser(UserEntity user);

    void updateUser(UserEntity user);

    // удаление юзера
    void deleteUser(UserEntity user);

    // Если логин уже есть в базе
    boolean isLoginExists(String login);

    // Если юзер и его пароль уже есть в базе
    boolean isPasswpodlCorrect(UserDTO user);

    // Если юзер с заданным емейлом уже есть в базе
    boolean isEmailExists(String email);

    // Нахождение юзера по логину
    UserEntity getUserByLogin(String login);

}
