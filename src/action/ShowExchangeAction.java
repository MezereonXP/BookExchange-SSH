package action;

import com.opensymphony.xwork2.ActionSupport;
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

    @Override
    public String execute() throws Exception {
        userbookEntities = iUserBookService.getAllUserBook();
        userBooksWithUserpics = new ArrayList<UserBooksWithUserpic>();
        for(UserbookEntity entity:userbookEntities){
            UserBooksWithUserpic userBooksWithUserpic = new UserBooksWithUserpic();
            userBooksWithUserpic.setEntity(entity);
            userBooksWithUserpic.setUserSrc(iUserService.getUserPic(entity.getUsername()));
            userBooksWithUserpics.add(userBooksWithUserpic);
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

}
