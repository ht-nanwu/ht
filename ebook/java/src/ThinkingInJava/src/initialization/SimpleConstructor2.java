package initialization;

class Rock2 {
    Rock2(int i) {
        System.out.print("有参构造器" + i);
    }
}

public class SimpleConstructor2 {
    public static void main(String[] args) {
        new Rock2(1);
        new Rock2();// 不允许创建无参构造器
    }
} /*
   * Output: 有参构造器1
   */// :~
