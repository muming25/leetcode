class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length/2 + 1];
        int top = 0;
        for (int i=0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                top--;
                stack[top-1] += stack[top];
            } else if (tokens[i].equals("-")) {
                top--;
                stack[top-1] -= stack[top];
            } else if (tokens[i].equals("*")) {
                top--;
                stack[top-1] *= stack[top];
            } else if (tokens[i].equals("/")) {
                top--;
                stack[top-1] /= stack[top];
            } else {
                stack[top] = Integer.valueOf(tokens[i]);
                top++;
            }
        }
        return stack[0];
    }
}