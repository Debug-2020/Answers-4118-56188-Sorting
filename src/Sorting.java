
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that contains several sorting routines, implemented as static
 * methods. Arrays are rearranged with smallest item first, using compareTo.
 * 
 * @author Mark Allen Weiss
 */
public final class Sorting {
	/**
	 * Simple insertion sort.
	 * 
	 * @param a
	 *            an array of Comparable items.
	 */
	public void insertionSort(int[] a) {
		int j;

		for (int p = 1; p < a.length; p++) {
			int tmp = a[p];
			for (j = p; j > 0 && tmp < a[j - 1]; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	public boolean isSorted(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i] > a[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void quicksort(int[] a) {
		quicksort(a, 0, a.length - 1);
	}

	private static final int CUTOFF = 10;

	public static final void swapReferences(Object[] a, int index1, int index2) {
		Object tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

	public static final void swap(int[] a, int index1, int index2) {
		int tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

	private static int median3(int[] a, int left, int right) {
		int center = (left + right) / 2;
		if (a[center] < a[left])
			swap(a, left, center);
		if (a[right] < a[left])
			swap(a, left, right);
		if (a[right] < a[center])
			swap(a, center, right);

		// Place pivot at position right - 1
		swap(a, center, right - 1);
		return a[right - 1];
	}

	// a[8]  0 7
	private static void quicksort(int[] a, int start, int end) {
		if (start >= end) {
			return;
		}
		//获取到已经排好序的数字，左边数字都比他小，右边都比他大。
		int flag = getFlag(a, start, end);
		quicksort(a, start, flag - 1);
		quicksort(a, flag + 1, end);
	}
	
	private static int getFlag(int[] a, int start, int end) {
		int begin = start;
		int over = end;
		//选取第一个为目标数字。
		int num = a[start];
		int flag = start;

		while (begin < over) {
			//从左找到第一个比目标数字大的。
			while (begin < end && a[begin] <= num){begin++;} 
			//从右找到第一个比目标数字小的。			
			while (over > start&& a[over] >= num){over--;}
			//如果begin小于end且值大于，则交互两个数字。
			if(begin < over&&a[begin] > a[over]) swap(a, begin, over);
		}
		//交换目标数字与上面循环完的数字的位置。
		swap(a, over, flag);
		return over;
	}

	public static void insertionSort(int[] a, int left, int right) {
		for (int p = left + 1; p <= right; p++) {
			int tmp = a[p];
			int j;

			for (j = p; j > left && tmp < a[j - 1]; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	private static final int NUM_ITEMS = 1000;
	private static int theSeed = 1;

	public static void printArray(int[] a) {
		for (int x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

}
