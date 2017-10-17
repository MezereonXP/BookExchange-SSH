package entity;

import javax.persistence.*;

/**
 * Created by Mezereon on 2017/10/17.
 */
@Entity
@Table(name = "forumview", schema = "mezereon")
public class ForumviewEntity {
    private int forumId;
    private int viewTiimes;
    private int likeNum;
    private String likeId;

    @Id
    @Column(name = "forumID", nullable = false)
    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    @Basic
    @Column(name = "viewTiimes", nullable = false)
    public int getViewTiimes() {
        return viewTiimes;
    }

    public void setViewTiimes(int viewTiimes) {
        this.viewTiimes = viewTiimes;
    }

    @Basic
    @Column(name = "likeNum", nullable = false)
    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int like) {
        this.likeNum = like;
    }

    @Basic
    @Column(name = "likeID", nullable = false, length = -1)
    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumviewEntity that = (ForumviewEntity) o;

        if (forumId != that.forumId) return false;
        if (viewTiimes != that.viewTiimes) return false;
        if (likeNum != that.likeNum) return false;
        if (likeId != null ? !likeId.equals(that.likeId) : that.likeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = forumId;
        result = 31 * result + viewTiimes;
        result = 31 * result + likeNum;
        result = 31 * result + (likeId != null ? likeId.hashCode() : 0);
        return result;
    }
}
