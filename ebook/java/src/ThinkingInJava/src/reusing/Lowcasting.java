package reusing;

class A1 {
	void aMthod() {
		System.out.println("A method");
	}
}

// A的子类B：
class B1 extends A1 {
	void bMethod1() {
		System.out.println("B method 1");
	}

	void bMethod2() {
		System.out.println("B method 2");
	}
}

// C类：
public class Lowcasting {
	public static void main(String[] args) {
		A1 a1 = new B1(); // 向上转型
		a1.aMthod(); // 调用父类aMthod()，a1遗失B类方法bMethod1()、bMethod2()
		B1 b1 = (B1) a1; // 向下转型，编译无错误，运行时无错误
		b1.bMethod2();// ！！！向下转型就可以调用子类所有方法了
		b1.aMthod(); // 调用父类A方法
		b1.bMethod1(); // 调用B类方法
		b1.bMethod2(); // 调用B类方法
		A1 a2 = new A1();
		// B1 b2 = (B1) a2; // 向下转型，编译无错误，运行时将出错
		// b2.aMthod();
		// b2.bMethod1();
		// b2.bMethod2();
		if (a2 instanceof B1) {// a2是A1类型的，不是B1类型的所以返回false
			B1 b2 = (B1) a2;
			b2.aMthod();
			b2.bMethod1();
			b2.bMethod2();
		}
	}
}
// //从上面的代码我们可以得出这样一个结论：向下转型需要使用强制转换。运行C程序，控制台将输出：
// Exception in thread "main" java.lang.ClassCastException: a.b.A cannot be cast
// to a.b.B at
// a.b.C.main(C.java:14)
// A method
// A method
// B method 1
// B method 2
// //其实黑体部分的向下转型代码后的注释已经提示你将发生运行时错误。为什么前一句向下转型代码可以，而后一句代码却出错？这是因为a1指向一个子类B的对象，所以子类B的实例对象b1当然也
// 可以指向a1。而a2是一个父类对象，子类对象b2不能指向父类对象a2。那么如何避免在执行向下转型时发生运行时ClassCastException异常？使用5.7.7节学过的instanceof就可以了。我们修改
// 一下C类的代码：
// A a2 = new A();
// if (a2 instanceof B) {
// B b2 = (B) a2;
// b2.aMthod();
// b2.bMethod1();
// b2.bMethod2();
// }
