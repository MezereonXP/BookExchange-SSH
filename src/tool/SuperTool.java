package tool;

import entity.BookarticleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

/**
 * Created by Mezereon on 2017/10/8.
 */
public class SuperTool {
    public List<Object> getAll(SessionFactory sessionFactory, Class tempClass){
        Session session = sessionFactory.getCurrentSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(tempClass);
        Root<Object> root = criteriaQuery.from(tempClass);
        criteriaQuery.select(root);
        TypedQuery<Object> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Object> list = typedQuery.getResultList();
        return list;
    }
}
