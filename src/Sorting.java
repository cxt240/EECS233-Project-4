/**
 * Class executing all of the sorting algorithms
 * @author Chris Tsuei
 */
public class Sorting {

	/**
	 * calls the mergeSort class/sorting algorithm
	 * @param arr the values to be sorted
	 * @return the time it took to sort
	 */
	public static long mergeSort(int[] arr) {
		long startTime = System.nanoTime();
		mergeSort.sort(arr);
		System.out.println((System.nanoTime() - startTime));
		return (System.nanoTime() - startTime);
	}
	
	/**
	 * calls the heapSort class/sorting algorithm
	 * @param arr the values to be sorted
	 * @return the time it took to sort
	 */
	public static long heapSort(int[] arr) {
		long startTime = System.nanoTime();
		heapSort.sort(arr);
		System.out.println((System.nanoTime() - startTime));
		return (System.nanoTime() - startTime);
	}
	
	/**
	 * calls the quickSort class/sorting algorithm
	 * @param arr the values to be sorted
	 * @return the time it took to sort
	 */
	public static long quickSort(int[] arr) {
		long startTime = System.nanoTime();
		quickSort.sort(arr);
		System.out.println((System.nanoTime() - startTime));
		return (System.nanoTime() - startTime);
	}
}
