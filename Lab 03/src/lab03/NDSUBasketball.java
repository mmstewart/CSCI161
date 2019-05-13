package lab03;

import java.util.Scanner;

/**
 *
 * @author Marcus
 * @version 9/16/16
 * * The NDSUBasketball main client
 * * * Uses methods from ArrayBag, Scores and Player Class.
 */
public class NDSUBasketball {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ArrayBag team = new ArrayBag<>(); //calls a new object from the arraybag (explict casted) that is referrenced from <Player>
        ArrayBag courses = new ArrayBag<>(); //calls a new object from the arraybag (explict casted) that is referrenced from <Courses>
        Scanner s = new Scanner(System.in); //declares and inherits a new scanner variable
        String name; //declares name variable
        String jerseyNumber; //declares jerseyNumber variable
        String positionPlayed; //declares positionPlayed variable
       
//        //creates new player variables from the player class 
//        Player player1 = new Player("Jimmy", "Guard", "11");
//        Player player2 = new Player("Graham", "Guard", "8");
//        Player player3 = new Player("Lane", "Forward", "20");
//        Player player4 = new Player("Peter", "Forward", "44");
//        Player player5 = new Player("Center", "Guard", "54");
//        
//        //adds the players to the team object
//        team.add(player1);
//        team.add(player2);
//        team.add(player3);
//        team.add(player4);
//        team.add(player5);
       
        //prints out a for loop of players(5) you would like to enter in the team object
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Player's information: ");
            System.out.println("Player " + (i + 1 ));            
            System.out.println("Player's Name: ");
            name = s.nextLine();            
            System.out.println("What position do you play? ");
            positionPlayed = s.nextLine();          
            System.out.println("Player's Jersey Number: ");
            jerseyNumber = s.nextLine();
            System.out.println();
            
            team.add(new Player(name, positionPlayed, jerseyNumber)); //adds players to the tesm object
        }
        
        team.remove(); //removes a random variable from the bag
        team.add(new Player("Billy", "Power Forward", "50")); //hardcoded a new player to the bag
        System.out.println("Count: " + team.getCount()); //get's the current ammount of players in a bag
        team.remove(1); //removes 1 player, first occurence, from the bag
        System.out.println("Updated count " + team.getCount()); //get's the current count after you remove the player
        System.out.println("Team: " + team.toString()); //prints out everybody from the team
        
        System.out.println();
        
        //creates and institates new course variables
        Courses course1 = new Courses("CSci 161");
        Courses course2 = new Courses("Chemistry 121");
        Courses course3 = new Courses("Spanish 201");
        Courses course4 = new Courses("Calculus I");
        
        //adds courses to the list
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        
        //removes a random course from the list
        courses.remove();
        
        //prints out updated list of courses
        System.out.println("My courses are: " + courses.toString());
    }
}
