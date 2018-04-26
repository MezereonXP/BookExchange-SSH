package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ExchangeEntity;
import entity.UserbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IExchangeServiceImpl;
import service.IUserBookServiceImpl;

import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
public class AcceptBookAction extends ActionSupport{
    private int id;
    private int type;

    @Autowired
    private IExchangeServiceImpl exchangeService;

    @Autowired
    private IUserBookServiceImpl userBookService;

    @Override
    public String execute() throws Exception {
        List<ExchangeEntity> exchangeEntities = exchangeService.getAllExchange();
        for (ExchangeEntity e: exchangeEntities){
            if (e.getId() == id){
                if (type == 1){
                    e.setNumberb("-1");
                    UserbookEntity userbookEntity = userBookService.getiUserbookDao().getUserbookById(Integer.parseInt(e.getBookidb()));
                    userbookEntity.setState(2);
                    userBookService.updateUserBook(userbookEntity);
                }else {
                    e.setNumbera("-1");
                    UserbookEntity userbookEntity = userBookService.getiUserbookDao().getUserbookById(Integer.parseInt(e.getBookida()));
                    userbookEntity.setState(2);
                    userBookService.updateUserBook(userbookEntity);
                }
                if (e.getNumbera().equals("-1")&&e.getNumberb().equals("-1")){
                    e.setStatus(2);
                }
                exchangeService.updateExchange(e);
                break;
            }
        }
        return ActionSupport.SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
}
