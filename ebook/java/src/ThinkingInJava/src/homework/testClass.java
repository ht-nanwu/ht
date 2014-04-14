package homework;

public class testClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinePrint.printClass(class_01.class, null);
		testClass a = new testClass();
		MinePrint.println(null,a.method_02());
	}
	
	String method_02(){
		String x = getClass().getName();
		return x;
	}
	
}
