package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import service.IUserServiceImpl;

import javax.servlet.Servlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoginCheckAction extends ActionSupport implements ServletRequestAware,
        ServletResponseAware {
    private String username;
    private String password;
    private String state;
    private HttpServletResponse response;
    private HttpServletRequest request;
    @Autowired
    private IUserServiceImpl userService;


    @Override
    public String execute() throws Exception {
        state="success";
        request = ServletActionContext.getRequest();
        response = ServletActionContext.getResponse();
        boolean right = getUserService().login(username,password);
        if(right){
              Cookie cookie = new Cookie("USERNAME",username);
              cookie.setMaxAge(60 * 60 * 24 );
              Cookie cookie2 = new Cookie("SRC",userService.getUserPic(username));
              cookie2.setMaxAge(60 * 60 * 24 );
              response.addCookie(cookie);
              response.addCookie(cookie2);
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

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }
}
