class Solution {
    public int[] singleNumber(int[] nums) {
        long xor=0;
        for(int i=0;i<nums.length;i++) 
            xor^=nums[i];

        long rightMost = xor & -xor;
        int bucket1=0;
        int bucket2=0;
        for(int i=0;i<nums.length;i++){
        if ((nums[i] & rightMost) != 0){
             bucket1^=nums[i];
            }
        else{
                bucket2^=nums[i];
            }
        }
        return new int[]{bucket1,bucket2};
    }
}