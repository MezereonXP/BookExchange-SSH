package dao;

import entity.ForumviewEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.sql.SQLException;

/**
 * Created by Mezereon on 2017/10/17.
 */
public class IForumViewDaoImpl implements IForumViewDao {


    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public void saveForumView(ForumviewEntity forumviewEntity) throws SQLException {
        hibernateTemplate.save(forumviewEntity);
    }

    @Override
    public void delForumView(ForumviewEntity forumviewEntity) throws SQLException {
        hibernateTemplate.delete(forumviewEntity);
    }

    @Override
    public void editForumView(ForumviewEntity forumviewEntity) throws SQLException {
        hibernateTemplate.update(forumviewEntity);
    }

    @Override
    public ForumviewEntity getForumViewById(int id) throws SQLException {
        return hibernateTemplate.get(ForumviewEntity.class,id);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
                .createQuery("from forumview ac where ac.id = :id").setParameter("id", id);
        System.out.println(query.list().size());
        hibernateTemplate.getSessionFactory().getCurrentSession().clear();
        return query.list().size()>0?true:false;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) throws SQLException {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
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
