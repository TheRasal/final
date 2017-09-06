package dao.message;


import entity.MessagesEntity;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;

@Repository("messageDAOImpl")
@Transactional
public class MessageDAOImpl implements MessageDAO {

    private final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;


    public MessagesEntity createMessage(MessagesEntity messagesEntity) {
        sessionFactory.getCurrentSession().save(messagesEntity);
        LOGGER.info(messageSource.getMessage("dao.messagesEntity.save", new Object[]{messagesEntity}, Locale.ENGLISH));
        return messagesEntity;
    }


    //    @Override
    public MessagesEntity getMessageById(Long messageID) {
        MessagesEntity messagesEntity = sessionFactory.getCurrentSession().get(MessagesEntity.class, messageID);
        LOGGER.info(messageSource.getMessage("dao.message.getById", new Object[]{messageID}, Locale.ENGLISH));
        return messagesEntity;
    }


    //    @Override
    public void updateMessage(MessagesEntity messagesEntity) {
        sessionFactory.getCurrentSession().update(messagesEntity);
        LOGGER.info(messageSource.getMessage("dao.messagesEntity.update", new Object[]{messagesEntity}, Locale.ENGLISH));
    }


    //    @Override
    public void deleteMessage(MessagesEntity messagesEntity) {
        MessagesEntity mergedMessages = (MessagesEntity) sessionFactory.getCurrentSession().merge(messagesEntity);
        sessionFactory.getCurrentSession().delete(mergedMessages);
        LOGGER.info(messageSource.getMessage("dao.messagesEntity.delete", new Object[]{messagesEntity}, Locale.ENGLISH));
    }


    //    @Override
    public List<MessagesEntity> getAllMessages() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MessagesEntity.class);
        criteria.addOrder(Order.desc("postDate"));

        List result = criteria.list();
        LOGGER.info(messageSource.getMessage("dao.messagesEntity.getAll", new Object[]{result}, Locale.ENGLISH));

        return result;
    }


}
