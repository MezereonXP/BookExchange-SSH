package entity;

/**
 * Created by Mezereon on 2017/10/17.
 */
public class SuperForum {
    private int id;
    private String username;
    private String introduction;
    private String title;
    private String time;
    private String src;
    private int numOfComments;
    private ForumviewEntity forumviewEntity;

    public void setEntity(ForumEntity forumEntity){
        id = forumEntity.getId();
        username = forumEntity.getUsername();
        introduction = forumEntity.getIntroduction();
        title = forumEntity.getTitle();
        time = forumEntity.getTime();
        src = forumEntity.getSrc();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getNumOfComments() {
        return numOfComments;
    }

    public void setNumOfComments(int numOfComments) {
        this.numOfComments = numOfComments;
    }

    public ForumviewEntity getForumviewEntity() {
        return forumviewEntity;
    }

    public void setForumviewEntity(ForumviewEntity forumviewEntity) {
        this.forumviewEntity = forumviewEntity;
    }
}
