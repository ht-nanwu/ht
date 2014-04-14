package polymorphism;

import homework.MinePrint;
import net.mindview.util.Print;

//: polymorphism/StaticPolymorphism.java
// Static methods are not polymorphic.

class StaticSuper {
	public static String staticGet() {
		return "Base staticGet()";
	}

	private static String privatecGet() {
		return "Base privateGet()";
	}

	public String dynamicGet() {
		return "Base dynamicGet()";
	}
}

class StaticSub extends StaticSuper {
	public static String staticGet() {
		return "Derived staticGet()";
	}

	public String dynamicGet() {
		return "Derived dynamicGet()";
	}

	public static String privatecGet() {
		return "Derived privateGet()";
	}
}

public class StaticPolymorphism {
	public static void main(String[] args) {
		StaticSuper sup = new StaticSub(); // Upcast
		MinePrint.println("sup的对象为", sup.getClass());
		// private static方法是不能被重写的。
		System.out.println(sup.staticGet());
		System.out.println(sup.dynamicGet());
	}
} /*
 * Output: Base staticGet() Derived dynamicGet()
 */// :~
