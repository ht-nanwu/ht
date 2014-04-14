package reusing;

//class Monitor {
//	public void displayText() {
//	}
//
//	public void displayGraphics() {
//	}
//}
//
//// 液晶显示器类LCDMonitor是Monitor的子类：
//class LCDMonitor extends Monitor {
//	public void displayText() {
//		System.out.println("LCD display text");
//	}
//
//	public void displayGraphics() {
//		System.out.println("LCD display graphics");
//	}
//}
//
//// 阴极射线管显示器类CRTMonitor自然也是Monitor的子类：
//class CRTMonitor extends Monitor {
//	public void displayText() {
//		System.out.println("CRT display text");
//	}
//
//	public void displayGraphics() {
//		System.out.println("CRT display graphics");
//	}
//}
//
//// 等离子显示器PlasmaMonitor也是Monitor的子类：
//class PlasmaMonitor extends Monitor {
//	public void displayText() {
//		System.out.println("Plasma display text");
//	}
//
//	public void displayGraphics() {
//		System.out.println("Plasma display graphics");
//	}
//}
//
//// 现在有一个MyMonitor类。假设没有向上转型，MyMonitor类代码如下：
//public class Upcasting01_wushp {
//	public static void main(String[] args) {
//		run(new LCDMonitor());
//		run(new CRTMonitor());
//		run(new PlasmaMonitor());
//	}
//
//	public static void run(LCDMonitor monitor) {
//		monitor.displayText();
//		monitor.displayGraphics();
//	}
//
//	public static void run(CRTMonitor monitor) {
//		monitor.displayText();
//		monitor.displayGraphics();
//	}
//
//	public static void run(PlasmaMonitor monitor) {
//		monitor.displayText();
//		monitor.displayGraphics();
//	}
//}
//可能你已经意识到上述代码有很多重复代码，而且也不易维护。有了向上转型，代码可以更为简洁：
public class Upcasting01_wushp {
	public static void main(String[] args) {
		run(new LCDMonitor()); // 向上转型
		run(new CRTMonitor()); // 向上转型
		run(new PlasmaMonitor()); // 向上转型
	}

	public static void run(Monitor monitor) { // 父类实例作为参数
		monitor.displayText();
		monitor.displayGraphics();
	}
}

// 我们也可以采用接口的方式，例如：
interface Monitor {
	abstract void displayText();

	abstract void displayGraphics();
}

// 将液晶显示器类LCDMonitor稍作修改：
class LCDMonitor implements Monitor {
	public void displayText() {
		System.out.println("LCD display text");
	}

	public void displayGraphics() {
		System.out.println("LCD display graphics");
	}
}

// 将液晶显示器类LCDMonitor稍作修改：
class CRTMonitor implements Monitor {
	public void displayText() {
		System.out.println("CRT display text");
	}

	public void displayGraphics() {
		System.out.println("CRT display graphics");
	}
}

// 将液晶显示器类LCDMonitor稍作修改：
class PlasmaMonitor implements Monitor {
	public void displayText() {
		System.out.println("Plasma display text");
	}

	public void displayGraphics() {
		System.out.println("Plasma display graphics");
	}
}
