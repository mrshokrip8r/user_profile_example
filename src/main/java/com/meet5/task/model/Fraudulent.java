package com.meet5.task.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.Date;


public class Fraudulent {
    @Id
    private Integer id;
    private AggregateReference<UserProfile, Integer> userProfileId;
    private Date creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AggregateReference<UserProfile, Integer> getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(AggregateReference<UserProfile, Integer> userProfileId) {
        this.userProfileId = userProfileId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
