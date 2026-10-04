class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,0,target,new ArrayList<>(),ans);
        return ans;
    }
    void backtrack(int index,int[] arr,int sum,int target,ArrayList<Integer>lst,List<List<Integer>> ans){
        if(sum==target){
            ans.add(new ArrayList<>(lst));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1])
                continue;
            if (sum + arr[i] > target)
                break;
            lst.add(arr[i]);
            backtrack(i + 1,arr,sum+arr[i],target,lst,ans);
            lst.remove(lst.size() - 1);
    }
    }
}