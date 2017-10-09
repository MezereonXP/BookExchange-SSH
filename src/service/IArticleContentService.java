package service;

import entity.ArticlecommentEntity;
import entity.ArticlecontentEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/8.
 */
public interface IArticleContentService {
    public List<ArticlecontentEntity> getAllArticleComment()throws SQLException;
    public void addArticleContent(ArticlecontentEntity articlecontentEntity) throws SQLException;
    public void updateArticleContent(ArticlecontentEntity articlecontentEntity)throws SQLException;
    public void delArticleContent(ArticlecontentEntity articlecontentEntity)throws SQLException;
    public boolean isExists(int id)throws SQLException;
}
