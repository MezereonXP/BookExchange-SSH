package entity;

import javax.persistence.*;

/**
 * Created by Mezereon on 2017/10/8.
 */
@Entity
@Table(name = "message", schema = "mezereon")
public class MessageEntity {
    private int id;
    private String goalUser;
    private String originUser;
    private String content;
    private String time;
    private int isRead;
    private String goalSrc;
    private String originSrc;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "goalUser", nullable = false, length = 20)
    public String getGoalUser() {
        return goalUser;
    }

    public void setGoalUser(String goalUser) {
        this.goalUser = goalUser;
    }

    @Basic
    @Column(name = "originUser", nullable = false, length = 20)
    public String getOriginUser() {
        return originUser;
    }

    public void setOriginUser(String originUser) {
        this.originUser = originUser;
    }

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "time", nullable = false, length = 20)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "isRead", nullable = false)
    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    @Basic
    @Column(name = "goalSrc", nullable = false, length = 120)
    public String getGoalSrc() {
        return goalSrc;
    }

    public void setGoalSrc(String goalSrc) {
        this.goalSrc = goalSrc;
    }

    @Basic
    @Column(name = "originSrc", nullable = false, length = 120)
    public String getOriginSrc() {
        return originSrc;
    }

    public void setOriginSrc(String originSrc) {
        this.originSrc = originSrc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (id != that.id) return false;
        if (isRead != that.isRead) return false;
        if (goalUser != null ? !goalUser.equals(that.goalUser) : that.goalUser != null) return false;
        if (originUser != null ? !originUser.equals(that.originUser) : that.originUser != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (goalSrc != null ? !goalSrc.equals(that.goalSrc) : that.goalSrc != null) return false;
        if (originSrc != null ? !originSrc.equals(that.originSrc) : that.originSrc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (goalUser != null ? goalUser.hashCode() : 0);
        result = 31 * result + (originUser != null ? originUser.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + isRead;
        result = 31 * result + (goalSrc != null ? goalSrc.hashCode() : 0);
        result = 31 * result + (originSrc != null ? originSrc.hashCode() : 0);
        return result;
    }
}
