package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ExchangeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IExchangeServiceImpl;

/**
 * Created by Mezereon on 2017/10/18.
 */
public class Refuse extends ActionSupport{

    @Autowired
    private IExchangeServiceImpl exchangeService;

    private int exchangeID;

    @Override
    public String execute() throws Exception {
        ExchangeEntity exchangeEntity = exchangeService.getiExchangeDao().getExchangeById(exchangeID);
        exchangeEntity.setStatus(4);
        exchangeService.updateExchange(exchangeEntity);
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
