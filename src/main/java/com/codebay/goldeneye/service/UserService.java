package com.codebay.goldeneye.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codebay.goldeneye.fakeBackend.Backend;
import com.codebay.goldeneye.model.JobPosition;
import com.codebay.goldeneye.model.User;

/*
 * Communicate with the backend API and manage all user related logic
 */
@Service
public class UserService {
    private List<JobPosition> jobPositions;
    
    public UserService() {
        jobPositions = Backend.getJobPositions();
    }
    
    public List<JobPosition> getJobPositions() {
        return jobPositions;
    }
    
    public User createUser(User userModel) {
        /*
         * TODO: Here you can integrate the function developed by your developers to
         * obtain a final string with the unwanted characters removed
         * 
         */
        
        // Send to the backend to create user data and return user's email address
        User user = Backend.createUser(userModel);
        return user;
    }
}
