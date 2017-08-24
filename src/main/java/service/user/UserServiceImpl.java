package service.user;


import dao.user.IUserDAO;
import dto.UserDTO;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  Created by Walder on 10.09.2016.
 */

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO iuserDao;

    @Override
    @Transactional
    public UserEntity getUserByLogin(String login) {
        return iuserDao.getUserByLogin(login);
    }

    @Override
    @Transactional
    public void createUser(UserEntity userEntity) {
        iuserDao.createUser(userEntity);
    }

    @Override
    @Transactional
    public void updateUser(UserEntity user) {
        iuserDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(UserEntity userEntity) {
        iuserDao.deleteUser(userEntity);
    }

    @Override
    @Transactional
    public boolean isPasswpodlCorrect(UserDTO user) {
        return iuserDao.isPasswpodlCorrect(user);
    }

    @Override
    @Transactional
    public boolean isLoginExists(String login) {
        return iuserDao.isLoginExists(login);
    }

    @Override
    @Transactional
    public boolean isEmailExists(String email) {
        return iuserDao.isEmailExists(email);
    }
}
