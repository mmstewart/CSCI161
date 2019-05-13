package lab09;

import java.util.Iterator;

/**
 *
 * @author Marcus
 * @param <E>
 */
public interface Tree<E> extends Iterable<E>{
    
    /**
     * 
     * @return 
     */
    Position<E> root();

    /**
     * 
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @return 
     */
    int size();

    /**
     * 
     * @return 
     */
    boolean isEmpty();

    /**
     * 
     * @return 
     */
    @Override
    Iterator<E> iterator();

    /**
     * 
     * @return 
     */
    Iterable<Position<E>> positions();
}
