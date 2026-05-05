/**
 * PC Builder Planner GUI
 * This java class provides a graphical user interface for building and managing a custom PC.
 * Users can add, view, sort, and remove parts, as well as check compatibility.
 *
 * @author [Jean M. Alvarez Robles]
 * @version 1.0
 * @since 2026
 */
/*
 * OS: [Mac]
 * IDE: [IntelliJ]
 * Copyright : This is my own original work
 * based on specifications issued by our instructor
 * Academic Honesty: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or
 * unmodified, nor used generative AI as a final draft.
 * I have not given other fellow student(s) access to my program.
 */
package gui;

import model.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PcBuilderGUI extends JFrame {

    // Data Structure used to store parts by category Ex.(GPU, CPU, ETC).
    private HashMap<String, ArrayList<Part>> partsMap;
    // Data Structure used to sort parts by price, from lowest to highest.
    private PriorityQueue<Part> priceQueue;

    private JComboBox<String> partTypeCombo;
    private JTextField nameField;
    private JTextField brandField;
    private JTextField priceField;

    private JTextField spec1Field;
    private JTextField spec2Field;
    private JTextField spec3Field;
    private JTextField spec4Field;

    private JLabel spec1Label;
    private JLabel spec2Label;
    private JLabel spec3Label;
    private JLabel spec4Label;

    // Displays results, messages, and program output
    private JTextArea outputArea;

    // Constructor to initialize GUI layout and main components.
    public PcBuilderGUI() {
        partsMap = new HashMap<>();
        priceQueue = new PriorityQueue<>(Comparator.comparingDouble(Part::getPrice));

        setTitle("PC Builder Planner");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(createTitlePanel(), BorderLayout.NORTH);
        add(createInputPanel(), BorderLayout.WEST);
        add(createOutputPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);

        spec4Label.setVisible(false);
        spec4Field.setVisible(false);

        updateSpecLabels();
    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        JLabel title = new JLabel("PC Builder Planner");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        panel.add(title);
        return panel;
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(16, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Part Information"));

        partTypeCombo = new JComboBox<>(new String[]{
                "CPU", "GPU", "RAM", "Storage", "Motherboard", "Power Supply"
        });

        partTypeCombo.addActionListener(e -> updateSpecLabels());

        nameField = new JTextField();
        brandField = new JTextField();
        priceField = new JTextField();

        spec1Label = new JLabel();
        spec2Label = new JLabel();
        spec3Label = new JLabel();
        spec4Label = new JLabel();

        spec1Field = new JTextField();
        spec2Field = new JTextField();
        spec3Field = new JTextField();
        spec4Field = new JTextField();

        panel.add(new JLabel("Part Type:"));
        panel.add(partTypeCombo);

        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        panel.add(new JLabel("Brand:"));
        panel.add(brandField);

        panel.add(new JLabel("Price:"));
        panel.add(priceField);

        panel.add(spec1Label);
        panel.add(spec1Field);

        panel.add(spec2Label);
        panel.add(spec2Field);

        panel.add(spec3Label);
        panel.add(spec3Field);

        panel.add(spec4Label);
        panel.add(spec4Field);

        return panel;
    }

    private JScrollPane createOutputPanel() {
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setText("Welcome to the PC Builder Planner!\n\nAdd a part to begin.");

        return new JScrollPane(outputArea);
    }

    // Creates the buttons of the GUI and assign actions for user  interaction.
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 3, 10, 10));

        JButton addButton = new JButton("Add Part");
        JButton viewButton = new JButton("View Parts");
        JButton totalButton = new JButton("Show Total");
        JButton sortButton = new JButton("Sort by Price");
        JButton compatibilityButton = new JButton("Check Compatibility");
        JButton removeButton = new JButton ("Remove Part");
        JButton clearButton = new JButton("Clear Output");

        addButton.addActionListener(e -> addPartFromGUI());

        viewButton.addActionListener(e -> viewAllParts());
        totalButton.addActionListener(e -> showTotalPrice());
        sortButton.addActionListener(e -> viewPartsSortedByPrice());
        compatibilityButton.addActionListener(e -> checkCompatibility());
        removeButton.addActionListener(e -> removePartFromGUI());
        clearButton.addActionListener(e -> outputArea.setText(""));

        panel.add(addButton);
        panel.add(viewButton);
        panel.add(totalButton);
        panel.add(sortButton);
        panel.add(compatibilityButton);
        panel.add(removeButton);
        panel.add(clearButton);

        return panel;
    }

    /**
     * Updates input labels dynamically depending on selected part type.
     * It also controls visibility of optional fields
     * */
    private void updateSpecLabels() {
        String type = (String) partTypeCombo.getSelectedItem();

        if (type.equals("CPU")) {
            spec1Label.setText("Cores:");
            spec2Label.setText("Clock Speed (GHz):");
            spec3Label.setText("Socket:");
        } else if (type.equals("GPU")) {
            spec1Label.setText("VRAM (GB):");
            spec2Label.setText("Clock Speed (MHz):");
            spec3Label.setText("Extra Info:");
        } else if (type.equals("RAM")) {
            spec1Label.setText("Capacity (GB):");
            spec2Label.setText("Speed (MHz):");
            spec3Label.setText("Type (DDR4/DDR5):");
        } else if (type.equals("Storage")) {
            spec1Label.setText("Capacity (GB):");
            spec2Label.setText("Type (SSD/HDD):");
            spec3Label.setText("Read Speed (MB/s):");
            spec4Label.setText("Write Speed (MB/s):");

        } else if (type.equals("Motherboard")) {
            spec1Label.setText("Socket:");
            spec2Label.setText("Form Factor:");
            spec3Label.setText("Extra info:");
        } else if (type.equals("Power Supply")) {
            spec1Label.setText("Wattage:");
            spec2Label.setText("Efficiency:");
            spec3Label.setText("Modular (yes/no):");
        }

        spec1Field.setText("");
        spec2Field.setText("");
        spec3Field.setText("");
        spec4Field.setText("");

        boolean isStorage = type.equals("Storage");

        spec4Label.setVisible(isStorage);
        spec4Field.setVisible(isStorage);
    }

    /**
     * Adds a new part based on the user choice.
     * Validates input and stores the part in both Data structures.
     * */
    private void addPartFromGUI() {
        try {
            String type = (String) partTypeCombo.getSelectedItem();
            String name = nameField.getText().trim();
            String brand = brandField.getText().trim();

            if (name.isEmpty() || brand.isEmpty() || priceField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name, brand, and price are required.");
                return;
            }

            // Validate numeric input
            double price = Double.parseDouble(priceField.getText().trim());

            if (price < 0) {
                // Error message for invalid input.
                JOptionPane.showMessageDialog(this, "Price cannot be negative.");
                return;
            }

            Part part = null;

            if (type.equals("CPU")) {
                int cores = Integer.parseInt(spec1Field.getText().trim());
                double clockSpeed = Double.parseDouble(spec2Field.getText().trim());
                String socket = spec3Field.getText().trim();

                part = new Cpu(name, brand, price, cores, clockSpeed, socket);
            } else if (type.equals("GPU")) {
                int vram = Integer.parseInt(spec1Field.getText().trim());
                int clockSpeed = Integer.parseInt(spec2Field.getText().trim());

                part = new Gpu(name, brand, price, vram, clockSpeed);
            } else if (type.equals("RAM")) {
                int capacity = Integer.parseInt(spec1Field.getText().trim());
                int speed = Integer.parseInt(spec2Field.getText().trim());
                String ramType = spec3Field.getText().trim().toUpperCase();

                part = new Ram(name, brand, price, capacity, speed, ramType);
            } else if (type.equals("Storage")) {
                int capacity = Integer.parseInt(spec1Field.getText().trim());
                String storageType = spec2Field.getText().trim();
                int readSpeed = Integer.parseInt(spec3Field.getText().trim());
                int writeSpeed = Integer.parseInt(spec4Field.getText().trim());

                part = new Storage(name, brand, price, capacity, storageType, readSpeed, writeSpeed);
            } else if (type.equals("Motherboard")) {
                String socket = spec1Field.getText().trim();
                String formFactor = spec2Field.getText().trim();

                part = new Motherboard(name, brand, price, socket, formFactor);
            } else if (type.equals("Power Supply")) {
                int wattage = Integer.parseInt(spec1Field.getText().trim());
                String efficiency = spec2Field.getText().trim();
                String modularInput = spec3Field.getText().trim();

                boolean modular = modularInput.equalsIgnoreCase("yes");

                part = new PowerSupply(name, brand, price, wattage, efficiency, modular);
            }

            if (part != null) {
                addPartToDataStructures(part);
                outputArea.setText(part.getName() + " was added successfully!\n\n" + part);
                clearInputFields();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for price and numeric specs.");
        }
    }

    private void addPartToDataStructures(Part part) {
        String category = part.getCategory();

        if (!partsMap.containsKey(category)) {
            partsMap.put(category, new ArrayList<>());
        }

        partsMap.get(category).add(part);
        priceQueue.add(part);
    }

    private void clearInputFields() {
        nameField.setText("");
        brandField.setText("");
        priceField.setText("");
        spec1Field.setText("");
        spec2Field.setText("");
        spec3Field.setText("");
    }

    // Display all the parts currently stored, grouped by category.
    private void viewAllParts() {
        if (partsMap.isEmpty()) {
            outputArea.setText("No parts have been added yet.");
            return;
        }

        StringBuilder sb = new StringBuilder("All Parts in the Build:\n\n");

        for (String category : partsMap.keySet()) {
            sb.append(category).append(":\n");

            for (Part part : partsMap.get(category)) {
                sb.append(part).append("\n");
            }

            sb.append("\n");
        }

        outputArea.setText(sb.toString());
    }

    // Calculates and display the total price of all parts.
    private void showTotalPrice() {
        double total = 0;

        for (ArrayList<Part> list : partsMap.values()) {
            for (Part part : list) {
                total += part.getPrice();
            }
        }

        outputArea.setText("Total Build Price: $" + String.format("%.2f", total));
    }

    // Display parts sorted by price using PriorityQueue
    private void viewPartsSortedByPrice() {
        if (priceQueue.isEmpty()) {
            outputArea.setText("No parts have been added yet.");
            return;
        }

        PriorityQueue<Part> copyQueue = new PriorityQueue<>(priceQueue);
        StringBuilder sb = new StringBuilder("Parts Sorted by Price:\n\n");

        while (!copyQueue.isEmpty()) {
            sb.append(copyQueue.poll()).append("\n");
        }

        outputArea.setText(sb.toString());
    }

    /**
     * Checks compatability between CPU and Motherboard socket
     * */
    private void checkCompatibility() {
        Cpu cpu = null;
        Motherboard motherboard = null;

        if (partsMap.containsKey("CPU") && !partsMap.get("CPU").isEmpty()) {
            cpu = (Cpu) partsMap.get("CPU").get(0);
        }

        if (partsMap.containsKey("Motherboard") && !partsMap.get("Motherboard").isEmpty()) {
            motherboard = (Motherboard) partsMap.get("Motherboard").get(0);
        }

        if (cpu == null || motherboard == null) {
            outputArea.setText("You need at least one CPU and one Motherboard to check compatibility.");
            return;
        }

        if (cpu.getSocket().equalsIgnoreCase(motherboard.getSocket())) {
            outputArea.setText(cpu.getName() + " is compatible with " + motherboard.getName() +
                    " motherboard.\n\nBoth use socket: " + cpu.getSocket());
        } else {
            outputArea.setText(cpu.getName() + " is NOT compatible with " + motherboard.getName() +
                    " motherboard.\n\nCPU Socket: " + cpu.getSocket() +
                    "\nMotherboard Socket: " + motherboard.getSocket());
        }
    }

    /**
     * Removes a part from the system based on the part name and category.
     * Updates both data structures
     * */
    private void removePartFromGUI() {
        String type = (String) partTypeCombo.getSelectedItem();
        String name = nameField.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the name of the part you want to remove.");
            return;
        }

        if (!partsMap.containsKey(type) || partsMap.get(type).isEmpty()) {
            outputArea.setText("No " + type + " parts found to remove.");
            return;
        }

        ArrayList<Part> partsList = partsMap.get(type);
        Part partToRemove = null;

        for (Part part : partsList) {
            if (part.getName().equalsIgnoreCase(name)) {
                partToRemove = part;
                break;
            }
        }

        if (partToRemove != null) {
            partsList.remove(partToRemove);
            priceQueue.remove(partToRemove);

            if (partsList.isEmpty()) {
                partsMap.remove(type);
            }

            outputArea.setText(partToRemove.getName() + " was removed from the build.");
            clearInputFields();
        } else {
            outputArea.setText("No " + type + " part named \"" + name + "\" was found.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PcBuilderGUI gui = new PcBuilderGUI();
            gui.setVisible(true);
        });
    }
}
