class Solution {
    public int romanToInt(String s) {
        String[] tableString = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V","IV","I" };
        int[] tableInt = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int output=0;
        for(int i=0;i<tableInt.length;i++){
            while(s.startsWith(tableString[i])){
                output += tableInt[i];
                s = s.substring(tableString[i].length());
            }
        }
        return output;
    }
}