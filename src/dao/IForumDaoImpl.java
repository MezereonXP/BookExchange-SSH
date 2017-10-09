package dao;
import entity.ForumEntity;
import entity.ForumcommentEntity;
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
public class IForumDaoImpl implements IForumDao {
    @Autowired
    private SessionFactory sessionFactory;

    private HibernateTemplate hibernateTemplate;

    @Override
    public void saveForum(ForumEntity forumEntity) throws SQLException {
        hibernateTemplate.save(forumEntity);
    }

    @Override
    public void delForum(ForumEntity forumEntity) throws SQLException {
        hibernateTemplate.delete(forumEntity);
    }

    @Override
    public void editForum(ForumEntity forumEntity) throws SQLException {
        hibernateTemplate.update(forumEntity);
    }

    @Override
    public ForumEntity getForumById(int id) throws SQLException {
        return hibernateTemplate.get(ForumEntity.class,id);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        Query query = sessionFactory.openSession()
                .createQuery("from forum f where f.id = :id").setParameter("id", id);
        System.out.println(query.list().size());
        return query.list().size()>0?true:false;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) throws SQLException {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public List<ForumEntity> getAllForum() {
        Session session = sessionFactory.getCurrentSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(ForumEntity.class);
        Root<ForumEntity> root = criteriaQuery.from(ForumEntity.class);
        criteriaQuery.select(root);
        TypedQuery<ForumEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<ForumEntity> list = typedQuery.getResultList();
        return list;
    }
}
