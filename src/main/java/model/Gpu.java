/**
 * Gpu class is a subclass of Part class.
 * This class is to set the specs of the GPU.
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

    private int vram;
    private int clockSpeed;

    public Gpu(String name, String brand, double price, int vram, int clockSpeed) {
        super(name, CATEGORY, brand, price);
        this.vram = vram;
        this.clockSpeed = clockSpeed;
    }

    public int getVram() {
        return vram;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setVram(int vram) {
        this.vram = vram;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    @Override
    public String toString() {
        return "GPU: " + getName() +
                " | Brand: " + getBrand() +
                " | Price: $" + String.format("%.2f", getPrice()) +
                " | VRAM: " + getVram() + " GB" +
                " | Clock Speed: " + getClockSpeed() + " MHz";
    }
}
