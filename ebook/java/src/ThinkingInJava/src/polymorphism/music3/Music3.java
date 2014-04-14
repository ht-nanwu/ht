//: polymorphism/music3/Music3.java
// An extensible program.
package polymorphism.music3;

import java.util.Random;

import polymorphism.music.Note;
import static net.mindview.util.Print.*;

class Instrument {
	@Override
	public String toString() {
		return "Instrument";
	}

	void play(Note n) {
		print("Instrument.play() " + n);
	}

	// String what() {
	// return "Instrument";
	// }

	void adjust() {
		print("Adjusting Instrument");
	}
}

class Wind extends Instrument {
	void play(Note n) {
		print("Wind.play() " + n);
	}

	String what() {
		return "Wind";
	}

	void adjust() {
		print("Adjusting Wind");
	}
}

class Percussion extends Instrument {
	void play(Note n) {
		print("Percussion.play() " + n);
	}

	String what() {
		return "Percussion";
	}

	void adjust() {
		print("Adjusting Percussion");
	}
}

class Stringed extends Instrument {
	void play(Note n) {
		print("Stringed.play() " + n);
	}

	String what() {
		return "Stringed";
	}

	void adjust() {
		print("Adjusting Stringed");
	}
}

class Brass extends Wind {
	void play(Note n) {
		print("Brass.play() " + n);
	}

	void adjust() {
		print("Adjusting Brass");
	}
}

class Woodwind extends Wind {
	void play(Note n) {
		print("Woodwind.play() " + n);
	}

	String what() {
		return "Woodwind";
	}
}

class randomInstrument {

	static Instrument randomReturn() {
		Random rdm = new Random();
		switch (rdm.nextInt(4)) {
		default:
		case 1:
			return new Wind();
		case 2:
			return new Percussion();
		case 3:
			return new Stringed();
		case 4:
			return new Woodwind();
		case 5:
			return new Brass();

		}
	}

}

public class Music3 {
	// Doesn't care about type, so new types
	// added to the system still work right:
	public static void tune(Instrument i) {
		// ...
		i.play(Note.MIDDLE_C);
	}

	public static void tuneAll(Instrument[] e) {
		for (Instrument i : e) {
			tune(i);
		}

	}

	public static void main(String[] args) {
		// Upcasting during addition to the array:
		// Instrument[] orchestra = { new Wind(), new Percussion(), new
		// Stringed(), new Brass(), new Woodwind() };
		Instrument[] orchestra = new Instrument[5];
		for (int i = 0; i < orchestra.length; i++) {
			orchestra[i] = randomInstrument.randomReturn();
		}

		System.out.println(new Wind());
		tuneAll(orchestra);
	}
} /*
 * Output: Wind.play() MIDDLE_C Percussion.play() MIDDLE_C Stringed.play()
 * MIDDLE_C Brass.play() MIDDLE_C Woodwind.play() MIDDLE_C
 */// :~
