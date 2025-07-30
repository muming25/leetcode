class Solution {
    String rec(String str, int count) {
        if (count == 1) {
            return str;
        }
        char c = '\n';
        int times = 0;
        String ret = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                times ++;
            } else if (times > 0){
                ret = ret + times + c;
                c = str.charAt(i);
                times = 1;
            } else {
                c = str.charAt(i);
                times = 1;
            }
        }
        ret = ret + times + c ;
        return rec(ret, count-1);
    }

    public String countAndSay(int n) {
        return rec("1", n);
    }
}