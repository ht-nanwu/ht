package initialization;

class Tree {
    // 无参构造器
    Tree() {
        System.out.println("获得了一本书。");
    }

    // 重载构造器
    Tree(String s) {
        System.out.println("我获得了一本" + s + "书。");
    }

    // 无参方法
    void info() {
        System.out.println("你学习java多少天啦？");
    }

    // 重载方法
    void info(int day) {
        System.out.println("我学习java" + day + "天了。");
    }

    // 无参方法和重载方法
    void info1(String... s) {
        if (s.length == 0) {
            System.out.println("你学习java多少天啦？");
        }
        for (int i = 0; i < s.length; i++) {
            System.out.println("大概有" + s[i] + "天了。");
            if(i == s.length - 1) {
                System.out.println("自己也不太记得了!!!");
            }
        }
        
    }
}

public class Overloading {
    public static void main(String[] args) {
        // 构造器
        new Tree();
        // 重载构造器
        Tree t = new Tree("java");
        // 无参方法
        t.info();
        // 重载方法
        t.info(1);
        // 无参方法
        t.info1();
        // 重载方法的另一种尝试
        t.info1(new String[] { "1", "2", "..." });
    }
}
/*
 * 获得了一本书。
 *  我获得了一本java书。
 *  你学习java多少天啦？
 *  重载方法：我学习java1天了。
 *  你学习java多少天啦？
 *  自己也不太记得了!!!
 *  大概有0天了。
 *  大概有1天了。
 *  大概有2天了。
 *  自己也不太记得了!!! 
 */

