package homework.interfaceTest;

/**
 * ①The interface keyword takes the concept of abstractness 
 * one step further
 * 
 * ②interface is used to establish a "protocol" between classes
 * 
 * ③it allows you to perform a variation of "multiple inheritance" 
 * by creating a class that can be upcast to more than one base type
 * 
 * ④If you leave off the public keyword, you get package access, 
 * so the interface is only usable within the same package
 * 
 * ⑤Illegal modifier for the interface method test01; 
 * only public & abstract are permitted
 * 
 * @author wushp
 * 
 */
public interface interFaceTest01 {
	/**
	 * The interface keyword produces a completely abstract class
	 * It allows the creator to determine 
	 * method names, argument lists, and return types
	 * but no method bodies
	 */
	//void test01(){};
	/** 
	 * Illegal modifier for the interface method test01; 
	 * only public & abstract are permitted
	 */
	// protected void test01();
	void test01();
}

class moreUpcase{
	// ③
	interFaceTest01 a = new overInterfaceMethod01();
	interFaceTest01 b = new overInterfaceMethod02();
}

/**
 * ②
 * @author Administrator
 *
 */
class overInterfaceMethod01 implements interFaceTest01 {

	@Override
	public void test01() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see homework.interfaceTest.interFaceTest01#test01()
	 * Cannot reduce the visibility of the inherited method from interFaceTest01
	 */
//	@Override
//	protected void test01() {
//		// TODO Auto-generated method stub
//		
//	}
	
}

/**
 * ②
 * @author Administrator
 *
 */
class overInterfaceMethod02 implements interFaceTest01 {

	/* (non-Javadoc)
	 * @see homework.interfaceTest.interFaceTest01#test01()
	 */
	@Override
	public void test01() {
		// TODO Auto-generated method stub
		
	}
	
}
/**
 * The abstract keyword allows you to create one 
 * or more undefined methods in a class
 * @author Administrator
 *
 */
class overAbstractMethod extends abstractTest01{

	/* 
	 * 抽象类里的方法被<非抽象类 overAbstractMethod>继承时，必须被重写
	 * 
	 */
	@Override
	void methodAbstract01() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void methodAbstract02() {
		// TODO Auto-generated method stub
		
	}	
}