package service;

import dao.IForumDaoImpl;
import entity.ForumEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/9.
 */
@Service
public class IForumServiceImpl implements IForumService {

    @Autowired
    private IForumDaoImpl iForumDao;

    public List<ForumEntity> searchForumByTitle(String t){
        return iForumDao.searchForumByTitle(t);
    }

    public List<ForumEntity> getAllForumByName(String name){
        List<ForumEntity> forumEntities = new ArrayList<>();
        for(ForumEntity forumEntity:iForumDao.getAllForum()){
            if(forumEntity.getUsername().equals(name)){
                forumEntities.add(forumEntity);
            }
        }
        return forumEntities;
    }

    @Override
    public List<ForumEntity> getAllForum() throws SQLException {
        return iForumDao.getAllForum();
    }

    @Override
    public void addForum(ForumEntity forumEntity) throws SQLException {
        iForumDao.saveForum(forumEntity);
    }

    @Override
    public void updateForum(ForumEntity forumEntity) throws SQLException {
        iForumDao.editForum(forumEntity);
    }

    @Override
    public void delForum(ForumEntity forumEntity) throws SQLException {
        iForumDao.delForum(forumEntity);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        return iForumDao.isExists(id);
    }

    public IForumDaoImpl getiForumDao() {
        return iForumDao;
    }

    public void setiForumDao(IForumDaoImpl iForumDao) {
        this.iForumDao = iForumDao;
    }
}
