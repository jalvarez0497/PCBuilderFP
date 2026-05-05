/**
 * This class works as the test unit for the GUI program.
 * In this unit testing, we are testing the Data Structures of the program: HashMap & PriorityQueue.
 * Also, we test the removal of a part from the HashMap, sorting the parts, calculating the total price of the build, and the motherboard compatability.
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
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class PcBuilderGUITest {

    @Test
    public void testAddPartToHashMap() {
        HashMap<String, ArrayList<Part>> partsMap = new HashMap<>();

        Cpu cpu = new Cpu("Ryzen 5 7600", "AMD", 199.99, 6, 3.8, "AM5");

        partsMap.putIfAbsent(cpu.getCategory(), new ArrayList<>());
        partsMap.get(cpu.getCategory()).add(cpu);

        assertTrue(partsMap.containsKey("CPU"));
        assertEquals(1, partsMap.get("CPU").size());
        assertEquals("Ryzen 5 7600", partsMap.get("CPU").get(0).getName());
    }

    @Test
    public void testPriorityQueueSortsByPrice() {
        PriorityQueue<Part> priceQueue =
                new PriorityQueue<>(Comparator.comparingDouble(Part::getPrice));

        Cpu cpu = new Cpu("Ryzen 5 7600", "AMD", 199.99, 6, 3.8, "AM5");
        Ram ram = new Ram("Vengeance", "Corsair", 89.99, 32, 6000, "DDR5");
        Storage storage = new Storage("970 Evo", "Samsung", 79.99, 1000, "SSD", 3500, 3000);

        priceQueue.add(cpu);
        priceQueue.add(ram);
        priceQueue.add(storage);

        assertEquals("970 Evo", priceQueue.poll().getName());
        assertEquals("Vengeance", priceQueue.poll().getName());
        assertEquals("Ryzen 5 7600", priceQueue.poll().getName());
    }

    @Test
    public void testTotalPriceCalculation() {
        ArrayList<Part> parts = new ArrayList<>();

        parts.add(new Cpu("Ryzen 5 7600", "AMD", 199.99, 6, 3.8, "AM5"));
        parts.add(new Ram("Vengeance", "Corsair", 89.99, 32, 6000, "DDR5"));
        parts.add(new Storage("970 Evo", "Samsung", 79.99, 1000, "SSD", 3500, 3000));

        double total = 0;

        for (Part part : parts) {
            total += part.getPrice();
        }

        assertEquals(369.97, total, 0.01);
    }

    @Test
    public void testCpuMotherboardCompatibility() {
        Cpu cpu = new Cpu("Ryzen 5 7600", "AMD", 199.99, 6, 3.8, "AM5");
        Motherboard motherboard = new Motherboard("B650 Tomahawk", "MSI", 189.99, "AM5", "ATX");

        assertTrue(cpu.getSocket().equalsIgnoreCase(motherboard.getSocket()));
    }

    @Test
    public void testRemovePartFromHashMapAndQueue() {
        HashMap<String, ArrayList<Part>> partsMap = new HashMap<>();
        PriorityQueue<Part> priceQueue =
                new PriorityQueue<>(Comparator.comparingDouble(Part::getPrice));

        Cpu cpu = new Cpu("Ryzen 5 7600", "AMD", 199.99, 6, 3.8, "AM5");

        partsMap.putIfAbsent(cpu.getCategory(), new ArrayList<>());
        partsMap.get(cpu.getCategory()).add(cpu);
        priceQueue.add(cpu);

        Part removedPart = partsMap.get("CPU").remove(0);
        priceQueue.remove(removedPart);

        assertTrue(partsMap.get("CPU").isEmpty());
        assertTrue(priceQueue.isEmpty());
    }
}
