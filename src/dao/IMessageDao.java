package dao;
import entity.MessageEntity;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
/**
 * Created by Administrator on 2017/10/8/008.
 */
public interface IMessageDao {
    public void saveMessage(MessageEntity messageEntity) throws SQLException;

    public void delMessage(MessageEntity messageEntity) throws SQLException;

    public void editMessage(MessageEntity messageEntity) throws SQLException;

    public MessageEntity getMessageById(int id) throws SQLException;

    public boolean isExists(int id) throws SQLException;

    public void setSessionFactory(SessionFactory sessionFactory)throws SQLException;
}
