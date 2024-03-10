package com.edu.upb.util.priorityQueue;

import com.edu.upb.util.queue.Queue;

public interface PriorityQueue<E> extends Queue<E>{
    
    public boolean insert(int index, E element);
}
