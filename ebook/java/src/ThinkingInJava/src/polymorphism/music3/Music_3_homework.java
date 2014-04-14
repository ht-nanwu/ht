package polymorphism.music3;

public class Music_3_homework {

	public static void main(String[] args) {
		relationAB test = new relationAB();
		methodAB upcaseMethodAB = test;
		test = new relationAB();
		methodAB testrelationAB = new methodAB();
		upcaseMethodAB.methodA();
		test.methodA();
		testrelationAB.methodA();
	}
}

class methodAB {
	public void methodA() {
		this.methodB();
		System.out.println("我是方法A");
	};

	public void methodB() {
		System.out.println("我是方法b");
	};

}

class relationAB extends methodAB {
	@Override
	public void methodA() {
		System.out.println("子类Override方法A");
	}

	public void methodC() {
		System.out.println("我是方法C");
	}
}
