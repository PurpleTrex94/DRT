package Roman;

import java.util.HashMap;
import java.util.Map;

public class Main {
    // Validation method for Roman numerals
    public static boolean isValidRoman(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false; // Null or empty strings are invalid
        }

        // Rule 1: Limit consecutive repetitions
        if (s.contains("IIII") || s.contains("XXXX") || s.contains("CCCC") || s.contains("MMMM")) {
            return false;
        }

        // Rule 2: Prevent repetition of V, L, D
        if (s.contains("VV") || s.contains("LL") || s.contains("DD")) {
            return false;
        }

        // Rule 3: Check invalid subtraction patterns
        // Only valid substractive pairs are: IV, IX, XL, XC, CD, CM
        if (s.matches(".*IL|IC|ID|IM|VX|VL|VC|VM|LC|LD|LM|DM.*")) {
            return false;
        }

        return true; // Passes all validation rules
    }

    // Conversion method
    public static int romanToInt(String s) {
        if (!isValidRoman(s)) {
            throw new IllegalArgumentException("Invalid Roman numeral: " + s);
        }

        // Roman numeral map
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        // Process Roman numeral from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            // Subtract if smaller, else add
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

    public static void main(String[] args) {
        try {
            // Valid test cases
            System.out.println("III -> " + romanToInt("III"));         // 3
            System.out.println("LVIII -> " + romanToInt("LVIII"));     // 58
            System.out.println("MCMXCIV -> " + romanToInt("MCMXCIV")); // 1994

            
            //System.out.println("IIII -> " + romanToInt("IIII"));   // Invalid
            // System.out.println("IC -> " + romanToInt("IC"));       // Invalid
            // System.out.println("VV -> " + romanToInt("VV"));       // Invalid
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
