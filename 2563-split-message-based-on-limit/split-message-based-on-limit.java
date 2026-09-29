class Solution {

    public String[] splitMessage(String message, int limit) {

        int n = message.length();

        int[] prefixDigits = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixDigits[i] = prefixDigits[i - 1] + digits(i);
        }

        for (int parts = 1; parts <= n; parts++) {

            int d = digits(parts);

            
            int maxSuffix = 2 * d + 3;

            if (limit <= maxSuffix) {
                continue;
            }

           
            long suffixLength =
                    (long) prefixDigits[parts]
                    + (long) parts * (d + 3);

           
            long capacity =
                    (long) parts * limit - suffixLength;

            if (capacity < n) {
                continue;
            }

         
            String[] ans = new String[parts];

            int index = 0;

            for (int i = 1; i <= parts; i++) {

                String suffix = "<" + i + "/" + parts + ">";

                int space = limit - suffix.length();

                
                int remainingMessage = n - index;

                int remainingParts = parts - i;

                int take = Math.min(
                        space,
                        remainingMessage - remainingParts
                );

                ans[i - 1] =
                        message.substring(index, index + take)
                        + suffix;

                index += take;
            }

            return ans;
        }

        return new String[0];
    }

    private int digits(int x) {
        if (x < 10) return 1;
        if (x < 100) return 2;
        if (x < 1000) return 3;
        if (x < 10000) return 4;
        return 5;
    }
}