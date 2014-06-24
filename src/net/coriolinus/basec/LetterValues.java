package net.coriolinus.basec;

public enum LetterValues {
	A(10), B(11), C(12), D(13), E(14), F(15), G(16), H(17), I(18), J(19), K(20), L(
			21), M(22), N(23), O(24), P(25), Q(26), R(27), S(28), T(29), U(30), V(
			31), W(32), X(33), Y(34), Z(35);

	private final int value;

	public char charOf() {
		return (char) (this.value + 87); // ascii 97 == 'a'
	}
	
	public int valueOf() {
		return value;
	}

	private LetterValues(int val) {
		this.value = val;
	}

	public static LetterValues letterOf(int num) {
		switch (num) {
		case 10:
			return LetterValues.A;
		case 11:
			return LetterValues.B;
		case 12:
			return LetterValues.C;
		case 13:
			return LetterValues.D;
		case 14:
			return LetterValues.E;
		case 15:
			return LetterValues.F;
		case 16:
			return LetterValues.G;
		case 17:
			return LetterValues.H;
		case 18:
			return LetterValues.I;
		case 19:
			return LetterValues.J;
		case 20:
			return LetterValues.K;
		case 21:
			return LetterValues.L;
		case 22:
			return LetterValues.M;
		case 23:
			return LetterValues.N;
		case 24:
			return LetterValues.O;
		case 25:
			return LetterValues.P;
		case 26:
			return LetterValues.Q;
		case 27:
			return LetterValues.R;
		case 28:
			return LetterValues.S;
		case 29:
			return LetterValues.T;
		case 30:
			return LetterValues.U;
		case 31:
			return LetterValues.V;
		case 32:
			return LetterValues.W;
		case 33:
			return LetterValues.X;
		case 34:
			return LetterValues.Y;
		case 35:
			return LetterValues.Z;
		default:
			throw new NumberFormatException(String.format(
					"%d is not representable in LetterValues!", num));
		}
	}

	public static LetterValues letterOf(char c) {
		c = Character.toLowerCase(c);
		int num = (int) c - 87; // 'a' == 97, but for our purposes equals 10
		return LetterValues.letterOf(num);
	}
}
