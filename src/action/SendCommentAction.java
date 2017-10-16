package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ArticlecommentEntity;
import entity.ArticlecontentEntity;
import entity.BookarticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.*;
import tool.SuperTool;

import javax.tools.Tool;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/17.
 */
public class SendCommentAction extends ActionSupport {

    @Autowired
    private IUserServiceImpl userService;

    @Autowired
    private IArticleCommentServiceImpl articleCommentService;

    @Autowired
    private IArticleContentServiceImpl articleContentService;

    @Autowired
    private IBookArticleServiceImpl bookArticleService;

    private int articleID;
    private String comment;
    private String username;
    private BookarticleEntity bookarticleEntity;
    private List<ArticlecommentEntity> articlecommentEntities;
    private ArticlecontentEntity articlecontentEntity;

    @Override
    public String execute() throws Exception {
        ArticlecommentEntity articlecommentEntity = new ArticlecommentEntity();
        articlecommentEntity.setSrc(userService.getUserPic(username));
        articlecommentEntity.setArticleid(articleID);
        articlecommentEntity.setComment(comment);
        articlecommentEntity.setTime(SuperTool.getTime());
        articlecommentEntity.setUsername(username);
        articleCommentService.addArticleComment(articlecommentEntity);
        for(ArticlecontentEntity ae:articleContentService.getAllArticleComment()){
            if(ae.getId()==articleID){
                articlecontentEntity = ae;
                break;
            }
        }
        for(BookarticleEntity be:bookArticleService.getAllBookArticle()){
            if(be.getId()==articleID){
                bookarticleEntity = be;
                break;
            }
        }
        articlecommentEntities = articleCommentService.getAllArticleCommentById(articleID);
        return SUCCESS;
    }

    public IArticleCommentServiceImpl getArticleCommentService() {
        return articleCommentService;
    }

    public void setArticleCommentService(IArticleCommentServiceImpl articleCommentService) {
        this.articleCommentService = articleCommentService;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserServiceImpl userService) {
        this.userService = userService;
    }

    public IArticleContentServiceImpl getArticleContentService() {
        return articleContentService;
    }

    public void setArticleContentService(IArticleContentServiceImpl articleContentService) {
        this.articleContentService = articleContentService;
    }

    public IBookArticleServiceImpl getBookArticleService() {
        return bookArticleService;
    }

    public void setBookArticleService(IBookArticleServiceImpl bookArticleService) {
        this.bookArticleService = bookArticleService;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BookarticleEntity getBookarticleEntity() {
        return bookarticleEntity;
    }

    public void setBookarticleEntity(BookarticleEntity bookarticleEntity) {
        this.bookarticleEntity = bookarticleEntity;
    }

    public List<ArticlecommentEntity> getArticlecommentEntities() {
        return articlecommentEntities;
    }

    public void setArticlecommentEntities(List<ArticlecommentEntity> articlecommentEntities) {
        this.articlecommentEntities = articlecommentEntities;
    }

    public ArticlecontentEntity getArticlecontentEntity() {
        return articlecontentEntity;
    }

    public void setArticlecontentEntity(ArticlecontentEntity articlecontentEntity) {
        this.articlecontentEntity = articlecontentEntity;
    }
}
