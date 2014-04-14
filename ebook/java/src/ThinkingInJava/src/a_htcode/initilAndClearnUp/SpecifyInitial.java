package a_htcode.initilAndClearnUp;

public class SpecifyInitial {
	class Test{};
	
	boolean t = true;
	char c = 'a';
	byte b = 41;
	short s = 0xff;
	int i = 99;
	long l = 1;
	float f = 1.1f;
	double d = 31.1212;
	Test reference = new Test();
	

	void printInitialValues() {
		System.out.println("boolean        " + t);
		System.out.println("char           " + c);
		System.out.println("byte           " + b);
		System.out.println("short          " + s);
		System.out.println("int            " + i);
		System.out.println("long           " + l);
		System.out.println("float          " + f);
		System.out.println("double         " + d);
		System.out.println("reference      " + reference);
	}

	public static void main(String[] args) {
		SpecifyInitial iv = new SpecifyInitial();
		iv.printInitialValues();
	}
}
//boolean        true
//char           a
//byte           41
//short          255
//int            99
//long           1
//float          1.1
//double         31.1212
//reference      a_htcode.initilAndClearnUp.SpecifyInitial$Test@bdb503
