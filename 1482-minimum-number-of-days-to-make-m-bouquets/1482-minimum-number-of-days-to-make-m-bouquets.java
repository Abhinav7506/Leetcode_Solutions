class Solution {
    boolean possible(int[] arr,int day,int m,int k){
        int count=0,bouquets=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<= day) count++;
            else{
                bouquets+=count/k;
                count=0;
            }
        }
        bouquets+=count/k;
        if(bouquets >= m) return true ;
        else return false ;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i:bloomDay){
            low = Math.min(low,i);
            high = Math.max(high,i);
        }
        int mid,ans=high;
        if(bloomDay.length < (long)m*k) return -1;
        while(low<=high){
            mid=low + (high - low) / 2;
            if(possible(bloomDay,mid,m,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
    return ans;
    }
}