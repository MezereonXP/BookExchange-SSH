package dao;

import entity.ArticlecommentEntity;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/10/8/008.
 */
public interface IArticleCommenntDao {
    public void saveArticleComment(ArticlecommentEntity articlecommentEntity) throws SQLException;

    public void delArticleComment(ArticlecommentEntity articlecommentEntity) throws SQLException;

    public void editArticleComment(ArticlecommentEntity articlecommentEntity) throws SQLException;

    public ArticlecommentEntity getArticleCommentById(int id) throws SQLException;

    public boolean isExists(int id) throws SQLException;

    public void setSessionFactory(SessionFactory sessionFactory)throws SQLException;
}
