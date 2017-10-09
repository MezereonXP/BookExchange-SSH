package service;

import dao.IExchangeDaoImpl;
import entity.ExchangeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/9.
 */
public class IExchangeServiceImpl implements IExchangeService {

    @Autowired
    private IExchangeDaoImpl iExchangeDao;

    @Override
    public List<ExchangeEntity> getAllExchange() throws SQLException {
        return iExchangeDao.getAllExchange();
    }

    @Override
    public void addExchange(ExchangeEntity exchangeEntity) throws SQLException {
        iExchangeDao.saveExchange(exchangeEntity);
    }

    @Override
    public void updateExchange(ExchangeEntity exchangeEntity) throws SQLException {
        iExchangeDao.editExchange(exchangeEntity);
    }

    @Override
    public void delExchange(ExchangeEntity exchangeEntity) throws SQLException {
        iExchangeDao.delExchange(exchangeEntity);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        return iExchangeDao.isExists(id);
    }
}
