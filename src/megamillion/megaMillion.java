/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package megamillion;

/**
 *
 * @author sheehantoufiq
 */
import java.util.*;
public class megaMillion {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
                
        // Runs Ticket Generator
        ticketGen: while(true) {       
        
            Scanner sc = new Scanner(System.in);
            Random rand = new Random();
     
            // Generates a ticket
            int[] group1 = new int[5];
            {
                group1[0] = (int) (rand.nextInt(56) + 1);
                group1[1] = (int) (rand.nextInt(56) + 1);
                group1[2] = (int) (rand.nextInt(56) + 1);
                group1[3] = (int) (rand.nextInt(56) + 1);
                group1[4] = (int) (rand.nextInt(56) + 1);
            }           
            
            // Prompts user for tickets
            System.out.println("Enter how many tickets you would like to purchase (1 - 5):");
            String userInput = sc.nextLine().trim();
            int ticketNum = Integer.parseInt(userInput);
            
            // Checks for illegal number of tickets
            if (ticketNum > 5 || ticketNum < 1) {
                System.out.println("Number must be between 1 - 5.");                
                continue;
            } else {
                System.out.println("Thank you, here are your numbers:");
                
                // Generates 2 Groups of numbers for each ticket
                for (int j = 0; j < ticketNum; j++) {
                    
                    // Generates Group 2 Number
                    int group2 = (rand.nextInt(46) + 1); 
                    
                    // Generates individual tickets
                    for (int i = 0; i < group1.length; i++) {
                        group1[i] = (rand.nextInt(56) + 1);
                        Arrays.sort(group1);                    
                    }
                    
                    // Checks for duplicates
                    for (int i = 0; i < group1.length; i++) {
                        if (group1[i] == group1[i]) {
                            group1[i] = (rand.nextInt(56) + 1);
                        }
                        Arrays.sort(group1);                    
                    }
                    
                    // Prints Numbers
                    System.out.println("Group 1: " + Arrays.toString(group1) + " Group 2: [" + group2 + "]");                
                }
                       
                // Prompts user for re-play
                System.out.println("Would you like to purchase more tickets? (yes/no)");
            
                String userAnswer = sc.next();
                if (userAnswer.equals("no")) {
                    System.out.println("Thank you for playing!");
                    break;
                }
                else {
                    // Replays Ticket Generator
                    continue ticketGen;            
                }
            }
        }
    }
}
