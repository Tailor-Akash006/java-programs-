package swings;

import java.awt.Color;
import javax.swing.*;

public class TabbedPaneExample {
    JFrame f;

    TabbedPaneExample() {
        f = new JFrame("JTabbedPane Demo");

        // 1. Create different panels (the content for each tab)
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        // 2. Set backgrounds so you can see the change
        p1.setBackground(Color.BLUE);
        p2.setBackground(Color.RED);
        p3.setBackground(Color.GREEN);

        // 3. Create the TabbedPane and add tabs
        JTabbedPane tp = new JTabbedPane();
        
        // Setting bounds because you are using null layout on the frame
        tp.setBounds(50, 50, 300, 250);
        
        tp.add("BLUE", p1);
        tp.add("RED", p2);
        tp.add("GREEN", p3);

        // 4. Final Frame setup
        f.add(tp);
        f.setSize(400, 400);
        f.setLayout(null); // Absolute positioning
        f.setLocationRelativeTo(null); // Center on screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        // Run on the UI thread for best performance
        SwingUtilities.invokeLater(() -> new TabbedPaneExample());
    }
}