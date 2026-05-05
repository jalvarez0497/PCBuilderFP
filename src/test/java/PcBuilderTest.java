/**
 * This class works as the test unit for the console base application.
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

import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PcBuilderTest {

    @Test
    public void testCpuCreation() {
        Cpu cpu = new Cpu("Ryzen 5 7600", "AMD", 199.99, 6, 3.8, "AM5");

        assertEquals("Ryzen 5 7600", cpu.getName());
        assertEquals("AMD", cpu.getBrand());
        assertEquals(199.99, cpu.getPrice(), 0.01);
        assertEquals("AM5", cpu.getSocket());
    }

    @Test
    public void testBuildTotalPrice() {
        PcBuild build = new PcBuild();

        build.setCpu(new Cpu("Ryzen 5 7600", "AMD", 199.99, 6, 3.8, "AM5"));
        build.setRam(new Ram("Vengeance", "Corsair", 89.99, 32, 6000, "DDR5"));
        build.setStorage(new Storage("970 Evo", "Samsung", 79.99, 1000, "SSD", 3500, 3000));

        assertEquals(369.97, build.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testCpuMotherboardCompatibility() {
        Cpu cpu = new Cpu("Ryzen 5 7600", "AMD", 199.99, 6, 3.8, "AM5");
        Motherboard motherboard = new Motherboard("B650", "MSI", 149.99, "AM5", "ATX");

        assertEquals(cpu.getSocket(), motherboard.getSocket());
    }
}