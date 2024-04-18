package com.edu.upb.partialCorrection.inventory;


public class Item {

    private String name;
    private int rank;
    private int priority;
    private Type type;
    private int durability;
    private String description;
    private int amt; 
    
    public Item(String name, int rank, Type type, int durability, String description, int priority) {
        this.name = name;
        this.rank = rank;
        this.type = type;
        this.durability = durability;
        this.description = description;
        this.priority = priority;
        amt = 1;
    }

    public boolean equalsThan(Item item){
        if(this.getName().equals(item.getName()) &&
        this.getRank() == (item.getRank()) &&
        this.getPriority() == (item.getPriority()) &&
        this.getType().equals(item.getType()) &&
        this.getDurability() == item.getDurability() &&
        this.getDescription().equals(item.getDescription())
        ){
                return true;
        }else{
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    @Override
    public String toString() {
        return "Item [name=" + name + ", rank=" + rank + ", priority=" + priority + ", type=" + type + ", durability="
                + durability + ", description=" + description + ", amt=" + amt + "]";
    }

}
