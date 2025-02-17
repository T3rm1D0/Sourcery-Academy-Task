package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println(string_compression("string"));
        System.out.println(string_decompression("s2tri4ng"));
    }

    public static String string_compression(String string) {

        // I Check that the string wouldn't be null so it wouldn't throw a NullPointerException and I also check that string only contains white spaces if it meets the conditions return "".
        if (string == null || string.isBlank()) {
            return "";
        }


        //I use StringBuilder because its faster and optimizes memory. Normal string creates a new string every time new character is linked and StringBuilder just modifies the existing object.
        StringBuilder ats = new StringBuilder();

        int k = 1;

        //I loop through the string and check if the current character is equal to the previous character if it is I increment k by 1 if it's not I append (append modifies the existing StringBuilder  by adding data to the end) the previous character and k to the result and reset k to 1.
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(i - 1)) {
                k++;
            } else {
                ats.append(string.charAt(i - 1)).append(k);
                k = 1;
            }
        }
        ats.append(string.charAt(string.length() - 1)).append(k);

        return ats.toString();
    }

    public static String string_decompression(String string) {
        if (string == null || string.isBlank()) {
            return "";
        }

        StringBuilder ats = new StringBuilder();

        // I loop through the string and check if the current character is a digit. If it's a digit, I retrieve its numeric value using Character.getNumericValue. If it is a digit, I repeat the last character (ats.charAt(ats.length() - 1)) the number of times indicated by the digit. If it's not a digit, I simply append the current character to the result.
        for (int i = 0; i < string.length(); i++) {
            int k = Character.getNumericValue(string.charAt(i));
            if (Character.isDigit(string.charAt(i))) {
                for (int j = 1; j < k; j++) {
                    ats.append(ats.charAt(ats.length() - 1));
                }

            } else {

                ats.append(string.charAt(i));
            }
        }
        return ats.toString();

    }
}
