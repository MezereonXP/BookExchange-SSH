package dao;

import entity.BeuserEntity;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

/**
 * Created by Mezereon on 2017/10/7.
 */
public interface IBeuserEntityDao {
    public void saveUser(BeuserEntity user) throws SQLException;

    public void delUser(BeuserEntity user) throws SQLException;

    public void editUser(BeuserEntity user) throws SQLException;

    public BeuserEntity getUserById(int id) throws SQLException;

    public boolean isExists(String username) throws SQLException;

    public void setSessionFactory(SessionFactory sessionFactory)throws SQLException;
}
