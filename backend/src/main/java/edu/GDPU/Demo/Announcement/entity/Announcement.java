package edu.GDPU.Demo.Announcement.entity;

public class Announcement {
    /**
     * 公告唯一标识（数据库自增主键）
     */
    private int anncId;

    /**
     * 发布者身份（如：系统管理员/宿管员）
     */
    private String publisher;

    /**
     * 发布者头像URL地址
     */
    private String avatar;

    /**
     * 公告正文内容
     */
    private String message;

    /**
     * 发布时间（格式：YYYY-MM-DD HH:mm:ss）
     */
    private String time;

    public Announcement(int anncId, String time, String message, String avatar, String publisher) {
        this.anncId = anncId;
        this.time = time;
        this.message = message;
        this.avatar = avatar;
        this.publisher = publisher;
    }

    public Announcement() {
    }

    public int getAnncId() {
        return anncId;
    }

    public void setAnncId(int anncId) {
        this.anncId = anncId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "anncId=" + anncId +
                ", publisher='" + publisher + '\'' +
                ", avatar='" + avatar + '\'' +
                ", message='" + message + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
