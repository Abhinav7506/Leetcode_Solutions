class Solution {
    long totalHours(int[] piles,int speed){
        long totalHrs=0;
        for(int i : piles){
            totalHrs+=(int)Math.ceil((double)i/speed);
        }
        return totalHrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        long totalHrs;
        int low=1;
        int high= Arrays.stream(piles).max().getAsInt();
        int ans=high,mid;
        while(low<=high){
            mid=(low+high)/2;
            totalHrs=totalHours(piles,mid);
            if(totalHrs<=h){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}