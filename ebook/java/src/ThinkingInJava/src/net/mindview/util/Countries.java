//: net/mindview/util/Countries.java
// "Flyweight" Maps and Lists of sample data.
package net.mindview.util;

import java.util.*;
import static net.mindview.util.Print.*;

public class Countries {
	public static final String[][] DATA = {
			// Africa
			{ "A", "1" }, { "B", "2" }, { "C", "3" }, { "D", "4" },
			{ "E", "5" }, { "D", "6" }, { "F", "7" }, { "G", "8" },
			{ "H", "9" }, { "I", "10" }, };

	// Use AbstractMap by implementing entrySet()
	private static class FlyweightMap extends AbstractMap<String, String> {
		private static class Entry implements Map.Entry<String, String> {
			int index;

			Entry(int index) {
				this.index = index;
			}

			public boolean equals(Object o) {
				return DATA[index][0].equals(o);
			}

			public String getKey() {
				return DATA[index][0];
			}

			public String getValue() {
				return DATA[index][1];
			}

			public String setValue(String value) {
				throw new UnsupportedOperationException();
			}

			public int hashCode() {
				return DATA[index][0].hashCode();
			}
		}

		// Use AbstractSet by implementing size() & iterator()
		static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
			private int size;

			EntrySet(int size) {
				if (size < 0)
					this.size = 0;
				// Can't be any bigger than the array:
				else if (size > DATA.length)
					this.size = DATA.length;
				else
					this.size = size;
			}

			public int size() {
				return size;
			}

			private class Iter implements Iterator<Map.Entry<String, String>> {
				// Only one Entry object per Iterator:
				private Entry entry = new Entry(-1);

				public boolean hasNext() {
					return entry.index < size - 1;
				}

				public Map.Entry<String, String> next() {
					entry.index++;
					return entry;
				}

				public void remove() {
					throw new UnsupportedOperationException();
				}
			}

			public Iterator<Map.Entry<String, String>> iterator() {
				return new Iter();
			}
		}

		private static Set<Map.Entry<String, String>> entries = new EntrySet(
				DATA.length);

		public Set<Map.Entry<String, String>> entrySet() {
			return entries;
		}
	}

	// Create a partial map of 'size' countries:
	static Map<String, String> select(final int size) {
		return new FlyweightMap() {
			public Set<Map.Entry<String, String>> entrySet() {
				return new EntrySet(size);
			}
		};
	}

	static Map<String, String> map = new FlyweightMap();

	public static Map<String, String> capitals() {
		return map; // The entire map
	}

	public static Map<String, String> capitals(int size) {
		return select(size); // A partial map
	}

	static List<String> names = new ArrayList<String>(map.keySet());

	// All the names:
	public static List<String> names() {
		return names;
	}

	// A partial list:
	public static List<String> names(int size) {
		return new ArrayList<String>(select(size).keySet());
	}

	public static void main(String[] args) {
		print(capitals(10));
		print(names(10));
		print(new HashMap<String, String>(capitals(3)));
		print(new LinkedHashMap<String, String>(capitals(3)));
		print(new TreeMap<String, String>(capitals(3)));
		print(new Hashtable<String, String>(capitals(3)));
		print(new HashSet<String>(names(6)));
		print(new LinkedHashSet<String>(names(6)));
		print(new TreeSet<String>(names(6)));
		print(new ArrayList<String>(names(6)));
		print(new LinkedList<String>(names(6)));
		print(capitals().get("A"));
	}
} /*
 * {A=1, B=2, C=3, D=4, E=5, D=6, F=7, G=8, H=9, I=10}
 * [A, B, C, D, E, D, F, G, H, I]
 * {A=1, B=2, C=3}
 * {A=1, B=2, C=3}
 * {A=1, B=2, C=3}
 * {A=1, C=3, B=2}
 * [D, E, A, B, C]
 * [A, B, C, D, E]
 * [A, B, C, D, E]
 * [A, B, C, D, E, D]
 * [A, B, C, D, E, D]
 * 1
 */// :~
