package com.edu.upb.util.hashmap;

public interface AbstractHashMap<E> {
    
    public abstract boolean put(String key, E object);

    public abstract E get(String key);

    public abstract boolean remove(String key);


}
