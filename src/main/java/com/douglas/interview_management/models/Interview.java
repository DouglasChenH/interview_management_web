package com.douglas.interview_management.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.stream.Stream;


@Document(collection = "interviews")
public class Interview {
    @Id
    private String id;
    private String positionName;
    private String positionDesc;
    private String companyName;
    private Date interviewTime;
    private String interviewLocation;


    public Interview() {
    }

    public Interview(String positionName, String positionDesc,
                     String companyName, Date interviewTime, String interviewLocation) {
        this.positionName = positionName;
        this.positionDesc = positionDesc;
        this.companyName = companyName;
        this.interviewTime = interviewTime;
        this.interviewLocation = interviewLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPositionNameName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Date interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getInterviewLocation() {
        return interviewLocation;
    }

    public void setInterviewLocation(String interviewLocation) {
        this.interviewLocation = interviewLocation;
    }


}
