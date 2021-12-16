package com.user.UserStoryManagement.repository;

import com.user.UserStoryManagement.entities.UserStory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStoryRepository extends CrudRepository<UserStory,String> {
}
