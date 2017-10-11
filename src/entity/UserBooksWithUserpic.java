package entity;

/**
 * Created by Mezereon on 2017/10/11.
 */
public class UserBooksWithUserpic {
    private int id;
    private String bookname;
    private String introduction;
    private String buydate;
    private String src;
    private int state;
    private String date;
    private String kind;
    private String wantkind;
    private String username;
    private String userSrc;

    public void setEntity(UserbookEntity userbookEntity){
        setBookname(userbookEntity.getBookname());
        setBuydate(userbookEntity.getBuydate());
        setDate(userbookEntity.getDate());
        setId(userbookEntity.getId());
        setIntroduction(userbookEntity.getIntroduction());
        setKind(userbookEntity.getKind());
        setWantkind(userbookEntity.getWantkind());
        setState(userbookEntity.getState());
        setSrc(userbookEntity.getSrc());
        setUsername(userbookEntity.getUsername());
    }

    public String getUserSrc() {
        return userSrc;
    }

    public void setUserSrc(String userSrc) {
        this.userSrc = userSrc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getWantkind() {
        return wantkind;
    }

    public void setWantkind(String wantkind) {
        this.wantkind = wantkind;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
