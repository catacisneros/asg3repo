
import java.util.Random;

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
        verticesNumber = 5;
        matrix = new int[verticesNumber][verticesNumber];
    }

    /**
     * Parameterized constructor. Defines an empty graph of n vertices.
     *
     * @param n number of vertices in the graph
     */
    public Graph(int n)
    {
        verticesNumber = n;
        matrix = new int[verticesNumber][verticesNumber];
    }

    /**
     * Parameterized constructor. Creates a graph as defined by the matrix
     * parameter.
     *
     * @param matrix given adjacency matrix
     */
    public Graph(int[][] matrix)
    {
        verticesNumber = matrix.length;
        this.matrix = new int[verticesNumber][verticesNumber];
        for (int i = 0; i < verticesNumber; i++)
            for (int j = 0; j < verticesNumber; j++)
                this.matrix[i][j] = matrix[i][j];
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
        matrix[v][w] = weight;
        matrix[w][v] = weight;
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
        // count adjacent vertices
        int count = 0;
        for (int i = 0; i < verticesNumber; i++)
        {
            if (matrix[v][i] != 0)
                count++;
        }
        // collect them
        int[] adjacent = new int[count];
        int index = 0;
        for (int i = 0; i < verticesNumber; i++)
        {
            if (matrix[v][i] != 0)
            {
                adjacent[index] = i;
                index++;
            }
        }
        return adjacent;
    }

    /**
     * Returns the number of vertices of this graph.
     *
     * @return number of vertices of this graph
     */
    public int getNumberOfVertices()
    {
        return verticesNumber;
    }

    /**
     * Returns weight of edge between given vertices.
     *
     * @param v given vertex
     * @param w given vertex
     * @return weight of edge
     */
    public int getWeight(int v, int w)
    {
        return matrix[v][w];
    }

    /**
     * Removes edge between given vertices.
     *
     * @param v given vertex
     * @param w given vertex
     */
    public void removeEdge(int v, int w)
    {
        matrix[v][w] = 0;
        matrix[w][v] = 0;
    }

    /**
     * Returns a string description of this graph.
     *
     * @return string description of the graph
     */
    public String toString()
    {
        String s = "";
        for (int i = 0; i < verticesNumber; i++)
        {
            for (int j = 0; j < verticesNumber; j++)
            {
                s += matrix[i][j] + " ";
            }
            s += "\n";
        }
        return s;
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
        int n = verticesNumber;
        int totalWeight = 0;
        for (int i = 0; i < n; i++)
        {
            int weight = matrix[a[i]][a[(i + 1) % n]];
            totalWeight += weight;
        }
        return totalWeight;
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
        for (int i = 0; i < a.length; i++)
            a[i] = i;

        Random rnd = new Random();
        for (int i = a.length - 1; i > 0; i--)
        {
            int randomLocation = rnd.nextInt(i + 1);
            if (randomLocation != i)
            {
                int temp = a[i];
                a[i] = a[randomLocation];
                a[randomLocation] = temp;
            }
        }
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
        int RESTARTS = 100;
        int globalBest = Integer.MAX_VALUE;
        int n = verticesNumber;
        int[] currentRoute = new int[n];

        for (int r = 0; r < RESTARTS; r++)
        {
            // generate a new random starting route
            randomPermutation(currentRoute);
            int currentDist = totalDistance(currentRoute);

            boolean improved = true;
            while (improved)
            {
                improved = false;
                PermutationNeighborhood pn = new PermutationNeighborhood(currentRoute);
                while (pn.hasNext())
                {
                    int[] a = pn.next();
                    int neighborDist = totalDistance(a);
                    if (neighborDist < currentDist)
                    {
                        for (int i = 0; i < n; i++)
                            currentRoute[i] = a[i];
                        currentDist = neighborDist;
                        improved = true;
                        break;
                    }
                }
            }

            if (currentDist < globalBest)
            {
                globalBest = currentDist;
                for (int i = 0; i < n; i++)
                    shortestRoute[i] = currentRoute[i];
            }
        }

        return globalBest;
    }
}
