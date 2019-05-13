package lab11;

import java.util.Random;

/**
 * @version 11/15/2016
 * @author Joshu_Zicke744
 */
public class Employee {

    Random rand = new Random();
    int id;
    String name;
    int dept;
    int hired;

    public Employee() {
    }

    public int id() {
        return rand.nextInt(99999999) + 0;
    }

    public String name() {
        int length = rand.nextInt(11) + 5;
        StringBuilder sb = new StringBuilder();
        
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] result = new char[length];
        
        for(int i = 0; i < result.length; i++) {
            int randomCharIndex = rand.nextInt(alpha.length);
            result[i] = alpha[randomCharIndex];
        }
        return new String(result);
    }

    public int dept() {
        return rand.nextInt(5) + 1;
    }

    public int hired() {
        return rand.nextInt(2010) + 1995;
    }
    
    public int getId() {
        return id;
    }
    
    public int getDept() {
        return dept;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHired() {
        return hired;
    }
}
