package com.codebay.goldeneye.model;

/*
 * Model for managing job data. The jobs can be created in code,
 * as now (/fakeBackend/Backend.java) or obtained from a real backend API
 */
public class JobPosition {
    private int id;
    private String location;
    private String department;
    
    public JobPosition(int id, String location, String department) {
        this.id = id;
        this.location = location;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
