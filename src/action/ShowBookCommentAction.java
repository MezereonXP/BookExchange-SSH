package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.BookarticleEntity;
import entity.Page;
import entity.UserBooksWithUserpic;
import entity.UserbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IBookArticleServiceImpl;
import service.IUserBookServiceImpl;
import service.IUserServiceImpl;

import java.awt.print.Book;
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

    public String list() throws Exception {
        bookarticleEntities = iBookArticleService.getAllBookArticle();

        bookarticleEntities2 = new ArrayList<BookarticleEntity>();
        List<BookarticleEntity>  bookarticleEntityList = new ArrayList<>();
        int count = 0;
        if(!(page!= 1&&page!=1)){
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
}
