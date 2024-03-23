package DataSheets;

public class plusOne {
        public static void main(String[] args) {
            plusoneSolution solution = new plusoneSolution();

            // Example 1: [1, 2, 3]
            int[] digits1 = {1, 2, 3};
            int[] result1 = solution.plusOne(digits1);
            printArray(result1);

            // Example 2: [4, 3, 2, 1]
            int[] digits2 = {4, 3, 2, 1};
            int[] result2 = solution.plusOne(digits2);
            printArray(result2);

            // Example 3: [9, 9, 9]
            int[] digits3 = {9, 9, 9};
            int[] result3 = solution.plusOne(digits3);
            printArray(result3);
        }

        private static void printArray(int[] array) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
class plusoneSolution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate through the digits starting from the least significant digit
        for (int i = n - 1; i >= 0; i--) {
            // Increment the current digit
            digits[i]++;

            // If the digit becomes 10, set it to 0 and carry over to the next digit
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                // If the current digit is not 10, no need to carry over, break the loop
                break;
            }
        }

        // If the most significant digit becomes 10, we need to carry over
        if (digits[0] == 0) {
            int[] result = new int[n + 1];
            result[0] = 1;
            return result;
        }

        return digits;
    }
}
