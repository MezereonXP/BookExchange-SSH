package service;

import entity.BookarticleEntity;
import entity.ExchangeEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/8.
 */
public interface IExchangeService {
    public List<ExchangeEntity> getAllExchange()throws SQLException;
    public void addExchange(ExchangeEntity exchangeEntity) throws SQLException;
    public void updateExchange(ExchangeEntity exchangeEntity)throws SQLException;
    public void delExchange(ExchangeEntity exchangeEntity)throws SQLException;
    public boolean isExists(int id)throws SQLException;
}
