package lab10;

/**
 *
 * @author Marcus
 * @version 11/9/16
 * * The Client Class w/ main method
 * * * Displays the verbose cyclic-shift hash code computation for the strings POTS, STOP, and TOPS.
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Creates three variables from POTS, STOP, and TOPS
        String pOTS = "POTS";
        String sTOP = "STOP";
        String tOPS = "TOPS";
        
        System.out.println("Summary hash code information:");
        System.out.println();
        
        //Hardcoded the POTS, STOP and TOPS binary code 
        System.out.println("POTS : 0000000000" + Integer.toBinaryString(hashCode(pOTS)).replace(' ', '0'));
        System.out.println("STOP : 0000000000" + Integer.toBinaryString(hashCode(sTOP)).replace(' ', '0'));
        System.out.println("TOPS : 0000000000" + Integer.toBinaryString(hashCode(tOPS)).replace(' ', '0'));
        System.out.println();
        
        //Prints out the 32-bit integer bit pattern at each stage of the cyclic-shift hash code computation 
        System.out.println("Detailed hash code information:\n");
        System.out.println(hashCodeVerbose(pOTS));
        System.out.println(hashCodeVerbose(sTOP));
        System.out.println(hashCodeVerbose(tOPS));   
    }
    
    //this method prints out the 32-bit integer bit pattern at each stage of the cyclic-shift hash code computation 
    /**
     * 
     * @param s
     * @return 
     */
    public static String hashCodeVerbose(String s)
    {
        int h = 0;
        System.out.println("Creating hash code for " + s + ":\n");
        for(int i = 0; i < s.length(); i++)
        {
            System.out.println("Entering hash code, pass " + i + "\t\t" + String.format("%32s\n", Integer.toBinaryString(h)).replace(' ', '0')); //starts the next pass for the letter
            System.out.println("hashCode <<5\t\t\t\t" + String.format("%32s\n", Integer.toBinaryString(h << 5)).replace(' ', '0')); //5 bit shift to the left of all 0s
            System.out.println("hashCode >>> 27\t\t\t\t" + String.format("%32s\n", Integer.toBinaryString(h >>> 27)).replace(' ', '0')); //27 bit shift to the right of all 0s
            System.out.println("hashCode <<5 | hashCode >>> 27\t\t" + String.format("%32s\n", Integer.toBinaryString(h << 5 | h >>> 27)).replace(' ', '0')); //5-bit shift of the running sum
            System.out.println("Adding character " + s.charAt(i) + "\t\t\t" + String.format("%32s\n", Integer.toBinaryString(h)).replace(' ', '0')); //adding the character's binary to the binary sequence
            System.out.println("Exiting hashCode\t\t\t" + String.format("%32s", String.format("%32s\n", Integer.toBinaryString(h << 5 | h >>> 27))).replace(' ', '0')); //exiting the binary shift from the step above
            h = (h<<5) | (h>>>27); //5-bit shift of the running sum
            h += (int)s.charAt(i); //add in next character
        }
        return "hashCode code for " + s + " is\t\t" + String.format("%32s\n", Integer.toBinaryString(h).replace(' ', '0')); //binary code for the word
    }
    
    //this method prints out the hashcode method for each word
    /**
     * 
     * @param s
     * @return 
     */
    public static int hashCode(String s)
    {
        int h = 0;
        for(int i = 0; i < s.length(); i++)
        {
            h = (h<<5) | (h>>>27); //5-bit shift of the running sum
            h += (int)s.charAt(i); //add in next character
        }
        return h;
    }
}
