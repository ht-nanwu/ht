package generics;

//: generics/CovariantArrays.java

class Fruit {
	static String fruit = "Fruit";
}

class Apple extends Fruit {
	static String apple = "Apple";
	void test(){}
	
}

class Jonathan extends Apple {
	static String jonathan = "Jonathan";
}

class Orange extends Fruit {
	static String orange = "Orange";
}

public class CovariantArrays {
	public static void main(String[] args) {
		//Fruit[] fruit = new Apple[10];
		Fruit[] fruit = new Fruit[10];
		System.out.println(fruit.getClass().getSimpleName());
		fruit[0] = new Apple(); // OK
		fruit[1] = new Jonathan(); // OK
		// Runtime type is Apple[], not Fruit[] or Orange[]:
		try {
			// Compiler allows you to add Fruit:
			fruit[0] = new Fruit(); // ArrayStoreException
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			// Compiler allows you to add Oranges:
			fruit[0] = new Orange(); // ArrayStoreException
		} catch (Exception e) {
			System.out.println(e);
		}
	}
} /*
 * Output: java.lang.ArrayStoreException: Fruit java.lang.ArrayStoreException:
 * Orange
 */// :~
