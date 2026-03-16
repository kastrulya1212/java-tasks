package lab_3;

public class Fraction implements CustomArray{
    private int integer_part;
    private int fraction_part;
    private boolean sign;
    private int precision;

    // Getters & Setters
    public int getInteger_part() {
        return this.integer_part;
    }

    public void setInteger_part(int integer_part) {
        if (integer_part < 0) {
            throw new Error("input integer part must be >= 0");
        }
        this.integer_part = integer_part;
    }

    public int getFraction_part() {
        return this.fraction_part;
    }

    public void setFraction_part(int fraction_part) {
        if (fraction_part < 0) {
            throw new Error("input fraction part must be >= 0");
        }
        int max_fraction = (int) Math.pow(10, getPrecision()) - 1;
        if (fraction_part > max_fraction) {
            throw new Error("fraction part is too big");
        }

        this.fraction_part = fraction_part;
    }

    public boolean isSign() {
        return this.sign;
    }

    public boolean getSign() {
        return this.sign;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public int getPrecision() {
        return this.precision;
    }

    // Constructors
    public Fraction(int integer_part, int precision) {
        if (precision < 0) { 
            throw new Error("precision must be >= 0");
        }
        this.precision = precision;

        setInteger_part(integer_part);
        setFraction_part(0);
        setSign(false);        
    }

    public Fraction(int integer_part, int fraction_part, int precision) {
        if (precision < 0) { 
            throw new Error("precision must be >= 0");
        }
        this.precision = precision;

        setInteger_part(integer_part);
        setFraction_part(fraction_part);
        setSign(false);
    }

    public Fraction(int integer_part, int fraction_part, boolean sign, int precision) {
        if (precision < 0) { 
            throw new Error("precision must be >= 0");
        }
        this.precision = precision;

        setInteger_part(integer_part);
        setFraction_part(fraction_part);
        setSign(sign);
    }

    // Methods
    // 5.4 - 3.7
    public CustomArray add(CustomArray array) {
        Fraction other = (Fraction) array;
        int max_fraction = (int) Math.max(this.precision, other.precision);

        // scale fraction's parts to max
        if (Integer.toString(this.fraction_part).length() > max_fraction) {
            int diff = Integer.toString(this.fraction_part).length() - max_fraction;
            this.fraction_part = this.fraction_part / (int)Math.pow(10, diff);
        }
        if (Integer.toString(other.fraction_part).length() > max_fraction) {
            int diff = Integer.toString(other.fraction_part).length() - max_fraction;
            other.fraction_part = other.fraction_part / (int)Math.pow(10, diff);
        }

        int sign_this = (this.isSign()?-1:1);
        int sign_other = (other.isSign()?-1:1);

        String num1_str = Integer.toString(sign_this*this.integer_part) + "." + Integer.toString(this.fraction_part);
        String num2_str = Integer.toString(sign_other*other.integer_part) + "." + Integer.toString(other.fraction_part);
        double num1 = Double.valueOf(num1_str);
        double num2 = Double.valueOf(num2_str);

        double result = num1 + num2;
        this.sign = (result < 0);
        result = Math.abs(result);
        
        String result_str = Double.toString(result);
        String[] result_str_split = result_str.split("\\.");
        String result_str_integer = result_str_split[0];
        String result_str_fraction = result_str_split[1];

        this.integer_part = Integer.valueOf(result_str_integer);

        // cutting "0" and cutting to max size
        if (result_str_fraction.length() > Integer.toString(Integer.MAX_VALUE).length()) {
            Character letter = result_str_fraction.charAt(result_str_fraction.length()-1);
            while (letter == '0' || result_str_fraction.length() > Integer.toString(Integer.MAX_VALUE).length()) {
                result_str_fraction = result_str_fraction.substring(0, result_str_fraction.length()-1);
                letter = result_str_fraction.charAt(result_str_fraction.length()-1);
            }
        }
        this.fraction_part = Integer.valueOf(result_str_fraction);

    
        // int fraction_sum_result = this.getFraction_part()+other.getFraction_part();
        // int fraction_carry = (Math.abs(fraction_sum_result)>=10 ? (fraction_sum_result>=10?1:-1) : 0);
        // int fraction_result = (Math.abs(fraction_sum_result)>=10 ? (fraction_sum_result>=10?fraction_sum_result%10:other.getFraction_part()-this.getFraction_part()) : fraction_sum_result);

        // int result_integer = (sign_this*this.getInteger_part() + sign_other*other.getInteger_part()) + fraction_carry;

        // this.setInteger_part(Math.abs(result_integer));
        // this.setFraction_part(fraction_result);
        // this.setSign((result_integer>0 ? false : true));
        // System.out.println("DEBUG " + getInteger_part() + " " + getFraction_part() + " " + getSign());
        return this;
    }

    public void print() {
        System.out.println((isSign()?"-":"") + getInteger_part() + "." + getFraction_part());
    }
}
