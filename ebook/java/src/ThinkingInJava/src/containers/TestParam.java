package containers;

//: containers/TestParam.java
// A "data transfer object."

/**
 * @author eaton_go_s
 * 
 * 根据不定参数，把它转换成TestParam的数组。<br>
 * e.g : 传进来的参数为：1,2,3,4,5<br>
 * TestParam[0]包含两个变量：size，loops。<br>
 * TestParam[0].size为1<br>
 * TestParam[0].loops为2<br>
 *
 */
public class TestParam {
	public final int size;
	public final int loops;

	/**
	 * @param size
	 * @param loops
	 */
	public TestParam(int size, int loops) {
		this.size = size;
		this.loops = loops;
	}

	// Create an array of TestParam from a varargs sequence:
	/**
	 * @param values
	 * @return
	 */
	public static TestParam[] array(int... values) {
		int size = values.length / 2;
		TestParam[] result = new TestParam[size];
		int n = 0;
		for (int i = 0; i < size; i++)
			result[i] = new TestParam(values[n++], values[n++]);
		return result;
	}

	// Convert a String array to a TestParam array:
	/**
	 * @param values
	 * @return
	 */
	public static TestParam[] array(String[] values) {
		int[] vals = new int[values.length];
		for (int i = 0; i < vals.length; i++)
			vals[i] = Integer.decode(values[i]);
		return array(vals);
	}
	
	public static void main(String[] args) {
		for(TestParam each : array(1,2,3,4,5,6))
		System.out.println(each.size + "/" + each.loops);
		for(TestParam each : array(new String[]{"1","2","3","4","5","6"}))
			System.out.println(each.size + "/" + each.loops);
	}
} // /:~
