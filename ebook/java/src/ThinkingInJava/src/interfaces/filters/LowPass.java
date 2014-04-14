//: interfaces/filters/LowPass.java
package interfaces.filters;

public class LowPass extends Filter {
	double cutoff;

	public LowPass(double cutoff) {
		this.cutoff = cutoff;
	}

	public Filterform process(Filterform input) {
		return input; // Dummy processing
	}
} // /:~
