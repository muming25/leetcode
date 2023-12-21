class Solution {
    public static int numDecodings(String s) {
        if (s.charAt(0) == '0'){
            return 0;
        }
        int[] map = new int[s.length()];
        map[0] = 1;
        for (int i=1; i<s.length(); i++){
            String twoDigits = s.substring(i-1, i+1);
            int c = Integer.valueOf(twoDigits);

            if (c == 0){
                return 0;
            }

            if (twoDigits.charAt(1) != '0') {
                map[i] += map[i-1];
            }
            if (i > 1 && c >= 10 && c <= 26) {
                map[i] += map[i-2];
            } else if (c >= 10 && c <= 26){
                map[i] ++;
            }
        }
        return map[map.length - 1];
    }
}