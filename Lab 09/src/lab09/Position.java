package lab09;

/**
 *
 * @author Marcus
 * @param <E>
 */
public interface Position<E>
{
     /**
     * Returns the element stored at this position.
     * 
     * @return the stored element
     * @thorws IllegalStateExceptoin if position no longer valid
     */
    E getElement( ) throws IllegalStateException;
}
