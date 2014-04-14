package initialization;

//: initialization/ArrayInit.java
// Array initialization.
import java.util.*;

public class ArrayInit {
	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		Integer[] a = { new Integer(1), new Integer(2), 3, // Autoboxing
		};
		long end = System.currentTimeMillis();

		System.out.println("第一种方法执行时间为：" + (end - start));

		long start_second = System.currentTimeMillis();
		Integer[] b = new Integer[] { new Integer(1), new Integer(2), 3, // Autoboxing
		};
		long end_second = System.currentTimeMillis();

		System.out.println("第二种方法执行时间为：" + (end_second - start_second));
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
} /*
 * Output: [1, 2, 3] [1, 2, 3]
 */// :~
