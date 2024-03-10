package com.edu.upb.quizes.quizTask;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import com.edu.upb.array.Array;
import com.edu.upb.util.iterator.Iterator;

public class TaskAdministrator {
    
    private TaskList taskList = new TaskList();

    public boolean addTask(String taskName, int priority){
        if(taskList.exist(taskName)){
            return false;
        }
        if(priority < 1){
            return false;
        }

        ToIntFunction<Task> toInt = new ToIntFunction<Task>() {

            @Override
            public int applyAsInt(Task value) {
                return value.getPriority();
            }
            
        };


        Task toAdd = new Task(taskName, priority);

        if(taskList.add(toAdd)){
            taskList.sort(toInt);
            return true;
        }
        return false;
    }

    public boolean removeTask(String taskName){

        Predicate<Task> equalName = new Predicate<Task>() {

            @Override
            public boolean test(Task t) {
                return t.getName().equals(taskName);
            }
            
        };

        return taskList.remove(equalName);
    }

    public boolean markComplete(String taskName){

        if(!taskList.exist(taskName)){
            return false;
        }
        Function<Task, Void> action = new Function<Task,Void>() {

            @Override
            public Void apply(Task t) {
                if(t.getName().equals(taskName)){
                    t.setStatus(true);
                }
                return null;
         
            }
        };

        taskList.forEach(action);

        return true;
    }

    public Array<Task> displayTasks(){
        if(taskList.isEmpty()){
            Array<Task> toRet = new Array<>(1);
            return toRet;

        }

        Array<Task> toRet = new Array<>(taskList.size());

        Iterator<Task> iter = taskList.iterator();

        while(iter.hasNext()){
            toRet.add(iter.next());

        }
        return toRet;

    }
    public boolean removeCompletedTasks(){

        Predicate<Task> completedTask = new Predicate<Task>() {

            @Override
            public boolean test(Task t) {
                return t.isStatus();
            }
            
        };

        return taskList.remove(completedTask);
    }

    public boolean exist(String name){

        return taskList.exist(name);
    }

    public String toString(){
        return taskList.toString();
    }

    public Array<Task> sortTasksByName(){
        taskList.sortTasksByName();
        return displayTasks();


    }
}
