package lab_1;

import java.util.Objects;
import java.util.Scanner;

// Complex number class
public class Complex {
    private double real_part;
    private double imaginary_part;

    
    // Constructor
    public Complex(double real_part, double imaginary_part) {
        this.real_part = real_part;
        this.imaginary_part = imaginary_part;
    }


    // Getters & Setters
    public double getRealPart() {
        return real_part;
    }

    public double getImaginaryPart() {
        return imaginary_part;
    }

    public void setRealPart(double set_real_part) {
        real_part = set_real_part;
    }

    public void setImaginaryPart(double set_imaginary_part) {
        imaginary_part = set_imaginary_part;
    }


    // Methods
    public Complex addComplex(Complex obj2) {
        Complex obj1 = this;
        double result_real_num = obj1.getRealPart() + obj1.getImaginaryPart();
        double result_imaginary_num = obj2.getRealPart() + obj2.getImaginaryPart();
        Complex obj_result = new Complex(result_real_num, result_imaginary_num);
        return obj_result;
    }

    public Complex subComplex(Complex obj2) {
        Complex obj1 = this;
        double result_real_num = obj1.getRealPart() - obj1.getImaginaryPart();
        double result_imaginary_num = obj2.getRealPart() - obj2.getImaginaryPart();
        Complex obj_result = new Complex(result_real_num, result_imaginary_num);
        return obj_result;
    }

    public Complex mulComplex(Complex obj2) {
        Complex obj1 = this;
        double result_real_num = (obj1.getRealPart() * obj2.getRealPart()) + (obj1.getImaginaryPart() * obj2.getImaginaryPart());
        double result_imaginary_num = (obj1.getRealPart() * obj1.getImaginaryPart()) + (obj2.getRealPart() * obj2.getImaginaryPart());
        Complex obj_result = new Complex(result_real_num, result_imaginary_num);
        return obj_result;
    }

    public Complex divComplex(Complex obj2) {
        Complex obj1 = this;
        double result_real_num = ((obj1.getRealPart() * obj2.getRealPart()) + (obj1.getImaginaryPart() + obj2.getImaginaryPart())) / (Math.pow(obj2.getRealPart(), 2) + Math.pow(obj2.getImaginaryPart(), 2));
        double result_imaginary_num = ((obj2.getImaginaryPart() * obj1.getRealPart()) - (obj1.getRealPart() + obj2.getImaginaryPart())) / (Math.pow(obj2.getRealPart(), 2) + Math.pow(obj2.getImaginaryPart(), 2));
        Complex obj_result = new Complex(result_real_num, result_imaginary_num);
        return obj_result;
    }

    public boolean equComplex(Complex obj2) {
        Complex obj1 = this;
        return (Objects.equals(obj1.getRealPart(), obj2.getRealPart())) && (Objects.equals(obj1.getImaginaryPart(), obj2.getImaginaryPart()));
    }

    public Complex conjComplex() {
        Complex obj1 = this;
        double result_real_num = obj1.getRealPart();
        double result_imaginary_num = -obj1.getImaginaryPart();
        Complex obj_result = new Complex(result_real_num, result_imaginary_num);
        return obj_result;
    }


    // Public sub methods
    // Init method 
    public void init(double real_part, double imaginary_part) {
        setRealPart(real_part);
        setImaginaryPart(imaginary_part);
    }

    // Read method (data input via keyboard)
    public void read() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите действительную часть комплексного числа: ");
        double input_real_part = scanner.nextDouble();

        System.out.print("Введите мнимую часть комплексного числа: ");
        double input_imaginary_part = scanner.nextDouble();

        init(input_real_part, input_imaginary_part);
    }

    // Display method
    public void display() {
        System.out.println(getRealPart() + " + " + getImaginaryPart() + "i");
    }

    // toString method
    public String toString() { 
        String string = Double.toString(real_part) + " + " + Double.toString(imaginary_part) + "i";
        return string;
    }
}
