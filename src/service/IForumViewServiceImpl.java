package service;

import dao.IForumViewDaoImpl;
import dao.IMessageDaoImpl;
import entity.ForumviewEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * Created by Mezereon on 2017/10/17.
 */
public class IForumViewServiceImpl implements IForumViewService {

    @Autowired
    private IForumViewDaoImpl iForumViewDao;
    @Override
    public ForumviewEntity getForumViewById(int id) throws SQLException {
        return iForumViewDao.getForumViewById(id);
    }

    @Override
    public void addForumView(ForumviewEntity forumviewEntity) throws SQLException {
        iForumViewDao.saveForumView(forumviewEntity);
    }

    @Override
    public void updateForumView(ForumviewEntity forumviewEntity) throws SQLException {
        iForumViewDao.editForumView(forumviewEntity);
    }

    @Override
    public void delForumView(ForumviewEntity forumviewEntity) throws SQLException {
        iForumViewDao.delForumView(forumviewEntity);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        return iForumViewDao.isExists(id);
    }

    public IForumViewDaoImpl getiForumViewDao() {
        return iForumViewDao;
    }

    public void setiForumViewDao(IForumViewDaoImpl iForumViewDao) {
        this.iForumViewDao = iForumViewDao;
    }
}
