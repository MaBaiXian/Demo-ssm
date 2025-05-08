package edu.GDPU.Demo.UserLogin.entity;

public class User {

    private Integer userId;

    private String username;

    private String password;

    private String token;

    private String avatar;

    private String roles;

    private String gender;

    private String dorm;

    private String major;

    public User() {
    }

    public User(Integer userId, String username, String password, String token, String avatar, String roles, String gender, String dorm, String major) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.token = token;
        this.avatar = avatar;
        this.roles = roles;
        this.gender = gender;
        this.dorm = dorm;
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roles='" + roles + '\'' +
                ", gender='" + gender + '\'' +
                ", dorm='" + dorm + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
