package innerclasses;

//: innerclasses/BigEgg.java
// An inner class cannot be overriden like a method.
import static net.mindview.util.Print.*;

class Egg {
	private Yolk y;

	protected class Yolk {
		public Yolk() {
			print("Egg.Yolk()");
		}
	}

	public Egg() {
		print("New Egg()");
		y = new Yolk();
	}
}

public class BigEgg extends Egg {
	public BigEgg() {
		new Yolk();
		// TODO Auto-generated constructor stub
	}

	public class Yolk extends Egg.Yolk {
		public Yolk() {
			print("BigEgg.Yolk()");
		}
	}

	public static void main(String[] args) {

		new BigEgg();
	}
} /*
 * Output: New Egg() Egg.Yolk()
 */// :~
