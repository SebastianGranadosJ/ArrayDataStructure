package com.edu.upb.quizes.quizBag;



import com.edu.upb.array.Array;
import com.edu.upb.linkedList.singly.LinkedList;
import com.edu.upb.util.iterator.Iterator;

public class Bag extends Array<Slot>{

    int length;

    public Bag(int length) {
        super(length);
       
    }

    public boolean exist(String name){
        Iterator<Slot> iter = iterator();

        while(iter.hasNext()){
            Slot slot = iter.next();
            
            if(slot != null){
                if(name.equals(slot.getItem().getName())){
                    return true;
                }
            }
            

        }
        return false;

    }

    public boolean hasSpace(){
        if(size() == length){
            return false;
        }
        return true;

    }

    public LinkedList<Item> toListItems(){
        LinkedList<Item> toRet = new LinkedList<>();
        Iterator<Slot> iter = iterator();

        while(iter.hasNext()){
            toRet.add(iter.next().getItem());

        }
        return toRet;

    }

    public LinkedList<Slot> toListSlots(){
        LinkedList<Slot> toRet = new LinkedList<>();
        Iterator<Slot> iter = iterator();

        while(iter.hasNext()){
            toRet.add(iter.next());

        }
        return toRet;

    }


}
