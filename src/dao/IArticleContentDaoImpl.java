package dao;

import entity.ArticlecontentEntity;
import entity.ArticlecontentEntity;
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
 * Created by Mezereon on 2017/10/8.
 */
public class IArticleContentDaoImpl implements IArticleContentDao {


    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void saveArticleContent(ArticlecontentEntity articlecontentEntity) throws SQLException {
        hibernateTemplate.save(articlecontentEntity);
    }

    @Override
    public void delArticleContent(ArticlecontentEntity articlecontentEntity) throws SQLException {
        hibernateTemplate.delete(articlecontentEntity);
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
    }

    @Override
    public void editArticleContent(ArticlecontentEntity articlecontentEntity) throws SQLException {
        hibernateTemplate.update(articlecontentEntity);
    }

    @Override
    public ArticlecontentEntity getArticleById(int id) throws SQLException {
        return hibernateTemplate.get(ArticlecontentEntity.class,id);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
                .createQuery("from articlecontent ac where ac.id = :id").setParameter("id", id);
        System.out.println(query.list().size());
        return query.list().size()>0?true:false;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) throws SQLException {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public List<ArticlecontentEntity> getAllArticleContent() {
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(ArticlecontentEntity.class);
        Root<ArticlecontentEntity> root = criteriaQuery.from(ArticlecontentEntity.class);
        criteriaQuery.select(root);
        TypedQuery<ArticlecontentEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<ArticlecontentEntity> list = typedQuery.getResultList();
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
