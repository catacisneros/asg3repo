
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import java.util.ArrayList;

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
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // white background
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // title at top
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("SansSerif", Font.BOLD, 14));
        g2.drawString("Shortest Route Obtained With Local Search:", 10, 20);

        // draw route edges
        g2.setColor(new Color(70, 130, 180));
        g2.setStroke(new BasicStroke(2));
        int n = localSearchRoute.length;
        for (int i = 0; i < n; i++)
        {
            int from = localSearchRoute[i];
            int to = localSearchRoute[(i + 1) % n];
            g2.drawLine(points.get(from).x, points.get(from).y,
                    points.get(to).x, points.get(to).y);
        }

        // draw city points
        int radius = 8;
        for (int i = 0; i < points.size(); i++)
        {
            int x = points.get(i).x;
            int y = points.get(i).y;

            g2.setColor(new Color(255, 200, 50));
            g2.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

            g2.setColor(Color.DARK_GRAY);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        }

        // display total distance at bottom
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("SansSerif", Font.BOLD, 14));
        g2.drawString("Shortest Route Total Distance: " + (int) localSearchCost,
                10, getHeight() - 15);
    }
}
