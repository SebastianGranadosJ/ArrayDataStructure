package com.edu.upb.exercises.quizes.quizBag;

public class Slot {

    Item item;
    int amt;
    public Slot(Item item) {
        this.item = item;
        amt = 1;
    }
    
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public int getAmt() {
        return amt;
    }
    public void setAmt(int amt) {
        this.amt = amt;
    }

    @Override
    public String toString() {
        return "Slot [item=" + item + ", amt=" + amt + "]";
    }

    
    
}
