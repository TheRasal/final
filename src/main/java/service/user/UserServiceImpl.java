package service.user;


import dao.user.UserDAO;
import dto.UserDTO;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  Created by Walder on 10.09.2016.
 */

@Service("iUserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO iuserDao;


    @Transactional
    public UserEntity getUserByLogin(String login) {
        return iuserDao.getUserByLogin(login);
    }


    @Transactional
    public void createUser(UserEntity userEntity) {
        iuserDao.createUser(userEntity);
    }


    @Transactional
    public void updateUser(UserEntity user) {
        iuserDao.updateUser(user);
    }


    @Transactional
    public void deleteUser(UserEntity userEntity) {
        iuserDao.deleteUser(userEntity);
    }


    @Transactional
    public boolean isPasswpodlCorrect(UserDTO user) {
        return iuserDao.isPasswpodlCorrect(user);
    }


    @Transactional
    public boolean isLoginExists(String login) {
        return iuserDao.isLoginExists(login);
    }


    @Transactional
    public boolean isEmailExists(String email) {
        return iuserDao.isEmailExists(email);
    }
}
