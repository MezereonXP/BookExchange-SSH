package service;

import entity.BeuserEntity;
import entity.MessageEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/9.
 */
public interface IMessageService {
    public List<MessageEntity> getAllMessage()throws SQLException;
    public void addMessage(MessageEntity messageEntity) throws SQLException;
    public void updateMessage(MessageEntity messageEntity)throws SQLException;
    public void delMessage(MessageEntity messageEntity)throws SQLException;
    public boolean isExists(int id)throws SQLException;
}
