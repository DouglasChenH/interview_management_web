package com.douglas.interview_management.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "interviews")
public class Interview {
    @Id
    private String id;
    private String postitionName;
    private String postitionDesc;
    private String companyName;
    private String interviewTime;
    private String interviewLocation;


    public Interview() {
    }

    public Interview(String postitionName, String postitionDesc,
                     String companyName, String interviewTime, String interviewLocation) {
        this.postitionName = postitionName;
        this.postitionDesc = postitionDesc;
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

    public String getPostitionNameName() {
        return postitionName;
    }

    public void setPostitionName(String postitionName) {
        this.postitionName = postitionName;
    }

    public String getPostitionDesc() {
        return postitionDesc;
    }

    public void setPostitionDesc(String postitionDesc) {
        this.postitionDesc = postitionDesc;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getInterviewLocation() {
        return interviewLocation;
    }

    public void setInterviewLocation(String interviewLocation) {
        this.interviewLocation = interviewLocation;
    }


}
