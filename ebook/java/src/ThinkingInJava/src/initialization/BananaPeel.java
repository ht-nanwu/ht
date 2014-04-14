package initialization;

class Banana { void peel(int i) { /* ... */ } }

public class BananaPeel {
  public static void main(String[] args) {
    Banana a = new Banana(),
           b = new Banana();
    a.peel(1);
    b.peel(2);
    // 我如何知道，peel()是被那个对象调用的呢？a还是b？
    // 编译器内部是这么执行的，它传递了一个你看不到的参数给了peel（）方法。
    // Banana(a,1);Banana(b,2);
    // 但是你不能这么写，编译器会报错的。
  }
}
