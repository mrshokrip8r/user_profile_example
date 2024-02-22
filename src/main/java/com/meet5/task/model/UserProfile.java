package com.meet5.task.model;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class UserProfile {

    @Id
    private Integer id;
    @NotNull(message = "Name Shouldn't be null")
    @NotBlank(message = "Name Shouldn't be empty")
    private String name;
    @Min(18)
    @Max(200)
    private Integer age;
    private String job;
    @NotNull(message = "Location Shouldn't be null")
    @NotBlank(message = "Location Shouldn't be empty")
    private String location;
    private GenderType gender;
    private RelationshipStatus relationshipStatus;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Invalid date format")
    private Date birthDate;
    private Date modificationDate;
    private Date creationDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public RelationshipStatus getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(RelationshipStatus relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
