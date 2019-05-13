package lab09;

/**
 *
 * @author Marcus
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {

    private final SinglyLinkedList<E> list = new SinglyLinkedList<>();  

    /**
     * 
     */
    public LinkedStack() 
    {
    
    }  

    /**
     * 
     * @return 
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 
     * @param element 
     */
    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    /**
     * 
     * @return 
     */
    @Override
    public E top() {
        return list.ﬁrst();
    }

    /**
     * 
     * @return 
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }
}
