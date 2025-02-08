package com.demo_rest.demo_rest_crud.rest;

public class StudentErrorResponse {
    private long timeStamp;
    private String status;
    private String message;
    public StudentErrorResponse(){

    }
    public long getTimeStamp() {
        return timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public StudentErrorResponse(int timeStamp, String status, String message) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
    }
}
