class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int temp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) temp++;
            else temp=0;
            if(temp>count) count=temp;
        }
        return count;
    }
}