//자료구조(6007) 과제 #2 (60231222)
package arcktect;

class Node<E> {
 private E item;
 private Node<E> next;

 public Node(E newitem, Node<E> p) {
     item = newitem;
     next = p;
 }

 public E getItem() {
     return item;
 }
 public Node<E> getNext(){
	 return next;
 }

 public void setItem(E newItem) {
     item = newItem;
 }


 public void setNext(Node<E> n) {
     next = n;
 }
}
