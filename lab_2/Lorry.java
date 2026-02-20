package lab_2;

public class Lorry extends Car{
    private int cargo_capacity;


    // Construcor
    public Lorry(String brand, int cylinder_count, int power, int cargo_capacity) {
        super(brand, cylinder_count, power);
        setCargoCapacity(cargo_capacity);
    }


    // Getters & setters
    public int getCargoCapacity() {
        return cargo_capacity;
    }

    public void setCargoCapacity(int cargo_capacity) {
        if (cargo_capacity < 0) {
            throw new Error("Cargo capacity cannot be less than 0");
        }

        this.cargo_capacity = cargo_capacity;
    }


    // Functions
    @Override
    public void print() {
        super.print();
        System.out.println("cargo_capacity=" + getCargoCapacity());
    }

    @Override
    public String toString() {
        return (
            super.toString() +
            ", " + "cargo_capacity=" + Integer.toString(cargo_capacity)
        );
    }
}
