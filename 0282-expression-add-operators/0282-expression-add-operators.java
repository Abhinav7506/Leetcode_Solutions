class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        backtrack(num, target, 0, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    void backtrack(
            String num,
            long target,
            int index,
            long value,
            long last,
            StringBuilder expr,
            List<String> ans) {

        if (index == num.length()) {
            if (value == target) {
                ans.add(expr.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            String part = num.substring(index, i + 1);
            long curr = Long.parseLong(part);

            int oldLength = expr.length();

            if (index == 0) {
                expr.append(part);

                backtrack(num, target, i + 1,
                          curr, curr, expr, ans);

                expr.setLength(oldLength);
            } else {
                
                expr.append('+').append(part);

                backtrack(num, target, i + 1,
                          value + curr, curr, expr, ans);

                expr.setLength(oldLength);

                expr.append('-').append(part);

                backtrack(num, target, i + 1,
                          value - curr, -curr, expr, ans);

                expr.setLength(oldLength);

                expr.append('*').append(part);

                backtrack(num, target, i + 1,
                          value - last + last * curr,
                          last * curr, expr, ans);

                expr.setLength(oldLength);
            }
        }
    }
}