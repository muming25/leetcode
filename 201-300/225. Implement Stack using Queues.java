class MyStack {
    List<Integer> stack = new ArrayList<>();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        stack.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int output;
        
        output = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return output;
    }
    
    /** Get the top element. */
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */