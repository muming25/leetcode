class Solution {
    public int reverse(int x) {
        int output=0;
        int max = Integer.MAX_VALUE/10;
        int maxdigits = Integer.MAX_VALUE%10;
        int min = Integer.MIN_VALUE/10;
        int mindigits = Integer.MIN_VALUE%10;
        int count = 0;
        int maxint = Integer.MAX_VALUE;
		int lenthofmaxinteger = 0;
		while(maxint!=0){
			maxint/=10;
			lenthofmaxinteger++;
		}
        while(x!=0){
            output = output*10 + x%10;
            x /= 10;
            count++;
            if(count == lenthofmaxinteger - 1){
                if((output > max && x!=0) || 
                   (output == max && x>maxdigits) || 
                   (output < min && x!=0) || 
                   (output == min && x<mindigits)){
                    return 0;
                }
            }
        }
        return output;
    }
}