package homework;

import static net.mindview.util.Print.print;

public class finalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test[] composing = { new test(),
				new test(),
				new test(),
				new test(),
				new test() };
	}
}

class test {
	private static int a = 0;
	private  final int b = a++;
	private  static final int c = a++;

	test() {
		MinePrint.println(null, String.valueOf(b));
		MinePrint.println(null, String.valueOf(c));
		print("Creating " + this);
	}
	
	public String toString() {
		return "Composing " + b;
	}
}