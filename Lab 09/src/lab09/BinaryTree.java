package lab09;

/**
 *
 * @author Marcus
 * @param <E>
 */
public interface BinaryTree<E> extends Tree<E> {

    /**
     * 
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}

