class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr={1,2,3,4,5,6,7,8,9};
        backtrack(arr,0,k,0,n,0,new ArrayList<Integer>(),ans);
        return ans;
    }

    void backtrack(int[] arr,int index,int k,int currentK,int sum,int currentSum,List<Integer> current,List<List<Integer>> ans){
        if(currentK==k){
                if(currentSum==sum){
                ans.add(new ArrayList<>(current));
            }
            return;
        }
        if(currentSum >= sum) return;
        
        for(int i=index;i<arr.length;i++){
            current.add(arr[i]);

            backtrack(arr, i + 1, k, currentK + 1,sum, currentSum + arr[i],current, ans);

            current.remove(current.size() - 1);
        }
        
    }
}