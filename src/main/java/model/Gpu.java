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
import model.Part;

public class Gpu extends Part {
    private static final String CATEGORY = "GPU";

    private String chipset;
    private int vram;
    private int clockSpeed;
    private int powerUsage;

    public Gpu(String name, String brand, double price, String chipset, int vram, int clockSpeed, int powerUsage) {
        super(name, CATEGORY, brand, price);
        this.chipset = chipset;
        this.vram = vram;
        this.clockSpeed = clockSpeed;
        this.powerUsage = powerUsage;
    }

    public String getChipset() {
        return chipset;
    }

    public int getVram() {
        return vram;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public int getPowerUsage() {
        return powerUsage;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public void setVram(int vram) {
        this.vram = vram;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public void setPowerUsage(int powerUsage) {
        this.powerUsage = powerUsage;
    }

    @Override
    public String toString() {
        return "Gpu{" +
                "chipset='" + chipset + '\'' +
                ", vram=" + vram +
                ", clockSpeed=" + clockSpeed +
                ", powerUsage=" + powerUsage +
                '}';
    }
}
