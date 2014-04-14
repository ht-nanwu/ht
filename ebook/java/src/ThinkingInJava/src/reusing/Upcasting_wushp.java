package reusing;

class A {
	public void a1() {
		System.out.println("Superclass a1");
	}
	public static void a2(A a) {
		System.out.println("父类引用子类的对象！！");
	}
}

// A的子类B：
class B extends A {
	public void a1() {
		System.out.println("Childrenclass"); // 覆盖父类方法
	}

	public void b1() {
		System.out.println("我不是父类的方法，我在向上转型时会丢失。当你看到我时，说明我没有用到向上转型！！");
	} // B类定义了自己的新方法
}

// C类：
public class Upcasting_wushp {
	public static void main(String[] args) {
		A c = new A();
		c.a1();
		A a = new B(); // 向上转型,遗失了和父类不同的方法
		a.a1();
		B b = new B();// 丧失了面向抽象的编程特色，降低了可扩展性。
		b.a1();
		b.b1();
		A.a2(b);
		
		//if(c.getClass().equals(b.getClass())){
			System.out.println("A c = new B()的类型为："+a.getClass());
			System.out.println("B b = new B()的类型为："+b.getClass());
			System.out.println("A c = new A()的类型为："+c.getClass());
		//}
	}
}/*
 * Superclass 
 * Childrenclass 
 * Childrenclass
 * 我不是父类的方法，我在向上转型时会丢失。当你看到我时，说明我没有用到向上转型！！
 * A c = new B()的类型为：class reusing.B
 * B b = new B()的类型为：class reusing.B
 * A c = new A()的类型为：class reusing.A
 */// :~
