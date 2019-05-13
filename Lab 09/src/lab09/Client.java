package lab09;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Marcus
 * @version 11/1/16
 * * Client class with main method
 * * * Prints out expressions from postfix, in order, pre order, shunting yard and the queue/stack method.
 */
public class Client {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        LinkedQueue<String> sequence; //Creates a new LinkedQueue object of sequence.
        System.out.println("Enter the File Path:");
        Scanner scan = new Scanner(System.in); //Creates a new scanner for user input.
//        String s = "d:/data.txt";
        String s = scan.nextLine(); //Creates a new string variable that read the next line of the file
        sequence = populate(s); //populate the file in the output with the s vsriable.
        
        while (!sequence.isEmpty()) 
        {
            try {
                LinkedQueue<String> lq = postfix(sequence.dequeue());
                
                int tempInt = lq.size();
                for (int i = 0; i < tempInt; i++) { //enqueues the token after dequeueing from the list and then priting out the values in postfix
                    String token = lq.dequeue();
                    System.out.print(token + " ");
                    lq.enqueue(token);
                }
                
                System.out.println("\nEvaluate:\n" + evaulate(lq)); //evaluates each equation
                LinkedBinaryTree<String> lbt = tree(lq); //buiulds the tree method
                
                if (lbt != null) 
                {
                    System.out.print("\nIn order:\n"); //if the linked binary tree is not null, it prints out the in order, pre order, and post order methods.
                    for (Position<String> c : lbt.inorder()) {
                        System.out.print(c.getElement() + " ");
                    }
                    System.out.print("\nPre order:\n");
                    for (Position<String> c : lbt.preorder()) {
                        System.out.print(c.getElement() + " ");
                    }
                    System.out.print("\nPost order:\n");
                    for (Position<String> c : lbt.postorder()) {
                        System.out.print(c.getElement() + " ");
                    }
                    System.out.println();
                }
            } catch (IllegalArgumentException e) { //catches the illegal argument exception if any wrong input.
                System.out.println("*Invalid Argument*");
            }
        }
    }

    public static LinkedQueue<String> populate(String path) throws FileNotFoundException { //populate method populates the output with all the equations from the file.
        LinkedQueue<String> temp = new LinkedQueue<>();
        File f = new File(path);
        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            temp.enqueue(s.nextLine());
        }
        return temp;
    }

    public static LinkedQueue<String> postfix(String populate) //prints the method from infix to postfix
    {
        LinkedQueue<String> queue = new LinkedQueue<>();
        Stack<String> stack = new LinkedStack<>();
        try {
            System.out.println("\nPostfix:");
            System.out.println(populate);
            String[] split = populate.split("\\s");
            if (isOperator(split[split.length-1])) { //if the operator is split in the enque, it is invalid.
                throw new IllegalArgumentException("*Invalid Equation*");
            } else if (isLeft(split[split.length-1])) { //if the left is split in the enque, it's invalid
                throw new IllegalArgumentException("*Invalid Equation*");

            } else {
                int left = 0, right = 0; //if there is a mismatch in parenthese, it is invalid.
                for (int i = 0; i < split.length; i++){
                    if (isRight(split[i])){ //if is right, add one parenthese to the right.
                                right++;
                    }
                    if(isLeft(split[i])){ //if is left, add one parenthese to the left.              
                        left++;
                    }
                }
                    if(left != right)
                    {
                        throw new IllegalArgumentException("*Invalid Equation*");
                    }
                    else {

                    for (int i = 0; i < split.length; i++) {
        
                        if (isNumber(split[i])) {
                            queue.enqueue(split[i]); //if it is a number, add it the the enque
                        }if (isRight(split[i])) { //if it is a right parenthese, and there is no left parentheese on the top of the stack,
                            //enque and then pop it.
                            while (!isLeft(stack.top())) {
                                queue.enqueue(stack.pop());
                                if (stack.isEmpty()) {
                                    
                                    break;
                                }
                            }
                            //else pop it.
                            stack.pop();
                        } //if the operators are next to each other, it's invalid
                        if (twoOperators(split)){
                            throw new IllegalArgumentException("*Invalid Equation*");
                        }
                        //if two numbers are next to each other, it's invalid.
                        if(twoNumbers(split)){
                            throw new IllegalArgumentException("*Invalid Equation*");
                        }
                        else {
                            //if the it is a left parenthese, push it on the stack
                            if (split[i].equals("(") || split[i].equals("[") || split[i].equals("{")) {
                                stack.push(split[i]);
                            }
                            if (split[i].equals("*") || split[i].equals("/")) {
                                while ("*".equals(stack.top()) || !"(".equals(stack.top()) && "/".equals(stack.top())) {
                                    //if it is a * or / and while the * is on the top of the stack or it is not a prenthese or divide on top of the stack,
                                    //add it the the enqueue and pop it.
                                    queue.enqueue(stack.pop());
                                    if (stack.isEmpty()) {

                                        break;
                                    }
                                }
                                stack.push(split[i]);
                            }
                            if (split[i].equals("+") || split[i].equals("-")) {
                                while ("+".equals(stack.top()) || "-".equals(stack.top()) || "*".equals(stack.top()) || "/".equals(stack.top()) && !"(".equals(stack.top())) {
                                    //if it is a + or - and while the + is on the top of the stack or it is a - or * or / and not a ( parethese on top of the stack,
                                    //add it the the enqueue and pop it.
                                    queue.enqueue(stack.pop());
                                    if (stack.isEmpty()) {
                                        break;
                                    }
                                }
                                stack.push(split[i]);
                            }
                        }
                    }
                }
            }
        } catch (IllegalArgumentException e) {
        }
        
        while (!stack.isEmpty()) {
            //if the stack is not empty, pop it
            queue.enqueue(stack.pop());
        }
        System.out.println("Postfix notation:"); //prints out the postfix equation
        return queue;
    }
    
    public static boolean isNumber(String token) {
        try {
            Integer.parseInt(token); //if it a number of the string, return true
            return true;
        } catch (NumberFormatException e) {
            //catch the number format exception because it is not a number and return false.
            return false;
        }
    }
    
    public static boolean isLeft(String token) { //checks for any type of left parenthese.
        return token.equals("(") || token.equals("{") || token.equals("[");
    }

    public static boolean isRight(String token) { //checks for any type of right parenthese.
        return token.equals("]") || token.equals(")") || token.equals("}");
    }

    public static boolean isOperator(String token) { //checks for the four types of operators.
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    public static boolean twoOperators(String[] array) //for the length of the array, if the operator before the main operator are the same, return true because they are the same operator, else return false.
    {
        for(int j = 1; j < array.length;j++)
        {
            if (isOperator(array[j-1]) && isOperator(array[j])) {
                return true;
            }  
        }
        return false;
    }
    
    public static boolean twoNumbers(String[] array) //for the length of the array, if the number before the main number are the same, return true because they are the same number, else return false.
    {
        for(int j = 1; j < array.length;j++)
        {
            if (isNumber(array[j-1]) && isNumber(array[j])) 
            {
                return true;
            }
        }
        return false;
    }
    
    public static int evaulate(LinkedQueue<String> postEvaluate)
    {
       LinkedStack<String> stack = new LinkedStack<>();
       String[] array = new String[postEvaluate.size()]; //create a string array with the size of the linked queue 
       int size = postEvaluate.size();
       for (int i = 0; i < size; i++){
           array[i] = postEvaluate.dequeue(); //for the size of the linked queue, add the dequeue to the array
           postEvaluate.enqueue(array[i]); //enqueue the array
       }
        
        for (int j = 0; j < array.length; j++){
            String token = array[j];
            if (isOperator(token)){ //if it is an operator, -, *, or + pop the right and left of the stack and them to their correct sides
                //turn numbers to integers and the answer will be those numbers added to the integer and then push the result back to the stack.
                int left2 = 0, right2 = 0;
                if ( token.equals("+")){
                   String right1 = stack.pop();
                   String left1 = stack.pop();
                   right2 = Integer.parseInt(right1);
                   left2 = Integer.parseInt(left1);
                   int answer = left2 + right2;
                   stack.push(String.valueOf(answer));
                }
                else if ( token.equals("-")){
                   String right1 = stack.pop();
                   String left1 = stack.pop();
                   right2 = Integer.parseInt(right1);
                   left2 = Integer.parseInt(left1);
                   int answer = left2 - right2;
                   stack.push(String.valueOf(answer));
                }
                else if ( token.equals("*")){
                   String right1 = stack.pop();
                   String left1 = stack.pop();
                   right2 = Integer.parseInt(right1);
                   left2 = Integer.parseInt(left1);
                   int answer = left2 / right2;
                   stack.push(String.valueOf(answer));
                }
                else if ( token.equals("/")){
                   String right1 = stack.pop();
                   String left1 = stack.pop();
                   right2 = Integer.parseInt(right1);
                   left2 = Integer.parseInt(left1);
                   int answer = left2 * right2;
                   stack.push(String.valueOf(answer));
                }
            }
            else{
                stack.push(token);
            }
           
        }
        return Integer.parseInt(stack.pop());
    }
    
    public static LinkedBinaryTree tree(LinkedQueue<String> q) //builds a tree method
    {
        Stack<LinkedBinaryTree<String>> stack = new LinkedStack<>();
        int size = q.size();
        for(int i = 0; i < size; i++) //from 0 to the size of the linkedqueue
        {
            String token = q.dequeue();
            
            if(isNumber(token)) //if it is a number, dequeue from the stack
            {
                LinkedBinaryTree<String> linkedBT = new LinkedBinaryTree(); //create a new binary tree method
                linkedBT.addRoot(token); //use the binary tree addRoot method to add the token to it
                stack.push(linkedBT); //push the linked binary tree
            }
            else
            {
                LinkedBinaryTree<String> linkedbinaryT = new LinkedBinaryTree();
                linkedbinaryT.addRoot(token); //add the token to the created linked binary tree object
                LinkedBinaryTree<String> right = stack.pop(); //create a right variable of the linked binary tree and pop it
                LinkedBinaryTree<String> left = stack.pop(); //create a left variable of the linked binary tree and pop it
                linkedbinaryT.attach(linkedbinaryT.root, left, right); //attach the root, right and left to a node.
                stack.push(linkedbinaryT); //push the linked binary tree
            }
        }
        return stack.pop(); //pop the stack.
    }
}
