package edu.GDPU.Demo.UserLogin.entity;

public class User {

    /**
     * 用户唯一标识符（数据库自增主键）
     */
    private Integer userId;

    /**
     * 用户名（系统登录凭证）
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 认证令牌（用于会话保持,时间戳）
     */
    private String token;

    /**
     * 用户头像URL地址
     */
    private String avatar;

    /**
     * 用户角色（SysAdmin=系统管理员，DormAdmin=宿管员，Student=学生）
     */
    private String roles;

    /**
     * 用户性别（男/女）
     */
    private String gender;

    /**
     * 宿舍信息（格式：楼号-房间号，示例：3-205）
     */
    private String dorm;

    /**
     * 专业信息（示例：计算机科学与技术/软件工程/电子信息工程）
     */
    private String major;

    /**
     * 学号（学生唯一标识符）
     */
    private String stuId;

    public User() {
    }

    public User(Integer userId, String username, String password, String token, String avatar, String roles, String gender, String dorm, String major, String stuId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.token = token;
        this.avatar = avatar;
        this.roles = roles;
        this.gender = gender;
        this.dorm = dorm;
        this.major = major;
        this.stuId = stuId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
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
                ", stuId='" + stuId + '\'' +
                '}';
    }
}
