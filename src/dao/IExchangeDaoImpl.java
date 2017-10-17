package dao;

import entity.BookarticleEntity;
import entity.ExchangeEntity;
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
public class IExchangeDaoImpl implements IExchangeDao{

    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void saveExchange(ExchangeEntity exchangeEntity) throws SQLException {
        hibernateTemplate.save(exchangeEntity);
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
    }

    @Override
    public void delExchange(ExchangeEntity exchangeEntity) throws SQLException {
        hibernateTemplate.delete(exchangeEntity);
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
    }

    @Override
    public void editExchange(ExchangeEntity exchangeEntity) throws SQLException {
        hibernateTemplate.update(exchangeEntity);
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
    }

    @Override
    public ExchangeEntity getExchangeById(int id) throws SQLException {
        return hibernateTemplate.get(ExchangeEntity.class,id);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
                .createQuery("from exchange ac where ac.id = :id").setParameter("id", id);
        System.out.println(query.list().size());
        return query.list().size()>0?true:false;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) throws SQLException {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public List<ExchangeEntity> getAllExchange() {
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(ExchangeEntity.class);
        Root<ExchangeEntity> root = criteriaQuery.from(ExchangeEntity.class);
        criteriaQuery.select(root);
        TypedQuery<ExchangeEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<ExchangeEntity> list = typedQuery.getResultList();
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
        return list;
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
