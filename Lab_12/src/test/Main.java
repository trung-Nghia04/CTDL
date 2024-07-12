package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		ListIterator<Integer> listIter = list.listIterator();
		ArrayList<Integer> previousOfI = danhSachChiaHetCho2(listIter);
		System.out.println(previousOfI);
	}

	public static ArrayList<Integer> danhSachChiaHetCho2(Iterator<Integer> iter) {
		ArrayList<Integer> result = new ArrayList();
		while (iter.hasNext()) {
			if (iter.next() % 2 == 0) {
				result.add(iter.next());
			}
		}
		return result;
	}
}