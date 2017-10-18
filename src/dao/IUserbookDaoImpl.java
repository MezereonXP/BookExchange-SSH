package dao;
import entity.ForumEntity;
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

    public List<UserbookEntity> searchBookByName(String s){
        String hql = "from UserbookEntity u where u.bookname like %?%";
        return (List<UserbookEntity>) this.hibernateTemplate.find(hql,s);
    }

    @Override
    public void saveUserbook(UserbookEntity userbookEntity) throws SQLException {
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
        hibernateTemplate.save(userbookEntity);
    }

    @Override
    public void delUserbook(UserbookEntity userbookEntity) throws SQLException {
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
        hibernateTemplate.delete(userbookEntity);
    }

    @Override
    public void editUserbook(UserbookEntity userbookEntity) throws SQLException {
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
        hibernateTemplate.update(userbookEntity);
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
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(UserbookEntity.class);
        Root<UserbookEntity> root = criteriaQuery.from(UserbookEntity.class);
        criteriaQuery.select(root);
        TypedQuery<UserbookEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<UserbookEntity> list = typedQuery.getResultList();
        return list;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
