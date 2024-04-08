//자료구조(6007) 과제 #3 (60231222)
package hw;
public class DList<E> {
    private DNode<E> head, tail;
    private int size;

    public DList() {
        head = new DNode<>(null, null, null);
        tail = new DNode<>(null, head, null);
        head.setNext(tail);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E newItem) {
        DNode<E> newNode = new DNode<>(newItem, null, head.getNext());
        if (isEmpty()) {
            tail.setPrev(newNode);
        } else {
            head.getNext().setPrev(newNode);
        }
        head.setNext(newNode);
        size++;
    }

    public void addLast(E newItem) {
        DNode<E> newNode = new DNode<>(newItem, tail.getPrev(), tail);
        tail.getPrev().setNext(newNode);
        tail.setPrev(newNode);
        size++;
    }

    public void deleteItem(E target) {
        DNode<E> current = head.getNext();
        while (current != tail && current != null) {
            if (current.getItem().equals(target)) {
                if (current == head.getNext()) {
                    head.setNext(current.getNext());
                    if (current.getNext() != null) {
                        current.getNext().setPrev(head);
                    }
                } else if (current == tail.getPrev()) {
                    tail.setPrev(current.getPrev());
                    if (current.getPrev() != null) {
                        current.getPrev().setNext(tail);
                    }
                } else {
                    current.getPrev().setNext(current.getNext());
                    if (current.getNext() != null) {
                        current.getNext().setPrev(current.getPrev());
                    }
                }
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public void concat(DList<E> other) {
        if (other.isEmpty()) {
            return;
        }
        tail.getPrev().setNext(other.head.getNext());
        other.head.getNext().setPrev(tail.getPrev());
        tail = other.tail;
        size += other.size;
        other.clear();
    }

    public void clear() {
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("항목수(").append(size).append("): ");
        DNode<E> current = head.getNext();
        while (current != tail) {
            sb.append(current.getItem()).append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    public int search(E item) {
        DNode<E> current = head.getNext();
        int index = 0;
        while (current != tail) {
            if (current.getItem().equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public void insertAfter(int index, E newItem) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        DNode<E> current = getNode(index);
        DNode<E> newNode = new DNode<>(newItem, current, current.getNext());
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
        size++;
    }

    public void insertBefore(int index, E newItem) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        DNode<E> current = getNode(index);
        DNode<E> newNode = new DNode<>(newItem, current.getPrev(), current);
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
        size++;
    }

    private DNode<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        DNode<E> current = head.getNext();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }
}