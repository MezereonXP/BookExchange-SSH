package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.UserbookEntity;
import service.IUserBookServiceImpl;

import java.sql.SQLException;

public class addBookAction extends ActionSupport {
    private String username;
    private String bookSRC;
    private String kind;
    private String wantKind;
    private String introduction;
    private String buyDate;
    private String bookName;
    private String date;
    private IUserBookServiceImpl userBookService;
    public String execute(){
        UserbookEntity userbookEntity = new UserbookEntity();
        userbookEntity.setBookname(bookName);
        userbookEntity.setBuydate(buyDate);
        userbookEntity.setIntroduction(introduction);
        userbookEntity.setKind(kind);
        userbookEntity.setSrc(bookSRC);
        userbookEntity.setState(0);
        userbookEntity.setWantkind(wantKind);
        userbookEntity.setUsername(username);
        userbookEntity.setDate(date);
        try {
            userBookService.addUserBook(userbookEntity);
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookSRC() {
        return bookSRC;
    }

    public void setBookSRC(String bookSRC) {
        this.bookSRC = bookSRC;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getWantKind() {
        return wantKind;
    }

    public void setWantKind(String wantKind) {
        this.wantKind = wantKind;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public IUserBookServiceImpl getUserBookService() {
        return userBookService;
    }

    public void setUserBookService(IUserBookServiceImpl userBookService) {
        this.userBookService = userBookService;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
