package service;

import dao.IForumCommentDao;
import dao.IForumCommentDaoImpl;
import entity.ForumcommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/9.
 */
@Service
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
    
    public IForumCommentDaoImpl getiForumCommentDaoImpl() {
        return iForumCommentDaoImpl;
    }

    public void setiForumCommentDaoImpl(IForumCommentDaoImpl iForumCommentDaoImpl) {
        this.iForumCommentDaoImpl = iForumCommentDaoImpl;
    }
}
