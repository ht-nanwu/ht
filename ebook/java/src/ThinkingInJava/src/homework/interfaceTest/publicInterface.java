package homework.interfaceTest;

public interface publicInterface {
	/** An interface can also contain fields, but these are implicitly static and final.*/
	String a = "test";
	/**
	 * You can choose to explicitly declare the methods in an interface as public, 
	 * but they are public even if you don’t say it
	 */
	void methodPublicInterface();
}
