class Solution {
    public void nextPermutation(int[] nums) {
        int index=-1;
        for(int i=nums.length-2; i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index == -1){
            int low=0,high=nums.length-1;
            while(low<high){
                int temp=nums[low];
                nums[low]=nums[high];
                nums[high]=temp;
                low++;
                high--;
            }
            return;
            }
        for(int i=nums.length-1;i>index;i--){
            if(nums[i]>nums[index]){
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                break;
            }
        }
        int low=index+1,high=nums.length-1;
        while(low<high){
                int temp=nums[low];
                nums[low]=nums[high];
                nums[high]=temp;
                low++;
                high--;
            }
    }
}