package com.edu.upb.nolineal.graph.weightedGraph;

import com.edu.upb.array.Array;
import com.edu.upb.nolineal.graph.Node;
import com.edu.upb.stack.list.Stack;

public class Graph<E> {

    private int numNodes;
    private Array<Node<E>> nodes;
    private Array<Array<Integer>> matAd;

    public Graph(int size){
        nodes = new Array<>(size);
        matAd = new Array<>(size);
        for(int ii = 0; ii < size; ii++){
            matAd.add(new Array<>(size));
        }

        for(int ii = 0; ii < size; ii ++){

            for(int jj = 0; jj <size; jj++){
                matAd.get(ii).set(jj, 0);
            }
        }

        numNodes = 0;
    }

    public int pathDistance(Array<E> path){
        Array<Integer> pathIndex = new Array<>(path.size());
        for(int ii = 0; ii < path.size(); ii++){
            pathIndex.set(ii, getNumNode( path.get(ii)));
            
        }

        int distance = 0;

        for(int ii = 0; ii < pathIndex.lenght() - 1; ii++){
            distance += matAd.get(pathIndex.get(ii)).get(pathIndex.get(ii + 1));
        }
        
        return distance;

    }

    public  Array<E> ShortestPath(E fromElement, E toElement) {

        int from = getNumNode(fromElement);
        int to = getNumNode(toElement);

        if(from == -1 || to  == -1){
            return new Array<>(1);
        }

        int numNodes = getNumNodes();
        int[] dist = new int[numNodes]; // Its use normal array to distance to use Integer.MAX_VALUE
        Array<Integer> pathArray = new Array<>(numNodes);
        Array<Boolean> visited = new Array<>(numNodes);

        // Initialaize distance as Infinite(Max value)
        for(int ii = 0; ii < numNodes; ii++){
            dist[ii] = Integer.MAX_VALUE;
        }
        for(int ii = 0; ii < numNodes; ii++){
           visited.add(false);
        }
        for(int ii = 0; ii < numNodes; ii++){
            pathArray.add(-1);
        }

        dist[from] = 0;

        
        for (int i = 0; i < numNodes - 1; i++) {
           
            int minDistNode = minDistance(dist, visited);
            
            visited.set(minDistNode, true);
           
            for (int jj = 0; jj < numNodes; jj++) {
                if (!visited.get(jj)&& getMatAd().get(minDistNode).get(jj) != 0 &&
                        dist[minDistNode] != Integer.MAX_VALUE &&
                        dist[minDistNode] + getMatAd().get(minDistNode).get(jj)  < dist[jj]) {
                    dist[jj] = dist[minDistNode] + getMatAd().get(minDistNode).get(jj) ;
                    pathArray.set(jj, minDistNode);
                    
                }
            }
        }

        Stack<Integer> path = new Stack<>();
        int current = to;
        
        while (pathArray.get(current)!= -1) {
            path.push(current);
            current = pathArray.get(current);
        }
        path.push(from);

        // Convertir el camino en un array
        Array<E> shortestPath = new Array<>(path.size());
        for (int ii = 0; ii < shortestPath.lenght(); ii++) {
           shortestPath.add( nodes.get(path.pop()).getElement());
        }

        return shortestPath;
    }

    // 
    private int minDistance(int[] dist, Array<Boolean> visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int ii = 0; ii < dist.length; ii++) {
            if (!visited.get(ii) && dist[ii] <= min) {
                min = dist[ii];
                minIndex = ii;
            }
        }

        return minIndex;
    }



    public int getNumNodes() {
        return numNodes;
    }



    public Array<Node<E>> getNodes() {
        return nodes;
    }



    public Array<Array<Integer>> getMatAd() {
        return matAd;
    }



    public boolean addNode(E element){
        try{

            for(int ii = 0; ii < nodes.size(); ii++){
                if(nodes.get(ii).getElement().equals(element)){
                    return false;
                }
            }

            Node<E> newNode = new Node<>(element, numNodes);
            numNodes++;
            nodes.add(newNode);

        }catch(Exception e){
            return false;
        }
        
        return true;
    }

    public int getNumNode(E element){

        for(int ii = 0; ii < nodes.size(); ii++){
            if(nodes.get(ii).getElement().equals(element)){
                return ii;
            }
        }
        return -1;
    }
    
    public boolean addEdge(E firstNode, E secondNode, int weight){
        int fNode , sNode;
        fNode = getNumNode(firstNode);
        sNode = getNumNode(secondNode);

        if(fNode < 0 || sNode < 0){
            return false;
        }
        matAd.get(fNode).set(sNode, weight);
        matAd.get(sNode).set(fNode, weight);
        return true;
    }

    public boolean addEdge(int firstNode, int secondNode, int weight){

        if(firstNode < 0 || secondNode < 0){
            return false;
        }
        matAd.get(firstNode).set(secondNode, weight);
        matAd.get(secondNode).set(firstNode, weight);
        return true;
    }
    

    @Override
    public String toString() {
        String toRet = "    ";
        
        for(int ii = 0; ii < nodes.lenght(); ii ++){
            toRet += ii + "  ";
        }
        toRet += "\n";

        for(int ii = 0; ii < matAd.lenght(); ii++){
            toRet +=  ii + "  "+  matAd.get(ii).toString() + "\n";
        }

        return toRet;
    }

}
