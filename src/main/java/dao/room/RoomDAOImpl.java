package dao.room;

import entity.RoomEntity;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;

@Repository("roomDAO")
@Transactional
public class RoomDAOImpl implements IRoomDAO {
    @Autowired
    private MessageSource messageSource;

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    private final Logger LOGGER = Logger.getLogger(getClass());



    public RoomEntity getRoomById(Long room_id) {
        String roomHQL = "FROM  RoomEntity WHERE room_id = :room_id";
        Query query=sessionFactory.getCurrentSession().createQuery(roomHQL);
        query.setParameter("room_id",room_id);
        LOGGER.info(messageSource.getMessage("dao.room.getById",new Object[]{room_id},Locale.ENGLISH));
        return (RoomEntity)query.uniqueResult() ;
//        RoomEntity roomEntity = sessionFactory.getCurrentSession().get(RoomEntity.class,room_id);
//        LOGGER.info(messageSource.getMessage("dao.room.getById",new Object[]{room_id},Locale.ENGLISH));
//        return roomEntity;
    }


    public RoomEntity getRoomByName(String room_name){
        String roomHQL = "FROM  RoomEntity WHERE room_name = :room_name";
        Query query=sessionFactory.getCurrentSession().createQuery(roomHQL);
        query.setParameter("room_name",room_name);
        LOGGER.info(messageSource.getMessage("dao.room.getByName",new Object[]{room_name},Locale.ENGLISH));
        return (RoomEntity)query.uniqueResult() ;
//        RoomEntity roomEntity = sessionFactory.getCurrentSession().get(RoomEntity.class,room_name);
//        LOGGER.info(messageSource.getMessage("dao.room.getByName",new Object[]{room_name},Locale.ENGLISH));
//        return roomEntity;
    }

    public List<RoomEntity> getAllRooms() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RoomEntity.class);
        criteria.addOrder(Order.desc("room_name"));

        List result = criteria.list();
        LOGGER.info(messageSource.getMessage("dao.room.getAll", new Object[]{result}, Locale.ENGLISH));

        return result;
    }
       

        
    
}


