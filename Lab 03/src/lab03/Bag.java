package lab03;

/**
 *
 * @author Marcus
 * @version 9/16/16
 * @param <T>
 * * The Bag Generic Interface
 * * * Calls on methods without the use of adding any bodies to the methods. Methods are abstract, meaning they can't no bodies
 * * * * Methods don't do anything in Bag, but once implemented in ArrayBag, all the methods must be called and have bodies in the methods.
 */
public interface Bag<T> {

    /**
     *
     * @return
     */
    int getCount();

    /**
     *
     * @return
     */
    boolean isEmpty();

    /**
     *
     * @return
     */
    boolean isFull();

    /**
     *
     *
     * @param num
     */
    void add(T num);

    /**
     *
     * @return
     */
    T remove();

    /**
     *
     * @param item
     */
    void remove(int item);

    /**
     *
     * @return
     */
    int removeAll();

    /**
     *
     * @return
     */
    boolean itemExists();
}
