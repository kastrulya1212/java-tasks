package lab_3;

public class Task_1 {
    public static void main(String[] args) {
        Fraction fr1 = new Fraction(1, 1234, true, 5);
        Fraction fr2 = new Fraction(6, 2323, true, 5);
        fr1.add(fr2).print();

        BitString bs1 = new BitString("1011101");
        BitString bs2 = new BitString("1001");
        bs1.add(bs2).print();
    }
}
