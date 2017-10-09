package entity;

import javax.persistence.*;

/**
 * Created by Mezereon on 2017/10/8.
 */
@Entity
@Table(name = "articlecomment", schema = "mezereon")
public class ArticlecommentEntity {
    private int id;
    private String username;
    private String comment;
    private int articleid;
    private String time;
    private String src;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 40)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "articleid", nullable = false)
    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    @Basic
    @Column(name = "time", nullable = false, length = 40)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "src", nullable = false, length = 90)
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticlecommentEntity that = (ArticlecommentEntity) o;

        if (id != that.id) return false;
        if (articleid != that.articleid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (src != null ? !src.equals(that.src) : that.src != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + articleid;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (src != null ? src.hashCode() : 0);
        return result;
    }
}
