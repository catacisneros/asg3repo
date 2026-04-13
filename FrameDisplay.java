
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Defines a frame to which a panel with drawings will be added.
 *
 * @author add here name, Panther ID, and class section of all authors
 */
public class FrameDisplay extends JFrame
{
    int WIDTH = 650;
    int HEIGHT = 650;

    public FrameDisplay(ArrayList<Point> points,
                        double localSearchCost,
                        int[] localSearchRoute)
    {
        setTitle("Shortest Route Obtained With Local Search");
        setSize(WIDTH, HEIGHT);
        GraphDisplay panel = new GraphDisplay(points, localSearchCost, localSearchRoute);
        add(panel);
    }
}
