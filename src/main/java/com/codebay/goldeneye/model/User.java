package com.codebay.goldeneye.model;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.codebay.goldeneye.service.UserService;
import com.codebay.goldeneye.utils.HelpFunctions;

/*
 * Model for managing user data
 */
public class User {
    @NotEmpty(message = "This field is required")
    private String name;
    @NotEmpty(message = "This field is required")
    private String surname;
    @NotNull(message = "This field is required")
    private JobPosition jobPosition;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname.trim();
    }

    public String getJobPosition() {
        if (jobPosition != null) {
            return Integer.toString(jobPosition.getId());
        } else {
            return null;
        }
    }

    public JobPosition getJobPositionObj() {
        return jobPosition;
    }

    public void setJobPosition(String jobPositionIdStr) {
        Integer jobPositionId = HelpFunctions.tryParseInt(jobPositionIdStr);

        if (jobPositionId != null) {
            Optional<JobPosition> job = new UserService().getJobPositions().stream().filter(obj -> obj.getId() == jobPositionId)
                    .findFirst();
            if (job.isPresent()) {
                this.jobPosition = job.get();
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }
}
