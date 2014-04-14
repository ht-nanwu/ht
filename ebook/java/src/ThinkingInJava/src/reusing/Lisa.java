package reusing;

//: reusing/Lisa.java
// {CompileTimeError} (Won't compile)

class Lisa extends Homer {
	@Override
//	void doh(Milhouse m) {
//		System.out.println("doh(Milhouse)");
//	}
	char doh(char m) {
		System.out.println("doh(Milhouse)");
		return m;
	}
} // /:~
