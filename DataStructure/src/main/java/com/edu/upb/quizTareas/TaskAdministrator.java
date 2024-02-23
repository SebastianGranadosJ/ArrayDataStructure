package com.edu.upb.quizTareas;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import com.edu.upb.array.Array;
import com.edu.upb.linkedList.node.singly.LinkedNode;
import com.edu.upb.linkedList.singly.*;

public class TaskAdministrator {
    
    private LinkedList<Task> taskList = new LinkedList<>();

    public TaskAdministrator(){

    }
    public boolean exist(String taskName){
        try{
            LinkedNode<Task> inode = taskList.getHead();
            while(inode != null){
                if(inode.get().getName().equals(taskName)){
                    return true;
                }
                inode = inode.getNext();
            }
            return false;
        }catch(Exception e){
            return false;
        }
        

    }

    public boolean addTask(String taskName, Integer priority){
        try{
            ToIntFunction<Task> prioritySort = new ToIntFunction<Task>() {

                @Override
                public int applyAsInt(Task task) {
                    return task.getPriority();
                }
                
            };

            if(priority < 1){
                return false;
            }
            if(exist(taskName)){
                return false;
            }
            Task toAdd = new Task(taskName, priority);

            taskList.add(toAdd);
            taskList.sort(prioritySort );

            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean removeTask(String taskName){
        try{
            Predicate<Task> sameName = new Predicate<Task>() {
                @Override
                public boolean test(Task task) {
                    return task.getName().equals(taskName);
                    
                }
            };
            if(!exist(taskName)){
                return false;
            }
            return taskList.remove(sameName);

        }catch(Exception e){
            return false;
        }
    }

    public boolean markComplete(String taskName){
        try{
            if(!exist(taskName)){
                return false;
            }
            LinkedNode<Task> inode = taskList.getHead();
            while(inode != null){
                if(inode.get().getName().equals(taskName)){
                    inode.get().setStatus(true);
                }
                inode = inode.getNext();
            }
            return true;


        }catch(Exception e){
            return false;
        }
    }

    /* 
    public Array<Task> displayTasks(){
        Array<Task> toReturn = new  Array<>(taskList.size());
        toReturn.add(0, taskList.toArray());
        return toReturn;
    }
    */

    public Array<Task> displayTasks(){
        Array<Task> toReturn = new  Array<>(taskList.size());
        LinkedNode<Task> inode = taskList.getHead();
        while(inode != null){
            toReturn.add(inode.get());
            inode = inode.getNext();
        }

        return toReturn;
    }

    public boolean removeCompletedTasks(){
        try{
            Predicate<Task> isCompleted = new Predicate<Task>() {
                @Override
                public boolean test(Task task) {
                    return task.isStatus() == true;
                    
                }
            };
            return taskList.remove(isCompleted);

        }catch(Exception e){
            return true;
        }
        
    }

    /*
    public boolean sortTasksByName(){
        try{
            ToIntFunction<Task> nameSort = new ToIntFunction<Task>() {

                @Override
                public int applyAsInt(Task task) {
                
                    return task.getName().hashCode();

                }
                
            };
            taskList.sort(nameSort);
            return true;

        }catch(Exception e){

        }
        return true;
    }
     */
    public Array<Task> sortTasksByName(){
        LinkedList<Task> listCopy = new LinkedList<>();
        LinkedNode<Task> inode ;
        Task minor;
        if(taskList.isEmpty()){
            Array<Task> array = new Array<>(1);
            return array;
        }
        Array<Task> array = new Array<>(taskList.size());


            while(!taskList.isEmpty()){
                inode = taskList.getHead();
                minor = inode.get();
                
                while(inode.getNext() != null){

                    if(inode.get().getName().compareTo(inode.getNext().get().getName() ) > 0){
                        minor = inode.getNext().get();
                    }
                    inode = inode.getNext();


                }
                listCopy.add(minor);
                taskList.remove(minor);

            }
            taskList.setHead( listCopy.getHead());;
            taskList.setTail(listCopy.getTail()); 
            taskList.setAmtData(listCopy.size());

            array.add(0, displayTasks());
            return array;

    }

    public String print(){

        LinkedNode<Task> inode = taskList.getHead();
        String z = "";
        while(inode != null){

           z+= inode.get().toString();
           z += " "   ;
            inode = inode.getNext();
        }
        return z;

    }
}
