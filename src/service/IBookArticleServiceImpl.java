package service;

import dao.IBookArticleDaoImpl;
import entity.BookarticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/8.
 */
@Service
public class IBookArticleServiceImpl implements IBookArticleService {
    @Autowired
    private IBookArticleDaoImpl iBookArticleDao;

    public List<BookarticleEntity> getAllBookArticleByName(String name){
        List<BookarticleEntity> bookarticleEntities = new ArrayList<>();
        for(BookarticleEntity bookarticleEntity:iBookArticleDao.getAllBookArticle()){
            if(bookarticleEntity.getUsername().equals(name)){
                bookarticleEntities.add(bookarticleEntity);
            }
        }
        return bookarticleEntities;
    }

    public List<BookarticleEntity> searchByTitle(String title){
        return iBookArticleDao.searchBookArticleEntity(title);
    }

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

    public IBookArticleDaoImpl getiBookArticleDao() {
        return iBookArticleDao;
    }

    public void setiBookArticleDao(IBookArticleDaoImpl iBookArticleDao) {
        this.iBookArticleDao = iBookArticleDao;
    }
}
