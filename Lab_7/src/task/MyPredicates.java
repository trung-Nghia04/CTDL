package task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T next = iterator.next();
			if (p.test(next)) {
				iterator.remove();
			}
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> pr) {
		List<T> itemsToRemove = new ArrayList<>();
		for (T item : coll) {
			if (!pr.test(item)) {
				itemsToRemove.add(item);
			}
		}
		coll.removeAll(itemsToRemove);
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> result = new HashSet<>();
		for (T item : coll) {
			if (p.test(item)) {
				result.add(item);
			}
		}
		return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		int index = 0;
		for (T item : coll) {
			if (p.test(item)) {
				return index;
			}
			index++;
		}
		return -1;
	}
}
