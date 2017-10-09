package entity;

import javax.persistence.*;

/**
 * Created by Mezereon on 2017/10/8.
 */
@Entity
@Table(name = "userbook", schema = "mezereon")
public class UserbookEntity {
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

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bookname", nullable = false, length = 40)
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Basic
    @Column(name = "introduction", nullable = false, length = -1)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "buydate", nullable = false, length = 20)
    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }

    @Basic
    @Column(name = "src", nullable = false, length = -1)
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "date", nullable = false, length = 40)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "kind", nullable = false, length = 7)
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Basic
    @Column(name = "wantkind", nullable = false, length = 7)
    public String getWantkind() {
        return wantkind;
    }

    public void setWantkind(String wantkind) {
        this.wantkind = wantkind;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 80)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserbookEntity that = (UserbookEntity) o;

        if (id != that.id) return false;
        if (state != that.state) return false;
        if (bookname != null ? !bookname.equals(that.bookname) : that.bookname != null) return false;
        if (introduction != null ? !introduction.equals(that.introduction) : that.introduction != null) return false;
        if (buydate != null ? !buydate.equals(that.buydate) : that.buydate != null) return false;
        if (src != null ? !src.equals(that.src) : that.src != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
        if (wantkind != null ? !wantkind.equals(that.wantkind) : that.wantkind != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bookname != null ? bookname.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (buydate != null ? buydate.hashCode() : 0);
        result = 31 * result + (src != null ? src.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (kind != null ? kind.hashCode() : 0);
        result = 31 * result + (wantkind != null ? wantkind.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
