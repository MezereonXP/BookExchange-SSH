package dao;

import entity.BeuserEntity;
import org.hibernate.Hibernate;
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
 * Created by Mezereon on 2017/10/7.
 */
public class IBeuserEntityDaoImpl implements IBeuserEntityDao{


    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public List<BeuserEntity> getAllUser() {
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(BeuserEntity.class);
        Root<BeuserEntity> root = criteriaQuery.from(BeuserEntity.class);
        criteriaQuery.select(root);
        TypedQuery<BeuserEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<BeuserEntity> list = typedQuery.getResultList();
        return list;
    }

    @Override
    public void saveUser(BeuserEntity user) throws SQLException {
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
        hibernateTemplate.save(user);
    }

    @Override
    public void delUser(BeuserEntity user) throws SQLException {
        hibernateTemplate.delete(user);
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
    }

    @Override
    public void editUser(BeuserEntity user) throws SQLException {
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
        hibernateTemplate.update(user);
    }

    @Override
    public BeuserEntity getUserById(int id) throws SQLException {
        BeuserEntity beuserEntity = hibernateTemplate.get(BeuserEntity.class, id);
        return beuserEntity;
    }

    public BeuserEntity getUserByName(String username){
        Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
                .createQuery("from BeuserEntity u where u.username = ?");
        query.setParameter(0,username);
        BeuserEntity beuserEntity = (BeuserEntity) query.list().get(0);
        return beuserEntity;
    }

    @Override
    public boolean isExists(String username) {
        Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
                .createQuery("from BeuserEntity u where u.username = ?");
        query.setParameter(0,username);
        System.out.println(query.list().size());
        return query.list().size()>0?true:false;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
