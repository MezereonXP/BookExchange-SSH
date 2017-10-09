package service;

/**
 * Created by Mezereon on 2017/10/7.
 */
import java.sql.SQLException;
import java.util.List;

import entity.BeuserEntity;
import dao.IBeuserEntityDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IBeuserEntityDaoImpl iBeuserEntityDaoImpl;

    @Override
    public List<BeuserEntity> getAllUser() {
        return iBeuserEntityDaoImpl.getAllUser();
    }

    @Override
    public void addUser(BeuserEntity beuserEntity) throws SQLException {
        iBeuserEntityDaoImpl.saveUser(beuserEntity);
    }

    @Override
    public void updateUser(BeuserEntity beuserEntity) throws SQLException {
        iBeuserEntityDaoImpl.editUser(beuserEntity);
    }

    @Override
    public void delUser(BeuserEntity beuserEntity) throws SQLException {
        iBeuserEntityDaoImpl.delUser(beuserEntity);
    }

    @Override
    @Cacheable(cacheNames="isExists", key="#username")
    public boolean isExists(String username) {
        return iBeuserEntityDaoImpl.isExists(username);
    }

    public void setiBeuserEntityDaoImpl(IBeuserEntityDaoImpl iBeuserEntityDaoImpl) {
        this.iBeuserEntityDaoImpl = iBeuserEntityDaoImpl;
    }

    public boolean login(String username, String password){
        BeuserEntity beuserEntity = iBeuserEntityDaoImpl.getUserByName(username);
        if(isExists(username)){
            return username.equals(beuserEntity.getUsername())
                    &&password.equals(beuserEntity.getPassword());
        }else{
            return false;
        }
    }

    public IBeuserEntityDaoImpl getiBeuserEntityDaoImpl() {
        return iBeuserEntityDaoImpl;
    }
}
