/* 
 * CSS 162 Assert Demo
 * 
 * Usage: This software is configured to crash your program immediately upon execution.
 * If your software doesn't crash, you don't have assertions enabled (use "-ea")
 * in your editor.  Google the name of your editor and "how to enable asserts" or follow
 * the instructions specific to BlueJ or Eclipse in the lab.
 * 
 * Author: Rob Nash
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/* ANSWERS TO QUESTIONS:
1. Debugging with the GUI is by far my favorite technique. It allows me to go 1 step at a time and see exactly what
	my code does and why.
2. For longer programs, asserts can be useful if you need to check that a certain condition is met at a certain point.
	If the condition isn't met, then using the debugger with break points can be a good way to figure out where
	in your code that condition gets changed
3. Using a debugger with a GUI lets you go 1 step at a time to see exactly what your code does. It also shows you the
	call stack to the left and gives you functions to step into, over, our out of methods. The call stack is something
	you get here that you don't get with print statements.
4. Proper documentation can help so that other people can understand your code when debugging it. Sometimes, having
	another set of eyes look at your code can fix a bug instantly. It's very important, however, that the other person
	knows what the code is supposed to do. Sometimes, that other person is yourself if in the future.
	It's hard to remember exactly what you wrote and why you wrote it, so documentation can save you.

 */

public class AssertDemo {

	/* Work on this in a piecewise fashion by uncommenting and focusing on one section at a time
	 * in isolation rather than running everything at once.
	 */
	public static void main(String[] args) {
		assert(true);
		//assert(false); Assert will cause a runtime error if the argument inside evaluates to false. It does here
		
		warmUpAsserts();
		
		assertWithPrimitives();
		
		assertWithObjects();
		
		homeworkRelatedAsserts();
	}

	/*
	 * Just a few warm-up asserts here.
	 * Add two new assert() statements after the TODO below
	 */
	private static void warmUpAsserts() {	
			assert( 5 > 1 );
			
			int a = 30;
			assert(a != 0);
	
			assert(null == null);	  //could this ever be false?
			assert(true == true);	  //a bad day indeed if this could be false
			//TODO: craft two more asserts and place them here.  If they're false, they'll crash the program.
			assert(80 > 36);
			String str = "Hello!";
			assert(str.length() == 6);
	}

	/*
	 * Using asserts in conjunction with primitive types is familiar to you;
	 * just as in a loop or if, you want to form a true/false (boolean) expression
	 * by employing the relational operators.
	 */
	private static void assertWithPrimitives() {
		//assert below to ensure a Fraction's denominator is never 0
		Scanner keys = new Scanner(System.in);
		System.out.println("Enter an integer numerator:");
		int num = keys.nextInt();
				
		System.out.println("Enter an int denominator, not 0:");
		int denom = keys.nextInt();
				
		assert(denom != 0);
	
		//assert that all ArrayLists start empty
		ArrayList<String> emptyList = new ArrayList<String>();
		assert(emptyList.size() == 0);
		//TODO: build two more asserts that use primitives and relational operators here
		assert(1 + 2 == 3);
		assert(89 - 80 > 0);
	}
	
	/*
	 * Asserts work with both primitives and objects.  Just as you 
	 * use "==" with primitives and ".equals()" with objects, so too 
	 * will you use ".equals()" in asserts that deal with object equality. 
	 */
	private static void assertWithObjects() {
		AssertDemo ad = new AssertDemo();
		ad.checkAddress(ad);		
		//guess what .equals() does if you don't create one yourself? (hint ==)
		assert( ad.equals(ad) );  
		//TODO: make a few objects from any previous lab and test them with assert
		//example: make two Point objects at the origin and assert they are equal
		//assert(p1.equals(p2);  //example
		Shape s1 = new Shape(1, 2, Color.BLUE);
		Shape s2 = s1;
		assert(s2.equals(s1));
		assert(s2.getX() == 1);
		assert(s1.getY() == 2);
	}


	/*
	 * This function compares the address at "this" to the address of the object handed 
	 * into the function.
	 *
	 * checkAddress prints the address of this AssertDemo object as well as that of the input object.
	 * It then causes a runtime error of the two addresses are not equal
	 *
	 * this maps to address 4dd8dc3. input also maps to the same address. This makes sense since it's the same thing
	 */
	public void checkAddress(Object input) {
		System.out.println("Address of this :" + this);
		System.out.println("Address of input:" + input);
		//how many aliases for the one "new" object created in main exist in this scope? 
		//1? 2? 3? Which are they?
		assert(this == input);  //== does an address check for objects, which is frequently NOT what we want
	}

	/*	
	 * Asserts are a useful tool for transforming postconditions and class invariants into code.
	 * Lets build a few asserts that work with your current Bill & Money assignment.
	 * Change the value of paidDate and cents to trip the asserts and observe the asserted error message. 
	 */
	private static void homeworkRelatedAsserts() {
		Object paidDate = new Object();  //really, a Date 
		assert( paidDate != null);  	 //perhaps one rule is that paidDate shouldn't be null after calling setPaidDate()
		int cents = 0;
		assert( cents >= 0 && cents <=99);  //another class invariant is written as an assert here.
		//TODO: craft 2 more asserts that you could use with any assignment
		String str1 = "HI";
		String str2 = "HI";
		assert(str1.equals(str2));
		int money = 100;
		for (int i = 0; i < 10; i++) {
			money *= 2;
		}
		assert(money > 3000);
	}
}
