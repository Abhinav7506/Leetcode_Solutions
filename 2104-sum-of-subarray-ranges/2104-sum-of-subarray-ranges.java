class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!min.isEmpty() && nums[min.peek()] >= nums[i]){
                min.pop();
            }
            leftMin[i] = min.isEmpty() ? i+1:i-min.peek();

            min.push(i);
        }
        min.clear();
        for(int i=n-1 ; i>=0 ; i--){
            while(!min.isEmpty() && nums[min.peek()] > nums[i]){
                min.pop();
            }
            rightMin[i] = min.isEmpty() ? n-i:min.peek()-i;
            min.push(i);
        }


        for(int i=0;i<n;i++){
            while(!max.isEmpty() && nums[max.peek()] <= nums[i]){
                max.pop();
            }
            leftMax[i] = max.isEmpty() ? i+1:i-max.peek();

            max.push(i);
        }
        max.clear();
        for(int i=n-1 ; i>=0 ; i--){
            while(!max.isEmpty() && nums[max.peek()] < nums[i]){
                max.pop();
            }
            rightMax[i] = max.isEmpty() ? n-i:max.peek()-i;
            max.push(i);
        }


        long sum=0;
        for(int i=0;i<n;i++){
            long maxContribution =(long) nums[i] * leftMax[i] * rightMax[i];
            long minContribution =(long) nums[i] * leftMin[i] * rightMin[i];
            sum += maxContribution - minContribution;

        }

        return sum;

    }
}