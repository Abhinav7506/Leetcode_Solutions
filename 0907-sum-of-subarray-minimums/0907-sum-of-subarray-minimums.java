class Solution {
    public int sumSubarrayMins(int[] arr) {
        long MOD =1_000_000_007L;
        int n = arr.length;
        long[] left = new long[n];
        long[] right = new long[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&
                   arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty()
                    ? i + 1
                    : i - stack.peek();

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                   arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty()
                    ? n - i
                    : stack.peek() - i;

            stack.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum = (sum + arr[i] * left[i] % MOD
                        * right[i] % MOD) % MOD;
        }

        return (int) sum;
    }
}