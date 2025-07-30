class Solution {
    public String getPermutation(int n, int k) {
        k--;
        String map = "";
        int count = 1;
        for(int i=1; i<=n; i++){
            map = map + i;
            count*=i;
        }
        String ret ="";
        for(int i=n; i>1; i--){
            int index = k/(count/i);
            ret += map.charAt(index);
            map = map.substring(0, index) + map.substring(index + 1);
            count /= i;
            k = k % count;
        }
        return ret+map;
    }
}