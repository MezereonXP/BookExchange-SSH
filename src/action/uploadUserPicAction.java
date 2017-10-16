package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import service.*;

import java.sql.SQLException;
import java.util.List;

public class uploadUserPicAction extends ActionSupport{
    private int type;
    private String src;
    private String username;
    @Autowired
    private IUserServiceImpl userService;
    @Autowired
    private IForumCommentServiceImpl forumCommentService;
    @Autowired
    private IForumServiceImpl forumService;
    @Autowired
    private IBookArticleServiceImpl bookArticleService;
    @Autowired
    private IArticleCommentServiceImpl articleCommentService;
    public String execute() throws SQLException {
        List<BookarticleEntity> bookarticleEntityList =  bookArticleService.getAllBookArticleByName(username);
        List<ArticlecommentEntity> articlecommentEntityList =  articleCommentService.getAllArticleCommentByName(username);
        List<ForumcommentEntity> forumcommentEntityList =forumCommentService.getAllForumCommentByName(username);
        List<ForumEntity> forumEntityList = forumService.getAllForumByName(username);
        List<BeuserEntity> beuserEntityList = userService.getAllUser();
        for(BookarticleEntity bookarticleEntity:bookarticleEntityList){
            bookarticleEntity.setAuthorpic(src);
            bookArticleService.updateBookArticle(bookarticleEntity);
        }
        for(ArticlecommentEntity articlecommentEntity:articlecommentEntityList){
            articlecommentEntity.setSrc(src);
            articleCommentService.updateArticleComment(articlecommentEntity);
        }
        for(ForumcommentEntity forumcommentEntity:forumcommentEntityList){
            forumcommentEntity.setSrc(src);
            forumCommentService.updateForumComment(forumcommentEntity);
        }
        for(ForumEntity forumEntity:forumEntityList){
            forumEntity.setSrc(src);
            forumService.updateForum(forumEntity);
        }
        for(BeuserEntity beuserEntity:beuserEntityList){
            if(beuserEntity.getUsername().equals(username)){
                beuserEntity.setSrc(src);
                userService.updateUser(beuserEntity);
            }
        }
        return "success";
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public IUserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(IUserServiceImpl userService) {
        this.userService = userService;
    }

    public IForumCommentServiceImpl getForumCommentService() {
        return forumCommentService;
    }

    public void setForumCommentService(IForumCommentServiceImpl forumCommentService) {
        this.forumCommentService = forumCommentService;
    }

    public IForumServiceImpl getForumService() {
        return forumService;
    }

    public void setForumService(IForumServiceImpl forumService) {
        this.forumService = forumService;
    }

    public IBookArticleServiceImpl getBookArticleService() {
        return bookArticleService;
    }

    public void setBookArticleService(IBookArticleServiceImpl bookArticleService) {
        this.bookArticleService = bookArticleService;
    }

    public IArticleCommentServiceImpl getArticleCommentService() {
        return articleCommentService;
    }

    public void setArticleCommentService(IArticleCommentServiceImpl articleCommentService) {
        this.articleCommentService = articleCommentService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
