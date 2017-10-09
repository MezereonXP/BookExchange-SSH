package dao;

import entity.ArticlecommentEntity;
import entity.BeuserEntity;
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
public class IArticleCommentDaoImpl implements IArticleCommenntDao{

    @Autowired
    private SessionFactory sessionFactory;

    private HibernateTemplate hibernateTemplate;

    @Override
    public void saveArticleComment(ArticlecommentEntity articleCommentEntity) throws SQLException {
        hibernateTemplate.save(articleCommentEntity);
    }

    @Override
    public void delArticleComment(ArticlecommentEntity articleCommentEntity) throws SQLException {
        hibernateTemplate.delete(articleCommentEntity);
    }

    @Override
    public void editArticleComment(ArticlecommentEntity articleCommentEntity) throws SQLException {
        hibernateTemplate.update(articleCommentEntity);
    }

    @Override
    public ArticlecommentEntity getArticleCommentById(int id) throws SQLException {
        return hibernateTemplate.get(ArticlecommentEntity.class,id);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        Query query = sessionFactory.openSession()
                .createQuery("from ArticleComment ac where ac.id = :id").setParameter("id", id);
        System.out.println(query.list().size());
        return query.list().size()>0?true:false;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) throws SQLException {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public List<ArticlecommentEntity> getAllArticleComment() {
        Session session = sessionFactory.getCurrentSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(ArticlecommentEntity.class);
        Root<ArticlecommentEntity> root = criteriaQuery.from(ArticlecommentEntity.class);
        criteriaQuery.select(root);
        TypedQuery<ArticlecommentEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<ArticlecommentEntity> list = typedQuery.getResultList();
        return list;
    }
}
