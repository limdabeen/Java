//자료구조(6007) 과제 #3 (60231222)
package hw;

public class DNode<E> {
    private E item;
    private DNode<E> prev;
    private DNode<E> next;

    public DNode(E newItem, DNode<E> prev, DNode<E> next) {
        item = newItem;
        this.prev = prev;
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public DNode<E> getPrev() {
        return prev;
    }

    public DNode<E> getNext() {
        return next;
    }

    public void setItem(E newItem) {
        item = newItem;
    }

    public void setPrev(DNode<E> newPrev) {
        prev = newPrev;
    }

    public void setNext(DNode<E> newNext) {
        next = newNext;
    }
}
