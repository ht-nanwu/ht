package homework.thinking.rawTypeRecover;

public class test {
	public static void main(String[] args) {
		rawType<String> a = new rawType<String>();
		String b = a.get(0);
		System.out.print(b);
	}
}

class rawType<E> {
	Object[] args = new Object[] { "test" };

	@SuppressWarnings("unchecked")
	E get(int index) {
		return (E) args[index];
	}
}