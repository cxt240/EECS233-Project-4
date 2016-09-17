/**
 * the mergeSort method of project 4
 * @author Chris Tsuei
 */
public class mergeSort {

	//the array to be sorted
	public int[] sort;

	/**
	 * sorts the array
	 */
	public static void sort(int[] chosen) {
		//finished is a quick exit variable, whichOne is a boolean that points to the array that is the most sorted
		//with true being the sort array, false being the sort2 array
		int unit = 1;
		boolean finished = false;
		boolean whichOne = true;
		
		int[] sort = chosen;
		int[] sort2 = new int[chosen.length];
		
		//if the array to be sorted isn't empty or the subarray length is less than the sorted array length
		if(sort.length == 0 || unit > sort.length) {
			finished = true;
		}
		
		//loops through till the subarray size becomes greater than the array length
		while(unit < sort.length && !finished) {
			
			//pointer at the start of each new subarray
			int sortedPointer = 0;
			//loops through till the subarray end hits the end of the array to be sorted
			while(sortedPointer < sort.length) {
				//finding the start and end of ht first subarray. Sorting is if we the unit doesn't
				//encompass the entire sort array(the array is sorted)
				int firstStart = sortedPointer;
				int firstEnd = 0;
				int secondStart;
				int secondEnd;
				boolean sorting = true;
				
				//checks to see if the end of the first subarray is pointing to a valid index, if not, exits the loop 
				if((firstStart + unit - 1) >= sort.length) {
					sortedPointer = sort.length;
					sorting = false;
				}
				else {
					firstEnd = firstStart + unit - 1;
				}
				
				secondStart = firstEnd + 1;
				secondEnd = 0;
				
				//if the start of the second array is the last index of the sort array
				if(secondStart == sort.length - 1) {
						secondEnd = secondStart;
				}
				//if the end of the second array is over the index of the first, sets the end index as the last of the so
				else if((secondStart + unit - 1) >= sort.length - 1) {
						secondEnd = sort.length - 1;
					}
				else {
					secondEnd = secondStart + unit - 1;
				}
				
				//sorts the subarrays if there wasn't a problem, if the pointer is true, sorts into sort2
				if(sorting) {
					if(whichOne) {
						merge(firstStart, firstEnd, secondStart, secondEnd, sort2, sort);
					}
					else {
						merge(firstStart, firstEnd, secondStart, secondEnd, sort, sort2);
					}
				}
				
				//increments the next pointer as the unit * 2(basically the sum of the 2 subarrays)
				sortedPointer = sortedPointer + (unit * 2);
			}
			whichOne = !whichOne;
			unit = unit * 2;
		}
		
		//if the final copy was into sort2, sets sort2 as sort
		if(whichOne == false) {
			sort = sort2;
		}
	}
	
	/**
	 * takes in the start and end of the subarrays and puts them into a temporary array
	 * then places them back into the main array
	 * @param firstStart the start index of the first subarray
	 * @param firstEnd the end index of the second subarray
	 * @param secondStart the start index of the first subarray
	 * @param secondEnd the end index of the second subarray
	 */
	public static void merge(int firstStart, int firstEnd, int secondStart, int secondEnd, int[] insert, int[] copy) {		
		int firstIndex = firstStart;
		int secondIndex = secondStart;
		int sortedIndex = firstStart;
		
		//loops through adding the smaller value of the array at each index to the subarray
		while(firstIndex < (firstEnd + 1) && secondIndex < (secondEnd + 1)) {
			if(copy[firstIndex] < copy[secondIndex]) {
				insert[sortedIndex] = copy[firstIndex];
				firstIndex++;
			}
			else {
				insert[sortedIndex] = copy[secondIndex];
				secondIndex++;
			}
			sortedIndex++;
		}
		
		//if the second subarray was finished first, fills the rest of the temp array with the
		//remains of the first subarray
		if(firstIndex <= firstEnd) {
			while(firstIndex <= firstEnd) {
				insert[sortedIndex] = copy[firstIndex];
				firstIndex++;
				sortedIndex++;				
			}
		}
		else {
			while(secondIndex <= secondEnd) {
				insert[sortedIndex] = copy[secondIndex];
				secondIndex++;
				sortedIndex++;
			}
		}
	}
}