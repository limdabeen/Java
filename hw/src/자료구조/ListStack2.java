//자료구조(6007) 과제 #5 (60231222 임다빈)
package 자료구조;

public class ListStack2 {
    private Node2 top;

    public ListStack2() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(char data) {
        Node2 newNode = new Node2(data);
        newNode.next = top;
        top = newNode;
    }

    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        char data = top.data;
        top = top.next;
        return data;
    }

    public char peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }
}
