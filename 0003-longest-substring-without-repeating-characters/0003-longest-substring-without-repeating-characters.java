class Solution {
    public int lengthOfLongestSubstring(String s) {
         Set<Character> used = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            while (used.contains(ch)) {
                used.remove(s.charAt(left));
                left++;
            }

            used.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}