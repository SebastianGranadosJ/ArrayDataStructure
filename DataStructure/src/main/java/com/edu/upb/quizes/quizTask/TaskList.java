package com.edu.upb.quizes.quizTask;



import com.edu.upb.linkedList.node.singly.LinkedNode;
import com.edu.upb.linkedList.singly.LinkedList;
import com.edu.upb.util.iterator.Iterator;

public class TaskList extends LinkedList<Task> {
    
    public TaskList(){
        super();
    }

    public boolean sortTasksByName() { // All elements are remplaced with ToIntFunction and then sorted? Or arent remplaced?
        try{
            LinkedList<Task> listCopy = new LinkedList<Task>();
            LinkedNode<Task> inode;
            Task minor;

            if(isEmpty()){
                return false;
            }

            while(!isEmpty()){
                inode = head;
                minor = head.get();
                
                while(inode != null){

                    if(inode.get().getName().compareTo(minor.getName()) < 1 ){
                        minor = inode.get();
                    }
                    inode = inode.getNext();


                }
                listCopy.add(minor);
                remove(minor);

            }
            add(listCopy);

            return true;
        }catch(Exception e){
            return false;
        }
        
    }

    public boolean exist(String name){
        
        Iterator<Task> iter = iterator();

        while(iter.hasNext()){
            Task task = iter.next();

            if(task.getName().equals(name)){
                return true;
            }
        }

        return false;
    }



}
