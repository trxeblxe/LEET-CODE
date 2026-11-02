class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long sum = 0;
        int mod = 1000000007;

        Stack<Integer> st = new Stack<>();

        int[] left = new int[n];  
        int[] right = new int[n];

   
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? i + 1 : i - st.peek();

            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n - i : st.peek() - i;

            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            sum = (sum + (long) arr[i] * left[i] * right[i]) % mod;
        }

        return (int) sum;
    }
}