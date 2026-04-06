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
//                    System.out.println("1. CPU");
//                    System.out.println("2. GPU");
//                    System.out.println("3. RAM");
//                    System.out.println("4. Storage");
//                    System.out.println("5. Motherboard");
//                    System.out.println("6. Power Supply");
//                    System.out.println("7. Back to main menu");
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

        }
    }
}
