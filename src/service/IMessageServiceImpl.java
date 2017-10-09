package service;

import dao.IMessageDaoImpl;
import entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/9.
 */
@Service
public class IMessageServiceImpl implements IMessageService {

    @Autowired
    private IMessageDaoImpl iMessageDao;

    @Override
    public List<MessageEntity> getAllMessage() throws SQLException {
        return iMessageDao.getAllForum();
    }

    @Override
    public void addMessage(MessageEntity messageEntity) throws SQLException {
        iMessageDao.saveMessage(messageEntity);
    }

    @Override
    public void updateMessage(MessageEntity messageEntity) throws SQLException {
        iMessageDao.editMessage(messageEntity);
    }

    @Override
    public void delMessage(MessageEntity messageEntity) throws SQLException {
        iMessageDao.delMessage(messageEntity);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        return iMessageDao.isExists(id);
    }

    public IMessageDaoImpl getiMessageDao() {
        return iMessageDao;
    }

    public void setiMessageDao(IMessageDaoImpl iMessageDao) {
        this.iMessageDao = iMessageDao;
    }
}
