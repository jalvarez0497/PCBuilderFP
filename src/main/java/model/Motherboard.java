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

public class Motherboard extends Part {

    private static final String CATEGORY = "Motherboard";

    private String socket;
    private String formFactor;
    private String chipset;

    public Motherboard(String name, String brand, double price, String socket, String formFactor, String chipset) {
        super(name, CATEGORY, brand, price);
        this.socket = socket;
        this.formFactor = formFactor;
        this.chipset = chipset;
    }

    public String getSocket() {
        return socket;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public String getChipset() {
        return chipset;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    @Override
    public String toString() {
        return "Motherboard{" +
                "socket='" + socket + '\'' +
                ", formFactor='" + formFactor + '\'' +
                ", chipset='" + chipset + '\'' +
                '}';
    }
}
