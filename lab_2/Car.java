package lab_2;

public class Car {
    private String brand;
    private int cylinder_count;
    private int power;


    // Constructor
    public Car(String brand, int cylinder_count, int power) {
        setBrand(brand);
        setCylinderCount(cylinder_count);
        setPower(power);
    }

    // Getters & setters
    public String getBrand() {
        return brand;
    }

    public int getCylinderCount() {
        return cylinder_count;
    }

    public int getPower() {
        return power;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCylinderCount(int cylinder_count) {
        if (cylinder_count <= 0) {
            throw new Error("Cylinder count cannot be less than 0");
        }

        this.cylinder_count = cylinder_count;
    }

    public void setPower(int power) {
        if (power <= 0) {
            throw new Error("Power cannot be less or equal 0");
        } 

        this.power = power;
    }


    // Functions
    public void print() {
        System.out.println("brand=" + getBrand());
        System.out.println("cylinder_count=" + getCylinderCount());
        System.out.println("power=" + getPower());
    }

    public String toString() {
        return (
            "brand=" + brand + ", " +
            "cylinder_count=" + cylinder_count + ", " +
            "power=" + power
        );
    }
}

