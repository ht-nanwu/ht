package polymorphism;

//: polymorphism/PolyConstructors.java
// Constructors and polymorphism
// don't produce what you might expect.
import static net.mindview.util.Print.*;

class Glyph {
	void draw() {
		print("Glyph.draw()");
	}

	Glyph() {
		print("Glyph() before draw()");
		draw();
		print("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;
	private A a;

	RoundGlyph(int r) {
		radius = r;
		print("RoundGlyph.RoundGlyph(), radius = " + radius);
		print("子类构造器在父类方法覆盖之后执行！！！！此时才会初始化radius变量。");
	}

	void draw() {
		print("RoundGlyph.draw(), radius = " + this.radius);
		print("radius,在子类覆写父类方法时，子类的变量还没完成初始化赋值"+a.test());
	}
}
class A {
    String test(){
        return "test";
    };
}

public class PolyConstructors {
	public static void main(String[] args) {
		new RoundGlyph(5);
	}
} /*
 * Output: Glyph() before draw() RoundGlyph.draw(), radius = 0 Glyph() after
 * draw() RoundGlyph.RoundGlyph(), radius = 5
 */// :~
