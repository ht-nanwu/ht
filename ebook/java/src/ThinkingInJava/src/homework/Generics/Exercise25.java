package homework.Generics;

public class Exercise25 {

	public static void main(String[] args) {
		Exercise25 exercise25 = new Exercise25();
		exercise25.mdA(new csA());
		exercise25.mdB(new csA());
	}

	<A extends if01_ex25> void mdA(A paramA) {
		paramA.if01_ex25_mdA();
	}

	<B extends if02_ex25> void mdB(B paramB) {
		paramB.if02_ex25_mdA();
	}

}

interface if01_ex25 {
	void if01_ex25_mdA();
}

interface if02_ex25 {
	void if02_ex25_mdA();
}

class csA implements if01_ex25, if02_ex25 {

	@Override
	public void if02_ex25_mdA() {
		// TODO Auto-generated method stub
		System.out.println("involk mdB!");
	}

	@Override
	public void if01_ex25_mdA() {
		// TODO Auto-generated method stub
		System.out.println("involk mdA!");
	}

}
