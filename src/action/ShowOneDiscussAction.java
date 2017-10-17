package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import service.*;

import java.util.List;

/**
 * Created by Mezereon on 2017/10/17.
 */
public class ShowOneDiscussAction extends ActionSupport {

    @Autowired
    private IForumServiceImpl forumService;

    @Autowired
    private IForumCommentServiceImpl forumCommentService;

    private int forumID;
    private ForumEntity forumEntity;
    private List<ForumcommentEntity> forumcommentEntities;

    @Override
    public String execute() throws Exception {
        for(ForumEntity entity:forumService.getAllForum()){
            if(entity.getId()==forumID){
                forumEntity = entity;
                break;
            }
        }
        forumcommentEntities = forumCommentService.getAllForumCommentById(forumID);
        return SUCCESS;
    }


    public List<ForumcommentEntity> getForumcommentEntities() {
        return forumcommentEntities;
    }

    public void setForumcommentEntities(List<ForumcommentEntity> forumcommentEntities) {
        this.forumcommentEntities = forumcommentEntities;
    }

    public ForumEntity getForumEntity() {
        return forumEntity;
    }

    public void setForumEntity(ForumEntity forumEntity) {
        this.forumEntity = forumEntity;
    }

    public void setForumID(int forumID) {
        this.forumID = forumID;
    }

    public IForumServiceImpl getForumService() {
        return forumService;
    }

    public void setForumService(IForumServiceImpl forumService) {
        this.forumService = forumService;
    }

    public IForumCommentServiceImpl getForumCommentService() {
        return forumCommentService;
    }

    public void setForumCommentService(IForumCommentServiceImpl forumCommentService) {
        this.forumCommentService = forumCommentService;
    }
}
