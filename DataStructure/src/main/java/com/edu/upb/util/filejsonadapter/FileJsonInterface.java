package com.edu.upb.util.filejsonadapter;

import java.io.Serializable;

public interface FileJsonInterface<E> extends Serializable{
   
        E getObject(String pathFile, Class<E> classOfT);
      
        E[] getObjects(String pathFile, Class<E[]> classOfT);
      
        Boolean writeObject(String pathFile, E object);
      
        Boolean writeObjects(String pathFile, E[] objects);
}
