//: interfaces/filters/Filter.java
package interfaces.filters;

/**
 * ①Filter has the same interface elements as Processor,
 * 
 * ②
 * 一，but because it isn’t inherited from Processor
 * 二，because the creator of the Filter class had no clue you might want to use it as a Processor
 * you can’t use a Filter with the Apply.process( ) method
 * @author Administrator
 *
 */
public class Filter {
	public String name() {
		return getClass().getSimpleName();
	}

	public Filterform process(Filterform input) {
		return input;
	}
} // /:~

//class Processor {
//	public String name() {
//		return getClass().getSimpleName();
//	}
//
//	Object process(Object input) {
//		return input;
//	}
//}
