class Solution {
    public int numDistinct(String s, String t) {
        int tlen = t.length();
        int slen = s.length();
        int[][] map = new int[tlen][slen];
        for (int i = 0; i < tlen; i++) {
            for (int j = 0; j < slen; j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    if (i == 0 && j == 0){
                        map[i][j] = 1;
                    } else if (i == 0 && j != 0) {
                        map[i][j] = map[i][j-1] + 1;
                    } else if (j != 0) {
                        map[i][j] = map[i][j-1] + map[i-1][j-1];
                    }
                } else if (j != 0) {
                    map[i][j] = map[i][j-1];
                }
            }
        }
        return map[tlen-1][slen-1];
    }
}

//better version with lower memory and runtime.

class Solution {
    public int numDistinct(String s, String t) {
        int tlen = t.length();
        int slen = s.length();
        int[] map = new int[slen];

        if (t.charAt(0) == s.charAt(0)) {
            map[0] = 1;
        }

        for (int j = 1; j < slen; j++) {
            if (t.charAt(0) == s.charAt(j)) {
                map[j] = map[j-1] + 1;
            } else {
                map[j] = map[j-1];
            }
        }

        int lastCount = 0;
        for (int i = 1; i < tlen; i++) {
            for (int j = 0; j < slen; j++) {
                int mapJ = map[j];
                if (i > j) {
                    map[j] = 0;
                } else if (t.charAt(i) == s.charAt(j)) {
                    map[j] = map[j-1] + lastCount;
                } else {
                    map[j] = map[j-1];
                }
                lastCount = mapJ;
            }
        }
        return map[slen-1];
    }
}