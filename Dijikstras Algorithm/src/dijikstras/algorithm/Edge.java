/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijikstras.algorithm;

/**
 * @author M Faizan Khan
 */
public class Edge {

    public Vertex target;
    public double weight;
    
    /**
     * Constructor for Edge class
     * 
     * @param t
     * @param w 
     */
    public Edge(Vertex t, double w) {
        target = t;
        weight = w;
    }
}
