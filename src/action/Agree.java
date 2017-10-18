package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ExchangeEntity;
import entity.UserbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IExchangeServiceImpl;
import service.IUserBookServiceImpl;

/**
 * Created by Mezereon on 2017/10/18.
 */
public class Agree extends ActionSupport{
    @Autowired
    private IExchangeServiceImpl exchangeService;

    @Autowired
    private IUserBookServiceImpl userBookService;

    private int exchangeID;

    @Override
    public String execute() throws Exception {
        ExchangeEntity entity = exchangeService.getiExchangeDao().getExchangeById(exchangeID);
        entity.setStatus(1);
        exchangeService.updateExchange(entity);
        UserbookEntity book1= userBookService.getiUserbookDao().getUserbookById(Integer.parseInt(entity.getBookida()));
        UserbookEntity book2= userBookService.getiUserbookDao().getUserbookById(Integer.parseInt(entity.getBookidb()));
        book1.setState(1);
        book2.setState(1);
        userBookService.updateUserBook(book1);
        userBookService.updateUserBook(book2);
        for(ExchangeEntity exchangeEntity:exchangeService.getAllExchange()){
            if(exchangeEntity.getStatus()!=4){
                if(exchangeEntity.getBookida().equals(entity.getBookida())&&!(exchangeEntity.getBookidb().equals(entity.getBookidb()))){
                    exchangeEntity.setStatus(4);
                    exchangeService.updateExchange(exchangeEntity);
                }
                if(exchangeEntity.getBookida().equals(entity.getBookidb())&&!(exchangeEntity.getBookidb().equals(entity.getBookida()))){
                    exchangeEntity.setStatus(4);
                    exchangeService.updateExchange(exchangeEntity);
                }
                if(exchangeEntity.getBookidb().equals(entity.getBookida())&&!(exchangeEntity.getBookida().equals(entity.getBookidb()))){
                    exchangeEntity.setStatus(4);
                    exchangeService.updateExchange(exchangeEntity);
                }
                if(exchangeEntity.getBookidb().equals(entity.getBookidb())&&!(exchangeEntity.getBookida().equals(entity.getBookida()))){
                    exchangeEntity.setStatus(4);
                    exchangeService.updateExchange(exchangeEntity);
                }
            }
        }
        return SUCCESS;
    }

    public IExchangeServiceImpl getExchangeService() {
        return exchangeService;
    }

    public void setExchangeService(IExchangeServiceImpl exchangeService) {
        this.exchangeService = exchangeService;
    }

    public int getExchangeID() {
        return exchangeID;
    }

    public void setExchangeID(int exchangeID) {
        this.exchangeID = exchangeID;
    }

    public IUserBookServiceImpl getUserBookService() {
        return userBookService;
    }

    public void setUserBookService(IUserBookServiceImpl userBookService) {
        this.userBookService = userBookService;
    }
}
