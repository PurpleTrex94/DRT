package Roman;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int romanToInt(String s) {
        // Create a map for Roman numeral values
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

        // Iterate through the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            // If the current value is less than the previous value, subtract it
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                // Otherwise, add it
                result += currentValue;
            }

            // Update previous value
            prevValue = currentValue;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("III -> " + romanToInt("III"));          // Output: 3
        System.out.println("LVIII -> " + romanToInt("LVIII"));      // Output: 58
        System.out.println("MCMXCIV -> " + romanToInt("MCMXCIV"));  // Output: 1994
        
    }
}
