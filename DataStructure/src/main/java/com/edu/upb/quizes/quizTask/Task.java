package com.edu.upb.quizes.quizTask;

// CLASE  = PLANTILLA = Son para rellenarlas
// Objeto

public class Task {



    // ATRIBUTOS 
    private String name;

    // juan.getName(); 

    private int priority;

    private boolean status;


    public Task(String name, int priority){
        setName(name);
        setPriority(priority);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Task [name=" + name + ", priority=" + priority + ", status=" + status + "]";
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
