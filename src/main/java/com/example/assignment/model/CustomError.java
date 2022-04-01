package com.example.assignment.model;

public class CustomError {
    private String ERROR;
    private String Description;

    public CustomError(String ERROR, String description) {
        this.ERROR = ERROR;
        this.Description = description;
    }

    public CustomError() {
    }

    public String getERROR() {
        return ERROR;
    }

    public void setERROR(String ERROR) {
        this.ERROR = ERROR;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
