//자료구조(6007) 과제 #2 (60231222)
package arcktect;
import java.util.NoSuchElementException;

public class SList<E extends Comparable<E>> {
    private Node<E> head;
    private int size;

    public SList() {
        head = null;
        size = 0;
    }

    public Node<E> getNode(int index) {
        Node<E> current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current;
            }
            count++;
            current = current.getNext();
        }
        return null;
    }

    public void add(E newItem, int index) {
        if (index < 0)
            throw new IllegalArgumentException("Index cannot be negative");
        if (index == 0) {
            insertFront(newItem);
            return;
        }

        Node<E> newNode = new Node<>(newItem, null);
        Node<E> current = getNode(index - 1);
        if (current == null)
            throw new IndexOutOfBoundsException("Index is out of bounds");

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    public void addLast(E newItem) {
        Node<E> newNode = new Node<>(newItem, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public void delete(int index) {
        if (index < 0)
            throw new IllegalArgumentException("Index cannot be negative");
        if (head == null)
            throw new IndexOutOfBoundsException("List is empty");

        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }

        Node<E> current = getNode(index - 1);
        if (current == null || current.getNext() == null)
            throw new IndexOutOfBoundsException("Index is out of bounds");

        current.setNext(current.getNext().getNext());
        size--;
    }

    public void insertFront(E newItem) {
        Node<E> newNode = new Node<>(newItem, head);
        head = newNode;
        size++;
    }

    public int search(E item) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.getItem().equals(item)) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    public void deletAfter(Node<E> prevNode) {
        if (prevNode == null || prevNode.getNext() == null)
            return;
        prevNode.setNext(prevNode.getNext().getNext());
        size--;
    }

    public void deleteItem(E item) {
        if (head == null)
            return;

        if (head.getItem().equals(item)) {
            head = head.getNext();
            size--;
            return;
        }

        Node<E> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getItem().equals(item)) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public void deleteFront() {
        if (head != null) {
            head = head.getNext();
            size--;
        }
    }

    public void reverse() {
        Node<E> prev = null;
        Node<E> current = head;
        Node<E> next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void print() {
        Node<E> current = head;
        System.out.print("항목수(" + size + "): ");
        while (current != null) {
            System.out.print(current.getItem() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}