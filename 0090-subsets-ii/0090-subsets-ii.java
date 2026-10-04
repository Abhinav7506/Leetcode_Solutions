class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    void backtrack(int index, int[] arr,ArrayList<Integer> current, List<List<Integer>> ans){
        ans.add(new ArrayList<>(current));
        
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i] == arr[i - 1]) continue;
            current.add(arr[i]);
            backtrack(i+1,arr,current,ans);
            current.remove(current.size()-1);
        }

    }
}