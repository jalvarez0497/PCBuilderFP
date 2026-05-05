/**
 * Main works as the console base application. This was done before the GUI program, and was keep in case the GUI program fails.
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
package driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

import model.*;

/**
 * Main driver class for the Computer Builder Program
 * Handles user interaction, menu navigation, and program flow.*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // HashMap is used to store parts grouped by category Ex.(GPU, CPU, RAM, etc)
        // Key = Category, Value = list of parts in that particular category
        HashMap<String, ArrayList<Part>> partsMap = new HashMap<>();

        // PrioriryQueue is used to automatically sort parts by price, from lowest to highest
        PriorityQueue<Part> priceQueue = new PriorityQueue<>(Comparator.comparingDouble(Part::getPrice));

        boolean keepRunning = false;

        // Main program loop. It continues until the user chooses to exit.
        while (!keepRunning) {
            System.out.println("Computer Builder Planner");
            System.out.println("1. Add Part");
            System.out.println("2. View All Parts");
            System.out.println("3. Show Build Price");
            System.out.println("4. Check CPU and Motherboard compatability");
            System.out.println("5. View Parts Sorted by Price");
            System.out.println("6. Exit");

            int choice = getValidInt(sc, "Choose and option: ");

            if (choice < 1 || choice > 6) {
                System.out.println("Invalid option. Try again.");
                continue;
            }

            // Handles user menu selection and call for corresponding methods or features.
            switch (choice) {
                case 1:
                    addPart(sc, partsMap, priceQueue);
                    break;

                case 2:
                    if (partsMap.isEmpty()) {
                        System.out.println("No parts added to the build yet");
                    } else {
                        System.out.println("Parts List");
                        for (String category : partsMap.keySet()) {
                            System.out.println("\nCategory: " + category);

                            for (Part part : partsMap.get(category)) {
                                System.out.println(part);
                            }
                        }
                    }
                    break;

                case 3:
                    double total = 0.0;
                    for (ArrayList<Part> list : partsMap.values()) {
                        for (Part part : list) {
                            total += part.getPrice();
                        }
                    }
                    System.out.println("Total Build price: $" + total);

                    break;

                // Case 4 checks compatibility between CPU and Motherboard based on the socket type
                case 4:
                    Cpu cp = null;
                    Motherboard mb = null;

                    if (partsMap.containsKey("CPU")) {
                        cp = (Cpu) partsMap.get("CPU").get(0);
                    }

                    if (partsMap.containsKey("Motherboard")) {
                        mb = (Motherboard) partsMap.get("Motherboard").get(0);
                    }

                    if (cp != null && mb != null) {
                        if (cp.getSocket().equalsIgnoreCase(mb.getSocket())) {
                            System.out.println(cp.getName() + " is compatible with Motherboard: " + mb.getName());
                        } else {
                            System.out.println(cp.getName() + " is NOT compatible with Motherboard: " + mb.getName());
                        }
                    } else {
                        System.out.println("You need at least one CPU and one Motherboard.");
                    }
                    break;

                case 5:
                    viewPartsSortedByPrice(priceQueue);

                case 6:
                    keepRunning = true;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        sc.close();
    }

    // Allows user to add different types of PC parts and stores them in data structures
    public static void addPart(Scanner sc, HashMap<String, ArrayList<Part>> partsMap, PriorityQueue<Part> priceQueue) {
        System.out.println("\n---Select a part to add---\n");
        System.out.println("1. CPU");
        System.out.println("2. GPU");
        System.out.println("3. RAM");
        System.out.println("4. Storage");
        System.out.println("5. Motherboard");
        System.out.println("6. Power Supply");
        System.out.println("7. Back to main menu");

        int choice = getValidInt(sc, "Choose part to add: ");

        if (choice < 1 || choice > 7) {
            System.out.println("Invalid choice.");
            return;
        }

        switch(choice) {
            case 1:
                System.out.println("---Enter CPU information---");

                System.out.print("Name: ");
                String cpuName = sc.nextLine();

                System.out.print("Brand: ");
                String cpuBrand = sc.nextLine();

                double cpuPrice = getValidDouble(sc, "Price: ");

                int cpuCores = getValidInt(sc, "Cores: ");

                double cpuClockSpeed = getValidDouble(sc, "Clock Speed (GHz): ");

                System.out.print("Socket: ");
                String cpuSocket = sc.nextLine();

                // Create CPU object base on what the user input
                Cpu cpu = new Cpu(cpuName, cpuBrand, cpuPrice, cpuCores, cpuClockSpeed, cpuSocket);

                String cpuCategory = cpu.getCategory();

                if (!partsMap.containsKey(cpuCategory)) {
                    partsMap.put(cpuCategory, new ArrayList<>());
                }

                // Adding CPU to HashMap and PriorityQueue
                partsMap.get(cpuCategory).add(cpu);
                priceQueue.add(cpu);

                System.out.println("CPU added to the build.");

                break;

            case 2:
                System.out.println("---Enter GPU information---");

                System.out.print("Name: ");
                String gpuName = sc.nextLine();

                System.out.print("Brand: ");
                String gpuBrand = sc.nextLine();

                double gpuPrice = getValidDouble(sc, "Price: ");

                int gpuVram = getValidInt(sc, "GPU vRam: ");

                int gpuClockSpeed = getValidInt(sc, "GPU clock speed: ");

                // Create GPU object base on what the user input
                Gpu gpu = new Gpu(gpuName, gpuBrand, gpuPrice, gpuVram, gpuClockSpeed);

                String gpuCategory = gpu.getCategory();

                if (!partsMap.containsKey(gpuCategory)) {
                    partsMap.put(gpuCategory, new ArrayList<>());
                }

                // Adding GPU to HashMap and PriorityQueue
                partsMap.get(gpuCategory).add(gpu);
                priceQueue.add(gpu);

                System.out.println("GPU added to the build.");

                break;

            case 3:
                System.out.println("---Enter RAM information---");

                System.out.print("Name: ");
                String ramName = sc.nextLine();

                System.out.print("Brand: ");
                String ramBrand = sc.nextLine();

                double ramPrice = getValidDouble(sc, "Price: ");

                int ramCapacity = getValidInt(sc, "Capacity (GB): ");

                int ramSpeed = getValidInt(sc, "Speed: ");

                System.out.print("Type (DDR4, DDR5): ");
                String ramType = sc.nextLine().toUpperCase();

                // Create RAM object base on what the user input
                Ram ram = new Ram(ramName, ramBrand, ramPrice, ramCapacity, ramSpeed, ramType);

                String ramCategory = ram.getCategory();

                if (!partsMap.containsKey(ramCategory)) {
                    partsMap.put(ramCategory, new ArrayList<>());
                }

                // Adding RAM to HashMap and PriorityQueue
                partsMap.get(ramCategory).add(ram);
                priceQueue.add(ram);

                System.out.println("RAM added to the build.");

                break;

            case 4:
                System.out.println("---Enter Storage information---");

                System.out.print("Name: ");
                String storageName = sc.nextLine();

                System.out.print("Brand: ");
                String storageBrand = sc.nextLine();

                double storagePrice = getValidDouble(sc, "Price: ");

                int storageCapacity = getValidInt(sc, "Capacity (GB, TB): ");

                System.out.print("Type (SSD, HDD): ");
                String storageType = sc.nextLine();

                int storageReadSpeed = getValidInt(sc, "Read speed: ");

                int storageWriteSpeed = getValidInt(sc, "Write speed: ");

                // Create Storage object base on what the user input
                Storage storage = new Storage(storageName, storageBrand, storagePrice, storageCapacity, storageType, storageReadSpeed, storageWriteSpeed);

                String storageCategory = storage.getCategory();

                if (!partsMap.containsKey(storageCategory)) {
                    partsMap.put(storageCategory, new ArrayList<>());
                }

                // Adding Storage to HashMap and PriorityQueue
                partsMap.get(storageCategory).add(storage);
                priceQueue.add(storage);

                System.out.println("Storage added to the build.");

                break;

            case 5:
                System.out.println("--- Enter Motherboard information ---");

                System.out.print("Name: ");
                String mbName = sc.nextLine();

                System.out.print("Brand: ");
                String mbBrand = sc.nextLine();

                double mbPrice = getValidDouble(sc, "Price: ");

                System.out.print("Socket: ");
                String mbSocket = sc.nextLine();

                System.out.print("Form Factor: ");
                String mbFormFactor = sc.nextLine();

                // Create Motherboard object base on what the user input
                Motherboard motherboard = new Motherboard(mbName, mbBrand, mbPrice, mbSocket, mbFormFactor);

                String mbCategory = motherboard.getCategory();

                if (!partsMap.containsKey(mbCategory)) {
                    partsMap.put(mbCategory, new ArrayList<>());
                }

                // Adding Motherboard to HashMap and PriorityQueue
                partsMap.get(mbCategory).add(motherboard);
                priceQueue.add(motherboard);

                System.out.println("Motherboard added to the build.");
                break;

            case 6:
                System.out.println("--- Enter Power Supply information ---");

                System.out.print("Name: ");
                String psuName = sc.nextLine();

                System.out.print("Brand: ");
                String psuBrand = sc.nextLine();

                double psuPrice = getValidDouble(sc, "Price: ");

                int psuWattage = getValidInt(sc, "Wattage: ");

                System.out.print("Efficiency (Bronze, Silver, Gold): ");
                String psuEfficiency = sc.nextLine();

                System.out.print("Modular (yes/no): ");
                String modularInput = sc.nextLine();

                boolean isPsuModular = modularInput.equalsIgnoreCase("yes");

                // Create Power Supply object base on what the user input
                PowerSupply psu = new PowerSupply(psuName, psuBrand, psuPrice, psuWattage, psuEfficiency, isPsuModular);

                String psuCategory = psu.getCategory();

                if (!partsMap.containsKey(psuCategory)) {
                    partsMap.put(psuCategory, new ArrayList<>());
                }

                // Adding Power Supply to HashMap and PriorityQueue
                partsMap.get(psuCategory).add(psu);
                priceQueue.add(psu);

                System.out.println("Power Supply added to the build.");
                break;

            case 7:
                System.out.println("Returning to main menu.");
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void viewPartsSortedByPrice (PriorityQueue<Part> priceQueue) {
        if (priceQueue.isEmpty()) {
            System.out.println("No parts added yet.");
            return;
        }

        PriorityQueue<Part> copyQueue = new PriorityQueue<>(priceQueue);

        System.out.println("Parts Sorted by Price");

        while (!copyQueue.isEmpty()) {
            System.out.println(copyQueue.poll());
        }
    }

    // Ensures users enters a valid integer number
    public static int getValidInt(Scanner sc, String message) {
        boolean isValid = false;
        int value = 0;

        while (!isValid) {
            System.out.print(message);

            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();

                if (value >= 0) {
                    isValid = true;
                } else {
                    System.out.println("Value cannot be negative. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
        return value;
    }

    // Ensures users enter a valid decimal number
    public static double getValidDouble(Scanner sc, String message) {
        boolean isValid = false;
        double value = 0;

        while (!isValid) {
            System.out.print(message);

            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                sc.nextLine();

                if (value >= 0) {
                    isValid = true;
                } else {
                    System.out.println("Value cannot be negative. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }
        return value;
    }
}
