package com.edu.upb.partialCorrection.inventory;

import com.edu.upb.linkedList.singly.LinkedList;
import com.edu.upb.priorityQueue.PriorityQueue;
import com.edu.upb.util.iterator.Iterator;

public class Bag extends PriorityQueue<Item>{
      int amtSlots;

    public Bag(int amtSlots) {
        super(5);
        this.amtSlots = amtSlots;
       
    }

    public void dimension(int newAmtSlots){

        amtSlots = newAmtSlots;

        while(size() > amtSlots){
            extract();
        }

    }

    public boolean add(Item item){
        if(!hasSpace()){
            return false;
        }
        return insert(item.getPriority(),item);
    }

    public boolean exist(Item item){
        Iterator<Item> iter = iterator();

        while(iter.hasNext()){
            Item element = iter.next();

            if(element.getName().equals(item.getName()) &&
            element.getRank() == (item.getRank()) &&
            element.getPriority() == (item.getPriority()) &&
            element.getType().equals(item.getType()) &&
            element.getDurability() == item.getDurability() &&
            element.getDescription().equals(item.getDescription())
            ){
                return true;
            }
            
            

        }
        return false;

    }

    public boolean hasSpace(){
        if(size() == amtSlots){
            return false;
        }
        return true;

    }

    public LinkedList<Item> toListItems(){
        LinkedList<Item> toRet = new LinkedList<>();
        Iterator<Item> iter = iterator();

        while(iter.hasNext()){
            toRet.add(iter.next());

        }
        return toRet;

    }


}
