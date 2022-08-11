package com.codebay.goldeneye.fakeBackend;

import java.util.ArrayList;
import java.util.List;

import com.codebay.goldeneye.model.JobPosition;
import com.codebay.goldeneye.model.User;
import com.codebay.goldeneye.utils.HelpFunctions;


/*
 * This class simulates a backend API
 */
public class Backend {
    static public List<JobPosition> getJobPositions() {
        return new ArrayList<JobPosition>() {
            {
                add(new JobPosition(0, "Milan", "Design"));
                add(new JobPosition(1, "Milan", "Business"));
                add(new JobPosition(2, "Milan", "Advertising"));
                add(new JobPosition(3, "Spain", "Research & development"));
                add(new JobPosition(4, "Spain", "Business"));
                add(new JobPosition(5, "New York", "Business"));
                add(new JobPosition(6, "New York", "Advertising"));
            }
        };
    }
    
    static public User createUser(User userModel) {
        // Check the presence of all required data
        if (HelpFunctions.checkNullOrEmptyStr(userModel.getName())
        || HelpFunctions.checkNullOrEmptyStr(userModel.getSurname())
        || HelpFunctions.checkNullOrEmptyStr(userModel.getJobPositionObj().getDepartment())
        || HelpFunctions.checkNullOrEmptyStr(userModel.getJobPositionObj().getLocation())) {
            return null;
        }
        
        String email = "";
        email += HelpFunctions.removeUndesiredCharacters(userModel.getName()).substring(0, 1).toLowerCase();
        email += HelpFunctions.removeUndesiredCharacters(userModel.getSurname().toLowerCase());
        email += ".";
        email += HelpFunctions.removeUndesiredCharacters(userModel.getJobPositionObj().getDepartment().toLowerCase());
        email += "@";
        email += HelpFunctions.removeUndesiredCharacters(userModel.getJobPositionObj().getLocation().toLowerCase());
        email += ".goldeneye.com";

        userModel.setEmail(email);
        return userModel;
    }

    
}
