package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ExchangeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IExchangeServiceImpl;

import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
public class AcceptBookAction extends ActionSupport{
    private int id;
    private int type;

    @Autowired
    private IExchangeServiceImpl exchangeService;

    @Override
    public String execute() throws Exception {
        List<ExchangeEntity> exchangeEntities = exchangeService.getAllExchange();
        for (ExchangeEntity e: exchangeEntities){
            if (e.getId() == id){
                if (type == 1){
                    e.setNumberb("-1");
                }else {
                    e.setNumbera("-1");
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
}
