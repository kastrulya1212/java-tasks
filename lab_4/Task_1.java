package lab_4;

public class Task_1 {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new Queue<>(123);
        for (int i = 20; i > 0; i--) {
            queue1.enqueue((i*3+7)%10);
        }
        for (int i = 0; i < 5; i++) {
            queue1.dequeue();
        }

        System.out.println(queue1.toString());
        System.out.println(queue1.size());
        System.out.println("Sorting starting...");

        queue1.sort();
        System.out.println(queue1.toString());
        System.out.println(queue1.size());
    }
}
