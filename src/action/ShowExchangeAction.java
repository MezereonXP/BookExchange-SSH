package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Page;
import entity.UserBooksWithUserpic;
import entity.UserbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IUserBookServiceImpl;
import service.IUserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/11.
 */
public class ShowExchangeAction extends ActionSupport {

    @Autowired
    private IUserBookServiceImpl iUserBookService;

    @Autowired
    private IUserServiceImpl iUserService;

    private List<UserbookEntity> userbookEntities;

    private List<UserBooksWithUserpic> userBooksWithUserpics;

    private List<Page> pageNum;

    private int page;

    @Override
    public String execute() throws Exception {
        userbookEntities = iUserBookService.getAllUserBook();
        userBooksWithUserpics = new ArrayList<UserBooksWithUserpic>();
        int count = 1;
        if(!(page!= 1&&page!=1)){
           page = 1;
        }
        for(UserbookEntity entity:userbookEntities){
            count++;
            if(count<=5*page&&count>5*(page-1)){
                UserBooksWithUserpic userBooksWithUserpic = new UserBooksWithUserpic();
                userBooksWithUserpic.setEntity(entity);
                userBooksWithUserpic.setUserSrc(iUserService.getUserPic(entity.getUsername()));
                userBooksWithUserpics.add(userBooksWithUserpic);
            }
        }
        pageNum = new ArrayList<Page>();
        for(int i=2;i<(int) (userbookEntities.size()/5.1+1);i++){
            Page page = new Page();
            page.setNum(i+"");
            pageNum.add(page);
        }
        return SUCCESS;
    }

    public IUserBookServiceImpl getiUserBookService() {
        return iUserBookService;
    }

    public void setiUserBookService(IUserBookServiceImpl iUserBookService) {
        this.iUserBookService = iUserBookService;
    }

    public List<UserbookEntity> getUserbookEntities() {
        return userbookEntities;
    }

    public void setUserbookEntities(List<UserbookEntity> userbookEntities) {
        this.userbookEntities = userbookEntities;
    }

    public void setUserBooksWithUserpics(List<UserBooksWithUserpic> userBooksWithUserpics) {
        this.userBooksWithUserpics = userBooksWithUserpics;
    }

    public IUserServiceImpl getiUserService() {
        return iUserService;
    }

    public void setiUserService(IUserServiceImpl iUserService) {
        this.iUserService = iUserService;
    }

    public List<UserBooksWithUserpic> getUserBooksWithUserpics() {
        return userBooksWithUserpics;
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
}
