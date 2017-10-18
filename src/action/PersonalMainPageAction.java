package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import entity.BeuserEntity;
import entity.BookarticleEntity;
import entity.ExchangeEntity;
import entity.UserbookEntity;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import service.IBookArticleServiceImpl;
import service.IExchangeServiceImpl;
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
    private List<ExchangeEntity> requestList;
    private List<ExchangeEntity> waitList;
    private List<ExchangeEntity> exchangingList;
    private List<ExchangeEntity> exchangedList;
    private BeuserEntity beuserEntity;

    @Autowired
    private IUserServiceImpl userService;
    @Autowired
    private IUserBookServiceImpl userBookService;
    @Autowired
    private IExchangeServiceImpl exchangeService;

    @Autowired
    private IBookArticleServiceImpl bookArticleService;

    public String execute() throws SQLException {
        boolean isLogin = false;
        request = ServletActionContext.getRequest();
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("USERNAME")) {
                username = cookie.getValue();
                isLogin = true;
                break;
            }
        }
        if (type == 1) {
            if (!isLogin) {
                return "error";
            }
            int count = 0;
            System.out.println(more);
            userbookEntityList = new ArrayList<UserbookEntity>();
            List<UserbookEntity> userbookEntityList2 = userBookService.getAllUserBook();
            for (UserbookEntity userbookEntity : userbookEntityList2) {
                if (userbookEntity.getUsername().equals(username)) {
                    userbookEntityList.add(userbookEntity);
                    count++;
                    System.out.println(count);
                    if (count == 6 && more == 0) {
                        System.out.println("hello");
                        break;
                    }
                }
            }
            bookarticleEntityList = bookArticleService.getAllBookArticleByName(username);
            beuserEntity = userService.getUserByName(username);
        } else if (type == 4) {
            showExchangeInfo();
        }
        return "success";
    }

    private void showExchangeInfo() throws SQLException {
        List<ExchangeEntity> list = exchangeService.getAllExchange();
        request = ServletActionContext.getRequest();
        requestList = new ArrayList<>();
        exchangingList = new ArrayList<>();
        exchangedList = new ArrayList<>();
        waitList = new ArrayList<>();
        for(ExchangeEntity entity:list){
            if(entity.getStatus()==0&&entity.getUsernameb().equals(username)){
                requestList.add(entity);
            }else if(entity.getStatus()==0&&entity.getUsernamea().equals(username)){
                waitList.add(entity);
            }else if(entity.getStatus()==1){
                exchangingList.add(entity);
            }else{
                exchangedList.add(entity);
            }
        }
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

    public IExchangeServiceImpl getExchangeService() {
        return exchangeService;
    }

    public void setExchangeService(IExchangeServiceImpl exchangeService) {
        this.exchangeService = exchangeService;
    }

    public List<ExchangeEntity> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<ExchangeEntity> requestList) {
        this.requestList = requestList;
    }

    public List<ExchangeEntity> getExchangingList() {
        return exchangingList;
    }

    public void setExchangingList(List<ExchangeEntity> exchangingList) {
        this.exchangingList = exchangingList;
    }

    public List<ExchangeEntity> getExchangedList() {
        return exchangedList;
    }

    public void setExchangedList(List<ExchangeEntity> exchangedList) {
        this.exchangedList = exchangedList;
    }

    public List<ExchangeEntity> getWaitList() {
        return waitList;
    }

    public void setWaitList(List<ExchangeEntity> waitList) {
        this.waitList = waitList;
    }
}
