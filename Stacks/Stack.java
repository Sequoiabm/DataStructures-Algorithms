public class Stack<E> {
    private java.util.Stack<E> stack;

    public Stack() {
        stack = new java.util.Stack<>();
    }

    public void push(E item){
        stack.push(item);
    }

    public E pop(E item){
        if(!isEmpty()) {
            return stack.pop();
        }
        return null;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}