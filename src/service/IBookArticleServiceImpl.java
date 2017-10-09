package service;

import dao.IBookArticleDaoImpl;
import entity.BookarticleEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/8.
 */
public class IBookArticleServiceImpl implements IBookArticleService {
    @Autowired
    private IBookArticleDaoImpl iBookArticleDao;

    @Override
    public List<BookarticleEntity> getAllBookArticle() throws SQLException {
        return iBookArticleDao.getAllBookArticle();
    }

    @Override
    public void addBookArticle(BookarticleEntity bookarticleEntity) throws SQLException {
        iBookArticleDao.saveArticle(bookarticleEntity);
    }

    @Override
    public void updateBookArticle(BookarticleEntity bookarticleEntity) throws SQLException {
        iBookArticleDao.editArticle(bookarticleEntity);
    }

    @Override
    public void delBookArticle(BookarticleEntity bookarticleEntity) throws SQLException {
        iBookArticleDao.delArticle(bookarticleEntity);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        return iBookArticleDao.isExists(id);
    }
}
