package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ArticlecommentEntity;
import entity.ArticlecontentEntity;
import entity.BookarticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IArticleCommentServiceImpl;
import service.IArticleContentServiceImpl;
import service.IBookArticleServiceImpl;
import service.IUserService;

import java.util.List;

/**
 * Created by Mezereon on 2017/10/16.
 */
public class ShowArticleAction extends ActionSupport {

    @Autowired
    private IArticleContentServiceImpl articleContentService;

    @Autowired
    private IBookArticleServiceImpl bookArticleService;

    @Autowired
    private IArticleCommentServiceImpl articleCommentService;

    private int articleID;
    private ArticlecontentEntity articlecontentEntity;
    private BookarticleEntity bookarticleEntity;
    private List<ArticlecommentEntity> articlecommentEntities;

    @Override
    public String execute() throws Exception {
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

    public IArticleContentServiceImpl getArticleContentService() {
        return articleContentService;
    }

    public void setArticleContentService(IArticleContentServiceImpl articleContentService) {
        this.articleContentService = articleContentService;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public IBookArticleServiceImpl getBookArticleService() {
        return bookArticleService;
    }

    public void setBookArticleService(IBookArticleServiceImpl bookArticleService) {
        this.bookArticleService = bookArticleService;
    }

    public ArticlecontentEntity getArticlecontentEntity() {
        return articlecontentEntity;
    }

    public void setArticlecontentEntity(ArticlecontentEntity articlecontentEntity) {
        this.articlecontentEntity = articlecontentEntity;
    }

    public BookarticleEntity getBookarticleEntity() {
        return bookarticleEntity;
    }

    public void setBookarticleEntity(BookarticleEntity bookarticleEntity) {
        this.bookarticleEntity = bookarticleEntity;
    }

    public IArticleCommentServiceImpl getArticleCommentService() {
        return articleCommentService;
    }

    public void setArticleCommentService(IArticleCommentServiceImpl articleCommentService) {
        this.articleCommentService = articleCommentService;
    }

    public List<ArticlecommentEntity> getArticlecommentEntities() {
        return articlecommentEntities;
    }

    public void setArticlecommentEntities(List<ArticlecommentEntity> articlecommentEntities) {
        this.articlecommentEntities = articlecommentEntities;
    }
}
