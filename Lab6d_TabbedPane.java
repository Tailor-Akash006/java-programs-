package swings;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Lab6d_TabbedPane extends JFrame {

    public Lab6d_TabbedPane() {
        // 1. Setup the Frame
        setTitle("Lab 6d: CMY Tabbed Pane");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 2. Create the Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // 3. Create Panels and add them to the Tabbed Pane
        tabbedPane.addTab("Cyan", createColorPanel(Color.CYAN, "CYAN PANEL"));
        tabbedPane.addTab("Magenta", createColorPanel(Color.MAGENTA, "MAGENTA PANEL"));
        tabbedPane.addTab("Yellow", createColorPanel(Color.YELLOW, "YELLOW PANEL"));

        // 4. Add the Tabbed Pane to the Frame
        add(tabbedPane);

        setVisible(true);
    }

    /**
     * Helper method to create a colored panel with a centered label
     */
    private JPanel createColorPanel(Color color, String text) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        
        // Adding a label to make the selection obvious
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label);
        
        return panel;
    }

    public static void main(String[] args) {
        // Run on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Lab6d_TabbedPane());
    }
}