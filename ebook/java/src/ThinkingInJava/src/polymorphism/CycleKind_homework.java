package polymorphism;

public class CycleKind_homework {

	public static void main(String[] args) {

		runEach(new Unicycle());
		runEach(new Bicycle());
		runEach(new Tricycle());

		// 向上转型子类遗失了自己的方法。
		Cycle_homework[] test = { new Unicycle(), new Bicycle(),
				new Tricycle() };
		// 向下转型后能时候子类方法了。
		Unicycle test_1 = (Unicycle) test[0];
		test_1.balance();
		Bicycle test_2 = (Bicycle) test[1];
		test_2.balance();
		Cycle_homework test_3 = (Tricycle) test[2];

	}

	public static void runEach(Cycle_homework cyclekind) {
		cyclekind.ride();
		Cycle_homework.wheels();
	}

}

class Unicycle extends Cycle_homework {
	public void ride() {
		System.out.println("ride Unicycle");
	}

	public void balance() {

	}
}

class Bicycle extends Cycle_homework {
	public void ride() {
		System.out.println("ride Bicycle");
	}

	public void balance() {

	}
}

class Tricycle extends Cycle_homework {
	public void ride() {
		System.out.println("ride Tricycle");
	};
}