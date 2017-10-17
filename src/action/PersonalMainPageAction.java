package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.UserbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IUserBookServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonalMainPageAction extends ActionSupport {
    private String username;
    private int type;
    private int more;
    private List<UserbookEntity> userbookEntityList;
    @Autowired
    private IUserBookServiceImpl userBookService;
    public String execute() throws SQLException {
        if(type==1){
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
}
