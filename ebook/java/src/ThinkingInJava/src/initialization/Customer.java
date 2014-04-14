package initialization;

/**
 * ①：对象属性的引用
 * ②：自身对象的返回
 * ③：对象的传递
 * ④：构造器之间调用
 * 
 * @author eaton_go_s
 *
 */
public class Customer {
    int ticketCount = 0;

    public Customer buyTicket(Ticket ticket) {
        this.ticketCount++;// ①：对象里属性引用
        return this;// ②：返回自己的类
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        // 你好，我要两张去南京的票
        customer.buyTicket(customer.new Ticket("南京")).buyTicket(
                customer.new Ticket("南京").pirntTicket());
        // 你好，我要1张去南京的票，不要保险
        customer.buyTicket(customer.new Ticket(false,"南京").pirntTicket());
        
        // 你好，我要1张20131111号去南京的票，不要保险
        customer.buyTicket(customer.new Ticket(false,"2013-11-11","南京").pirntTicket());
    }

    class Ticket {
        boolean hasAssurance;
        String ticketDate;
        String dest;

        Ticket(String dest) {
            // ④：构造器的引用
            this(true, getNextStartTime(dest), dest);
        }

        Ticket(boolean hasAssurance, String dest) {
            // ④：构造器的引用
            this(hasAssurance, getNextStartTime(dest), dest);
        }

        Ticket(boolean hasAssurance, String dateTime, String dest) {
            System.out.println("你成功买了一张票,信息如下");
            if (hasAssurance) {
                System.out.println("保险：买了保险，3块钱。");
            } else {
                System.out.println("你没买保险");
            }
            System.out.println("出发时间：" + dateTime);
            System.out.println("目的地：" + dest + "\n");
        }
        
        Ticket pirntTicket(){
            // ③：对象的传递
            return this;
        };
    }

    /**
     * @param dest
     *            目的地
     * @return 下班车发车时间
     */
    String getNextStartTime(String dest) {
        return "2013-10-28 10:10";
    };
}

//你成功买了一张票,信息如下
//保险：买了保险，3块钱。
//出发时间：2013-10-28 10:10
//目的地：南京
//
//你成功买了一张票,信息如下
//保险：买了保险，3块钱。
//出发时间：2013-10-28 10:10
//目的地：南京
//
//你成功买了一张票,信息如下
//你没买保险
//出发时间：2013-10-28 10:10
//目的地：南京
//
//你成功买了一张票,信息如下
//你没买保险
//出发时间：2013-11-11
//目的地：南京