package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ForumEntity;
import entity.ForumcommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IForumCommentService;
import service.IForumCommentServiceImpl;
import service.IForumServiceImpl;
import service.IUserServiceImpl;
import tool.SuperTool;

import java.util.List;

/**
 * Created by Mezereon on 2017/10/17.
 */
public class SendForumCommentAction extends ActionSupport {
    @Autowired
    private IUserServiceImpl userService;

    @Autowired
    private IForumCommentServiceImpl forumCommentService;

    @Autowired
    private IForumServiceImpl forumService;

    private int forumID;
    private String comment;
    private String username;
    private ForumEntity forumEntity;
    private List<ForumcommentEntity> forumcommentEntities;

    @Override
    public String execute() throws Exception {
        ForumcommentEntity forumcommentEntity = new ForumcommentEntity();
        forumcommentEntity.setSrc(userService.getUserPic(username));
        forumcommentEntity.setArticleid(forumID);
        forumcommentEntity.setComment(comment);
        forumcommentEntity.setTime(SuperTool.getTime());
        forumcommentEntity.setUsername(username);
        forumCommentService.addForumComment(forumcommentEntity);
        for(ForumEntity fe:forumService.getAllForum()){
            if(fe.getId()==forumID){
                forumEntity = fe;
                break;
            }
        }
        forumcommentEntities = forumCommentService.getAllForumCommentById(forumID);
        return SUCCESS;
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

    public int getForumID() {
        return forumID;
    }

    public void setForumID(int forumID) {
        this.forumID = forumID;
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

    public ForumEntity getForumEntity() {
        return forumEntity;
    }

    public void setForumEntity(ForumEntity forumEntity) {
        this.forumEntity = forumEntity;
    }

    public List<ForumcommentEntity> getForumcommentEntities() {
        return forumcommentEntities;
    }

    public void setForumcommentEntities(List<ForumcommentEntity> forumcommentEntities) {
        this.forumcommentEntities = forumcommentEntities;
    }
}
