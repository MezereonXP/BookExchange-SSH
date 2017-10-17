package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.BeuserEntity;
import entity.UserbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IUserBookServiceImpl;
import service.IUserServiceImpl;

import java.util.List;

/**
 * Created by Mezereon on 2017/10/17.
 */
public class ShowBookAction extends ActionSupport{
    @Autowired
    private IUserBookServiceImpl userBookService;

    @Autowired
    private IUserServiceImpl userService;

    private int bookID;
    private String username;
    private UserbookEntity userbookEntity;
    private BeuserEntity beuserEntity;

    @Override
    public String execute() throws Exception {
        for(UserbookEntity ube: userBookService.getAllUserBook()){
            if(ube.getId()==bookID){
                userbookEntity = ube;
                break;
            }
        }
        beuserEntity = userService.getUserByName(userbookEntity.getSrc());
        return SUCCESS;
    }

    public IUserBookServiceImpl getUserBookService() {
        return userBookService;
    }

    public void setUserBookService(IUserBookServiceImpl userBookService) {
        this.userBookService = userBookService;
    }

    public IUserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(IUserServiceImpl userService) {
        this.userService = userService;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserbookEntity getUserbookEntity() {
        return userbookEntity;
    }

    public void setUserbookEntity(UserbookEntity userbookEntity) {
        this.userbookEntity = userbookEntity;
    }

    public BeuserEntity getBeuserEntity() {
        return beuserEntity;
    }

    public void setBeuserEntity(BeuserEntity beuserEntity) {
        this.beuserEntity = beuserEntity;
    }
}
