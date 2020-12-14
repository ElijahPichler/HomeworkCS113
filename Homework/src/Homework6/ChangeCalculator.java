package Homework6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ChangeCalculator {
	private static final int[] COINS = new int[] {25, 10, 5, 1}; 
	private static int counter = 0;
    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * In addition to returning the number of unique combinations, this method will print out each combination to the
     * console. The format of naming each combination is up to the user, as long as they adhere to the expectation
     * that the coins are listed in descending order of their value (quarters, dimes, nickels, then pennies). Examples
     * include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static int calculateChange(int cents) {
        // TODO:
        // Implement a recursive solution following the given documentation.
    	
    	
    	
    	dispense(cents, 0, 0, 0, 0, 0);
    	
        return counter;
    }
    
    //Helper method to solve the problem
    /**
     * 
     * @param amount the amount of cents you want to calculate 
     * @param start  of COINS array to begin calculating sum 
     * 				and prevents duplicate combinations (Starts at 0)	
     * @param q	count of quarters (start at 0)
     * @param d	count of dimes (start at 0)
     * @param n count of nickels (start at 0)
     * @param p count of pennies (start at 0)
     */
    public static void  dispense(int amount, int start, int q, int d, int n, int p) {
    	//Base case when sum of coins equal amount 
    	if(amount == 0) {
    		printChange(q,d,n,p);
    		counter++;
    		return;
    	}
    	
    	// Case when sum of coins become negative
    	if(amount < 0)
    		return;
    	
    	/*
        Each subtree of the recursive call tree will only consider the coins
        smaller than the coin used at the root of the subtree to prevent
        duplicate combinations.
        */
        for (int i = start; i < COINS.length; i++) {
            switch (COINS[i]) {
                case 25:
                    dispense(amount - COINS[i], i, q + 1, d, n, p);
                    break;
                case 10:
                    dispense(amount - COINS[i], i, q, d + 1, n, p);
                    break;
                case 5:
                    dispense(amount - COINS[i], i, q, d, n + 1, p);
                    break;
                case 1:
                    dispense(0, i, q, d, n, amount);
            }
        }
    }
    public static String  dispensePrintToText(int amount, int start, int q, int d, int n, int p) {
    	//Base case when sum of coins equal amount 
    	if(amount == 0) {
    		 printChange(q,d,n,p);
    		
    	}
    	
    	// Case when sum of coins become negative
    	if(amount < 0)
    		return"";
    	
    	/*
        Each subtree of the recursive call tree will only consider the coins
        smaller than the coin used at the root of the subtree to prevent
        duplicate combinations.
        */
        for (int i = start; i < COINS.length; i++) {
            switch (COINS[i]) {
                case 25:
                    dispense(amount - COINS[i], i, q + 1, d, n, p);
                    break;
                case 10:
                    dispense(amount - COINS[i], i, q, d + 1, n, p);
                    break;
                case 5:
                    dispense(amount - COINS[i], i, q, d, n + 1, p);
                    break;
                case 1:
                    dispense(0, i, q, d, n, amount);
            }
        }
        return "";
    }
    

    /**
     * Helper method used to print each unique combination of change.
     *
     * @param q number of quarters
     * @param d number of dimes
     * @param n number of nickels
     * @param p number of pennies
     */
    private static String printChange(int q, int d, int n, int p) {
        String out = "";
        if (q != 0) {
        	out += q > 1 ? q + " Quarters " : q + " Quarter ";
        }
        if (d != 0) {
        	out += d > 1 ? d + " Dimes " : d + " Dime ";
        }
        if (n != 0) {
        	out += n > 1 ? n + " Nickels " : n + " Nickel ";
        }
        if (p != 0) {
        	out += p > 1 ? p + " Pennies " : p + " Penny ";
        }
        
        System.out.println(out);
        return out;
    }

    /**
     * Calls upon calculateChange(int) to calculate and print all possible unique combinations of quarters, dimes,
     * nickels, and pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will also
     * produce a text file named "CoinCombinations.txt", writing each combination to separate lines.
     *
     * @param cents a monetary value in cents
     * @throws IOException 
     */
    public static void printCombinationsToFile(int cents) throws IOException {
        // TODO:
        // This when calculateChange is complete. Note that the text file must be created within this directory.
//    	File file = new File("CoinCombinations.txt");
//    	FileWriter fw = new FileWriter(file);
//    	PrintWriter pw = new PrintWriter(fw);
//    	pw.println(dispensePrintToText(cents,0,0,0,0,0));
//    	pw.close();
    	
    	
    }
    public static void main(String[] args) throws IOException {
    	calculateChange(75);
    }

} // End of class ChangeCalculator