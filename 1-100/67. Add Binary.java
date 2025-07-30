class Solution {
    public String addBinary(String a, String b) {
        int len_a = a.length();
        int len_b = b.length();
        String ret = "";
        int carry = 0;
        while(len_a > 0 || len_b > 0){
            len_a--;
            len_b--;
            int val = 0;
            if (len_a >= 0 && a.charAt(len_a) == '1') {
                val ++;
            }
            if (len_b >= 0 && b.charAt(len_b) == '1') {
                val ++;
            }
            val += carry;
            carry = val / 2;
            if (val % 2 == 1) {
                ret = "1" + ret;
            } else {
                ret = "0" + ret;
            }
        }
        if (carry == 1) {
            ret = "1" + ret;
        }
        return ret;
    }
}