package dao;

import entity.ArticlecontentEntity;
import entity.BeuserEntity;
import entity.BookarticleEntity;
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
public class IBookArticleDaoImpl implements IBookArticleDao {

    @Autowired
    private SessionFactory sessionFactory;

    private HibernateTemplate hibernateTemplate;

    @Override
    public void saveArticle(BookarticleEntity bookarticleEntity) throws SQLException {
        hibernateTemplate.save(bookarticleEntity);
    }

    @Override
    public void delArticle(BookarticleEntity bookarticleEntity) throws SQLException {
        hibernateTemplate.delete(bookarticleEntity);
    }

    @Override
    public void editArticle(BookarticleEntity bookarticleEntity) throws SQLException {
        hibernateTemplate.update(bookarticleEntity);
    }

    @Override
    public BookarticleEntity getArticleById(int id) throws SQLException {
        return hibernateTemplate.get(BookarticleEntity.class, id);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        Query query = sessionFactory.openSession()
                .createQuery("from BookArticle ba where ba.id = :id").setParameter("id", id);
        System.out.println(query.list().size());
        return query.list().size()>0?true:false;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) throws SQLException {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public List<BookarticleEntity> getAllBookArticle() {
        Session session = sessionFactory.getCurrentSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(BookarticleEntity.class);
        Root<BookarticleEntity> root = criteriaQuery.from(BookarticleEntity.class);
        criteriaQuery.select(root);
        TypedQuery<BookarticleEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<BookarticleEntity> list = typedQuery.getResultList();
        return list;
    }
}
