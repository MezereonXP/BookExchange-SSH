package dao;

import entity.ArticlecontentEntity;
import entity.ArticlecontentEntity;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

/**
 * Created by Mezereon on 2017/10/8.
 */
public interface IArticleContentDao {
    public void saveArticleContent(ArticlecontentEntity articlecontentEntity) throws SQLException;

    public void delArticleContent(ArticlecontentEntity articlecontentEntity) throws SQLException;

    public void editArticleContent(ArticlecontentEntity articlecontentEntity) throws SQLException;

    public ArticlecontentEntity getArticleById(int id) throws SQLException;

    public boolean isExists(int id) throws SQLException;

    public void setSessionFactory(SessionFactory sessionFactory)throws SQLException;
}
