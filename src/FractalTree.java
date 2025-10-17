import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {

    private final int MAX_DEPTH = 12;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Start the recursion from the bottom center of the panel
        int startX = getWidth() / 2;
        int startY = getHeight() -50;
        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    /**
     * Recursively draws a fractal tree.
     * @param g The graphics object to draw on.
     * @param x1 The starting x-coordinate of the branch.
     * @param y1 The starting y-coordinate of the branch.
     * @param angle The angle of the branch in degrees.
     * @param depth The current recursion depth.
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        // TODO: Implement the recursive logic here.

        // 1. Base Case (Stopping Condition)
        // If depth is 0, stop the recursion.
        if (depth >= 0) {
            // 2. Recursive Step
            // Calculate the length of the current branch (it should get smaller with depth).
            // Calculate the end point (x2, y2) of the branch using trigonometry.
            // Hint: x2 = x1 + length * cos(angle_in_radians)
            //       y2 = y1 + length * sin(angle_in_radians)
            // Remember to convert the angle to radians: Math.toRadians(angle)
            System.out.println("draw line of tree at depth = " + depth);
            
            
            // int newDepth = depth - 1;
            int x2 = (int) (x1 + depth * 6 * Math.cos((angle / 180) * Math.PI));
            int y2 = (int) (y1 + depth * 7  * Math.sin((angle / 180) * Math.PI)) ;
            
    
            
            // Draw the line for the current branch.
            g.setColor(Color.BLACK);
            
            g.drawLine(x1, y1, x2, y2);
            // Make two recursive calls for the left and right sub-branches.
            // - Branch left by subtracting from the angle (e.g., angle - 20).
            drawTree(g, x2, y2, angle - 15.0, depth - 1);
            // - Branch right by adding to the angle (e.g., angle + 30).
            drawTree(g, x2, y2, angle + 15.0, depth - 1);
            // - Decrease the depth for both calls (depth - 1).

        }

        


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.add(new FractalTree());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
