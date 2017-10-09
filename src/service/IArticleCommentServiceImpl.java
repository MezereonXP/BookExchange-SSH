package service;

import dao.IArticleCommentDaoImpl;
import dao.IBeuserEntityDaoImpl;
import entity.ArticlecommentEntity;
import entity.BeuserEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/8.
 */

@Service
public class IArticleCommentServiceImpl implements IArticleCommentService {

    @Autowired
    private IArticleCommentDaoImpl iArticleCommentDao;

    @Override
    public List<ArticlecommentEntity> getAllArticleComment() throws SQLException {
        return iArticleCommentDao.getAllArticleComment();
    }

    @Override
    public void addArticleComment(ArticlecommentEntity articlecommentEntity) throws SQLException {
        iArticleCommentDao.saveArticleComment(articlecommentEntity);
    }

    @Override
    public void updateArticleComment(ArticlecommentEntity articlecommentEntity) throws SQLException {
        iArticleCommentDao.editArticleComment(articlecommentEntity);
    }

    @Override
    public void delArticleComment(ArticlecommentEntity articlecommentEntity) throws SQLException {
        iArticleCommentDao.delArticleComment(articlecommentEntity);
    }

    @Override
    @Cacheable(cacheNames="isExists", key="#id")
    public boolean isExists(int id) throws SQLException {
        return iArticleCommentDao.isExists(id);
    }

    public IArticleCommentDaoImpl getiArticleCommentDao() {
        return iArticleCommentDao;
    }

    public void setiArticleCommentDao(IArticleCommentDaoImpl iArticleCommentDao) {
        this.iArticleCommentDao = iArticleCommentDao;
    }
}
