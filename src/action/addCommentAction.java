package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.IBookArticleDaoImpl;
import entity.ArticlecontentEntity;
import entity.BookarticleEntity;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import service.IArticleContentService;
import service.IBookArticleService;
import service.IBookArticleServiceImpl;
import tool.SuperTool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class addCommentAction extends ActionSupport {
    private String bookName;
    private String title;
    private String bookImgSrc;
    private String content;
    private HttpServletRequest request;
    @Autowired
    private IArticleContentService articleContentService;
    @Autowired
    private IBookArticleServiceImpl bookArticleService;
    public String execute() throws SQLException {
        String username="";
        String src="";
        boolean isLogin = false;
        request = ServletActionContext.getRequest();
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("USERNAME")) {
                username = cookie.getValue();
                isLogin = true;
            }
            if (cookie.getName().equals("SRC")) {
                src = cookie.getValue();
                isLogin = true;
            }
        }
        if(!isLogin){
            return "error";
        }
        ArticlecontentEntity articlecontentEntity = new ArticlecontentEntity();
        articlecontentEntity.setContent(content);
        articleContentService.addArticleContent(articlecontentEntity);
        BookarticleEntity bookarticleEntity = new BookarticleEntity();
        bookarticleEntity.setAuthorpic(src);
        bookarticleEntity.setBookname(bookName);
        bookarticleEntity.setSrc(bookImgSrc);
        bookarticleEntity.setIntroduction(SuperTool.getRawString(content).substring(0,50));
        bookarticleEntity.setTime(SuperTool.getTime());
        bookarticleEntity.setTitle(title);
        bookarticleEntity.setUsername(username);
        bookArticleService.addBookArticle(bookarticleEntity);
        return SUCCESS;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookImgSrc() {
        return bookImgSrc;
    }

    public void setBookImgSrc(String bookImgSrc) {
        this.bookImgSrc = bookImgSrc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public IArticleContentService getArticleContentService() {
        return articleContentService;
    }

    public void setArticleContentService(IArticleContentService articleContentService) {
        this.articleContentService = articleContentService;
    }

    public IBookArticleServiceImpl getBookArticleService() {
        return bookArticleService;
    }

    public void setBookArticleService(IBookArticleServiceImpl bookArticleService) {
        this.bookArticleService = bookArticleService;
    }
}
