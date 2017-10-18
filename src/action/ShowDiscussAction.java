package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import service.IForumCommentServiceImpl;
import service.IForumService;
import service.IForumServiceImpl;
import service.IForumViewServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/17.
 */
public class ShowDiscussAction extends ActionSupport {

    @Autowired
    private IForumServiceImpl forumService;

    @Autowired
    private IForumCommentServiceImpl forumCommentService;

    @Autowired
    private IForumViewServiceImpl forumViewService;

    private List<ForumEntity> forumEntities;
    private List<Page> pageNum;
    private List<SuperForum> forumList;

    private int type;
    private String tag;
    private String key;

    private int page;

    @Override
    public String execute() throws Exception {
        forumList = new ArrayList<>();
        if(type==0){
            type = 1;
        }
        if(type==2){
            forumEntities = forumService.searchForumByTitle(tag);
        }else{
            forumEntities = forumService.getAllForum();
        }
        List<ForumEntity> list = new ArrayList<>();
        List<ForumEntity> list2 = new ArrayList<>();
        int count = 0;
        if(!(page!= 1&&page!=1)){
            page = 1;
        }
        for(int i=forumEntities.size()-1;i>=0;i--){
            list.add(forumEntities.get(i));
        }
        for(ForumEntity entity:list){
            count++;
            if(count<=5*page&&count>5*(page-1)){
                SuperForum superForum = new SuperForum();
                superForum.setEntity(entity);
                superForum.setNumOfComments(forumCommentService.getAllForumCommentById(entity.getId()).size());
                superForum.setForumviewEntity(forumViewService.getForumViewById(entity.getId()));
                forumList.add(superForum);
            }
        }
        pageNum = new ArrayList<Page>();
        for(int i=1;i<=(int) (list.size()/5.1+1);i++){
            Page page = new Page();
            page.setNum(i+"");
            pageNum.add(page);
        }
        return SUCCESS;
    }

    public IForumServiceImpl getForumService() {
        return forumService;
    }

    public void setForumService(IForumServiceImpl forumService) {
        this.forumService = forumService;
    }

    public List<Page> getPageNum() {
        return pageNum;
    }

    public void setPageNum(List<Page> pageNum) {
        this.pageNum = pageNum;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<ForumEntity> getForumEntities() {
        return forumEntities;
    }

    public void setForumEntities(List<ForumEntity> forumEntities) {
        this.forumEntities = forumEntities;
    }

    public IForumCommentServiceImpl getForumCommentService() {
        return forumCommentService;
    }

    public void setForumCommentService(IForumCommentServiceImpl forumCommentService) {
        this.forumCommentService = forumCommentService;
    }

    public List<SuperForum> getForumList() {
        return forumList;
    }

    public void setForumList(List<SuperForum> forumList) {
        this.forumList = forumList;
    }

    public IForumViewServiceImpl getForumViewService() {
        return forumViewService;
    }

    public void setForumViewService(IForumViewServiceImpl forumViewService) {
        this.forumViewService = forumViewService;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
