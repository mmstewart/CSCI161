package lab11;

/**
 * @version 9/27/2016
 * @author Joshu_Zicke744
 * Creates a queue
 */
public interface Queue<E> {
    /**
     * Returns the number of elements in the queue
     * @return 
     */
    int size();
    /**
     * Tests whether the queue is empty
     * @return 
     */
    boolean isEmpty();
    /**
     * Inserts an element at the rear of the queue
     * @param e 
     */
    void enqueue(E e);
    /**
     * Returns. but does not remove, the first element of the queue (null if empty)
     * @return 
     */
    E first();
    /**
     * Removes and returns the first element of the queue (null if empty)
     * @return 
     */
    E dequeue();
}
