package org.example;

class NumArray {
    private int[] prefixSum;
    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 4, 5};
        NumArray numArray = new NumArray(nums);

        System.out.println("Sum of elements from index 0 to 2: " + numArray.sumRange(0, 1)); // Output: 6
        System.out.println("Sum of elements from index 1 to 3: " + numArray.sumRange(1, 3)); // Output: 9
        System.out.println("Sum of elements from index 2 to 4: " + numArray.sumRange(2, 4)); // Output: 12
    }

}