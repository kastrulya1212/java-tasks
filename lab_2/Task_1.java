package lab_2;

public class Task_1 {
    public static void main(String[] args) {
        Car car1 = new Car("Abc", 5, 200);
        Lorry lorry1 = new Lorry("Scania", 16, 750, 10);
        
        lorry1.print();
        System.out.println("\n" + lorry1.toString());

        car1.print();
    }
}
