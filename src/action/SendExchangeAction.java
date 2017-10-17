package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ExchangeEntity;
import entity.UserbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.*;
import tool.SuperTool;

/**
 * Created by Mezereon on 2017/10/17.
 */
public class SendExchangeAction extends ActionSupport{

    @Autowired
    private IExchangeServiceImpl exchangeService;

    @Autowired
    private IUserBookServiceImpl userBookService;

    @Autowired
    private IUserServiceImpl userService;

    private String usernameForSelf;
    private String usernameForExchange;
    private int bookIDA,bookIDB;

    private UserbookEntity selfBook;
    private UserbookEntity herBook;

    @Override
    public String execute() throws Exception {
        ExchangeEntity exchangeEntity = new ExchangeEntity();
        exchangeEntity.setUsernamea(usernameForSelf);
        exchangeEntity.setUsernameb(usernameForExchange);
        exchangeEntity.setBookida(bookIDA+"");
        exchangeEntity.setBookidb(bookIDB+"");
        exchangeEntity.setBooknamea(userBookService.getiUserbookDao().getUserbookById(bookIDA).getBookname());
        exchangeEntity.setBooknameb(userBookService.getiUserbookDao().getUserbookById(bookIDB).getBookname());
        exchangeEntity.setDate(SuperTool.getTime());
        exchangeEntity.setBooksrca(userBookService.getiUserbookDao().getUserbookById(bookIDA).getSrc());
        exchangeEntity.setBooksrcb(userBookService.getiUserbookDao().getUserbookById(bookIDB).getSrc());
        exchangeEntity.setStatus(0);
        exchangeEntity.setNumbera("");
        exchangeEntity.setNumberb("");
        exchangeService.addExchange(exchangeEntity);
        return SUCCESS;
    }

    public IExchangeServiceImpl getExchangeService() {
        return exchangeService;
    }

    public void setExchangeService(IExchangeServiceImpl exchangeService) {
        this.exchangeService = exchangeService;
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

    public String getUsernameForSelf() {
        return usernameForSelf;
    }

    public void setUsernameForSelf(String usernameForSelf) {
        this.usernameForSelf = usernameForSelf;
    }

    public String getUsernameForExchange() {
        return usernameForExchange;
    }

    public void setUsernameForExchange(String usernameForExchange) {
        this.usernameForExchange = usernameForExchange;
    }

    public int getBookIDA() {
        return bookIDA;
    }

    public void setBookIDA(int bookIDA) {
        this.bookIDA = bookIDA;
    }

    public int getBookIDB() {
        return bookIDB;
    }

    public void setBookIDB(int bookIDB) {
        this.bookIDB = bookIDB;
    }

    public UserbookEntity getSelfBook() {
        return selfBook;
    }

    public void setSelfBook(UserbookEntity selfBook) {
        this.selfBook = selfBook;
    }

    public UserbookEntity getHerBook() {
        return herBook;
    }

    public void setHerBook(UserbookEntity herBook) {
        this.herBook = herBook;
    }
}
