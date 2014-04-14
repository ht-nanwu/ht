package generics;

//: generics/NonCovariantGenerics.java
// {CompileTimeError} (Won't compile)
import java.util.*;

public class NonCovariantGenerics {
	// Compile Error: incompatible types:
	List<? extends Fruit> flist = new ArrayList<Apple>();
	List<Fruit> flist1 = new ArrayList<Fruit>();
	public static void main(String[] args) {
		NonCovariantGenerics a = new NonCovariantGenerics();
		System.out.println(a.flist.getClass());
		System.out.println(a.flist.getClass() == a.flist1.getClass());
	}
} // /:~
