/**
 * Handles integer cases
 * 
 */

package net.coriolinus.basec;

public class ArbitraryBaseInteger {
	private long value; // the value of the integer, stored in good old binary

	/**
	 * @param number
	 *            A number, specified in the given base
	 * @param base
	 */
	public ArbitraryBaseInteger(String number, int base) {
		this.value = ArbitraryBaseInteger.interpret(number, base);
	}
	
	public String formatAs(int base) {
		return ArbitraryBaseInteger.formatAs(this.value, base);
	}

	/**
	 * Format the given number as a string with the given base
	 * 
	 * @param num
	 * @param base
	 * @return
	 */
	public static String formatAs(long num, int base) {
		StringBuilder ret = new StringBuilder();
		
		if (base < 2 || base > 36) {
			throw new IllegalArgumentException("Base must be in range 2..36");
		}
		
		int exp = ArbitraryBaseInteger.maxExponentLessThan(num, base);
		if (exp == -1) return "0";
		while (exp >= 0) {
			long pos_val = Math.round(Math.pow(base, exp));
			int char_val = (int) (num / (pos_val));
			assert char_val < base;
			ret.append(ArbitraryBaseInteger.charOf(char_val));
			num -= char_val * pos_val;
			exp -= 1;
		}
		assert num == 0;
		return ret.toString();
	}

	/**
	 * @param number
	 *            A number, specified in the given base
	 * @param base
	 * @return The number as standard Java long
	 */
	public static long interpret(String number, int base) {
		assert (base > 1) && (base <= 36);
		
		long ret = 0;

		// interpret the number, from the right
		for (int power = 0; power < number.length(); ++power) {
			int v = ArbitraryBaseInteger.valueOf(number.charAt(number.length() - power - 1), base);
			ret += v * Math.pow(base, power);
		}
		
		return ret;
	}

	/**
	 * @param c
	 *            a character to be interpreted according to a given base
	 * @param base
	 * @return the integer value of the given character
	 */
	private static int valueOf(Character c, int base) {
		int v;
		try {
			v = Integer.parseInt(c.toString());
		} catch (NumberFormatException e) {
			v = LetterValues.letterOf(c).valueOf();
		}
		if (v >= base) {
			throw new IllegalArgumentException(String.format("Value %d >= base %d", v, base));
		}
		return v;
	}
	
	/**
	 * @param n
	 * @return the character representing a given number, assuming that number fits into one character in the current base
	 */
	private static char charOf(int n) {
		char ret;
		assert (n >= 0) && (n <= 36);
		if (n < 10) {
			ret = (char) (n + 48); // chr(48) == '0'
		} else {
			ret = LetterValues.letterOf(n).charOf();
		}
		return ret;
	}
	
	/**
	 * Otherwise known as "digitsOf"
	 * @param num
	 * @param base
	 * @return the maximal integer exponent of base for which which (base ^ exp) is <= than num
	 */
	public static int maxExponentLessThan(long num, int base) {
		int exp = 0;
		while (Math.pow(base,  exp) <= num) {
			exp += 1;
		}
		return exp - 1;
		
//		return (int) (Math.round(Math.ceil(Math.log(num) / Math.log(base)))) - 1;
	}
	
}
