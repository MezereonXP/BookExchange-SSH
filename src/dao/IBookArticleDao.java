package dao;

import entity.BeuserEntity;
import entity.BookarticleEntity;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

/**
 * Created by Mezereon on 2017/10/8.
 */
public interface IBookArticleDao {
    public void saveArticle(BookarticleEntity bookarticleEntity) throws SQLException;

    public void delArticle(BookarticleEntity bookarticleEntity) throws SQLException;

    public void editArticle(BookarticleEntity bookarticleEntity) throws SQLException;

    public BookarticleEntity getArticleById(int id) throws SQLException;

    public boolean isExists(int id) throws SQLException;

    public void setSessionFactory(SessionFactory sessionFactory)throws SQLException;
}
