package edu.GDPU.Demo.Repair.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;
@Data
public class RepairDto extends BaseEntity{
    private Integer id;
    private String title;
    private Integer applicant;
    private Date applicationTime;
    private Integer importance;
    private String content;
    private String imageUri;
    private Integer status;

    public RepairDto() {
    }

    public RepairDto(Date beginTime, Date endTime) {
        super(beginTime, endTime);
    }

    public RepairDto(Integer id, String title, Integer applicant, Date applicationTime, Integer importance, String content, String imageUri, Integer status) {
        this.id = id;
        this.title = title;
        this.applicant = applicant;
        this.applicationTime = applicationTime;
        this.importance = importance;
        this.content = content;
        this.imageUri = imageUri;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getApplicant() {
        return applicant;
    }

    public void setApplicant(Integer applicant) {
        this.applicant = applicant;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}