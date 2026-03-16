package lab_3;

public class BitString implements CustomArray {
    private int max_length = 100;
    private byte[] bits;
    private int length;

    public BitString(String bit_str) {
        if (bit_str == null || bit_str.length() > max_length) {
            throw new Error("incorrect bit string length");
        }

        length = bit_str.length();
        bits = new byte[max_length];
        for (int i = 0; i < length; i++) {
            char c = bit_str.charAt(length - 1 - i);
            if (c == '0') bits[i] = 0;
            else if (c == '1') bits[i] = 1;
            else throw new Error("invalid character in bit string");
        }
    }

    public CustomArray add(CustomArray array) {
        BitString other = (BitString) array;

        int curr_max_len = Math.max(this.length, other.length);
        byte[] result_bits = new byte[max_length];
        int carry = 0;
        int i;

        for (i = 0; i < curr_max_len; i++) {
            int bitThis = (i < this.length) ? this.bits[i] : 0;
            int bitOther = (i < other.length) ? other.bits[i] : 0;
            int sum = bitThis + bitOther + carry;
            result_bits[i] = (byte) (sum & 1); 
            carry = sum >> 1;                  
        }

        int result_len = curr_max_len;
        if (carry != 0) {
            if (curr_max_len >= max_length) {
                throw new Error("overflow, result exceeds " + max_length + " bits");
            }
            result_bits[curr_max_len] = (byte) carry;
            result_len = curr_max_len + 1;
        }

        this.bits = result_bits;
        this.length = result_len;

        return this;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(bits[i]);
        }
        System.out.println(sb.toString());
    }
 }
