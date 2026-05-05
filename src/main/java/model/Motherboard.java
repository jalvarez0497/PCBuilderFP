/**
 * Motherboard class in another subclass of Part class.
 * In here we set the specs of the Motherboard.
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

public class Motherboard extends Part {

    private static final String CATEGORY = "Motherboard";

    private String socket;
    private String formFactor;

    public Motherboard(String name, String brand, double price, String socket, String formFactor) {
        super(name, CATEGORY, brand, price);
        this.socket = socket;
        this.formFactor = formFactor;
    }

    public String getSocket() {
        return socket;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    @Override
    public String toString() {
        return "Motherboard: " + getName() +
                " | Brand: " + getBrand() +
                " | Price: $" + String.format("%.2f", getPrice()) +
                " | Socket: " + getSocket() +
                " | Form Factor: " + getFormFactor();
    }
}
