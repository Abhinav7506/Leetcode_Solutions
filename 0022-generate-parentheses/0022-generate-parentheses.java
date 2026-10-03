class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack("", 0, 0, n, ans);
        return ans;
    }
    void backTrack(String current,int open,int close,int n,List<String>ans){
        if (open == n && close == n) {
            ans.add(current);
            return;
        }
        if (open < n) {
            backTrack(current + "(", open + 1, close, n, ans);
        }
        if (close < open) {
            backTrack(current + ")", open, close + 1, n, ans);
        }

    }
}