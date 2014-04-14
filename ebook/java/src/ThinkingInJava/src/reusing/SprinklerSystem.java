package reusing;

//: reusing/SprinklerSystem.java
// Composition for code reuse.
//当把对象当String类型用时，会自动调toString方法。

class WaterSource {
	private String s;

	WaterSource() {
		System.out.println("WaterSource()");
		s = "Constructed";
	}

	public String toString() {
		return s;
	}
}

public class SprinklerSystem {
	private String valve1, valve2, valve3, valve4;
	private WaterSource source = new WaterSource();
	private int i;
	private float f;
	
	public String toString() {
		return "valve1 = " + valve1 + " " + "valve2 = " + valve2 + " "
				+ "valve3 = " + valve3 + " " + "valve4 = " + valve4 + "\n"
				+ "i = " + i + " " + "f = " + f + " " + "source = " + source;
	}

	public static void main(String[] args) {
		SprinklerSystem sprinklers = new SprinklerSystem();
		System.out.println(sprinklers);
	}
} /*
 * Output: WaterSource() valve1 = null valve2 = null valve3 = null valve4 = null
 * i = 0 f = 0.0 source = Constructed
 */// :~