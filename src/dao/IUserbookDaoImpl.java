package dao;
import entity.MessageEntity;
import entity.UserbookEntity;
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
public class IUserbookDaoImpl implements IUserbookDao{

    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void saveUserbook(UserbookEntity userbookEntity) throws SQLException {
        hibernateTemplate.save(userbookEntity);
        //hibernateTemplate.getSessionFactory().getCurrentSession().clear();
    }

    @Override
    public void delUserbook(UserbookEntity userbookEntity) throws SQLException {
        hibernateTemplate.delete(userbookEntity);
        //hibernateTemplate.getSessionFactory().getCurrentSession().clear();
    }

    @Override
    public void editUserbook(UserbookEntity userbookEntity) throws SQLException {
        hibernateTemplate.update(userbookEntity);
        //hibernateTemplate.getSessionFactory().getCurrentSession().clear();
    }

    @Override
    public UserbookEntity getUserbookById(int id) throws SQLException {
        return hibernateTemplate.get(UserbookEntity.class,id);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
                .createQuery("from userbook ac where ac.id = :id").setParameter("id", id);
        System.out.println(query.list().size());
        return query.list().size()>0?true:false;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) throws SQLException {

    }

    public List<UserbookEntity> getAllForum() {
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(UserbookEntity.class);
        Root<UserbookEntity> root = criteriaQuery.from(UserbookEntity.class);
        criteriaQuery.select(root);
        TypedQuery<UserbookEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<UserbookEntity> list = typedQuery.getResultList();
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
        return list;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
