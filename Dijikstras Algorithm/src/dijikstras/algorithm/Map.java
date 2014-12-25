/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | travelingVertexlates
 * and open the template in the editor.
 */
package dijikstras.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author M Faizan Khan
 */
public class Map {

    ArrayList<Vertex> vertices = new ArrayList();
    
    /**
     * Method to add vertex into a Map
     * 
     * @param Vertex
     */
    public void addVertex(Vertex V) {
        vertices.add(V);
    }
    
    /**
     * Method to check whether the vertex is present or not
     * 
     * @param Vertex
     * @return boolean 
     */
    public boolean isPresent(Vertex V) {

        for (int i = 0; i < vertices.size(); i++) {
            if (V.equals(vertices.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method to get total number of vertex present in it 
     * 
     * @return size
     */
    public int size() {
        return vertices.size();
    }
    
    /**
     * Method to get a vertex by its index value
     * 
     * @param index
     * @return Vertex
     * returns null if not found any
     * 
     */
    public Vertex vertexAt(int index) {
        if (index >= size()) {
            return null;
        }
        return vertices.get(index);
    }
    
    /**
     * Method to get a vertex by its name
     * 
     * @param str
     * @return
     * returns null if not found any
     */
    public Vertex vertexOf(String str){
        for (int i = 0; i < size(); i++) {
            if(str.compareTo( vertexAt(i).name ) == 0){
                return vertexAt(i);
            }
        }
        return null;
    }
    
    /**
     * Method to add an edge between to vertex 
     * 
     * It makes an edge from vertex1 to vertex2 , in a directed manner
     * 
     * 
     * @param VERTEX1
     * @param VERTEX2
     * @param WEIGHT
     * @return 
     * Returns false if any of vertex not found or vertex2 is null
     */
    public boolean addEdge(Vertex VERTEX1, Vertex VERTEX2, double WEIGHT) {
        
        if (!isPresent(VERTEX1) && !isPresent(VERTEX2) && VERTEX2 == null) {
            return false;
        }

        VERTEX1.addNeighbours(new Edge(VERTEX2, WEIGHT));
        return true;
    }
    
    /**
     * Helping method for computation which gives every vertex the distance infinity
     */
    private void makeStart(){
        for (int i = 0; i < size(); i++) {
            vertexAt(i).weight = Double.POSITIVE_INFINITY;
            vertexAt(i).lastVisited = null;
        }
    }
    
    /**
     * Method which computes shortest path to every Vertex using Dijiksta's algorithm
     * 
     * @param source 
     */
    public void compute(Vertex source) {
        //Initializing all vertecis
        makeStart();
        
        //The distance to itself iszero0
        source.weight = 0;
        
        //Implementation of a priority queue
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        
        //Adding the source in queue
        queue.add(source);
        
        //Execute while the queue is not empty
        while (!queue.isEmpty()) {
            //queue.poll() removes the head of queue and returns the removed node
            Vertex travelingVertex = queue.poll();
            
            //Loop to traverse each and every neighbour
            for (int i = 0; i < travelingVertex.outDegree() ; i++) {
                
                //Retrieve the target vertex
                Vertex targetVertex = travelingVertex.edgeAt(i).target;
                
                //Get the weight of target vertex
                double weightNew = travelingVertex.weight + travelingVertex.edgeAt(i).weight;
                
                //Condition to check previous
                if (weightNew < targetVertex.weight) {
                    
                    //Removes the previous Vertex if present in queue
                    queue.remove(targetVertex);
                    
                    //Change values
                    targetVertex.weight = weightNew;
                    targetVertex.lastVisited = travelingVertex;
                    
                    //Add it into the queue
                    queue.add(targetVertex);
                    
                }
            }
        }
    }
    
    /**
     * Helping Method to reverse an ArrayList 
     * 
     * @param v
     * @return 
     */
    private ArrayList<Vertex> reverseList(ArrayList<Vertex> v) {
        Collections.reverse(v);
        return v;
    }

    /**
     * Display path to a particular vertex from the source provided when we compute it
     * 
     * @param TARGET
     * @return ArrayList
     * It returns all vertices which comes in path from source to target
     */
    public ArrayList<Vertex> getPathTo(Vertex TARGET) {
        ArrayList<Vertex> path = new ArrayList<Vertex>();
        
        for (Vertex vertex = TARGET; vertex != null; vertex = vertex.lastVisited) {
            path.add(vertex);
        }
        path = reverseList(path);
        return path;
    }
    
    /**
     * Method to display shortest distance and shortest path to every vertex
     */
    public void showAll() {

        for(Vertex v : vertices) {
            show(v);
        }
    }
    
    /**
     * Method to show shortest distance and shortest path to a particular Vertex
     * 
     * @param targetVertex 
     */
    public void show(Vertex targetVertex){
        System.out.println("Distance to " + targetVertex + ": " + targetVertex.weight);
        ArrayList<Vertex> path = getPathTo(targetVertex);
        System.out.println("Path: " + path);
    }
    
    /**
     * Method to delete a particular vertex if present
     * 
     * @param VERTEX 
     */
    public void delete(Vertex VERTEX){
        if(!isPresent(VERTEX)) return;
        
        //Code to delete every edge from other vertices to VERTEX to be deleted
        for(Vertex Traverse : vertices){
            
            //Check every neighbour
            for(int i=0;i<Traverse.outDegree() ;i++){
                
                //If neighbour contains an edge to the vertex than delete the edge
                if( Traverse.neighbours.get(i).target.name.compareTo(VERTEX.name)  == 0 ){
                    Traverse.neighbours.remove(Traverse.neighbours.get(i));
                    
                    //The deleted size decreases
                    i--;
                }
            }
        }
        //Remove vertex from the list
        vertices.remove(VERTEX);
    }
}
