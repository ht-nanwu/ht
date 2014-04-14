package polymorphism;

import homework.MinePrint;

//: polymorphism/CovariantReturn.java

class Grain {
	public String toString() {
		return "Grain";
	}
}

class Wheat extends Grain {
	public String toString() {
		return "Wheat";
	}
}

class Mill {
	Grain process() {
		return new Grain();
	}
}

class WheatMill extends Mill {
	@Override
	Wheat process() {
		return new Wheat();
	}

	void test() {

	}
}

public class CovariantReturn {
	public static void main(String[] args) {
		Mill m = new Mill();
		Grain g = m.process();
		System.out.println(g);

		Mill m1 = new WheatMill();
		// m1.test(); 向上转型会遗失和父类不一样的方法。
		WheatMill m2 = new WheatMill();
		m2.test();

		g = m1.process();
		System.out.println(g);

		m = new WheatMill();
		g = m.process();
		System.out.println(g);
	}
} /*
 * Output: Grain Wheat
 */// :~
