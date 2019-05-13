package lab09;

/**
 *
 * @author Marcus
 * @param <E>
 * 
 */
public class SinglyLinkedList<E> implements Stack<E> {

    @Override
    public void push(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E top() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class Node<E> {

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

    /**
     * 
     */
    public SinglyLinkedList() 
    {
    
    } 

    /**
     * 
     * @return 
     */
    @Override
    public int size() 
    {
        return size;
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 
     * @return 
     */
    public E ﬁrst() { 
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    /**
     * 
     * @return 
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    /**
     * 
     * @param e 
     */
    public void addFirst(E e) { 
        head = new Node<>(e, head); 
        if (size == 0) {
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
        if (isEmpty()) {
            head = newest; 
        } else {
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
        if (isEmpty()) {
            return null; 
        }
        E answer = head.getElement();
        head = head.getNext(); 
        size--;
        if (size == 0) {
            tail = null; 
        }
        return answer;
    }
}
