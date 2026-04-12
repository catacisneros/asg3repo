
/**
 * Implements a Graph. Uses an adjacency matrix to represent the graph.
 *
 * @author add here name, Panther ID, and class section of all authors
 */
public class Graph implements GraphInterface
{

    private int[][] matrix; //adjacency matrix
    private int verticesNumber;

    /**
     * Default constructor. Defines an empty graph of 5 vertices.
     */
    public Graph()
    {
        //TO IMPLEMENT
    }

    /**
     * Parameterized constructor. Defines an empty graph of n vertices.
     *
     * @param n number of vertices in the graph
     */
    public Graph(int n)
    {
        //TO IMPLEMENT
    }

    /**
     * Parameterized constructor. Creates a graph as defined by the matrix
     * parameter.
     *
     * @param matrix given adjacency matrix
     */
    public Graph(int[][] matrix)
    {
        //TO IMPLEMENT
    }

    /**
     * Adds an edge between given vertices with given weight.
     *
     * @param v given vertex
     * @param w given vertex
     * @param weight given weight
     */
    public void addEdge(int v, int w, int weight)
    {
        //TO IMPLEMENT
    }

    /**
     * Finds vertices adjacent to a given vertex.
     *
     * @param v given vertex
     * @return list of vertices adjacent to v stored in an array; size of array
     * = number of adjacent vertices
     */
    public int[] findAdjacencyVertices(int v)
    {
        //TO IMPLEMENT
    }

    /**
     * Returns the number of vertices of this graph.
     *
     * @return number of vertices of this graph
     */
    public int getNumberOfVertices()
    {
        //TO IMPLEMENT
    }

    /**
     * Returns weight of edge between given vertices.
     *
     * @param v given vertex
     * @param w given vertex
     * @return
     */
    public int getWeight(int v, int w)
    {
        //TO IMPLEMENT
    }

    /**
     * Removes edge between given vertices.
     *
     * @param v given vertex
     * @param w given vertex
     */
    public void removeEdge(int v, int w)
    {
        //TO IMPLEMENT
    }

    /**
     * Returns a string description of this graph.
     *
     * @return string description of the graph
     */
    public String toString()
    {
        //TO IMPLEMENT
    }

    /**
     * Calculates distance of given route.
     *
     * @param a route
     *
     * @return distance of route
     */
    private int totalDistance(int[] a)
    {
        //TO IMPLEMENT
    }

    /**
     * Given an array, generates random permutation of values in [0, n-1],
     * where n is size of given array; random permutation will be stored
     * in the array. Uses Fisher-Yates shuffle algorithm.
     *
     * @param a output array
     */
    private void randomPermutation(int[] a)
    {
        //TO IMPLEMENT
    }

    /**
     * Finds a shortest route that visits every vertex
     * exactly once and returns to the starting point.
     * Uses local search, so optimal solution is not
     * obtained, in general.
     *
     * @param shortestRoute array with a shortest path (return value)
     *
     * @return shortest distance
     */
    public int TSP_localSearch(int[] shortestRoute)
    {
        //TO IMPLEMENT
    }
}
