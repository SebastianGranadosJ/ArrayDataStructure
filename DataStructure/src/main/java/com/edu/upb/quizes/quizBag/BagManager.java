package com.edu.upb.quizes.quizBag;

import java.util.function.Function;
import java.util.function.ToIntFunction;

import com.edu.upb.linkedList.singly.LinkedList;
import com.edu.upb.util.iterator.Iterator;

public class BagManager {

    Bag bag1;
    Bag bag2;
    Bag bag3;
    Bag bag4;

    public BagManager(){
        bag1 = new Bag(6);
        bag2 = null;
        bag3 = null;
        bag4 = null;
    }

    public boolean addBag(int length){

        if(length != 6 && length != 8 && length != 12 ){
            length = 6;
        }

        if(bag2 == null){
            bag2 = new Bag(length);
            return true;
        }
        if(bag3 == null){
            bag3 = new Bag(length);
            return true;
        }
        if(bag4 == null){
            bag4 = new Bag(length);
            return true;
        }
        return false;
    }

    public boolean addItem(Item item){

        if(bag1 != null){
            if(addItemInBag(bag1, item)){
                return true;
            }
            
        }

        if(bag2 != null){
            if(addItemInBag(bag2, item)){
                return true;
            }
            
        }

        if(bag3 != null){
            if(addItemInBag(bag3, item)){
                return true;
            }
            
        }

        if(bag4 != null){
            if(addItemInBag(bag4, item)){
                return true;
            }
            
        }

        return false;


    }

    public LinkedList<Item> displayItems(){

        LinkedList<Item> toRet = new LinkedList<>();

        if(bag1 != null){
            toRet.add(bag1.toListItems());
        }

        if(bag2 != null){
            toRet.add(bag2.toListItems());
        }

        if(bag3 != null){
            toRet.add(bag3.toListItems());
        }

        if(bag4 != null){
            toRet.add(bag4.toListItems());
        }

        return toRet;

    }

    public  LinkedList<Item> sortItemsByTRange(){
        LinkedList<Item> toRet = displayItems();
        ToIntFunction<Item> sortRange = new ToIntFunction<Item>() {
            @Override
            public int applyAsInt(Item value) {
                return value.getRank();
            }
        };
        toRet.sort(sortRange);


        LinkedList<Slot> toAdd = displaySlots();

        ToIntFunction<Slot> sortRangeSlot = new ToIntFunction<Slot>() {
            @Override
            public int applyAsInt(Slot value) {
                return value.getItem().getRank();
            }
        };
        toAdd.sort(sortRangeSlot);

        if(bag1 != null){
            bag1.clear();
        }

        if(bag2 != null){
            bag2.clear();
        }

        if(bag3 != null){
            bag3.clear();
        }

        if(bag4 != null){
            bag4.clear();
        }

        Iterator<Slot> iter = toAdd.iterator();
        boolean add = true;

        while(iter.hasNext()){

            add = true;
            Slot slotToAdd = iter.next();

            if(bag1 != null){
                if(bag1.hasSpace() && add == true){
                    bag1.add(slotToAdd);
                    add = false;
                }
            }
            if(bag2 != null){
                if(bag2.hasSpace() && add == true){
                    bag2.add(slotToAdd);
                    add = false;
                }
            }
            if(bag3 != null){
                if(bag3.hasSpace() && add == true){
                    bag3.add(slotToAdd);
                    add = false;
                }
            }
            if(bag4 != null){
 
                if(bag4.hasSpace() && add == true){
                    bag4.add(slotToAdd);
                    add = false;
                }
            }


        }

        return toRet;

    }


    private boolean addItemInBag(Bag bag, Item item){

        if (bag.exist(item.getName())){

            Function<Slot, Void> existItem = new Function<Slot,Void>() {
                @Override
                public Void apply(Slot t) {
                    if(t == null){
                        return null;
                    }


                    if(t.getItem().getName().equals(item.getName())){
                        t.setAmt( t.getAmt() + 1);
                        return null;
                    }
                    return null;
                }
                
            };
            
            bag.forEach(existItem);
            return true;
        }

        Slot slot = new Slot(item);
        if(bag.add(slot)){
            return true;
        }
        return false;
    }

    public LinkedList<Slot> displaySlots(){

        LinkedList<Slot> toRet = new LinkedList<>();

        if(bag1 != null){
            toRet.add(bag1.toListSlots());
        }

        if(bag2 != null){
            toRet.add(bag2.toListSlots());
        }

        if(bag3 != null){
            toRet.add(bag3.toListSlots());
        }

        if(bag4 != null){
            toRet.add(bag4.toListSlots());
        }

        return toRet;

    }
  
    public String toString(){
        String ret = "";

        if(bag1 != null){
            ret += "Bag 1:\n";
            ret += bag1.toString() + "\n";

        }

        if(bag2 != null){
            ret += "Bag 2:\n";
            ret += bag2.toString()  + "\n";

        }

        if(bag3 != null){
            ret += "Bag 3:\n";
            ret += bag3.toString()  + "\n";

        }

        if(bag4 != null){
            ret += "Bag 4:\n";
            ret += bag4.toString()  + "\n";

        }

        return ret;


    }


    
}
