package DataSheets;

    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int mini = Integer.MAX_VALUE; // Initialize the minimum element seen so far
            int maxi = Integer.MIN_VALUE; // Initialize the maximum element seen so far
            boolean meetDecrease = false; // Flag to indicate if a decreasing sequence has been encountered
            boolean meetIncrease = false; // Flag to indicate if an increasing sequence has been encountered

            for (int i = 1; i < n; ++i) {
                if (nums[i] < nums[i - 1])
                    meetDecrease = true; // Set the flag if a decrease is encountered
                if (meetDecrease)
                    mini = Math.min(mini, nums[i]); // Update the minimum element if we are in a decreasing sequence
            }

            for (int i = n - 2; i >= 0; --i) {
                if (nums[i] > nums[i + 1])
                    meetIncrease = true; // Set the flag if an increase is encountered
                if (meetIncrease)
                    maxi = Math.max(maxi, nums[i]); // Update the maximum element if we are in an increasing sequence
            }

            int l;
            for (l = 0; l < n; ++l)
                if (nums[l] > mini)
                    break; // Find the left boundary of the unsorted subarray

            int r;
            for (r = n - 1; r >= 0; --r)
                if (nums[r] < maxi)
                    break; // Find the right boundary of the unsorted subarray

            return l < r ? r - l + 1 : 0; // Return the length of the unsorted subarray or 0 if it is already sorted
        }
    }

    public class unSortedSubarray {
        public static void main(String[] args) {
            int[] nums = {2,1,17,15, 16};
            Solution sol = new Solution();
            int result = sol.findUnsortedSubarray(nums);
            System.out.println("Length of the unsorted subarray: " + result);
        }
    }