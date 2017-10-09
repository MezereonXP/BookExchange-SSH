package service;

import dao.IForumCommentDao;
import dao.IForumCommentDaoImpl;
import entity.ForumcommentEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/9.
 */
public class IForumCommentServiceImpl implements IForumCommentService{

    @Autowired
    private IForumCommentDaoImpl iForumCommentDaoImpl;

    @Override
    public List<ForumcommentEntity> getAllForumComment() throws SQLException {
        return iForumCommentDaoImpl.getAllForumComment();
    }

    @Override
    public void addForumComment(ForumcommentEntity forumcommentEntity) throws SQLException {
        iForumCommentDaoImpl.saveForumComment(forumcommentEntity);
    }

    @Override
    public void updateForumComment(ForumcommentEntity forumcommentEntity) throws SQLException {
        iForumCommentDaoImpl.editForumComment(forumcommentEntity);
    }

    @Override
    public void delForumComment(ForumcommentEntity forumcommentEntity) throws SQLException {
        iForumCommentDaoImpl.delForumComment(forumcommentEntity);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        return iForumCommentDaoImpl.isExists(id);
    }
}
