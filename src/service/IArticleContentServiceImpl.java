package service;

import dao.IArticleCommentDaoImpl;
import dao.IArticleContentDao;
import dao.IArticleContentDaoImpl;
import entity.ArticlecommentEntity;
import entity.ArticlecontentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/8.
 */

@Service
public class IArticleContentServiceImpl implements IArticleContentService{

    @Autowired
    private IArticleContentDaoImpl iArticleContentDao;

    @Override
    public List<ArticlecontentEntity> getAllArticleComment() throws SQLException {
        return iArticleContentDao.getAllArticleContent();
    }

    @Override
    public void addArticleContent(ArticlecontentEntity articlecontentEntity) throws SQLException {
        iArticleContentDao.saveArticleContent(articlecontentEntity);
    }

    @Override
    public void updateArticleContent(ArticlecontentEntity articlecontentEntity) throws SQLException {
        iArticleContentDao.editArticleContent(articlecontentEntity);
    }

    @Override
    public void delArticleContent(ArticlecontentEntity articlecontentEntity) throws SQLException {
        iArticleContentDao.delArticleContent(articlecontentEntity);
    }

    @Override
    public boolean isExists(int id) throws SQLException {
        return iArticleContentDao.isExists(id);
    }

    public IArticleContentDaoImpl getiArticleContentDao() {
        return iArticleContentDao;
    }

    public void setiArticleContentDao(IArticleContentDaoImpl iArticleContentDao) {
        this.iArticleContentDao = iArticleContentDao;
    }
}
