package DataSheets;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        // Define the array
        int[] array = {1, 2, 3, 4, 5};

        // Define the number of positions to rotate
        int positions = 2;

        // Perform the rotation
        rotate(array, positions);

        // Print the rotated array
        System.out.println(Arrays.toString(array));
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l < r)
            swap(nums, l++, r--);
    }

    private static void swap(int[] nums, int l, int r) {
        final int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
