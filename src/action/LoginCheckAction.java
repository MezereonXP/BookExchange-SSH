package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.springframework.beans.factory.annotation.Autowired;
import service.IUserServiceImpl;

public class LoginCheckAction extends ActionSupport{
    private String username;
    private String password;
    private String state;

    @Autowired
    private IUserServiceImpl userService;


    @Override
    public String execute() throws Exception {
        System.out.println("submit");
        state="success";
      boolean right = getUserService().login(username,password);
      if(right){
          return "success";
      }else{
          state = "error";
          return  "error";
      }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
