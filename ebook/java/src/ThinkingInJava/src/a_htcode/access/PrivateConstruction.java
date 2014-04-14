package a_htcode.access;

public class PrivateConstruction {
    //
    private PrivateConstruction() {

    }

    public static PrivateConstruction getConstruction() {
        return new PrivateConstruction();
    }
}

class NewPrivateConstruction {

    public NewPrivateConstruction() {
        // 编译出错
        // The constructor PrivateConstruction() is not visible
        // new PrivateConstruction();
        PrivateConstruction.getConstruction();
    }
}
