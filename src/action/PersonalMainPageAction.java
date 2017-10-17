package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import entity.BeuserEntity;
import entity.BookarticleEntity;
import entity.UserbookEntity;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import service.IBookArticleServiceImpl;
import service.IUserBookServiceImpl;
import service.IUserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalMainPageAction extends ActionSupport {
    private String username;
    private int type;
    private int more;
    private HttpServletRequest request;
    private List<UserbookEntity> userbookEntityList;
    private List<BookarticleEntity> bookarticleEntityList;
    private BeuserEntity beuserEntity;
    @Autowired
    private IUserServiceImpl userService;
    @Autowired
    private IUserBookServiceImpl userBookService;

    @Autowired
    private IBookArticleServiceImpl bookArticleService;

    public String execute() throws SQLException {
        if(type==1){
            boolean isLogin = false;
            request =  ServletActionContext.getRequest();
            for(Cookie cookie:request.getCookies()){
                if(cookie.getName().equals("USERNAME")){
                    username = cookie.getValue();
                    isLogin = true;
                    break;
                }
            }
            if(!isLogin){
                return "error";
            }
            int count=0;
            System.out.println(more);
            userbookEntityList = new ArrayList<UserbookEntity>();
            List<UserbookEntity> userbookEntityList2 = userBookService.getAllUserBook();
            for(UserbookEntity userbookEntity:userbookEntityList2){
                if(userbookEntity.getUsername().equals(username)){
                    userbookEntityList.add(userbookEntity);
                    count++;
                    System.out.println(count);
                    if(count==6&&more==0){
                        System.out.println("hello");
                        break;
                    }
                }
            }
            bookarticleEntityList = bookArticleService.getAllBookArticleByName(username);
            beuserEntity = userService.getUserByName(username);
        }
        return "success";
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public IUserBookServiceImpl getUserBookService() {
        return userBookService;
    }

    public void setUserBookService(IUserBookServiceImpl userBookService) {
        this.userBookService = userBookService;
    }

    public List<UserbookEntity> getUserbookEntityList() {
        return userbookEntityList;
    }

    public void setUserbookEntityList(List<UserbookEntity> userbookEntityList) {
        this.userbookEntityList = userbookEntityList;
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

    public List<BookarticleEntity> getBookarticleEntityList() {
        return bookarticleEntityList;
    }

    public void setBookarticleEntityList(List<BookarticleEntity> bookarticleEntityList) {
        this.bookarticleEntityList = bookarticleEntityList;
    }

    public IBookArticleServiceImpl getBookArticleService() {
        return bookArticleService;
    }

    public void setBookArticleService(IBookArticleServiceImpl bookArticleService) {
        this.bookArticleService = bookArticleService;
    }

    public IUserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(IUserServiceImpl userService) {
        this.userService = userService;
    }

    public BeuserEntity getBeuserEntity() {
        return beuserEntity;
    }

    public void setBeuserEntity(BeuserEntity beuserEntity) {
        this.beuserEntity = beuserEntity;
    }
}
