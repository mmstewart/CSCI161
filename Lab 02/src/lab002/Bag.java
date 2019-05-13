/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab002;

/**
 *
 * @author Marcus
 */
public interface Bag {
    
    int getCurrentSize();
    
    boolean isEmpty();
    
    int add(int num);
    
    int remove();
    
    int clear();
    
    int getFrequencyOf(int num);
    
    boolean contains(int num);
    
    @Override
    String toString();
    
    @Override
    boolean equals(Object o);
}
