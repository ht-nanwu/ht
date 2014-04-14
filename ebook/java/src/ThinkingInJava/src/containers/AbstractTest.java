package containers;

//: containers/Test.java
// Framework for performing timed tests of containers.

/**
 * @author eaton_go_s
 *
 * @param <C> 接收泛型数据
 * 
 */
public abstract class AbstractTest<C> {
	String name;

	public AbstractTest(String name) {
		this.name = name;
	}

	// Override this method for different tests.
	// Returns actual number of repetitions of test.
	/**
	 * @param container 实例化的容器
	 * @param <a>{@link TestParam}</a>
	 * @return
	 */
	abstract int test(C container, TestParam tp);
} // /:~
