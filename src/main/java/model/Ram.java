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

public class Ram extends Part{

    private static final String CATEGORY = "RAM";

    private int capacity;
    private int speed;
    private String type;

    public Ram(String name, String brand, double price, int capacity, int speed, String type) {
        super(name, CATEGORY, brand, price);
        this.capacity = capacity;
        this.speed = speed;
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public String getType() {
        return type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "capacity=" + capacity +
                ", speed=" + speed +
                ", type='" + type + '\'' +
                '}';
    }
}
