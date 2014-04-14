package a_htcode.initilAndClearnUp;
/**
 * Example shows garbage collector in action Note that the finalize() method of
 * object GC1 runs without being specifically called and that the id's of
 * garbage collected objects are not always sequential.
 */

class Finalize {

    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();

        System.out.println("Available Free Memory: " + rt.freeMemory());

        for (int i = 0; i < 10000; i++) {
            GC1 x = new GC1(i);
        }

        System.out.println("Free Memory before call to gc(): "
                + rt.freeMemory());
        System.runFinalization();
        System.gc();
        System.out.println("Free Memory after call to gc(): "
                + rt.freeMemory());

    }
}

class GC1 {

    String str;
    int id;

    GC1(int i) {
        this.str = new String("abcdefghijklmnopqrstuvwxyz");
        this.id = i;
    }

    protected void finalize() {
        System.out.println("GC1 object " + id + " has been finalized.");
    }

}