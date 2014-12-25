/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijikstras.algorithm;

import java.util.ArrayList;

/**
 *
 * @author M Faizan Khan
 */
public class Vertex implements Comparable<Vertex> {

    String name;
    ArrayList<Edge> neighbours = new ArrayList();
    //ArrayList<Vertex> inVertices = new ArrayList();
    double weight ;
    Vertex lastVisited;
    
    /**
     * Method to get the edge by its index
     * 
     * @param index
     * @return
     * returns Edge at a particular index 
     */
    public Edge edgeAt(int index){
        return neighbours.get(index);
    }
    
    /**
     * Method to add an edge between two vertices, in which vertex1 is the source and vertex2 is the target
     * Those edges which are already present will not be added
     * 
     * @param E 
     */
    public void addNeighbours(Edge E){
        for(Edge Ed : neighbours){
            if(Ed.target.name.equals(E.target.name))
                return;
        }
        neighbours.add(E);
    }
    
    /**
     * Calculates outDegree of the node
     * 
     * @return size
     */
    public int outDegree(){
        return neighbours.size();
    }
    
    /**
     * Constructor for Vertex class
     * @param NAME 
     */
    public Vertex(String NAME){
        name = NAME;
    }
    
    /**
     * @return
     * String
     */
    @Override
    public String toString() {
        return name;
    }
    
    /**
     * Method to compare two vertices weight
     * 
     * Work for priority queue 
     * 
     * @param Vertex
     * @return int
     */
    @Override
    public int compareTo(Vertex o) {
        return Double.compare(weight, o.weight);
    }

}
