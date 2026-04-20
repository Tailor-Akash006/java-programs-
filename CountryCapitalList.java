package swings;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.HashMap;
import java.util.Map;

public class CountryCapitalList extends JFrame {
    private JList<String> countryList;
    private Map<String, String> capitalMap;

    public CountryCapitalList() {
        // 1. Initialize the Capital Map
        capitalMap = new HashMap<>();
        capitalMap.put("USA", "Washington, D.C.");
        capitalMap.put("India", "New Delhi");
        capitalMap.put("Vietnam", "Hanoi");
        capitalMap.put("Canada", "Ottawa");
        capitalMap.put("Denmark", "Copenhagen");
        capitalMap.put("France", "Paris");
        capitalMap.put("Great Britain", "London");
        capitalMap.put("Japan", "Tokyo");
        capitalMap.put("Africa", "N/A (Africa is a Continent)"); // Note: Lab requirement includes Africa
        capitalMap.put("Greenland", "Nuuk");
        capitalMap.put("Singapore", "Singapore");

        // 2. Create the List Model and add countries
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String country : capitalMap.keySet()) {
            listModel.addElement(country);
        }

        // 3. Setup the JList
        countryList = new JList<>(listModel);
        
        // 4. Add Event Handling
        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Check if selection has finished changing
                if (!e.getValueIsAdjusting()) {
                    String selectedCountry = countryList.getSelectedValue();
                    String capital = capitalMap.get(selectedCountry);
                    
                    if (selectedCountry != null) {
                        System.out.println("Country: " + selectedCountry + " | Capital: " + capital);
                    }
                }
            }
        });

        // 5. Frame Setup
        add(new JScrollPane(countryList));
        setTitle("BCA Lab 6c: Country Capitals");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CountryCapitalList());
    }
}