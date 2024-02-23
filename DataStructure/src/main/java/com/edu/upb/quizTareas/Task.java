package com.edu.upb.quizTareas;

public class Task {
    private String name;
    private Integer priority;
    private boolean status;

    public Task(){
        status = false;
    }
    public Task(String name, Integer priority){
        this.name  = name;
        this.priority = priority;
        status = false;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task [name=" + name + ", priority=" + priority + ", status=" + status + "]";
    }
    
}
