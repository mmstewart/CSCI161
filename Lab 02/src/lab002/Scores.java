package lab002;

import java.util.Arrays;

/**
 *
 * @author Marcus
 * @version 9/2/16
 */
public class Scores implements Bag{
    int[] list;
    int count;
    
    public Scores()
    {
        list = new int[50];
    }
    
    public Scores(int value)
    {
        list = new int[value];
    }

    @Override
    public int getCurrentSize() 
    {
        return count;
    }

    @Override
    public int clear() 
    {
        for (int i = 0; i < count; i++)
        {
        list[i] = count;
        count = 0;
        }
        return count;
    }

    @Override
    public boolean isEmpty() 
    {
//        if(list.equals(isEmpty()))
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
        return count == 0;
    }

    @Override
    public int add(int num) 
    {
//        if(!(list.equals(num)))
        int[] temp = new int[100];
        if(count == list.length)
        {
            temp = new int[100];
            for(int a = 0; a < list.length; a++)
            {
                temp[a] = list[a];
                temp = null;
            }
        }
        temp[list.length - 1] = num;
        return num;
    }

    @Override
    public int getFrequencyOf(int num) 
    {
       count = 0;
       for(int a = 1; a < list.length; a++)
       {
           if()
       }
        
        
    }

    @Override
    public boolean contains(int num) 
    {
        return Arrays.asList(list).contains(num);
    }
    
    
    
    
}
