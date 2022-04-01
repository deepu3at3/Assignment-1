package com.example.assignment.model;

public class Info {
   private String description;
   private String api_version;


    public Info() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public Info(String description, String api_version) {
        this.description = description;
        this.api_version = api_version;
    }

}
