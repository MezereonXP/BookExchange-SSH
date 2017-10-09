package service;

import entity.ArticlecommentEntity;
import entity.BeuserEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/8.
 */
public interface IArticleCommentService {
    public List<ArticlecommentEntity> getAllArticleComment()throws SQLException;
    public void addArticleComment(ArticlecommentEntity articlecommentEntity) throws SQLException;
    public void updateArticleComment(ArticlecommentEntity articlecommentEntity)throws SQLException;
    public void delArticleComment(ArticlecommentEntity articlecommentEntity)throws SQLException;
    public boolean isExists(int id)throws SQLException;
}
