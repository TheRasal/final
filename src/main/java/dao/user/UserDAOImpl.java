package dao.user;

import dto.UserDTO;
import entity.UserEntity;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import utils.UtilClass;


import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;

    @Repository("userDAOImpl")
    @Transactional
    public class UserDAOImpl implements IUserDAO {

        private final Logger LOGGER = Logger.getLogger(getClass());

        @Autowired
        private MessageSource messageSource;

        @Resource(name = "sessionFactory")
        public SessionFactory sessionFactory;

        // User creation

        public UserEntity createUser(UserEntity user) {
            sessionFactory.getCurrentSession().save(user);
            LOGGER.info(messageSource.getMessage("dao.user.save", new Object[]{user}, Locale.ENGLISH));
            return user;
        }

        // Updating

        public void updateUser(UserEntity user) {
            UserEntity mergedUser = (UserEntity) sessionFactory.getCurrentSession().merge(user);
            sessionFactory.getCurrentSession().update(mergedUser);
            LOGGER.info(messageSource.getMessage("dao.user.update", new Object[]{user}, Locale.ENGLISH));
        }

        // User deletion

        public void deleteUser(UserEntity user) {
            UserEntity mergedUser = (UserEntity) sessionFactory.getCurrentSession().merge(user);
            sessionFactory.getCurrentSession().delete(mergedUser);
            LOGGER.info(messageSource.getMessage("dao.user.delete", new Object[]{user}, Locale.ENGLISH));
        }


        public boolean isLoginExists(String login) {

            String userHQL = "FROM UserEntity WHERE login = :login";
            org.hibernate.query.Query query = sessionFactory.getCurrentSession().createQuery(userHQL);
            query.setParameter("login", login);
            return query.list().size() > 0;
        }

        // If user has needed password

        public boolean isPasswpodlCorrect(UserDTO user) {

            String login = user.getLogin();
            String password = UtilClass.passEncoding(user.getPassword());

            String userHQL = "FROM UserEntity WHERE password=:password AND login=:login";
            Query query = sessionFactory.getCurrentSession().createQuery(userHQL);
            query.setParameter("password", password);
            query.setParameter("login", login);

            List userEntities = query.list();

            return userEntities.size() > 0;
        }

        // If user's email already exists

        public boolean isEmailExists(String email) {

            String userHQL = "FROM UserEntity WHERE email = :email";
            Query query = sessionFactory.getCurrentSession().createQuery(userHQL);
            query.setParameter("email", email);

            List userEntities = query.list();

            return userEntities.size() > 0;
        }

        // Getting user by login

        public UserEntity getUserByLogin(String login) {
            String userHQL = "FROM  UserEntity WHERE login = :login";
            Query query = sessionFactory.getCurrentSession().createQuery(userHQL);
            query.setParameter("login", login);
            LOGGER.info(messageSource.getMessage("dao.user.getByLogin", new Object[]{login}, Locale.ENGLISH));

            return (UserEntity) query.uniqueResult();
        }
}
