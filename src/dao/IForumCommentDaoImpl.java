package dao;
import entity.ExchangeEntity;
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
public class IForumCommentDaoImpl implements IForumCommentDao{
    @Autowired
    private SessionFactory sessionFactory;

    private HibernateTemplate hibernateTemplate;

    @Override
    public void saveForumComment(ForumcommentEntity forumcommentEntity) throws SQLException {
        hibernateTemplate.save(forumcommentEntity);
    }

    @Override
    public void delForumComment(ForumcommentEntity forumcommentEntity) throws SQLException {
        hibernateTemplate.delete(forumcommentEntity);
    }

    @Override
    public void editForumComment(ForumcommentEntity forumcommentEntity) throws SQLException {
        hibernateTemplate.update(forumcommentEntity);
    }

    @Override
    public ForumcommentEntity getForumCommentById(int id) throws SQLException {
        return hibernateTemplate.get(ForumcommentEntity.class,id);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        Query query = sessionFactory.openSession()
                .createQuery("from forumcomment ac where ac.id = :id").setParameter("id", id);
        System.out.println(query.list().size());
        return query.list().size()>0?true:false;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) throws SQLException {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public List<ForumcommentEntity> getAllForumComment() {
        Session session = sessionFactory.getCurrentSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(ForumcommentEntity.class);
        Root<ForumcommentEntity> root = criteriaQuery.from(ForumcommentEntity.class);
        criteriaQuery.select(root);
        TypedQuery<ForumcommentEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<ForumcommentEntity> list = typedQuery.getResultList();
        return list;
    }
}
