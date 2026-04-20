package Swings;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonExample {
    JLabel l1;

    ButtonExample() {
        JFrame f = new JFrame("Image Button Example");
        
        l1 = new JLabel("Click a button", SwingConstants.CENTER);
        l1.setBounds(50, 50, 700, 100);
        // Using a slightly smaller font size to ensure it fits the screen
        l1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 40));

        // --- 1. Load and Scale Images ---
        // Make sure clock.png and hourglass.png are in your project folder
        ImageIcon clockIcon = new ImageIcon(new ImageIcon("clock.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon hourglassIcon = new ImageIcon(new ImageIcon("hourglass.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        // --- 2. Initialize Buttons with Text and Images ---
        JButton b1 = new JButton("Digital Clock", clockIcon);
        JButton b2 = new JButton("Hour Glass", hourglassIcon);

        // Adjusting bounds to fit the text + image
        b1.setBounds(100, 200, 200, 100);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Digital Clock is pressed");
            }
        });

        b2.setBounds(400, 200, 200, 100);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Hour Glass is pressed");
            }
        });

        // --- 3. Finalize Frame ---
        f.add(b1);
        f.add(b2);
        f.add(l1);
        
        f.setSize(800, 500); // Increased width to fit the large font and buttons
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ButtonExample();
    }
}