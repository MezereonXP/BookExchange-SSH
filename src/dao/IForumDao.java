package dao;
import entity.ForumEntity;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
/**
 * Created by Administrator on 2017/10/8/008.
 */
public interface IForumDao {
    public void saveForum(ForumEntity forumEntity) throws SQLException;

    public void delForum(ForumEntity forumEntity) throws SQLException;

    public void editForum(ForumEntity forumEntity) throws SQLException;

    public ForumEntity getForumById(int id) throws SQLException;

    public boolean isExists(int id) throws SQLException;

    public void setSessionFactory(SessionFactory sessionFactory)throws SQLException;
}
