
/**
 * Iterator class, allows traversal of the set of neighbors
 * of given permutation. There will be n(n-1)/2 neighbors,
 * obtained by swapping all pairs of elements in the permutation.
 *
 * @author add here name, Panther ID, and class section of all authors
 */
public class PermutationNeighborhood
{

    private final int[] p; //permutation
    private final int SIZE; //size of permutation
    private int loc1; //loc1 and loc2 are the locations of
    private int loc2; //p that will be swapped next

    /**
     * Initializes permutation of this object and locations
     * whose values will be swapped.
     *
     * @param a permutation whose neighborhood is to be generated
     */
    public PermutationNeighborhood(int[] a)
    {
        //TO IMPLEMENT
    }

    /**
     * Returns true if at least a neighbor remains to be generated; false
     * otherwise.
     */
    public boolean hasNext()
    {
        //TO IMPLEMENT
    }

    /**
     * Returns next permutation neighbor.
     *
     * @return next permutation neighbor, if one exists; null otherwise
     */
    public int[] next()
    {
        //TO IMPLEMENT
    }
}
