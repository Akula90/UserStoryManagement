package com.user.UserStoryManagement.service;

import com.user.UserStoryManagement.entities.UserStory;

import java.util.Optional;

public interface UserStoryService {
    
    UserStory addStory(UserStory userStory);
    
    void deleteStory(String userStoryId);

    Optional<UserStory> getUserStoryById(String userStoryId);

    Iterable<UserStory> getAllUserStories();

    void deleteUserStory(String userStoryId);

    Boolean checkIfIdExistsOrNot(String userStoryId);
}
