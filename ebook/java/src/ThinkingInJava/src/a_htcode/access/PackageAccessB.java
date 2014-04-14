package a_htcode.access;

import a_htcode.access.A.PackageAccessC;

/**
 * PackageAccessB与PackageAccessC不在同个包里
 * 
 */
class PackageAccessB extends InheritedClass{
    
    @Override
    public void getMethod() {
        // 这样我就能访问到methodPrivate方法了
        super.getMethod();
    }

    @Override
    protected void methodProtected() {
        super.methodProtected();
    }

//    protected void methodPrivate() {
//        // The method methodPrivate() from the type InheritedClass is not visible
//        super.methodPrivate();
//    }
    
    

    @Override
    public void methodPublic() {
        super.methodPublic();
    }

    PackageAccessB() {
        // 所以在PackageAccessB里，我能直接访问PackageAccessA
        PackageAccessA  a = new PackageAccessA();
        // 用了import a_htcode.access.A.PackageAccessC;
        // 所以在PackageAccessB里，我能直接访问PackageAccessC
        new PackageAccessC();
    }
}