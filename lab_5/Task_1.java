package lab_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_1 {
    public static void main(String[] args) {
        String text = ":mW,&sEpNФГФГФГФkm,t|V*2222WE(Z*^|cNGhm%?YPV0gJ<nRH6fBE(drmvg6@z?k_b*@Qc@go_zF47$9S7kUpv{Mt'pv8rpTy|M>$8IH74ID.0d&K<OxYlF2";

        Pattern pattern = Pattern.compile("[^a-zA-Zа-яА-Я]+");
        Matcher matcher = pattern.matcher(text);


        int max_length = 0;
        String max_result = "";
        while (matcher.find()) {
            String current_substring = matcher.group(); 
            if (current_substring.length() > max_length) {
                max_result = current_substring;
                max_length = current_substring.length();
            }
        }

        if (max_length == 0 && max_result.equals("")) {
            System.out.println("No results");
        } else {
            System.out.println("Max result: " + max_result);
            System.out.println("Length: " + max_length);
        }
    }
}
