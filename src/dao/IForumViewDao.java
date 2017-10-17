package dao;

import entity.ForumviewEntity;
import entity.MessageEntity;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

/**
 * Created by Mezereon on 2017/10/17.
 */
public interface IForumViewDao {
    public void saveForumView(ForumviewEntity forumviewEntity) throws SQLException;

    public void delForumView(ForumviewEntity forumviewEntity) throws SQLException;

    public void editForumView(ForumviewEntity forumviewEntity) throws SQLException;

    public ForumviewEntity getForumViewById(int id) throws SQLException;

    public boolean isExists(int id) throws SQLException;

    public void setSessionFactory(SessionFactory sessionFactory)throws SQLException;
}
