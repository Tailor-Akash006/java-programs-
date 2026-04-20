package Swings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonApp extends JFrame implements ActionListener {
    // Component declarations
    JButton btnClock, btnHourGlass;
    JLabel lblMessage;

    public ImageButtonApp() {
        // 1. Setup the Frame
        setTitle("Image Button Event Handler");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Load Images (Ensure these files exist in your project directory)
        // Use scaled images to fit the buttons nicely
        ImageIcon clockIcon = new ImageIcon(new ImageIcon("clock.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon hourglassIcon = new ImageIcon(new ImageIcon("hourglass.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        // 3. Initialize Buttons with Images
        btnClock = new JButton("Digital Clock", clockIcon);
        btnHourGlass = new JButton("Hour Glass", hourglassIcon);

        // 4. Initialize Message Label
        lblMessage = new JLabel("Press a button to see the message.");
        lblMessage.setFont(new Font("Arial", Font.BOLD, 14));

        // 5. Register the ActionListeners
        btnClock.addActionListener(this);
        btnHourGlass.addActionListener(this);

        // 6. Add components to the frame
        add(btnClock);
        add(btnHourGlass);
        add(lblMessage);

        setVisible(true);
    }

    // 7. Implement the event handling mechanism
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClock) {
            lblMessage.setText("Digital Clock is pressed");
            lblMessage.setForeground(Color.BLUE);
        } else if (e.getSource() == btnHourGlass) {
            lblMessage.setText("Hour Glass is pressed");
            lblMessage.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new ImageButtonApp());
    }
}