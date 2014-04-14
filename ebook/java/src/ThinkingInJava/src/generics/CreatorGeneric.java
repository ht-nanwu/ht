package generics;

//: generics/CreatorGeneric.java

abstract class GenericWithCreate<T> {
	final T element;

	GenericWithCreate() {
		element = create();
		System.out.println("abstract init!!!!");
	}

	abstract T create();
}

class test {
}

class Creator extends GenericWithCreate<test> {
	test create() {
		System.out.println("Creator init!!!!");
		return new test();
	}

	void f() {
		System.out.println(element.getClass().getSimpleName());
	}
}

public class CreatorGeneric {
	public static void main(String[] args) {
		Creator c = new Creator();
		c.f();
	}
} /*
 * Output: test
 */// :~
