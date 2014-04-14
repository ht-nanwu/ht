package a_htcode.initilAndClearnUp;

public class DefaultInitial {

    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    DefaultInitial reference;
    
    void methodInitial(){
    	int a;
    	a++;//ERROR The local variable a may not have been initialized
    }

    void printInitialValues() {
    	System.out.println("boolean        " + t);
    	System.out.println("(int)char           " + (int)c + "   //这里原本输出为空白，为了直观输出了它的assic码。" );
    	System.out.println("byte           " + b);
    	System.out.println("short          " + s);
    	System.out.println("int            " + i);
    	System.out.println("long           " + l);
    	System.out.println("float          " + f);
    	System.out.println("double         " + d);
    	System.out.println("reference      " + reference);
    }

    public static void main(String[] args) {
        DefaultInitial iv = new DefaultInitial();
        iv.printInitialValues();
    }
}
//boolean        false
//(int)char           0   //这里原本输出为空白，为了直观输出了它的assic码。
//byte           0
//short          0
//int            0
//long           0
//float          0.0
//double         0.0
//reference      null