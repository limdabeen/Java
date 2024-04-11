package 자료구조;
import java.util.EmptyStackException;

public class ListStack <E>{
    private Node<E> top;
    private int size;
    
    public ListStack() {
        top = null;
        size = 0;
    }
    
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getData();
    }
    
    public void push(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;
        
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
        
        public E getData() {
            return data;
        }
        
        public void setData(E data) {
            this.data = data;
        }
        
        public Node<E> getNext() {
            return next;
        }
        
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
    }
}
