package dao;
import entity.UserbookEntity;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
/**
 * Created by Administrator on 2017/10/8/008.
 */
public interface IUserbookDao {
    public void saveUserbook(UserbookEntity userbookEntity) throws SQLException;

    public void delUserbook(UserbookEntity userbookEntity) throws SQLException;

    public void editUserbook(UserbookEntity userbookEntity) throws SQLException;

    public UserbookEntity getUserbookById(int id) throws SQLException;

    public boolean isExists(int id) throws SQLException;

    public void setSessionFactory(SessionFactory sessionFactory)throws SQLException;
}
