/**
 * Program description
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
import java.util.Scanner;

import model.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Part> partsList = new ArrayList<>();

        Cpu cpu = null;
        Motherboard motherboard = null;

        boolean keepRunning = false;

        while (!keepRunning) {
            System.out.println("Computer Builder Planner");
            System.out.println("1. Add Part");
            System.out.println("2. View All Parts");
            System.out.println("3. Show Build Price");
            System.out.println("4. Check CPU and Motherboard compatability");
            System.out.println("5. Exit");

            System.out.println("\nChoose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addPart(sc, partsList);
                    break;

                case 2:
                    if (partsList.isEmpty()) {
                        System.out.println("No parts added to the build yet");
                    } else {
                        System.out.println("Parts List");
                        for (Part part : partsList) {
                            System.out.println(part);
                        }
                    }
                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:
                    keepRunning = true;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        sc.close();
    }

    public static void addPart(Scanner sc, ArrayList<Part> partsList) {
        System.out.println("\n---Select a part to add---\n");
        System.out.println("1. CPU");
        System.out.println("2. GPU");
        System.out.println("3. RAM");
        System.out.println("4. Storage");
        System.out.println("5. Motherboard");
        System.out.println("6. Power Supply");
        System.out.println("7. Back to main menu");

        System.out.print("Choose part to add: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice) {
            case 1:
                System.out.println("---Enter CPU information---");

                System.out.print("Name: ");
                String cpuName = sc.nextLine();

                System.out.print("Brand: ");
                String cpuBrand = sc.nextLine();

                System.out.print("Price: ");
                double cpuPrice = sc.nextDouble();

                System.out.print("Cores: ");
                int cpuCores = sc.nextInt();

                System.out.print("Clock Speed: ");
                int cpuClockSpeed = sc.nextInt();
                sc.nextLine();

                System.out.print("Socket: ");
                String cpuSocket = sc.nextLine();

                Cpu cpu = new Cpu(cpuName, cpuBrand, cpuPrice, cpuCores, cpuClockSpeed, cpuSocket);

                System.out.println("CPU added to the build.");

                break;

            case 2:
                System.out.println("---Enter GPU information---");

                System.out.print("Name: ");
                String gpuName = sc.nextLine();

                System.out.print("Brand: ");
                String gpuBrand = sc.nextLine();

                System.out.print("Price: ");
                double gpuPrice = sc.nextDouble();

                System.out.print("Chipset: ");
                String gpuChipset = sc.nextLine();

                System.out.print("vRam: ");
                int gpuVram = sc.nextInt();

                System.out.print("Clock Speed: ");
                int gpuClockSpeed = sc.nextInt();

                System.out.print("Power Usage: ");
                int gpuPowerUsage = sc.nextInt();

                Gpu gpu = new Gpu(gpuName, gpuBrand, gpuPrice, gpuChipset, gpuVram, gpuClockSpeed, gpuPowerUsage);

                System.out.println("GPU added to the build.");

                break;

            case 3:
                System.out.println("---Enter RAM information---");

                System.out.print("Name: ");
                String ramName = sc.nextLine();

                System.out.print("Brand: ");
                String ramBrand = sc.nextLine();

                System.out.print("Price: ");
                double ramPrice = sc.nextDouble();

                System.out.print("Capacity (GB): ");
                int ramCapacity = sc.nextInt();

                System.out.print("Speed: ");
                int ramSpeed = sc.nextInt();

                System.out.print("Type (DDR4, DDR5): ");
                String ramType = sc.nextLine();

                Ram ram = new Ram(ramName, ramBrand, ramPrice, ramCapacity, ramSpeed, ramType);

                System.out.println("RAM added to the build.");

                break;

            case 4:
                System.out.println("---Enter Storage information---");

                System.out.print("Name: ");
                String storageName = sc.nextLine();

                System.out.print("Brand: ");
                String storageBrand = sc.nextLine();

                System.out.print("Price: ");
                double storagePrice = sc.nextDouble();

                System.out.print("Capacity (GB, TB): ");
                int storageCapacity = sc.nextInt();

                System.out.print("Type (SSD, HDD): ");
                String storageType = sc.nextLine();

                System.out.print("Read speed: ");
                int storageReadspeed = sc.nextInt();

                System.out.print("Write speed: ");
                int storageWriteSpeed = sc.nextInt();

                Storage storage = new Storage(storageName, storageBrand, storagePrice, storageCapacity, storageType, storageReadspeed, storageWriteSpeed);

                System.out.println("Storage added to the build.");

                break;

            case 5:
                System.out.println("---Enter Power Supply information---");

                System.out.print("Name: ");
                String psuName = sc.nextLine();

                System.out.print("Brand: ");
                String psuBrand = sc.nextLine();

                System.out.print("Price: ");
                double psuPrice = sc.nextDouble();

                System.out.print("Wattage: ");
                int psuWattage = sc.nextInt();

                System.out.print("Efficiency (Bronze, Silver, Gold): ");
                String psuEfficiency = sc.nextLine();

                System.out.print("Modular: ");
                String modular = sc.nextLine();

                boolean isPsuModular = false;

                if(modular.equalsIgnoreCase("no")) {
                    isPsuModular = false;
                } else if (modular.equalsIgnoreCase("yes")) {
                    isPsuModular = true;
                } else {
                    System.out.println("Wrong input, please provide a 'yes' or 'no' answer.");
                    System.out.print("Modular: ");
                    modular = sc.nextLine();
                }

                PowerSupply psu = new PowerSupply(psuName, psuBrand, psuPrice, psuWattage, psuEfficiency, isPsuModular);

                System.out.println("Power Supply added to the build.");

                break;

            case 6:
                System.out.println("---Enter Motherboard information---");

                System.out.print("Name: ");
                String mbName = sc.nextLine();

                System.out.print("Brand: ");
                String mbBrand = sc.nextLine();

                System.out.print("Price: ");
                double mbPrice = sc.nextDouble();
                sc.nextLine();

                System.out.print("Socket: ");
                String mbSocket = sc.nextLine();

                System.out.print("Formfactor: ");
                String mbFormfactor = sc.nextLine();

                System.out.print("Chipset: ");
                String mbChipset = sc.nextLine();

                Motherboard motherboard = new Motherboard(mbName, mbBrand, mbPrice, mbSocket, mbFormfactor, mbChipset);

                System.out.println("Motherboard added to the build.");

                break;

            case 7:
                System.out.println("Returning to main menu.");
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
}
