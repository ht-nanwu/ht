package a_htcode.access;

public class InheritedClass {
    protected void methodProtected() {
        // 我是protected方法，但是我能被子类访问
    }

    private void methodPrivate() {
        // 我是private方法，我只能被本身的类内部访问
    }

    public void methodPublic() {
     // 我是public方法，但是我能被任何类访问
    }
    
    public void getMethod(){
        // 我可以访问methodPrivate，其他人可以通过我来访问methodPrivate
        this.methodPrivate();
    }
}
