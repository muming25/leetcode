class Solution {
    public int divide(int dividend, int divisor) {
        int counter = 0;
        if (divisor == 1){
            return dividend;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        if (divisor == -1){
            return 0 - dividend;
        }
        
        if(dividend > 0 && divisor > 0) {
            while (dividend >= divisor) {
                dividend -= divisor;
                counter = addOne(counter);
            }
        } else if(dividend < 0 && divisor < 0) {
            while (dividend <= divisor) {
                dividend -= divisor;
                counter = addOne(counter);
            }
        } else if(dividend > 0 && divisor < 0) {
            while (dividend >= 0) {
                dividend += divisor;
                counter = reduceOne(counter);
            }
            if (dividend < 0) {
                counter = addOne(counter);
            }
        } else if(dividend < 0 && divisor > 0) {
            while (dividend <= 0) {
                dividend += divisor;
                counter = reduceOne(counter);
            }
            if (dividend > 0) {
                counter = addOne(counter);
            }
        }
        return counter;
    }
    int addOne(int counter){
        if(counter < Integer.MAX_VALUE){
            counter++;
        }
        return counter;
    }
    int reduceOne(int counter){
        if(counter > Integer.MIN_VALUE){
            counter--;
        }
        return counter;
    }
}