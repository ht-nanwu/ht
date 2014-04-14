package homework.abstractTest;

import homework.MinePrint;

/**
 * @author wushp
 * 
 *         父类的初始化先开始。
 * 
 */
public class abstract03 extends test03 {
	private int a = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinePrint.println(null, "abstract03未初始化，a没定义。");
		abstract03 test = new abstract03();
		MinePrint.println(null, "abstract03开始初始化完了，但是子类的开始初始化赋值，值为："
				+ test.a);
		test.print();
	}

	@Override
	void print() {
		// TODO Auto-generated method stub
		MinePrint.println(null, a);
	}

}

abstract class test03 {
	test03() {
		MinePrint.println(null, "test03开始初始化了，但是子类的a还没初始化赋值。");
		this.print();
		MinePrint.println(null, "test03开始初始化完了，但是子类的a还没初始化赋值");
	}

	abstract void print();
}
