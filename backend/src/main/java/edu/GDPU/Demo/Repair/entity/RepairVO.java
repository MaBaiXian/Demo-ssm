package edu.GDPU.Demo.Repair.entity;

import java.util.Date;

public class RepairVO extends Repair {
    private String student;

    public RepairVO() {
    }

    public RepairVO(Integer id, String title, Integer applicant, Date applicationTime, Integer importance, String content, String imageUri, Integer status) {
        super(id, title, applicant, applicationTime, importance, content, imageUri, status);
    }

    public RepairVO(String student) {
        this.student = student;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }
}
