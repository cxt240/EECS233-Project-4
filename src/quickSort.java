/**
 * quickSort method for project 4
 * @author Chris Tsuei
 */
public class quickSort {

	// the array to be sorted
	public static int[] sortArray;
	
	/**
	 * quick sorts the array
	 * @param arr the array to be sorted
	 */
	public static void sort(int[] arr) {
		sortArray = arr;
		myQuickSort(0, (arr.length - 1));
	}
	
	/**
	 * splits the array along a pivot value, then with the right subarray containing elements greater than
	 * the pivot value, splits the subarrays until there is nothing left to be sorted
	 * @param first
	 * @param last
	 */
	public static void myQuickSort(int first, int last) {
		if (first >= last) return;
		int split = partition(first, last);
		myQuickSort(first, split);
		myQuickSort((split + 1), last);
	}


	/**
	 * partitions the array by creating two subarrays, one greater than and one less than the pivot
	 * pivot is calculated by using the halfway point of the array
	 * @param first the begining of the array/subarray
	 * @param last the end of the array/subarray
	 * @return the pivot
	 */
	public static int partition(int first, int last)
	{
		int pivot = sortArray[(first + last)/2];
		int i = first - 1;  // index going left to right
		int j = last + 1; // index going right to left
		while (true) {
			do {
					i++;
			} while (sortArray[i] < pivot);
			do {
				j--;
			} while (sortArray[j] > pivot);
			//swaps the two elements since the left one is greater and the right is less than the pivot
			if (i < j) {
				int holder = sortArray[i];
				sortArray[i] = sortArray[j];
				sortArray[j] = holder;
			}
			else {
				return j;  // arr[j] = end of left array
			}
		}
	}
}
