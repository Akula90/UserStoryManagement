package com.user.UserStoryManagement.entities;

import com.user.UserStoryManagement.constants.UserStoryStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserStory {
    @Id
    @Column(name = "userStoryId", nullable = false)
    String userStoryId;
    @Column(name = "description")
    String description;
    @Column(name = "status")
    UserStoryStatus status;

    public String getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(String userStoryId) {
        this.userStoryId = userStoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserStoryStatus getStatus() {
        return status;
    }

    public void setStatus(UserStoryStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserStory{" +
                "userStoryId='" + userStoryId + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
