//: interfaces/filters/Waveform.java
package interfaces.filters;

public class Filterform {
	private static long counter;
	private final long id = counter++;

	public String toString() {
		return "Waveform " + id;
	}
} // /:~
