package Homework3;

public class Term implements Comparable{
	int exponent,coefficient;
	/**
	 * Constructor for the Term object
	 * @param ex exponent
	 * @param co coefficient 
	 */
	 public Term(int coefficient, int exponent) {
		this.exponent = exponent;
		this.coefficient = coefficient;
	}
	 /**
	  * Constructor when given a Term
	  * @param t Term giver
	  */
	 public Term(Term t) {
		 this.coefficient = t.getCoefficient();
		 this.exponent = t.getExponent();
	 }
	 /**
	  * Constructor when given a String
	  * @param s String given
	  */
	 public Term(String s) {
		 this.coefficient = Integer.parseInt(s.substring(1,2));
		 this.exponent = Integer.parseInt(s.substring(s.length() - 1));
	 }
	 /**
	  * Constructor when given nothing
	  */
	 public Term() {
		 this.coefficient = 1;
		 this.exponent = 1;
	 }
	 /**
	  * Sets a new value for the exponent
	  * @param newExponent
	  */
	 public void setExponent(int newExponent) {
		 this.exponent = newExponent;
	 }
	 /**
	  * Get the exponent
	  * @return exponent
	  */
	 public int getExponent() {
		 return this.exponent;
	 }
	 /**
	  * Sets a new coefficient
	  * @param newCoefficient
	  */
	 public void setCoefficient(int newCoefficient) {
		 this.coefficient = newCoefficient;
	 }
	 /**
	  * get the coefficient
	  * @return
	  */
	 public int getCoefficient() {
		 return this.coefficient;
	 }
	 
	 /**
	  * Compares two terms to check if they are equal
	  */
	 public int compareTo(Object temp) {
		 Term other = (Term) temp;
		 if(exponent > other.exponent)
			 return 1;
		 else if(exponent < other.exponent)
			 return -1;
		 else 
			 return 0;
	 }
	 /**
	  * Sets both variables to new values
	  * @param i coefficient
	  * @param j exponent
	  */
	 public void setAll(int i, int j) {
		 setExponent(j);
		 setCoefficient(i);
	 }
	 
	 /**
	  * Makes a clone of a Term
	  */
	 public Term clone() {
		 return new Term(this.coefficient,this.exponent);
	 }
	 /**
	  * Adds two Terms together
	  * @param t Term 1
	  * @param i Term 2
	  * @return
	  */
	 public Term sumOf(Term t, Term i) {
		 
		 int sumCoefficient, sumExponent;
		 sumCoefficient = t.coefficient + i.coefficient;
		 sumExponent = t.exponent + i.exponent;
		 return new Term(sumCoefficient, sumExponent);
		 
	 }
	 /**
	  * Adds current Term with new Term
	  * @param t New Term
	  * @return Sum of both Terms
	  */
	 public Term plus(Term t) {
		 return sumOf(new Term(coefficient,exponent),t);
	 }
	 
	/**
	 * Makes Term into a string
	 */
	 public String toString() {
		 if(coefficient != 0) {
			 
			 String sign = (coefficient > 0)?"+":"-";
			 String signExponent = (exponent > 0)?"":"-";
			if(coefficient < 0) {
				coefficient *= -1;
			}
			if(exponent < 0) {
				exponent *= -1;
			}
			 if(exponent == 0) {
				 System.out.println(sign + coefficient);
				 return sign + coefficient;
			 }

			 if(exponent == 1) {
				System.out.println(sign + ((coefficient == 1)? "": coefficient) + "x");
				 return sign + ((coefficient == 1)? "": coefficient) + "x";
			 }
			 System.out.println(sign + ((coefficient == 1 || coefficient == -1)? "": coefficient) + "x^" + signExponent + exponent);
			 return sign + ((coefficient == 1)? "": coefficient) + "x^" + signExponent + exponent;
		 }else {
			 System.out.println("");
			 return "";
		 }
		 	
	 }
	 
	
}
