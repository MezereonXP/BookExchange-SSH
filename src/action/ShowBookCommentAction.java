package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.BookarticleEntity;
import entity.Page;
import entity.UserbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IBookArticleServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/15.
 */
public class ShowBookCommentAction extends ActionSupport {

    @Autowired
    private IBookArticleServiceImpl iBookArticleService;

    private List<BookarticleEntity> bookarticleEntities;
    private List<BookarticleEntity> bookarticleEntities2;

    private List<Page> pageNum;
    private int page;
    private int type;
    private String key;

    public String list() throws Exception {
        if(type==0){
            type = 1;
        }
        if(type==1){
            bookarticleEntities = iBookArticleService.getAllBookArticle();
        }else{
            System.out.println("Key: "+key);
            System.out.println("type: "+type);
            bookarticleEntities = doWithKey(iBookArticleService.getAllBookArticle());
        }



        bookarticleEntities2 = new ArrayList<BookarticleEntity>();
        List<BookarticleEntity>  bookarticleEntityList = new ArrayList<>();
        int count = 0;
        if(!(page!= 1&&page!=0)){
            page = 1;
        }
        for(int i=bookarticleEntities.size()-1;i>=0;i--){
            bookarticleEntityList.add(bookarticleEntities.get(i));
        }
        for(BookarticleEntity entity:bookarticleEntityList){
            count++;
            if(count<=5*page&&count>5*(page-1)){
                bookarticleEntities2.add(entity);
            }
        }
        pageNum = new ArrayList<Page>();
        for(int i=1;i<=(int) (bookarticleEntities.size()/5.1+1);i++){
            Page page = new Page();
            page.setNum(i+"");
            pageNum.add(page);
        }
        return SUCCESS;
    }

    public IBookArticleServiceImpl getiBookArticleService() {
        return iBookArticleService;
    }

    public void setiBookArticleService(IBookArticleServiceImpl iBookArticleService) {
        this.iBookArticleService = iBookArticleService;
    }

    public List<BookarticleEntity> getBookarticleEntities() {
        return bookarticleEntities;
    }

    public void setBookarticleEntities(List<BookarticleEntity> bookarticleEntities) {
        this.bookarticleEntities = bookarticleEntities;
    }
    private List<BookarticleEntity> doWithKey(List<BookarticleEntity> bookarticleEntities) {
        List<BookarticleEntity> list = new ArrayList<>();
        for(BookarticleEntity bae:bookarticleEntities){
            if((bae.getTitle().indexOf(getKey())!=-1)){
                list.add(bae);
            }
        }
        System.out.println("Tag: "+list.size());
        return list;
    }
    public List<BookarticleEntity> getBookarticleEntities2() {
        return bookarticleEntities2;
    }

    public void setBookarticleEntities2(List<BookarticleEntity> bookarticleEntities2) {
        this.bookarticleEntities2 = bookarticleEntities2;
    }

    public List<Page> getPageNum() {
        return pageNum;
    }

    public void setPageNum(List<Page> pageNum) {
        this.pageNum = pageNum;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
