class Solution {
    public String intToRoman(int num) {
        String[] tableString = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V","IV","I" };
        int[] tableInt = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String output = "";
        for(int i=0;i<tableInt.length;i++){
            while(num >= tableInt[i]){
                output += tableString[i];
                num -= tableInt[i];
            }
        }
        return output;
    }
}