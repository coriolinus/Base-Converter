/**
 * Base Converter
 * 
 * Converts input strings, interpreted as numbers with a specified arbitrary base, into output strings representing
 * the same number with (another) arbitrary base. Works for bases 1 to 36, as bases greater than that will run out of
 * english-language characters to use.
 * 
 */
package net.coriolinus.basec;

import java.util.ArrayList;
import java.util.List;

/**
 * @author coriolinus
 *
 */
public class BaseConv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < 50; ++i) {
			nums.add(i);
		}
		for (int i = 2; i < 6; ++i) {
			nums.add((int) Math.round(Math.pow(8, i)));
			nums.add((int) Math.round(Math.pow(10, i)));
			nums.add((int) Math.round(Math.pow(11, i)));
			nums.add((int) Math.round(Math.pow(17, i)));
		}
		
		List<Integer> bases = new ArrayList<Integer>();
		bases.add(2);
		bases.add(3);
		bases.add(5);
		bases.add(8);
		bases.add(10);
		bases.add(12);
		bases.add(16);
		bases.add(20);
		bases.add(25);
		bases.add(30);
		bases.add(36);
		
		for (int num : nums) {
			for (int base : bases) {
				System.out.println(String.format("%d base %d: %s", num, base, ArbitraryBaseInteger.formatAs(num, base)));
			}
			System.out.println();
		}
		
		boolean interpretSuccess = true;
		for (int num : nums) {
			for (int base : bases) {
				if (num != ArbitraryBaseInteger.interpret(ArbitraryBaseInteger.formatAs(num, base), base)) {
					String numBaseN = ArbitraryBaseInteger.formatAs(num, base);
					long result = ArbitraryBaseInteger.interpret(numBaseN, base);
					System.out.println(String.format("Failure to interpret %s base $d; expected %d, got %d", numBaseN, base, num, result));
					interpretSuccess = false;
				}
			}
		}
		if (interpretSuccess) System.out.println("Successfully reversed all test cases");
	}

}
