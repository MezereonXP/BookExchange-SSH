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
    @Autowired
    private SessionFactory sessionFactory;

    private HibernateTemplate hibernateTemplate;

    @Override
    public void saveExchange(ExchangeEntity exchangeEntity) throws SQLException {
        hibernateTemplate.save(exchangeEntity);
    }

    @Override
    public void delExchange(ExchangeEntity exchangeEntity) throws SQLException {
        hibernateTemplate.delete(exchangeEntity);
    }

    @Override
    public void editExchange(ExchangeEntity exchangeEntity) throws SQLException {
        hibernateTemplate.update(exchangeEntity);
    }

    @Override
    public ExchangeEntity getExchangeById(int id) throws SQLException {
        return hibernateTemplate.get(ExchangeEntity.class,id);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        Query query = sessionFactory.openSession()
                .createQuery("from exchange ac where ac.id = :id").setParameter("id", id);
        System.out.println(query.list().size());
        return query.list().size()>0?true:false;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) throws SQLException {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public List<ExchangeEntity> getAllExchange() {
        Session session = sessionFactory.getCurrentSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(ExchangeEntity.class);
        Root<ExchangeEntity> root = criteriaQuery.from(ExchangeEntity.class);
        criteriaQuery.select(root);
        TypedQuery<ExchangeEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<ExchangeEntity> list = typedQuery.getResultList();
        return list;
    }
}
