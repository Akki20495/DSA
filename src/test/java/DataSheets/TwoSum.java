package DataSheets;

public class TwoSum {

        public static void main(String[] args) {
            int[] arr = {1, 4, 45, 6, 10, 8};
            int x = 15;
            int[] mem = new int[10]; // Assuming the maximum value in Arr is 10000
            System.out.println(hasTwoSum(arr, x, mem) ? "Yes" : "No");
        }

        public static boolean hasTwoSum(int[] arr, int x, int[] mem) {
            for (int num : arr) {
                if (x - num >= 0 && mem[x - num]==1) {
                    return true;
                }
                mem[num] = 1;
            }
            return false;
        }
    }

