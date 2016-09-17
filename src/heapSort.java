/**
 * the heapSort method of project 4
 * @author Chris Tsuei
 */
public class heapSort {

	/**
	 * sortArray is the array to be sorted
	 * numIndex is the last index currently filled
	 */
	public static int[] sortArray;
	public static int numIndex;
	
	/**
	 * sorting the array
	 * @param arr the array to be sorted
	 */
	public static void sort(int[] arr) {
		sortArray = new int[arr.length];
		numIndex = 0;
		
		//creates the heap
		for(int i = 0; i < arr.length; i++) {
			insert(arr[i]);
			numIndex++;
		}
		
		//creates the results array
		int[] results = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			results[i] = findMax();
		}
		
		for(int i = 0; i < arr.length; i++) {
			sortArray[i] = results[arr.length - i - 1];
		}
		sortArray = results;
	}

	/**
	 * inserts an element into the array
	 * @param i the value of the elemenet to be inerted
	 */
	public static void insert(int i) {
		sortArray[numIndex] = i;
		siftUp(numIndex);
	}
	
	/**
	 * checks the parents to see if the value is in its correct spot
	 * @param index the index of the value to be checked
	 */
	public static void siftUp(int index) {
		if(numIndex != 0) {
			int index2 = index;
			
			//keeps going until the index hits the top(index 0) or is manually set as such
			while(index2 != 0) {
				//if the parent is less than the current value, switches them
				if(sortArray[(index2 - 1)/2] < sortArray[index2]) {
					int holder = sortArray[(index2 - 1)/2];
					sortArray[(index2 - 1)/2] = sortArray[index2];
					sortArray[index2] = holder;
					index2 = (index2 - 1)/2;
				}
				//if the parent was greater, exits the loop
				else {
					index2 = 0;
				}
			}
		}
	}
	
	/**
	 * finds the maximum value, removes it and resorts the array
	 * @return the maximum value
	 */
	public static int findMax() {
		int next = sortArray[0];
		remove();
		return next;
	}
	
	/**
	 * removes the maximum value, replaces it with the value at numIndex and sifts down from the top
	 */
	public static void remove() {
		sortArray[0] = sortArray[numIndex - 1];
		numIndex--;
		siftDown();
	}
	
	/**
	 * checks the top value with the children and rearranges as necessary
	 */
	public static void siftDown() {
		int index = 0;
		
		//loops until the current spot reaches the current insertion index
		while(index < numIndex) {
			int child = 2 * index + 1;
			int holder;
			
			//if the left child exists
			if(child < numIndex) {
				//if the right child exists
				if((child + 1) < numIndex) {
					//if the right child is greater than both the left child and the parent
					if(sortArray[child + 1] > sortArray[child] && sortArray[child + 1] > sortArray[index]) {
						holder = sortArray[index];
						sortArray[index] = sortArray[child + 1];
						sortArray[child + 1] = holder;
						index = child + 1;
					}
					//if the left is bigger than the index
					else if(sortArray[child] > sortArray[index]) {
						holder = sortArray[index];
						sortArray[index] = sortArray[child];
						sortArray[child] = holder;
						index = child;
					}
					// if nothing else
					else {
						index = numIndex;
					}
				}
				else {
					//if the left is bigger than the index
					if(sortArray[child] > sortArray[index]) {
						holder = sortArray[index];
						sortArray[index] = sortArray[child];
						sortArray[child] = holder;
						index = child;
					}
					else {
						//exits the loop since nothing was done
						index = numIndex;
					}
				}
			}
			else {
				//since the children don't exist, exits the loop
				index = numIndex;
			}
			
		}
	}
}
