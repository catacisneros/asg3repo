
/**
 * Defines the panel the drawings will be made in.
 *
 * @author add here name, Panther ID, and class section of all authors
 */
public class GraphDisplay extends JPanel
{
    ArrayList<Point> points;
    double localSearchCost;
    int[] localSearchRoute;

    public GraphDisplay(ArrayList<Point> points,
                        double localSearchCost,
                        int[] localSearchRoute)
    {
        this.points = points;
        this.localSearchCost = localSearchCost;
        this.localSearchRoute = localSearchRoute;
    }

    public void paint(Graphics g)
    {
        //TO IMPLEMENT
    }
}
