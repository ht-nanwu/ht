package homework.interfaceTest.accessInterface;

import homework.interfaceTest.interFaceTest01;
import homework.interfaceTest.publicInterface;

public class accessIf implements interFaceTest01{

	@Override
	public void test01() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		accessIf01 a = new accessIf01();
		a.methodPublicInterface();
	}

}
/**
 * If you leave off the public keyword, you get package access, 
 * so the interface is only usable within the same package
 * 如果接口省了<public>，则不同包下不能引用
 * 
 *  Error
 */
//class accessIf01 implements defualtInterface{
//
//}
class accessIf01 implements publicInterface{
	
	/* 
	 * You can choose to explicitly declare the methods in an interface as public, 
	 * but they are public even if you don’t say it
	 */
	@Override
	protected void methodPublicInterface() {
		// TODO Auto-generated method stub
		System.out.println("can implements default access method!");
		System.out.println(this.a);
	}
}
