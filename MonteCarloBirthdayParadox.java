/* Name: Jonathan Price
   Date: 11/28/2018
   Class: CIT-130-Z04B
   
   The purpose of this file is to use a hash set to do a
   Monte Carlo analysis of the birthday paradox that states
   that the odds of 2 people in a group sharing a birthday
   is surprisingly high. */

import java.util.*;

public class MonteCarloBirthdayParadox
{
   public static void main(String[] args) 
   {
      //Call Random() and create an assortment of random numbers
      Random rand = new Random();
      
      //Set amount of tests and hold the probability
      int tests = 100000;
      float prob = 0;
      
      //Create a loop that goes from 10 to 100 by 10
      for (int people = 10; people <= 100; people += 10) 
      {
         //Create a counter for collisions
         int collisions = 0;
         
         //Create a loop that counts the tests that have been run
         for (int runs = 0; runs < tests; runs++)
         {
            //Create the hash set
            Set<Integer> birthdays = new HashSet<>(365);
            birthdays.add(rand.nextInt(365));
            
            //Check for matching birthdays
            for (int i = 0; i < people; i++) 
            {
               int randBirthday = rand.nextInt(365);
               
               if (birthdays.contains(randBirthday)) 
               {
                      collisions++;
                      break;
               }
               birthdays.add(randBirthday);
            }
            
            //Calculate the probability
            prob = (float)collisions / tests;

          }
          
          //Display the results to the user
          System.out.println("After " + tests + " tests there were " + collisions + 
                             " occurrences of shared birthdays in a set of " + people + 
                             " people.");
          System.out.println("Probability: " + prob);
      }
   }
}