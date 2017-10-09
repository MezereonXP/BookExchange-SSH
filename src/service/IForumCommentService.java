package service;
/**
 * Created by Mezereon on 2017/10/9.
 */
import entity.ExchangeEntity;
import entity.ForumcommentEntity;

import java.sql.SQLException;
import java.util.List;

public interface IForumCommentService {
    List<ForumcommentEntity> getAllForumComment()throws SQLException;
    void addForumComment(ForumcommentEntity forumcommentEntity) throws SQLException;
    void updateForumComment(ForumcommentEntity forumcommentEntity)throws SQLException;
    void delForumComment(ForumcommentEntity forumcommentEntity)throws SQLException;
    boolean isExists(int id)throws SQLException;
}
