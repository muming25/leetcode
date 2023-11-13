class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; ; i--){
            if (i == -1) {
                int [] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                for(int j = 1; j<newDigits.length; j++){
                    newDigits[j] = digits[j-1];
                }
                return newDigits;
            } else if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        return digits;
    }
}