package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import entity.*;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import service.*;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.management.MemoryManagerMXBean;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class uploadUserPicAction extends ActionSupport{
    private int type,more;
    private String src;
    private String username;
    private HttpServletRequest request;
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
        boolean isLogin = false;
        String name="";
        request =  ServletActionContext.getRequest();
        for(Cookie cookie:request.getCookies()){
            if(cookie.getName().equals("USERNAME")){
                name = cookie.getValue();
                System.out.println("hello "+name);
                isLogin = true;
                type = 1;
                more = 0;
                break;
            }
        }
        if(!isLogin){
            return "error";
        }
        List<BookarticleEntity> bookarticleEntityList =  bookArticleService.getAllBookArticleByName(name);
        List<ArticlecommentEntity> articlecommentEntityList =  articleCommentService.getAllArticleCommentByName(name);
        List<ForumcommentEntity> forumcommentEntityList =forumCommentService.getAllForumCommentByName(name);
        List<ForumEntity> forumEntityList = forumService.getAllForumByName(name);
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
            if(beuserEntity.getUsername().equals(name)){
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

    public int getMore() {
        return more;
    }

    public void setMore(int more) {
        this.more = more;
    }
}
