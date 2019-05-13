package lab11;

/**
 * @version 9/27/2016
 * @author Joshu_Zicke744
 * A class that sets up the SinglyLinkedList to use with the queue and other classes
 */
public class SinglyLinkedList<E> {
    /**
     * 
     * @param <E> 
     */
    public static class Node<E> {
        private E element;
        private Node<E> next;
        /**
         * 
         * @param e
         * @param n 
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        /**
         * 
         * @return 
         */
        public E getElement() {
            return element;
        }
        /**
         * 
         * @return 
         */
        public Node<E> getNext() {
            return next;
        }
        /**
         * 
         * @param n 
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    public SinglyLinkedList() {}
    /**
     * 
     * @return 
     */
    public int size() {
        return size;
    }
    /**
     * 
     * @return 
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * 
     * @return 
     */
    public E first() {
        if(isEmpty()) return null;
        return head.getElement();
    }
    /**
     * 
     * @return 
     */
    public E last() {
        if(isEmpty()) return null;
        return tail.getElement();
    }
    /**
     * 
     * @param e 
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if(size == 0) {
            tail = head;
        }
        size++;
    }
    /**
     * 
     * @param e 
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if(isEmpty()) {
            head = newest;
        }
        else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }
    /**
     * 
     * @return 
     */
    public E removeFirst() {
        if(isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0) {
            tail = null;
        }
        return answer;
    }
}
