import java.util.Scanner;
public class LcmHcf {
	/**
	 * calculates HCF of given two numbers
	 * @param firstNumber should always be greater than secondNumber
	 * @param secondNumber
	 * @return HCF of given numbers
	 */
	public int calculateHCFOfGivenNumber(int firstNumber,int secondNumber) {
		if(firstNumber<0||secondNumber<0) {
			throw new AssertionError("Negative Values Are Not Allowed");
		}
		if(firstNumber>=secondNumber) {
			if(secondNumber==0) {
				return firstNumber;
			}
			else {
				return calculateHCFOfGivenNumber(secondNumber,firstNumber%secondNumber);
			}
		}
		return -1;
	}
	/**
	 * calculates LCM of given two numbers
	 * @param firstNumber should always be greater than secondNumber
	 * @param secondNumber
	 * @return LCM of given numbers
	 */
	public int calculateLCMOfGivenNumbers(int firstNumber,int secondNumber) {
		if(firstNumber<0||secondNumber<0) {
			throw new AssertionError("Negative Values Are Not Allowed");
		}
		if(firstNumber>=secondNumber) {
			int lcmOfNumbers=(firstNumber*secondNumber)/(calculateHCFOfGivenNumber(firstNumber,secondNumber));
			return lcmOfNumbers;
		}
		return -1;
	}
	
	public static void main(String args[]){
		int num1, num2, c, HCF, LCM;
	    LcmHcf Obj = new LcmHcf();
	    System.out.println("Enter two integers to calculate their HCF & LCM:- ");
	    Scanner in = new Scanner(System.in);	     
	    num1 = in.nextInt();
	    num2 = in.nextInt();
	    if(num1 <= num2){	
	        c = num1;
	      	num1 = num2;
            num2 = c;
	      } 
	      
	    System.out.println("LCM," + "HCF : " + Obj.calculateLCMOfGivenNumbers(num1, num2) +"," + Obj.calculateHCFOfGivenNumber(num1,num2) );
	  }
}