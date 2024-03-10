package com.edu.upb.quizes.quizBag;

public class Item {

    private String name;
    private int rank;
    private Type type;
    private float durability;
    private String description;
    
    public Item(String name, int rank, Type type, float durability, String description) {
        this.name = name;
        this.rank = rank;
        this.type = type;
        this.durability = durability;
        this.description = description;
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

    public float getDurability() {
        return durability;
    }

    public void setDurability(float durability) {
        this.durability = durability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", rank=" + rank + ", type=" + type + ", durability=" + durability
                + ", description=" + description + "]";
    }
    
    

    
}
