package homework.abstractTest;

//在学习这两者区别时，重要的是两者都有抽象方法在里面。但对于abstract而言，可以有实现了的方法，也可以有没有实现的方法，只有方法的定义。在interface中，可以有常量的定义和方法的定义（但没有实现体）。接口类是抽象类的特殊形式。
//
//还有一种通俗的解释如下
//1.接口可以多重继承 ，抽象类不可以 
//我的解释：
//如果你在面试这么说会判定你的思想是错的，java中并没有多重继承的概念，此处这么说
//是说他好比是多重继承一样，但是却不是。
//
//2.接口定义方法，不给实现；而抽象类可以实现部分方法
//我的解释：抽象类中可以有非抽象的方法，但是接口中都是抽象方法
//
//3.接口中基本数据类型的数据成员，都默认为static和final，抽象类则不是
//这个我就不解释，说的很明白
//
//如果事先知道某种东西会成为基础类，
//那么第一个选择就是把它变成一个接口。
//只有在必须使用方法定义或者成员变量的时候，才应考虑采用抽象类。
public class abstract_AND_interface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//test a = new test();//ERROR:Cannot instantiate the type test
		//test_01 class_01 = new test_01();
	}

}

abstract class test {

	String test() {
		return "failed";
	}

}

interface test_01{
	void method_01();
}