class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0,candidates,0,new ArrayList<Integer>(),target,ans);
        return ans;
    }
    void backtrack(int index,int[] candidates,int sum, ArrayList<Integer> lst,int target,List<List<Integer>>ans){
        if(sum==target){
            ans.add(new ArrayList<>(lst));
            return;
        }
        
    
        if (index == candidates.length || sum > target) {
        return;
    }
        lst.add(candidates[index]);
        sum+=candidates[index];
        backtrack(index,candidates,sum,lst,target,ans);
        lst.remove(lst.size() - 1);
        sum-=candidates[index];
        backtrack(index+1,candidates,sum,lst,target,ans);
    }
}