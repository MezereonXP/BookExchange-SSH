package dao;
import entity.ForumEntity;
import entity.MessageEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/10/8/008.
 */
public class IMessageDaoImpl implements IMessageDao{
    @Autowired
    private SessionFactory sessionFactory;

    private HibernateTemplate hibernateTemplate;

    @Override
    public void saveMessage(MessageEntity messageEntity) throws SQLException {
        hibernateTemplate.save(messageEntity);
    }

    @Override
    public void delMessage(MessageEntity messageEntity) throws SQLException {
        hibernateTemplate.delete(messageEntity);
    }

    @Override
    public void editMessage(MessageEntity messageEntity) throws SQLException {
        hibernateTemplate.update(messageEntity);
    }

    @Override
    public MessageEntity getMessageById(int id) throws SQLException {
        return hibernateTemplate.get(MessageEntity.class,id);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        Query query = sessionFactory.openSession()
                .createQuery("from message ac where ac.id = :id").setParameter("id", id);
        System.out.println(query.list().size());
        return query.list().size()>0?true:false;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) throws SQLException {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public List<MessageEntity> getAllForum() {
        Session session = sessionFactory.getCurrentSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(MessageEntity.class);
        Root<MessageEntity> root = criteriaQuery.from(MessageEntity.class);
        criteriaQuery.select(root);
        TypedQuery<MessageEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<MessageEntity> list = typedQuery.getResultList();
        return list;
    }
}
