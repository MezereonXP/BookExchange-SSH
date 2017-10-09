package dao;
import entity.ExchangeEntity;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
/**
 * Created by Administrator on 2017/10/8/008.
 */
public interface IExchangeDao {
    public void saveExchange(ExchangeEntity exchangeEntity) throws SQLException;

    public void delExchange(ExchangeEntity exchangeEntity) throws SQLException;

    public void editExchange(ExchangeEntity exchangeEntity) throws SQLException;

    public ExchangeEntity getExchangeById(int id) throws SQLException;

    public boolean isExists(int id) throws SQLException;

    public void setSessionFactory(SessionFactory sessionFactory)throws SQLException;
}
