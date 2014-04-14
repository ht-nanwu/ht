//: interfaces/music5/Music5.java
// Interfaces.
package interfaces.music5;

import polymorphism.music.Note;
import static net.mindview.util.Print.*;

interface Instrument {
	// Compile-time constant:
	int VALUE = 5; // static & final

	// Cannot have method definitions:
	void play(Note n); // Automatically public

	void adjust();
}

class Wind implements Instrument {
	public void play(Note n) {
		print(this + ".play() " + n);
	}

	public String toString() {
		return "Wind";
	}

	public void adjust() {
		print(this + ".adjust()");
	}
}

class Percussion implements Instrument {
	public void play(Note n) {
		print(this + ".play() " + n);
	}

	public String toString() {
		return "Percussion";
	}

	public void adjust() {
		print(this + ".adjust()");
	}
}

class Stringed implements Instrument {
	public void play(Note n) {
		print(this + ".play() " + n);
	}

	public String toString() {
		return "Stringed";
	}

	public void adjust() {
		print(this + ".adjust()");
	}
}

class Brass extends Wind {
	public String toString() {
		return "Brass";
	}
}

class Woodwind extends Wind {
	public String toString() {
		return "Woodwind";
	}
}

/**
 * @author wushp 1.无论是接口，抽象类，还是普通父类都能实现向上转型。 2.ToString是Object类的一部分，不用写在接口里了。
 */
public class Music5 {
	// Doesn't care about type, so new types
	// added to the system still work right:
	static void tune(Instrument i) {
		// ...
		i.play(Note.MIDDLE_C);
	}

	static void tuneAll(Instrument[] e) {
		for (Instrument i : e)
			tune(i);
	}

	public static void main(String[] args) {
		// Upcasting during addition to the array:
		Instrument[] orchestra = { new Wind(), new Percussion(),
				new Stringed(), new Brass(), new Woodwind() };
		tuneAll(orchestra);
	}
} /*
 * Output: Wind.play() MIDDLE_C Percussion.play() MIDDLE_C Stringed.play()
 * MIDDLE_C Brass.play() MIDDLE_C Woodwind.play() MIDDLE_C
 */// :~
