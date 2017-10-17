package service;

import entity.ForumviewEntity;
import entity.MessageEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/17.
 */
public interface IForumViewService {
    public ForumviewEntity getForumViewById(int id)throws SQLException;
    public void addForumView(ForumviewEntity forumviewEntity) throws SQLException;
    public void updateForumView(ForumviewEntity forumviewEntity)throws SQLException;
    public void delForumView(ForumviewEntity forumviewEntity)throws SQLException;
    public boolean isExists(int id)throws SQLException;
}
