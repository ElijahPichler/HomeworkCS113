package Homework3;

import java.util.LinkedList;

public class Polynomial {
	LinkedList<Term> list;
	/**
	 * Default Constructor
	 */
	public Polynomial() {
		list = new LinkedList<>();
	}
	/**
	 * Constructor when given a Polynomial
	 * @param p
	 */
	public Polynomial(Polynomial p) {
		list = p.list;
	}
	/**
	 * Adds two Polunomials
	 * @param p
	 */
	public void add(Polynomial p) {
		Term t = new Term(); 
		for(int i =0; i < p.getNumTerms(); i++) {
			if(p.list.get(i).exponent == this.list.get(i).exponent)
			this.list.get(i).coefficient += p.list.get(i).coefficient;
			
		}
	}
	/**
	 * Returns the size of the Polynomial
	 * @return
	 */
	public int getNumTerms() {
		return this.list.size();
	}
	/**
	 * Adds a term to the Polynomial
	 * @param t
	 */
	public void addTerm(Term t) {
		list.add(t);
	}
	/**
	 * Removes a term from the Polynomial
	 * @param index
	 * @return
	 */
	public Term remove(int index) {
		return list.remove(index);
	}
	/**
	 * Gets a Term from the Polynomial
	 * @param index
	 * @return
	 */
	public Term getTerm(int index) {
		return list.get(index);
	}
	/**
	 * Clears the entire Polynomial
	 */
	public void clear() {
		list.clear();
	}
	/**
	 * Makes the Polynomial into a String
	 */
	public String toString() {
		if(list.size() == 0)
			return "0";
		
		String outcome = "";
		int c,e, coefficient;
		for(int i = 0; i < list.size(); i++) {
			
			c = list.get(i).coefficient;
			e = list.get(i).exponent;
			coefficient = (c < 0)? c* -1:c*1;
			outcome += ((c >= 0 && !outcome.equals(""))?"+":"-") + coefficient + "x^" + e + "";
		}
//		for(Term t : list) {
//			outcome += ((t.coefficient >= 0)?"+":"-" + t.coefficient +"x^" + t.exponent);
//		}
		return outcome;
	}
	
}
