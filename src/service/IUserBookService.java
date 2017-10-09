package service;

import entity.ForumcommentEntity;
import entity.UserbookEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/9.
 */
public interface IUserBookService {
    List<UserbookEntity> getAllUserBook()throws SQLException;
    void addUserBook(UserbookEntity userbookEntity) throws SQLException;
    void updateUserBook(UserbookEntity userbookEntity)throws SQLException;
    void delUserBook(UserbookEntity userbookEntity)throws SQLException;
    boolean isExists(int id)throws SQLException;
}
