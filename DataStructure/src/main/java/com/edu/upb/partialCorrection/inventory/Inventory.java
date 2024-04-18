package com.edu.upb.partialCorrection.inventory;

import java.util.function.Function;
import com.edu.upb.array.Array;
import com.edu.upb.util.iterator.Iterator;
/*
 * Implementar un componente para gestionar el inventario de personaje de un juego. Cada ítem debe tener 
las siguientes propiedades: Item name (string); Priority (integer: 0 a 4); Rank (integer: 0 a 1000); Type 
(enum: cloth, leather, plate); Durability (integer: 0 a 1); Y description (string). El inventario consta de 4 
bolsas con 8 o 12 o 14 slots. La bosas cambian en el tiempo de juego. Al inicio del juego solo se tiene una 
bolsa es de 8 slots. El componente debe tener la capacidad de: Agrega una bolsa al inventario. Agrega un 
ítem a la bolsa por prioridad (0 es la mayor prioridad). Si la bolsa está llena pasará a la siguiente. Si el ítem 
ya se encuentra en la bolsa los apila en el mismo lugar. Desplegar una lista priorizada de ítems. 
Intercambia dos ítems de lugar al otro en el inventario. Las bolsas pueden ir en cualquier orden y se 
pueden eliminar junto con todos los ítems. 
 */
public class Inventory {
    
    Array<Bag> inventory;

    public Inventory(){
        inventory = new Array<>(4);
        inventory.add(new Bag(8));
    }

    public boolean addBag(int amtSlots, int indexBag){
        if((amtSlots != 8) && (amtSlots != 12 )&& (amtSlots != 14) ){
            return false;
        }

        if(inventory.get(indexBag) == null){
            inventory.set(indexBag, new Bag(amtSlots));
        }else{
            inventory.get(indexBag).dimension(amtSlots);
        }
        
        return true;

    }

    public boolean addItem(Item item){
        Bag bag;
        Function<Item, Void> sumAmtItem = new Function<Item,Void>() {

            @Override
            public Void apply(Item t) {
                if(t.getName().equals(item.getName())){
                    t.setAmt(t.getAmt() + 1);
                }
                return null;
            }
            
        };

        for(int ii = 0; ii < inventory.lenght(); ii++){
            bag = inventory.get(ii);
            if(bag.exist(item)){
                bag.forEach(sumAmtItem);
                return true;
            }
            if(bag.hasSpace()){
                bag.add(item);
                return true;
            }

        }
        return false;

    }

    public boolean exchangeItems(Item item1, int bag1Index, Item item2, int bag2Index){
        Item extracted;
        Bag tempBag1 = new Bag(20);
        Bag tempBag2 = new Bag(20);
        boolean item1Founded = false;
        boolean item2Founded = false;
        Bag bag1 = inventory.get(bag1Index);
        Bag bag2 = inventory.get(bag2Index);

        if(!bag1.exist(item1)){
            return false;
        }

        if(!bag2.exist(item2)){
            return false;
        
        }
        //----

        while(!item1Founded){
            extracted = bag1.extract();

            if(extracted.equals(item1)){
                bag1.add(item2);
                item1Founded = true;
            }else{
                tempBag1.add(extracted);
            }
        }

        while(!tempBag1.isEmpty()){
            bag1.add(tempBag1.extract());
        }

        //-----
    
        while(!item2Founded){
            extracted = bag2.extract();

            if(extracted.equals(item2)){
                bag2.add(item1);
                item2Founded = true;
            }else{
                tempBag2.add(extracted);
            }
        }

        while(!tempBag2.isEmpty()){
            bag2.add(tempBag2.extract());
        }

        
        return true;
    }

    public boolean deleteBags(int index){
        return inventory.remove(index);
    }

    public void deployInventory(){

        for(int ii = 0; ii < inventory.lenght(); ii++){
            System.out.println("Bolsa " + ii + ": \n");
            System.out.println(inventory.get(ii).toString());
        }

    }

    public void deployPriorizedListOfItems(){

        Bag generalInventory = new Bag(amtItems());

        for(int ii = 0; ii < inventory.lenght(); ii++){
            Iterator<Item> iter = inventory.get(ii).iterator();
            while(iter.hasNext()){
                generalInventory.add(iter.next());
            }
        }



            System.out.println("Todos los items organizados por prioridad: \n");
            System.out.println(generalInventory.toString());


    }

    private int amtItems(){
        int amtItems = 0;

        for (int ii = 0; ii < inventory.lenght(); ii++){
            if(inventory.get(ii) != null){
                amtItems += inventory.get(ii).size();
            }

        }
        return amtItems;
    

    }

}
