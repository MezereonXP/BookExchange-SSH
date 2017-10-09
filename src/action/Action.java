package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import entity.BeuserEntity;
import service.IUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Mezereon on 2017/8/31.
 */
public class Action extends ActionSupport {

    private List<BeuserEntity> users;
    private String username;
    private String password;

    @Autowired
    private IUserServiceImpl userService;

    public String list(){
        try{
            //得到user表中的所有记录
            users = userService.getAllUser();
            return SUCCESS;
        }catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
            return ERROR;
        }
    }
    public List<BeuserEntity> getUsers(){
        return users;
    }
    public void setUsers(List<BeuserEntity> users){
        this.users = users;
    }

    @Override
    public String execute() throws Exception {
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        System.out.println(valueStack.findString("username"));
        return "success";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IUserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(IUserServiceImpl userService) {
        this.userService = userService;
    }

}
