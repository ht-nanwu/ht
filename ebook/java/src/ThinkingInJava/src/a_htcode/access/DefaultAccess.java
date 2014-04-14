package a_htcode.access;

public class DefaultAccess {
    PackageAccessA defaultAccess = new PackageAccessA();
    // PackageAccessMethod省略关键字，默认是包内可以访问
    // defaultAccess.PackageAccessMethod();// 放开注释，编译不通过
}
