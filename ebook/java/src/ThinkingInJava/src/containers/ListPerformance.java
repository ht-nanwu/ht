package containers;

//: containers/ListPerformance.java
// Demonstrates performance differences in Lists.
// {Args: 100 500} Small to keep build testing short
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

import net.mindview.util.CountingGenerator;
import net.mindview.util.CountingIntegerList;
import net.mindview.util.Generated;

public class ListPerformance {
	static Random rand = new Random();
	static int reps = 1000;
	static List<AbstractTest<List<Integer>>> abstraactMethodTest = new ArrayList<AbstractTest<List<Integer>>>();
	static List<AbstractTest<LinkedList<Integer>>> qTests = new ArrayList<AbstractTest<LinkedList<Integer>>>();

	// AbstractTest的具体实现
	static {
		abstraactMethodTest.add(new AbstractTest<List<Integer>>("add") {
			int test(List<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int listSize = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
					for (int j = 0; j < listSize; j++)
						list.add(j);
				}
				return loops * listSize;
			}
		});
		abstraactMethodTest.add(new AbstractTest<List<Integer>>("get") {
			int test(List<Integer> list, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = list.size();
				for (int i = 0; i < loops; i++)
					list.get(rand.nextInt(listSize));
				return loops;
			}
		});
		abstraactMethodTest.add(new AbstractTest<List<Integer>>("set") {
			int test(List<Integer> list, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = list.size();
				for (int i = 0; i < loops; i++)
					list.set(rand.nextInt(listSize), 47);
				return loops;
			}
		});
		abstraactMethodTest.add(new AbstractTest<List<Integer>>("iteradd") {
			int test(List<Integer> list, TestParam tp) {
				final int LOOPS = 1000000;
				int half = list.size() / 2;
				ListIterator<Integer> it = list.listIterator(half);
				for (int i = 0; i < LOOPS; i++)
					it.add(47);
				return LOOPS;
			}
		});
		abstraactMethodTest.add(new AbstractTest<List<Integer>>("add(,)") {
			int test(List<Integer> list, TestParam tp) {
				int loops = tp.loops;
				for (int i = 0; i < loops; i++)
					list.add(5, 47); // Minimize random-access cost
				return loops;
			}
		});
		abstraactMethodTest.add(new AbstractTest<List<Integer>>("remove()") {
			int test(List<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while (list.size() > 5)
						list.remove(5); // Minimize random-access cost
				}
				return loops * size;
			}
		});
		// Tests for queue behavior:
		qTests.add(new AbstractTest<LinkedList<Integer>>("addFirst") {
			int test(LinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
					for (int j = 0; j < size; j++)
						list.addFirst(47);
				}
				return loops * size;
			}
		});
		qTests.add(new AbstractTest<LinkedList<Integer>>("addLast") {
			int test(LinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
					for (int j = 0; j < size; j++)
						list.addLast(47);
				}
				return loops * size;
			}
		});
		qTests.add(new AbstractTest<LinkedList<Integer>>("rmFirst") {
			int test(LinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while (list.size() > 0)
						list.removeFirst();
				}
				return loops * size;
			}
		});
		qTests.add(new AbstractTest<LinkedList<Integer>>("rmLast") {
			int test(LinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while (list.size() > 0)
						list.removeLast();
				}
				return loops * size;
			}
		});
	}

	static class ListTester extends Tester<List<Integer>> {
		public ListTester(List<Integer> container,
				List<AbstractTest<List<Integer>>> tests) {
			super(container, tests);
		}

		// Fill to the appropriate size before each test:
		@Override
		protected List<Integer> initialize(int size) {
			container.clear();
			container.addAll(new CountingIntegerList(size));
			return container;
		}

		// Convenience method:
		public static void run(List<Integer> list,
				List<AbstractTest<List<Integer>>> tests) {
			new ListTester(list, tests).timedTest();
		}
	}

	public static void main(String[] args) {
		if (args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		// Can only do these two tests on an array:
		Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null,
				abstraactMethodTest.subList(1, 3)) {
			// This will be called before each test. It
			// produces a non-resizeable array-backed list:
			@Override
			protected List<Integer> initialize(int size) {
				Integer[] ia = Generated.array(Integer.class,
						new CountingGenerator.Integer(), size);
				return Arrays.asList(ia);
			}
		};
		arrayTest.setHeadline("Array as List");
		arrayTest.timedTest();
		Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000,
				10000, 200);
		if (args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		ListTester.run(new ArrayList<Integer>(), abstraactMethodTest);
		ListTester.run(new LinkedList<Integer>(), abstraactMethodTest);
		ListTester.run(new Vector<Integer>(), abstraactMethodTest);
		Tester.fieldWidth = 12;
		Tester<LinkedList<Integer>> qTest = new Tester<LinkedList<Integer>>(
				new LinkedList<Integer>(), qTests);
		qTest.setHeadline("Queue tests");
		qTest.timedTest();
	}
}
/*
 * ------ Array as List ------ size get set 10 19 21 100 18 21 1000 17 21 10000
 * 17 21 ------------------------------ ArrayList ------------------------------
 * size add get set iteradd add(,) remove() 10 30 20 24 35 530 97 100 9 20 24 30
 * 552 38 1000 10 20 24 119 333 132 10000 11 21 24 962 1951 980
 * ------------------------------ LinkedList ------------------------------ size
 * add get set iteradd add(,) remove() 10 31 32 35 86 199 162 100 16 49 52 90 24
 * 51 1000 19 307 312 33 22 44 10000 20 3259 3270 76 32 45
 * -------------------------------- Vector -------------------------------- size
 * add get set iteradd add(,) remove() 10 27 27 29 92 491 95 100 12 27 31 33 514
 * 40 1000 14 27 31 122 296 136 10000 13 27 31 967 2124 986 --------------------
 * Queue tests -------------------- size addFirst addLast rmFirst rmLast 10 39
 * 32 66 57 100 15 14 27 26 1000 12 12 27 27 10000 13 13 28 28
 */
