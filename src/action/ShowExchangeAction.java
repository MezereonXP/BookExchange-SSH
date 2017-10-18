package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Page;
import entity.UserBooksWithUserpic;
import entity.UserbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import service.IUserBookServiceImpl;
import service.IUserServiceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/11.
 */
public class ShowExchangeAction extends ActionSupport {

    @Autowired
    private IUserBookServiceImpl iUserBookService;

    @Autowired
    private IUserServiceImpl iUserService;

    private List<UserbookEntity> userbookEntities;

    private List<UserBooksWithUserpic> userBooksWithUserpics;

    private List<Page> pageNum;

    private int page;
    private int type;
    private String tag;
    private String key;

    @Override
    public String execute() throws Exception {
        if(type==0){
            type = 1;
        }
        if(type==1){
            userbookEntities = iUserBookService.getAllUserBook();
        }else{
            System.out.println("Tag: "+tag);
            System.out.println("Key: "+key);
            System.out.println("type: "+type);
            userbookEntities = doWithTag(iUserBookService.getAllUserBook(),tag);
        }

        userBooksWithUserpics = new ArrayList<UserBooksWithUserpic>();
        List<UserbookEntity> list = new ArrayList<>();
        int count = 0;
        if(!(page!= 1&&page!=1)){
           page = 1;
        }
        for(int i=userbookEntities.size()-1;i>=0;i--){
            list.add(userbookEntities.get(i));
        }
        for(UserbookEntity entity:list){
            count++;
            if(count<=5*page&&count>5*(page-1)){
                UserBooksWithUserpic userBooksWithUserpic = new UserBooksWithUserpic();
                userBooksWithUserpic.setEntity(entity);
                userBooksWithUserpic.setUserSrc(iUserService.getUserPic(entity.getUsername()));
                userBooksWithUserpics.add(userBooksWithUserpic);
            }
        }
        pageNum = new ArrayList<Page>();
        for(int i=1;i<=(int) (userbookEntities.size()/5.1+1);i++){
            Page page = new Page();
            page.setNum(i+"");
            pageNum.add(page);
        }
        return SUCCESS;
    }

    private List<UserbookEntity> doWithTag(List<UserbookEntity> userbookEntities, String tag) {
        List<UserbookEntity> list = new ArrayList<>();
        for(UserbookEntity ube:userbookEntities){
            if((ube.getBookname().indexOf(key)!=-1)&&check(ube.getKind(),tag)){
                list.add(ube);
            }
        }
        System.out.println("Tag: "+list.size());
        return list;
    }

    private boolean check(String kind, String tag) {
        String[] tags = tag.split(";");
        for(String t:tags){
            if(kind.indexOf(t)==-1){
                System.out.println("Tag: "+t);
                return false;
            }
        }
        return true;
    }

    public IUserBookServiceImpl getiUserBookService() {
        return iUserBookService;
    }

    public void setiUserBookService(IUserBookServiceImpl iUserBookService) {
        this.iUserBookService = iUserBookService;
    }

    public List<UserbookEntity> getUserbookEntities() {
        return userbookEntities;
    }

    public void setUserbookEntities(List<UserbookEntity> userbookEntities) {
        this.userbookEntities = userbookEntities;
    }

    public void setUserBooksWithUserpics(List<UserBooksWithUserpic> userBooksWithUserpics) {
        this.userBooksWithUserpics = userBooksWithUserpics;
    }

    public IUserServiceImpl getiUserService() {
        return iUserService;
    }

    public void setiUserService(IUserServiceImpl iUserService) {
        this.iUserService = iUserService;
    }

    public List<UserBooksWithUserpic> getUserBooksWithUserpics() {
        return userBooksWithUserpics;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
