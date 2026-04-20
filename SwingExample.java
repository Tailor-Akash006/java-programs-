package Swings;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * Class Name: SwingExample
 * Lab Exercise: 5a
 */
class SwingExample {
    
    SwingExample() {
        // 1. Create a new JFrame container (the window)
        JFrame jfrm = new JFrame("A Simple Swing Application");

        // 2. Give the frame an initial size (800 width ensures text fits)
        jfrm.setSize(800, 200);

        // 3. Terminate the program when the user closes the application
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4. Create a text-based label with your message
        JLabel jlab = new JLabel(" Hello! VI C , Welcome to Swing Programming!");

        // 5. Set font properties: Verdana, Plain style, size 32
        jlab.setFont(new Font("Verdana", Font.PLAIN, 32));
        
        // 6. Set text color to Blue (RGB: 0, 0, 255)
        jlab.setForeground(new Color(0, 0, 255));

        // 7. Add the label to the content pane of the frame
        jfrm.add(jlab);

        // 8. Center the window on the screen automatically
        jfrm.setLocationRelativeTo(null);

        // 9. Display the frame
        jfrm.setVisible(true);
    }

    public static void main(String args[]) {
        // Create the frame on the event dispatching thread for thread-safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingExample();
            }
        });
    }
}