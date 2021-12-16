package com.user.UserStoryManagement.service.impl;

import com.user.UserStoryManagement.entities.UserStory;
import com.user.UserStoryManagement.repository.UserStoryRepository;
import com.user.UserStoryManagement.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserStoryServiceImpl implements UserStoryService {

    @Autowired
    UserStoryRepository userStoryRepository;

    @Override
    public UserStory addStory(UserStory userStory) {
       UserStory addedUserStory = userStoryRepository.save(userStory);
        return addedUserStory;
    }

    @Override
    public void deleteStory(String userStoryId) {

    }

    @Override
    public Optional<UserStory> getUserStoryById(String userStoryId) {
       return userStoryRepository.findById(userStoryId);
    }

    @Override
    public Iterable<UserStory> getAllUserStories() {
        return userStoryRepository.findAll();    }

    @Override
    public void deleteUserStory(String userStoryId) {
        userStoryRepository.deleteById(userStoryId);
    }

    @Override
    public Boolean checkIfIdExistsOrNot(String userStoryId) {
        if (userStoryRepository.existsById(userStoryId)) {
            return true;
        }
        return false;
    }
}

