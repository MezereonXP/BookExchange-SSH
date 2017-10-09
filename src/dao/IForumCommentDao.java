package dao;
import entity.ForumcommentEntity;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
/**
 * Created by Administrator on 2017/10/8/008.
 */
public interface IForumCommentDao {
    public void saveForumComment(ForumcommentEntity forumCommentEntity) throws SQLException;

    public void delForumComment(ForumcommentEntity forumCommentEntity) throws SQLException;

    public void editForumComment(ForumcommentEntity forumCommentEntity) throws SQLException;

    public ForumcommentEntity getForumCommentById(int id) throws SQLException;

    public boolean isExists(int id) throws SQLException;

    public void setSessionFactory(SessionFactory sessionFactory)throws SQLException;
}
