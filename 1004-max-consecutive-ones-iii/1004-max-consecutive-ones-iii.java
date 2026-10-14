class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, maxOnes = 0, zeros = 0;
         
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }

            maxOnes = Math.max(maxOnes, r - l + 1);
        }

        return maxOnes;
    }
}