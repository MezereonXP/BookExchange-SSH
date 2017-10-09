package service;

import dao.IUserbookDaoImpl;
import entity.UserbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/9.
 */
@Service
public class IUserBookServiceImpl implements IUserBookService {

    @Autowired
    private IUserbookDaoImpl iUserbookDao;

    @Override
    public List<UserbookEntity> getAllUserBook() throws SQLException {
        return iUserbookDao.getAllForum();
    }

    @Override
    public void addUserBook(UserbookEntity userbookEntity) throws SQLException {
        iUserbookDao.saveUserbook(userbookEntity);
    }

    @Override
    public void updateUserBook(UserbookEntity userbookEntity) throws SQLException {
        iUserbookDao.editUserbook(userbookEntity);
    }

    @Override
    public void delUserBook(UserbookEntity userbookEntity) throws SQLException {
        iUserbookDao.delUserbook(userbookEntity);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        return iUserbookDao.isExists(id);
    }

    public IUserbookDaoImpl getiUserbookDao() {
        return iUserbookDao;
    }

    public void setiUserbookDao(IUserbookDaoImpl iUserbookDao) {
        this.iUserbookDao = iUserbookDao;
    }
}
