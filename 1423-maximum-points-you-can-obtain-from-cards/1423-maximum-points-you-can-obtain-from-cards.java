class Solution {
    public int maxScore(int[] cardPoints, int k) {
       int maxScore=0;
       int leftSum=0,rightSum=0;

        for(int i=0;i<k;i++){
            leftSum+=cardPoints[i];
        }
        maxScore=leftSum;
        int rightIndex=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            leftSum-=cardPoints[i];
            rightSum+=cardPoints[rightIndex];
            rightIndex--;

            maxScore=Math.max(maxScore,leftSum + rightSum);
        }
    return maxScore;
    }
}