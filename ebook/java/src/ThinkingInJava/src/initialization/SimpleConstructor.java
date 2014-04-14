package initialization;

//: initialization/SimpleConstructor.java
// Demonstration of a simple constructor.

class Rock {
    Rock() { // 无参数构造器
        System.out.print("Rock ");
    }
}

public class SimpleConstructor {
    public static void main(String[] args) {
        new Rock();// 无参构造器调用
    }
}
/*
 * 输出: Rock
 * 
 * 1.Java的构造器并不是函数，所以他并不能被继承，这在我们extends的时候写子类的构造器时比较的常见，即使子类构造器参数和父类的完全一样，我们也要写super
 */


