package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.BeuserEntity;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import service.IUserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class UpdateUserAction extends ActionSupport {
    private String phone;
    private String email;
    private String sign;
    private HttpServletRequest request;
    @Autowired
    private IUserServiceImpl userService;

    public String execute() throws SQLException {
        request =  ServletActionContext.getRequest();
        boolean isLogin = false;
        String username="";
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
        List<BeuserEntity> beuserEntityList = userService.getAllUser();
        for(BeuserEntity beuserEntity:beuserEntityList){
            if(beuserEntity.getUsername().equals(username)){
                beuserEntity.setSignatrue(sign);
                beuserEntity.setPhone(phone);
                beuserEntity.setEmail(email);
                userService.updateUser(beuserEntity);
            }
        }
        return "success";
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public IUserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(IUserServiceImpl userService) {
        this.userService = userService;
    }
}
