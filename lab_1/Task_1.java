package lab_1;

import java.util.Objects;
import java.util.Scanner;
import lab_1.Complex;

// Entry point
public class Task_1 {

    public static void main(String[] args) {
        Complex num1 = new Complex(2, 2);
        Complex num2 = new Complex(2, 3);

        Complex add_test = num1.addComplex(num2);
        Complex sub_test = num1.subComplex(num2);
        Complex mul_test = num1.mulComplex(num2);
        Complex div_test = num1.divComplex(num2);
        boolean equ_test = num1.equComplex(num2);
        Complex conj_test = num1.conjComplex();

        // After test results
        System.out.println("(TESTS) After test result");
        add_test.display();
        sub_test.display();
        mul_test.display();
        div_test.display();
        System.out.println(equ_test);
        conj_test.display();

        // Sub functions tests
        System.out.println("(TESTS) Sub functions tests");
        num1.read();
        num1.display();
        System.out.print("\n");

        System.out.println(num1.toString());
    }
}