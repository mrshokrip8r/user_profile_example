package com.meet5.task.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.Date;

public class Interaction {
    @Id
    private Integer id;
    private Date interactionDate;
    private AggregateReference<UserProfile, Integer> srcUserProfileId;
    private AggregateReference<UserProfile, Integer> destUserProfileId;
    private InteractionType interactionType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInteractionDate() {
        return interactionDate;
    }

    public void setInteractionDate(Date interactionDate) {
        this.interactionDate = interactionDate;
    }

    public AggregateReference<UserProfile, Integer> getSrcUserProfileId() {
        return srcUserProfileId;
    }

    public void setSrcUserProfileId(AggregateReference<UserProfile, Integer> srcUserProfileId) {
        this.srcUserProfileId = srcUserProfileId;
    }

    public AggregateReference<UserProfile, Integer> getDestUserProfileId() {
        return destUserProfileId;
    }

    public void setDestUserProfileId(AggregateReference<UserProfile, Integer> destUserProfileId) {
        this.destUserProfileId = destUserProfileId;
    }

    public InteractionType getInteractionType() {
        return interactionType;
    }

    public void setInteractionType(InteractionType interactionType) {
        this.interactionType = interactionType;
    }
}
