package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.BeuserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IUserServiceImpl;

public class RegisterCheckedAction extends ActionSupport {
    private String username;
    private String password;
    private String email;
    private String sex;
    private String phone;
    private String exist;
    @Autowired
    private IUserServiceImpl userService;
    public String execute() throws Exception {
        if(getUserService().isExists(username)){
            exist = "true";
            return "error";
        }else {
            exist = "false";
            String sign = "这个人很懒，没留下任何东西";
            BeuserEntity entity = new BeuserEntity();
            entity.setUsername(username);
            entity.setEmail(email);
            entity.setPassword(password);
            entity.setPhone(phone);
            entity.setSex(sex);
            entity.setSignatrue(sign);
            entity.setSrc("http://mezereon.gotoip2.com/simple.jpg");
            getUserService().addUser(entity);
            return "success";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getExist() {
        return exist;
    }

    public void setExist(String exist) {
        this.exist = exist;
    }

    public IUserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(IUserServiceImpl userService) {
        this.userService = userService;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
