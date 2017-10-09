package service;

import entity.ArticlecontentEntity;
import entity.BookarticleEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/8.
 */
public interface IBookArticleService {
    public List<BookarticleEntity> getAllBookArticle()throws SQLException;
    public void addBookArticle(BookarticleEntity bookarticleEntity) throws SQLException;
    public void updateBookArticle(BookarticleEntity bookarticleEntity)throws SQLException;
    public void delBookArticle(BookarticleEntity bookarticleEntity)throws SQLException;
    public boolean isExists(int id)throws SQLException;
}
