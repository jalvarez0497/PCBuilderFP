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
package model;

import model.*;

public class PcBuild {

    private Cpu cpu;
    private Gpu gpu;
    private Ram ram;
    private Storage storage;
    private Motherboard motherboard;
    private PowerSupply powerSupply;

    public Cpu getCpu() {
        return cpu;
    }

    public Gpu getGpu() {
        return gpu;
    }

    public Ram getRam() {
        return ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public double calculateTotalPrice() {
        double total = 0;

        if (cpu != null) {
            total += cpu.getPrice();
        }
        if (gpu != null) {
            total += gpu.getPrice();
        }
        if (ram != null) {
            total += ram.getPrice();
        }
        if (storage != null) {
            total += storage.getPrice();
        }
        if (motherboard != null) {
            total += motherboard.getPrice();
        }
        if (powerSupply != null) {
            total += powerSupply.getPrice();
        }

        return total;
    }

    public void displayBuild() {
        System.out.println("---PC Build---");

        if (cpu != null) {
            System.out.println(cpu);
        }
        if (gpu != null) {
            System.out.println(gpu);
        }
        if (ram != null) {
            System.out.println(ram);
        }
        if (storage != null) {
            System.out.println(storage);
        }
        if (motherboard != null) {
            System.out.println(motherboard);
        }
        if (powerSupply != null) {
            System.out.println(powerSupply);
        }

        System.out.println("The total price for the Build is: $" + calculateTotalPrice());
    }
}
