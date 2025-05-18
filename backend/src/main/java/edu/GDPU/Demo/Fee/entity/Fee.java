package edu.GDPU.Demo.Fee.entity;

public class Fee {
    private String stuId;
    private String stuName;
    private String className;
    private double Fee;
    private String dormitory;
    public Fee() {
    }

    public Fee(String stuId, String stuName, String className, double fee, String dormitory) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.className = className;
        Fee = fee;
        this.dormitory = dormitory;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getFee() {
        return Fee;
    }

    public void setFee(double fee) {
        Fee = fee;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }
}