package Homework7;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;


public class MorseCodeTree extends BinaryTree<Character> {
	
	
	
   
	/**
	 * This method takes in a input file called MorseCode.txt
	 * and it parses through each line and assigns the character
	 * to the morsecode position in the tree
	 */
	
	public MorseCodeTree() {
		try  { 
			Scanner x = new Scanner(new FileInputStream("MorseCode.txt"));
            Character rootLetter = ' ';
            this.root = new Node<Character>(rootLetter);

            while (x.hasNext()) {
                Node<Character> node = this.root; 
                Character letter = x.next().charAt(0); 
              
                String morse = x.next(); 

                for (int i = 0; i < morse.length(); i++) { 
                    if (morse.charAt(i) == '*') {
                        if (node.left == null) {
                            Node<Character> nextLetter = new Node(letter.toString());
                            node.left = nextLetter;
                        }

                        node = node.left;
                    } else if (morse.charAt(i) == '-') {
                        if (node.right == null) {
                            Node<Character> nextLetter = new Node(letter.toString());
                            node.right = nextLetter;
                        }

                        node = node.right;
                    }
                }

                node.data = letter;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	public  void decodeFile(String fileName) {
		try  { 
			Scanner x = new Scanner(new FileInputStream("fileName"));
            Character rootLetter = ' ';
            this.root = new Node<Character>(rootLetter);

            while (x.hasNext()) {
                Node<Character> node = this.root; 
                Character letter = x.next().charAt(0); 
              
                String morse = x.next(); 

                for (int i = 0; i < morse.length(); i++) { 
                    if (morse.charAt(i) == '*') {
                        if (node.left == null) {
                            Node<Character> nextLetter = new Node(letter.toString());
                            node.left = nextLetter;
                            System.out.println(letter);
                        }

                        node = node.left;
                    } else if (morse.charAt(i) == '-') {
                        if (node.right == null) {
                            Node<Character> nextLetter = new Node(letter.toString());
                            node.right = nextLetter;
                            System.out.println(letter);
                        }

                        node = node.right;
                    }
                }

                node.data = letter;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	 

	/**
	 * Translate a string of morse code and uses the morsecode tree to decode it
	 * 
	 * 
	 * @param morseCode value
	 * @return morseCode in a string format
	 */
    public String translateFromMorseCode(String morseCode)  {
    	String[] letters = morseCode.split(" ");
        String output = "";

        for (int i = 0; i < letters.length; i++) {
            Node node = root;
            for (int j = 0; j < letters[i].length(); j++) {
            	if(letters[i].length() > 4)
            		throw new  IllegalArgumentException();
                if (letters[i].charAt(j) == '*') {
                    if (node.left != null) {
                        Node temp = node.left;
                        node = temp;
                    }
                }
                else if (letters[i].charAt(j) == '-') {
                    if (node.right != null) {
                        Node temp = node.right;
                        node = temp;
                    }
                } else {
                	throw new IllegalArgumentException();
                }
            }
            output += node;
        }
        return output;
    }
    
    
    
   
   public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
	   int choice = -1;
	   while(choice != 4) {
		   System.out.println("1) Test output for all morse code letters");
		   System.out.println("2) Enter a text file to decode");
		   System.out.println("3) Enter a line of morse code to decode");
		   System.out.println("4) Exit");
		   
		   choice = input.nextInt();
		   input.nextLine();
		   switch(choice) {
			   case 1:
				   System.out.println("a *-");
				   System.out.println("b -***");
				   System.out.println("c -*-*");
				   System.out.println("d -**");
				   System.out.println("e *");
				   System.out.println("f **-*");
				   System.out.println("g --*");
				   System.out.println("h ****");
				   System.out.println("i **");
				   System.out.println("j *---");
				   System.out.println("k -*-");
				   System.out.println("l *-**");
				   System.out.println("m --");
				   System.out.println("n -*");
				   System.out.println("p *--*");
				   System.out.println("q --*-");
				   System.out.println("r *-*");
				   System.out.println("s ***");
				   System.out.println("t -");
				   System.out.println("u **-");
				   System.out.println("v ***-");
				   System.out.println("w *--");
				   System.out.println("x -**-");
				   System.out.println("y -*--");
				   System.out.println("z --**");
				   break;
			   case 2:
				  
				   System.out.print("Please enter file name: ");
				   String fileName = input.nextLine();
				   MorseCodeTree tree = new MorseCodeTree();
				   tree.decodeFile(fileName);
				   break;
			   case 3:
				   System.out.print("Enter morse code: ");
				   String morseCode = input.nextLine();
				   MorseCodeTree t = new MorseCodeTree();
				   System.out.println(t.translateFromMorseCode(morseCode));
				   break;
			   default:
				   System.out.println("Goodbye");
				   
		   }
				   
	   }
	   
   }


} // End of class MorseCodeTree