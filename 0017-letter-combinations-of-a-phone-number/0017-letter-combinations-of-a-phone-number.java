class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(0,digits,new StringBuilder(),map,ans);
        return ans;
    }
    void backtrack(int index,String digits,StringBuilder current,String[] map,List<String> ans){
        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
         for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(index + 1, digits, current, map, ans);
            current.deleteCharAt(current.length() - 1);
         }
    }
}