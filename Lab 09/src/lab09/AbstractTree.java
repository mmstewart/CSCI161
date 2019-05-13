package lab09;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcus
 * @param <E>
 */
public abstract class AbstractTree<E> implements Tree<E> {

    /**
     * 
     * @param p
     * @return 
     */
    @Override
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    /**
     * 
     * @param p
     * @return 
     */
    @Override
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    /**
     * 
     * @param p
     * @return 
     */
    @Override
    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public int depth(Position<E> p)
    {
        if(isRoot(p))
        {
            return 0;
        }
        return 1 + depth(parent(p));
    }
    
    public int height(Position<E> p)
    {
        int h = 0;
        for(Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }
    
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot)
    {
        snapshot.add(p);
        for(Position<E> c : children(p))
        {
            preorderSubtree(c, snapshot);
        }
    }
    
    public Iterable<Position<E>> preorder()
    {
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
        {
            preorderSubtree(root(), snapshot);
        }
        return (Iterable<Position<E>>) snapshot;
    }
    
    @Override
    public Iterable<Position<E>> positions() {
        return preorder();
    }
    
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot)
    {
        for(Position<E> c : children(p))
        {
            postorderSubtree(c, snapshot);
        }
        snapshot.add(p);
    }
    
    public Iterable<Position<E>> postorder()
    {
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
        {
            postorderSubtree(root(), snapshot);
        }
        return (Iterable<Position<E>>) snapshot;      
    }
    
    
    public Iterable<Position<E>> breadthfirst()
    {
        List <Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
        {
            LinkedQueue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());
            while(!fringe.isEmpty())
            {
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for(Position<E> c : children(p))
                {
                    fringe.enqueue(c);
                }
            }
        }
        return (Iterable<Position<E>>) snapshot;
    }

}
