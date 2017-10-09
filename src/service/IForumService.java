package service;

import entity.ForumEntity;
import entity.ForumcommentEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/9.
 */
public interface IForumService {
    List<ForumEntity> getAllForum()throws SQLException;
    void addForum(ForumEntity forumEntity) throws SQLException;
    void updateForum(ForumEntity forumEntity)throws SQLException;
    void delForum(ForumEntity forumEntity)throws SQLException;
    boolean isExists(int id)throws SQLException;
}
