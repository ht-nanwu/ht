package initialization;

class Worker {
    Worker move(int i) {
        System.out.printf("我搬了" + i + "块砖头，我的工号是：");
        return this;
    }

    void whoMove(int i) {
        System.out.printf("我搬了" + i + "块砖头");
    }
}

// 找了两个人来搬砖

public class MoveBrick {

    public static void main(String[] args) {

        Worker a = new Worker(), b = new Worker();

        // ①
        a.whoMove(1);// 我不知道谁搬的砖头
        b.whoMove(1);// 我不知道谁搬的砖头
        // 我如何知道，whoMove()是被那个对象调用的呢？a还是b？

        // 编译器内部是这么执行的，它传递了一个你看不到的参数给了peel（）方法。

        // Worker(a,1);Worker(b,2);

        // 但是你不能这么写，编译器会报错的。
        
        // ②
        System.out.println(a.move(1).hashCode());// a搬了1个砖头

        System.out.println(b.move(2).hashCode());// b搬了2个砖头

        // 我们引入this关键字

        // move返回了这个对象

        // 然后我们可以利用对象查出谁搬的砖头
    }

}