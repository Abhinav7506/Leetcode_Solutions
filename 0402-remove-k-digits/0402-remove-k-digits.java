class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int n=num.length();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && k>0 && num.charAt(i) < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.removeLast());
        }

        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }

        String answer = result.substring(i);
        return answer.isEmpty() ? "0" : answer;

    }
}