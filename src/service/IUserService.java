package service;
import entity.BeuserEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/7.
 */
@Service
public interface IUserService {
    public List<BeuserEntity> getAllUser()throws SQLException;
    public void addUser(BeuserEntity beuserEntity) throws SQLException;
    public void updateUser(BeuserEntity beuserEntity)throws SQLException;
    public void delUser(BeuserEntity beuserEntity)throws SQLException;
    public boolean isExists(String username)throws SQLException;
}
