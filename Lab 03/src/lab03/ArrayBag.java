package lab03;

import com.sun.webkit.dom.CounterImpl;
import java.util.Random;

/**
 *
 * @author Marcus
 * @version 9/16/16
 * @param <T>
 * * The ArrayBag Generic Class
 * * * Implements Bag Generic Interface
 * * * * Methods do specific things once called on(i.e. remove a random player or add  specific player).
 * * * * * Provides generic methods from the Bag interface that will be called in the main class, with descriptions.
 */
public class ArrayBag<T> implements Bag<T> {
    
    public T[] bag;
    public int count;

    /**
     *
     */
    public ArrayBag() {
        bag = (T[]) new Object[1];
    }

    /**
     *
     * @param c
     */
    public ArrayBag(int c) {
        for (int a = 0; a < c; a++) {
            bag = (T[]) new Object[a];
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int getCount() {
        return count;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isFull() {
        return count == bag.length+1;
    }

    /**
     *
     * @param num
     */
    @Override
    public void add(T num) {
        if (count == bag.length) {
            T[] bag2 = (T[]) new Object[bag.length * 2];
            System.arraycopy(bag, 0, bag2, 0, bag.length);
            bag = bag2;
            
        }
        bag[count] = num;
        
        count++;
        
    }

    /**
     *
     * @return
     */
    @Override
    public T remove() {
        Random rand = new Random();
        int index = rand.nextInt(count);
        T number = bag[index];

        for (int d = index; d < count-1; d++) {
            bag[d] = bag[d + 1];
        }
        count--;
        return number;
    }

    /**
     *
     * @param item
     */
    @Override
    public void remove(int item) {
        for (int f = 0; f < count; f++) {
            if (bag[f].equals(item)) {
                for (int g = f; g < count-1; g++) {
                    bag[g] = bag[g + 1];
                }
                count--;
                break;
            }
        }
    }

    /**
     * 
     * @return 
     */
    @Override
    public int removeAll() {
        return count = 0;
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean itemExists() {
        for (T bag1 : bag) {
            if (bag1.equals(bag)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArrayBag)) {
            return false;
        } else {
            ArrayBag s = (ArrayBag) o;
            return count == s.count;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String s = "[ ";
        for (int u = 0; u < count; u++) {
            s += bag[u];
            s += ", ";
        }
        s += "]";
        return s;
    }

    /**
     * 
     * @return 
     */
    public T[] arrayCopy() {
        T[] temp = (T[]) new Object[bag.length];
        for (int a = 0; a < count; a++) {
            temp[a] = (T) bag[a];

        }
        return temp;
    }

    /**
     * 
     * @param i
     * @return
     * @throws ArrayIndexOutOfBoundsException 
     */
    public T get(int i) throws ArrayIndexOutOfBoundsException {
        if (i <= 0 || i > count-1) {
            throw new ArrayIndexOutOfBoundsException("Invalid index entry: " + i);
        }
        T scores = bag[i];
        return scores;
    }
}
