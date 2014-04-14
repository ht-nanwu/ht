package homework.interfaceTest;

/**
 * The abstract keyword allows you to create one 
 * or more undefined methods in a class
 * @author Administrator
 *
 */
public abstract class abstractTest01 {
	/**
	 * 你只提供了相应的未实现的方法
	 * you provide part of the interface 
	 * without providing a corresponding implementation
	 * 具体的实现在它的<非抽象子类>里实现
	 * The implementation is provided by inheritors.
	 */
	abstract void methodAbstract01();
	abstract void methodAbstract02();

	void methodNormal() {
	};
}
