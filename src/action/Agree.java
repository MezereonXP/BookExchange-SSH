package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ExchangeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IExchangeServiceImpl;

/**
 * Created by Mezereon on 2017/10/18.
 */
public class Agree extends ActionSupport{
    @Autowired
    private IExchangeServiceImpl exchangeService;

    private int exchangeID;

    @Override
    public String execute() throws Exception {
        ExchangeEntity entity = exchangeService.getiExchangeDao().getExchangeById(exchangeID);
        entity.setStatus(1);
        exchangeService.updateExchange(entity);
        for(ExchangeEntity exchangeEntity:exchangeService.getAllExchange()){
            if(exchangeEntity.getStatus()!=4){
                if(exchangeEntity.getBookida()==entity.getBookida()&&exchangeEntity.getBookidb()!=entity.getBookidb()){
                    exchangeEntity.setStatus(4);
                    exchangeService.updateExchange(exchangeEntity);
                }
                if(exchangeEntity.getBookida()==entity.getBookidb()&&exchangeEntity.getBookidb()!=entity.getBookida()){
                    exchangeEntity.setStatus(4);
                    exchangeService.updateExchange(exchangeEntity);
                }
                if(exchangeEntity.getBookidb()==entity.getBookida()&&exchangeEntity.getBookida()!=entity.getBookidb()){
                    exchangeEntity.setStatus(4);
                    exchangeService.updateExchange(exchangeEntity);
                }
                if(exchangeEntity.getBookidb()==entity.getBookidb()&&exchangeEntity.getBookida()!=entity.getBookida()){
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
}
