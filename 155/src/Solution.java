import java.util.Stack;

class MinStack {
    Stack<Integer> ms;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        ms = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        ms.push(x);
        if(min.isEmpty())
            min.push(x);
        else if(min.peek() >= x)
            min.push(x);
    }

    public void pop() {
        if(ms.pop() == min.peek() && !min.isEmpty())
            min.pop();
    }

    public int top() {
        return ms.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
