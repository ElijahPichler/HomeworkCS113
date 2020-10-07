package Homework3;
import java.util.Scanner;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polynomial p = new Polynomial();
		Scanner keyBoard = new Scanner(System.in); 
		int input;
		do {
			System.out.println("1. Edit First Polynomial:");
			System.out.println("2. Edit Second Polynomial:");
			System.out.println("3. Display Polynomial:");
			System.out.println("4. Exit:");
			input = keyBoard.nextInt(); 
			
			switch(input) {
				case 1:
					int choice;
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("What would you like to do with Polynomial 1?");
					System.out.println("1. Clear:");
					System.out.println("2. Create:");
					System.out.println("3 Add Term:");
					choice = keyBoard.nextInt();
					if(choice == 1) {
						p.clear();
						System.out.println("All CLeared!");
						
					}else if(choice == 2) {
						Polynomial newPoly = new Polynomial();
						System.out.println("Please enter how many terms you would like in your new Polynomial:");
						int total = keyBoard.nextInt();
						for(int i = 0; i < total; i++) {
							int c,e;
							System.out.println("Coefficient:");
							c = keyBoard.nextInt();
							System.out.println("Exponent:");
							e = keyBoard.nextInt();
							newPoly.addTerm(new Term(c,e));
							
						}
						p = newPoly;
					}else {
						int c,e;
						System.out.println("Coefficient:");
						c = keyBoard.nextInt();
						System.out.println("Exponent:");
						e = keyBoard.nextInt();
						p.addTerm(new Term(c,e));
					}
					break;
				case 2:
					int choice2;
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("What would you like to do with Polynomial 2?");
					System.out.println("1. Clear:");
					System.out.println("2. Create:");
					System.out.println("3 Add Term:");
					choice2 = keyBoard.nextInt();
					if(choice2 == 1) {
						p.clear();
						System.out.println("All CLeared!");
						
					}else if(choice2 == 2) {
						Polynomial newPoly2 = new Polynomial();
						System.out.println("Please enter how many terms you would like in your new Polynomial:");
						int total = keyBoard.nextInt();
						for(int i = 0; i < total; i++) {
							int c,e;
							System.out.println("Coefficient:");
							c = keyBoard.nextInt();
							System.out.println("Exponent:");
							e = keyBoard.nextInt();
							newPoly2.addTerm(new Term(c,e));
							
						}
						p = newPoly2;
					}else {
						int c,e;
						System.out.println("Coefficient:");
						c = keyBoard.nextInt();
						System.out.println("Exponent:");
						e = keyBoard.nextInt();
						p.addTerm(new Term(c,e));
					}
					
					break;
				default:
					System.out.println(p);
					break;
					
			}
				
		}while(input != 4);
		
		System.out.println("Enjoy your day!");
	}

}
