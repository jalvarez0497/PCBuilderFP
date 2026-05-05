/**
 * Cpu class is one of my subclasses.
 * In this class we set the components of a CPU.
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

public class Cpu extends Part {

    private int cores;
    private double clockSpeed;
    private String socket;
    private static final String CATEGORY = "CPU";

    public Cpu(String name, String brand, double price, int cores, double clockSpeed, String socket) {
        super(name, CATEGORY, brand, price);
        this.cores = cores;
        this.clockSpeed = clockSpeed;
        this.socket = socket;
    }

    public int getCores() {
        return cores;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public String getSocket() {
        return socket;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "CPU: " + getName() +
                " | Brand: " + getBrand() +
                " | Price: $" + String.format("%.2f", getPrice()) +
                " | Cores: " + getCores() +
                " | Clock Speed: " + getClockSpeed() + " GHz" +
                " | Socket: " + getSocket();

    }
}
