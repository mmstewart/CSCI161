package lab09;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcus
 * @param <E>
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    /**
     * 
     * @param p
     * @return 
     */
    @Override
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) {
            return null; // p must be the root
        }
        if (p == left(parent)) // p is a left child
        {
            return right(parent); // (right child might be null)
        } else // p is a right child
        {
            return left(parent); // (left child might be null)
        }
    }

    /**
     * 
     * @param p
     * @return 
     */
    @Override
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    /**
     * 
     * @param p
     * @return 
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) 
    {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if(left(p) != null)
            snapshot.add(left(p));
        if(right(p) != null)
            snapshot.add(right(p));
        return (Iterable<Position<E>>) snapshot;
    }
    
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot)
    {
        if(left(p)!= null)
        {
            inorderSubtree(left(p), snapshot);
        }
        snapshot.add(p);
        if(right(p)!= null)
        {
            inorderSubtree(right(p), snapshot);
        }
    }
    
    public Iterable<Position<E>> inorder()
    {
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
        {
            inorderSubtree(root(), snapshot);
        }
        return (Iterable<Position<E>>) snapshot;
    }
    
    @Override
    public Iterable<Position<E>> positions()
    {
        return inorder();
    }
    
    public void EulerTour(Tree<E> T, Position<E> p)
    {
        left(p);
        for(Position<E> c : T.children(p))
        {
            EulerTour(T, c);
        }
        right(p);
    }   
}
