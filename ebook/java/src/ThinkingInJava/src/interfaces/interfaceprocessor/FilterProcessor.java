//: interfaces/interfaceprocessor/FilterProcessor.java
package interfaces.interfaceprocessor;

import interfaces.filters.*;

class FilterAdapter implements Processor {

	Filter filter;

	public FilterAdapter(Filter filter) {
		this.filter = filter;
	}

	public String name() {
		return filter.name();
	}

	public Filterform process(Object input) {
		return filter.process((Filterform) input);
	}
}

public class FilterProcessor {
	public static void main(String[] args) {
		Filterform w = new Filterform();
		Apply.process(new FilterAdapter(new LowPass(1.0)), w);
		Apply.process(new FilterAdapter(new HighPass(2.0)), w);
		Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
	}
} /*
 * Output: Using Processor LowPass Waveform 0 Using Processor HighPass Waveform
 * 0 Using Processor BandPass Waveform 0
 */// :~
