package swings;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListExample extends JFrame {
    private JList<String> countryList;

    public JListExample() {
        // 1. Create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
        listModel.addElement("Singapore");

        // 2. Create the JList with the model
        countryList = new JList<>(listModel);

        // 3. Add Selection Listener (Event Handling)
        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // valueIsAdjusting ensures the event only fires once per click
                if (!e.getValueIsAdjusting()) {
                    List<String> selectedValuesList = countryList.getSelectedValuesList();
                    System.out.println("Selected: " + selectedValuesList);
                }
            }
        });

        // 4. Add to a ScrollPane (important for long lists)
        add(new JScrollPane(countryList));

        // 5. Frame Settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Country Selector");
        this.setSize(300, 400); // Increased size for better visibility
        this.setLocationRelativeTo(null); // Centers the window
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Best practice: Run Swing apps on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> new JListExample());
    }
}