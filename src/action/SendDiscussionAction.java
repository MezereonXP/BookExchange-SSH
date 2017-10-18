package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ForumEntity;
import entity.ForumviewEntity;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import service.IForumServiceImpl;
import service.IForumViewServiceImpl;
import tool.SuperTool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class SendDiscussionAction extends ActionSupport {
    private String content;
    private String title;
    private HttpServletRequest request;
    @Autowired
    private IForumServiceImpl forumService;
    @Autowired
    private IForumViewServiceImpl forumViewService;
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
        ForumEntity forumEntity = new ForumEntity();
        forumEntity.setSrc(src);
        forumEntity.setIntroduction(content);
        forumEntity.setTime(SuperTool.getTime());
        forumEntity.setTitle(title);
        forumEntity.setUsername(username);
        forumService.addForum(forumEntity);
        ForumviewEntity forumviewEntity = new ForumviewEntity();
        forumviewEntity.setViewTiimes(0);
        forumviewEntity.setLikeId("");
        forumviewEntity.setLikeNum(0);
        forumViewService.addForumView(forumviewEntity);
        return "success";
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IForumServiceImpl getForumService() {
        return forumService;
    }

    public void setForumService(IForumServiceImpl forumService) {
        this.forumService = forumService;
    }

    public IForumViewServiceImpl getForumViewService() {
        return forumViewService;
    }

    public void setForumViewService(IForumViewServiceImpl forumViewService) {
        this.forumViewService = forumViewService;
    }
}
