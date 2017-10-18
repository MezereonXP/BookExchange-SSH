package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterRemoverInterceptor;
import entity.ExchangeEntity;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import service.IExchangeService;
import service.IExchangeServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mezereon on 2017/10/18.
 */
public class UploadNumAction extends ActionSupport{

    @Autowired
    private IExchangeServiceImpl exchangeService;

    private HttpServletRequest request;

    private int exchangeID;
    private String number;
    private String username;

    @Override
    public String execute() throws Exception {
        ExchangeEntity exchangeEntity = exchangeService.getiExchangeDao().getExchangeById(exchangeID);
        request = ServletActionContext.getRequest();
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("USERNAME")) {
                username = cookie.getValue();
                break;
            }
        }
        if(exchangeEntity.getUsernamea().equals(username)){
            exchangeEntity.setNumberb(number);
        }else{
            exchangeEntity.setNumbera(number);
        }
        exchangeService.updateExchange(exchangeEntity);

        return SUCCESS;
    }

    public int getExchangeID() {
        return exchangeID;
    }

    public void setExchangeID(int exchangeID) {
        this.exchangeID = exchangeID;
    }

    public IExchangeServiceImpl getExchangeService() {
        return exchangeService;
    }

    public void setExchangeService(IExchangeServiceImpl exchangeService) {
        this.exchangeService = exchangeService;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
