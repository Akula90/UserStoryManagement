package com.user.UserStoryManagement.controller;

import com.user.UserStoryManagement.entities.UserStory;
import com.user.UserStoryManagement.repository.UserStoryRepository;
import com.user.UserStoryManagement.service.UserStoryService;
import exception.EntityNotFoundExceptionById;
import exception.UserStoryIdNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserStoryController {

    Logger logger = LoggerFactory.getLogger(UserStoryController.class);

    @Autowired
    UserStoryService userStoryService;

    @PostMapping("/addStory")
    @Produces("application/json")
    @Consumes("application/json")
    public ResponseEntity addStory(@RequestBody UserStory userStory) {
        UserStory addedUserStory = userStoryService.addStory(userStory);
        return new ResponseEntity(addedUserStory, HttpStatus.valueOf(200));
    }

    @GetMapping("/getStory/{userStoryId}")
    @Produces("application/json")
    @Consumes("application/json")
    public ResponseEntity getUserStoryById(@PathVariable String userStoryId) {
        System.out.println("userStoryId: "+userStoryId);
        logger.info("fetching details of userStoryId : "+userStoryId+" in getUserStoryById{} ");
        Boolean userStoryExists = userStoryService.checkIfIdExistsOrNot(userStoryId);
        if(userStoryExists) {
            Optional<UserStory> userStory =  userStoryService.getUserStoryById(userStoryId);
            return new ResponseEntity(userStory, HttpStatus.valueOf(200));
        }
        else {
            return new ResponseEntity("Invalid Id was provided",HttpStatus.valueOf(500));
        }
    }

    @GetMapping("/getAllStories")
    @Produces("application/json")
    @Consumes("application/json")
    public Iterable<UserStory> getAllUserStories() {
        logger.info("fetching all details in getAllUserStories{} ");
        return userStoryService.getAllUserStories();
    }

    @DeleteMapping("/deleteStory/{userStoryId}")
    @Produces("application/json")
    @Consumes("application/json")
    public ResponseEntity deleteUserStory(@PathVariable String userStoryId) {
        logger.info("Deleting user story id in  deleteUserStory{} ");
        Boolean userStoryExists = userStoryService.checkIfIdExistsOrNot(userStoryId);
        if (userStoryExists) {
            userStoryService.deleteUserStory(userStoryId);
            return new ResponseEntity("Deleted Successfully!!!", HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity("Invalid Id was provided",HttpStatus.valueOf(500));
        }
    }
}
