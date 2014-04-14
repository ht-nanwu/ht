public class Test {  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Demo d = new Demo();  
        System.out.println("begin to set d to null");  
        d = null;  
        System.out.println("d was set to null");  
        System.out.println("begin run gc");  
        System.gc();  
        System.out.println("gc runed");  
    }  
}  
  
class Demo {  
    @Override  
    protected void finalize() throws Throwable {  
        // TODO Auto-generated method stub  
        System.out.println("Demo finalized");  
        super.finalize();  
    }  
}  