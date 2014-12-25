/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijikstras.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * 
 * @author M Faizan Khan
 */
public class DijikstrasAlgorithm {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args)
    {
        implementation();
    }
    
    public static void implementation(){
        
        /*          5
                B * * * *D   
          4   * *       ** *  
            *   *      * *   *  6
          *     *     *  *     *
        A     1 *  8 *   * 2     F   
          *     *   *    *     *
            *   *  *     *   *  3
          2   * * *      * *   
                C * * * *E
                    10
        */
        
        Map map = new Map();
        map.addVertex(new Vertex("A"));
        map.addVertex(new Vertex("B"));
        map.addVertex(new Vertex("C"));
        map.addVertex(new Vertex("D"));
        map.addVertex(new Vertex("E"));
        map.addVertex(new Vertex("F"));
        map.addVertex(new Vertex("G"));
        
        map.addEdge(map.vertexOf("A"), map.vertexOf("B"), 4);
	map.addEdge(map.vertexOf("A"), map.vertexOf("C"), 2);
        
        map.addEdge(map.vertexOf("B"), map.vertexOf("A"), 4);
        map.addEdge(map.vertexOf("B"), map.vertexOf("C"), 1);
        map.addEdge(map.vertexOf("B"), map.vertexOf("D"), 5);
        
        map.addEdge(map.vertexOf("C"), map.vertexOf("A"), 2);
        map.addEdge(map.vertexOf("C"), map.vertexOf("B"), 1);
        map.addEdge(map.vertexOf("C"), map.vertexOf("D"), 8);
        map.addEdge(map.vertexOf("C"), map.vertexOf("E"), 10);
	
        map.addEdge(map.vertexOf("D"), map.vertexOf("B"), 5);
        map.addEdge(map.vertexOf("D"), map.vertexOf("C"), 8);
        map.addEdge(map.vertexOf("D"), map.vertexOf("E"), 2);
        map.addEdge(map.vertexOf("D"), map.vertexOf("F"), 6);
        
	map.addEdge(map.vertexOf("E"), map.vertexOf("C"), 10);
        map.addEdge(map.vertexOf("E"), map.vertexOf("D"), 2);
        map.addEdge(map.vertexOf("E"), map.vertexOf("F"), 3);
        
        map.addEdge(map.vertexOf("F"), map.vertexOf("D"), 6);
        map.addEdge(map.vertexOf("F"), map.vertexOf("E"), 3);
        
        map.compute(map.vertexOf("A"));
        map.showAll();
    }
    
}
