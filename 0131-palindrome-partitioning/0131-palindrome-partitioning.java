class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), ans);
        return ans;
    }
    void backtrack(int index,String s,List<String> current,List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (!isPalindrome(sub)) {
                continue;
            }
            current.add(sub);
            backtrack(i + 1, s, current, ans);
            current.remove(current.size() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}