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

public class PowerSupply extends Part {

    private static final String CATEGORY = "PSU";

    private int wattage;
    private String efficiency;
    private boolean modular;

    public PowerSupply(String name, String brand, double price, int wattage, String efficiency, boolean modular) {
        super(name, CATEGORY, brand, price);
        this.wattage = wattage;
        this.efficiency = efficiency;
        this.modular = modular;
    }

    public int getWattage() {
        return wattage;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public boolean isModular() {
        return modular;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public void setModular(boolean modular) {
        this.modular = modular;
    }

    @Override
    public String toString() {
        return "PowerSupply{" +
                "wattage=" + wattage +
                ", efficiency='" + efficiency + '\'' +
                ", modular=" + modular +
                '}';
    }
}
