package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ForumEntity;
import entity.Page;
import entity.UserBooksWithUserpic;
import entity.UserbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IForumService;
import service.IForumServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/17.
 */
public class ShowDiscussAction extends ActionSupport {

    @Autowired
    private IForumServiceImpl forumService;

    private List<ForumEntity> forumEntities;
    private List<Page> pageNum;

    private int page;

    @Override
    public String execute() throws Exception {
        forumEntities = forumService.getAllForum();
        List<ForumEntity> list = new ArrayList<>();
        List<ForumEntity> list2 = new ArrayList<>();
        int count = 1;
        if(!(page!= 1&&page!=1)){
            page = 1;
        }
        for(int i=forumEntities.size()-1;i>=0;i--){
            list.add(forumEntities.get(i));
        }
        for(ForumEntity entity:list){
            count++;
            if(count<=5*page&&count>5*(page-1)){
                list2.add(entity);
            }
        }
        pageNum = new ArrayList<Page>();
        for(int i=1;i<=(int) (list.size()/5.1+1);i++){
            Page page = new Page();
            page.setNum(i+"");
            pageNum.add(page);
        }
        forumEntities = list2;
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
}
