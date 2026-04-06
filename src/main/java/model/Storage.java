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

public class Storage extends Part{

    private static final String CATEGORY = "Storage";

    private int capacity;
    private String type;
    private int readSpeed;
    private int writeSpeed;

    public Storage(String name, String brand, double price, int capacity, String type, int readSpeed, int writeSpeed) {
        super(name, CATEGORY, brand, price);
        this.capacity = capacity;
        this.type = type;
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public int getReadSpeed() {
        return readSpeed;
    }

    public int getWriteSpeed() {
        return writeSpeed;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setReadSpeed(int readSpeed) {
        this.readSpeed = readSpeed;
    }

    public void setWriteSpeed(int writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "capacity=" + capacity +
                ", type='" + type + '\'' +
                ", readSpeed=" + readSpeed +
                ", writeSpeed=" + writeSpeed +
                '}';
    }
}
