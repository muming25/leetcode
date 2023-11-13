class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }

        m--;
        n--;
        double ret = 1;
        int x = m;
        if (n < m){
            x = n;
        }
        int pathLength = m + n - x;
        for (int i = 1; i <=x; i++) {
            ret *= (pathLength + i);
            ret /= i;

        }
        return (int) ret;
    }
}