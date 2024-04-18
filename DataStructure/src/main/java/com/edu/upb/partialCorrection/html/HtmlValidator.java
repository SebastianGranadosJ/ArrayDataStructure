package com.edu.upb.partialCorrection.html;

import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.stack.list.Stack;
import com.edu.upb.txtManager.TxtManager;
import com.edu.upb.util.iterator.Iterator;

public class HtmlValidator {
    

    public static void validateHtml(){

        LinkedList<String> lines = TxtManager.readLines("in.html");
        Stack<String> tags = new Stack<>();
        Iterator<String> iter = lines.iterator();
        boolean noErrors = true;


        while(iter.hasNext()){
           LinkedList<String> lineParts = tagsSeparator(iter.next());
           Iterator<String> partsIter = lineParts.iterator();

           while(partsIter.hasNext()){
                String part = partsIter.next();
                if (part.charAt(1) == '/') {
                    if(tags.isEmpty()){
                        System.out.println("Error: " + part + " no tiene etiqueta de apertura.");
                        noErrors = false;
                    }
                    String partFixed = part.replace("/", "");
                
                    if(tags.contains(partFixed)){
                        

                        if(tags.peek().equals(partFixed)){
                            tags.pop();
                        }else{

                            while(!tags.peek().equals(partFixed)){
                               System.out.println("Error: " + tags.pop() + " no tiene etiqueta de cierre.");
                               noErrors = false;
                               
                            }
                            tags.pop();
                        }

                    }else{
                        System.out.println("Error: " + part + " no tiene etiqueta de apertura.");
                        noErrors = false;
                    }


                    
                }else{
                    tags.push(part);
                }

           }

           
        }

        while(!tags.isEmpty()){
            System.out.println("Error: " + tags.pop() + " no tiene etiqueta de cierre.");

            noErrors = false;
       }
       if(noErrors){
            System.out.println("OK");
       }
        
      

    }

    private static LinkedList<String> tagsSeparator(String line) {
        LinkedList<String> parts = new LinkedList<>();
        int start = 0;
        while (start < line.length()) {
            int openIndex = line.indexOf('<', start);
            if (openIndex == -1) {
                return parts;
            }
            int closeIndex = line.indexOf('>', openIndex);
            if (closeIndex == -1) {
                return parts;
            }
            parts.add(line.substring(openIndex, closeIndex + 1)); 
            start = closeIndex + 1; 
        }
        
        return parts;
    }

}
