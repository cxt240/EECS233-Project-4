import java.util.Random;

/**
 * the first report class of project 4
 * @author Chris Tsuei
 */
public class Reporting1 {

	//fields holding arrays with increasing order
	public static int[] threeUp;
	public static int[] fourUp;
	public static int[] fiveUp;
	public static int[] sixUp;
	
	//fields holding arrays in decreasing order
	public static int[] threeDown;
	public static int[] fourDown;
	public static int[] fiveDown;
	public static int[] sixDown;
	
	//fields holding arrays in random order
	public static int[] threeRand;
	public static int[] fourRand;
	public static int[] fiveRand;
	public static int[] sixRand;
	
	public static void main(String[] args) {
		Reporting1 test = new Reporting1();
		long merge = test.mergeTest() / 48;
		System.out.println("Merge Sort Average: " + merge + "ns");
		
		long quick = test.quickTest() / 48;
		System.out.println("Quick Sort Average: " + quick + "ns");
		
		long heap = test.heapTest() / 48;
		System.out.println("Heap Sort Average: " + heap + "ns");
	}
	
	/**
	 * testing the mergeSort method
	 * @return the total time (48 trials)
	 */
	public static long mergeTest() {
		long time = 0;
		genUp();
		genDown();
		time += Sorting.mergeSort(threeUp);
		time += Sorting.mergeSort(fourUp);
		time += Sorting.mergeSort(fiveUp);
		time += Sorting.mergeSort(sixUp);
		
		time += Sorting.mergeSort(threeDown);
		time += Sorting.mergeSort(fourDown);
		time += Sorting.mergeSort(fiveDown);
		time += Sorting.mergeSort(sixDown);
		
		//1
		genRandom(14);
		time += Sorting.mergeSort(threeRand);
		time += Sorting.mergeSort(fourRand);
		time += Sorting.mergeSort(fiveRand);
		time += Sorting.mergeSort(sixRand);
		
		//2
		genRandom(1123);
		time += Sorting.mergeSort(threeRand);
		time += Sorting.mergeSort(fourRand);
		time += Sorting.mergeSort(fiveRand);
		time += Sorting.mergeSort(sixRand);
		
		//3
		genRandom(54);
		time += Sorting.mergeSort(threeRand);
		time += Sorting.mergeSort(fourRand);
		time += Sorting.mergeSort(fiveRand);
		time += Sorting.mergeSort(sixRand);
				
		//4
		genRandom(456);
		time += Sorting.mergeSort(threeRand);
		time += Sorting.mergeSort(fourRand);
		time += Sorting.mergeSort(fiveRand);
		time += Sorting.mergeSort(sixRand);

		//5
		genRandom(12346);
		time += Sorting.mergeSort(threeRand);
		time += Sorting.mergeSort(fourRand);
		time += Sorting.mergeSort(fiveRand);
		time += Sorting.mergeSort(sixRand);
				
		//6
		genRandom(88888);
		time += Sorting.mergeSort(threeRand);
		time += Sorting.mergeSort(fourRand);
		time += Sorting.mergeSort(fiveRand);
		time += Sorting.mergeSort(sixRand);
		
		//7
		genRandom(2119);
		time += Sorting.mergeSort(threeRand);
		time += Sorting.mergeSort(fourRand);
		time += Sorting.mergeSort(fiveRand);
		time += Sorting.mergeSort(sixRand);
		
		//8
		genRandom(1223);
		time += Sorting.mergeSort(threeRand);
		time += Sorting.mergeSort(fourRand);
		time += Sorting.mergeSort(fiveRand);
		time += Sorting.mergeSort(sixRand);
		
		//9
		genRandom(2104);
		time += Sorting.mergeSort(threeRand);
		time += Sorting.mergeSort(fourRand);
		time += Sorting.mergeSort(fiveRand);
		time += Sorting.mergeSort(sixRand);
		
		//10
		genRandom(925);
		time += Sorting.mergeSort(threeRand);
		time += Sorting.mergeSort(fourRand);
		time += Sorting.mergeSort(fiveRand);
		time += Sorting.mergeSort(sixRand);
		
		return time;
	}
	
	/**
	 * testing the quickSort method
	 * @return the total time (48 trials)
	 */
	public static long quickTest() {
		long time = 0;
		genUp();
		genDown();
		time += Sorting.quickSort(threeUp);
		time += Sorting.quickSort(fourUp);
		time += Sorting.quickSort(fiveUp);
		time += Sorting.quickSort(sixUp);
		
		time += Sorting.quickSort(threeDown);
		time += Sorting.quickSort(fourDown);
		time += Sorting.quickSort(fiveDown);
		time += Sorting.quickSort(sixDown);
		
		//1
		genRandom(14);
		time += Sorting.quickSort(threeRand);
		time += Sorting.quickSort(fourRand);
		time += Sorting.quickSort(fiveRand);
		time += Sorting.quickSort(sixRand);
		
		//2
		genRandom(1123);
		time += Sorting.quickSort(threeRand);
		time += Sorting.quickSort(fourRand);
		time += Sorting.quickSort(fiveRand);
		time += Sorting.quickSort(sixRand);
		
		//3
		genRandom(54);
		time += Sorting.quickSort(threeRand);
		time += Sorting.quickSort(fourRand);
		time += Sorting.quickSort(fiveRand);
		time += Sorting.quickSort(sixRand);
				
		//4
		genRandom(456);
		time += Sorting.quickSort(threeRand);
		time += Sorting.quickSort(fourRand);
		time += Sorting.quickSort(fiveRand);
		time += Sorting.quickSort(sixRand);

		//5
		genRandom(12346);
		time += Sorting.quickSort(threeRand);
		time += Sorting.quickSort(fourRand);
		time += Sorting.quickSort(fiveRand);
		time += Sorting.quickSort(sixRand);
				
		//6
		genRandom(88888);
		time += Sorting.quickSort(threeRand);
		time += Sorting.quickSort(fourRand);
		time += Sorting.quickSort(fiveRand);
		time += Sorting.quickSort(sixRand);
		
		//7
		genRandom(2119);
		time += Sorting.quickSort(threeRand);
		time += Sorting.quickSort(fourRand);
		time += Sorting.quickSort(fiveRand);
		time += Sorting.quickSort(sixRand);
		
		//8
		genRandom(1223);
		time += Sorting.quickSort(threeRand);
		time += Sorting.quickSort(fourRand);
		time += Sorting.quickSort(fiveRand);
		time += Sorting.quickSort(sixRand);
		
		//9
		genRandom(2104);
		time += Sorting.quickSort(threeRand);
		time += Sorting.quickSort(fourRand);
		time += Sorting.quickSort(fiveRand);
		time += Sorting.quickSort(sixRand);
		
		//10
		genRandom(925);
		time += Sorting.quickSort(threeRand);
		time += Sorting.quickSort(fourRand);
		time += Sorting.quickSort(fiveRand);
		time += Sorting.quickSort(sixRand);
				
		return time;
	}
	
	/**
	 * testing the quickSort method
	 * @return the total time (48 trials)
	 */
	public static long heapTest() {
		long time = 0;
		genUp();
		genDown();
		time += Sorting.heapSort(threeUp);
		time += Sorting.heapSort(fourUp);
		time += Sorting.heapSort(fiveUp);
		time += Sorting.heapSort(sixUp);
		
		time += Sorting.heapSort(threeDown);
		time += Sorting.heapSort(fourDown);
		time += Sorting.heapSort(fiveDown);
		time += Sorting.heapSort(sixDown);
		
		//1
		genRandom(14);
		time += Sorting.heapSort(threeRand);
		time += Sorting.heapSort(fourRand);
		time += Sorting.heapSort(fiveRand);
		time += Sorting.heapSort(sixRand);
		
		//2
		genRandom(1123);
		time += Sorting.heapSort(threeRand);
		time += Sorting.heapSort(fourRand);
		time += Sorting.heapSort(fiveRand);
		time += Sorting.heapSort(sixRand);
		
		//3
		genRandom(54);
		time += Sorting.heapSort(threeRand);
		time += Sorting.heapSort(fourRand);
		time += Sorting.heapSort(fiveRand);
		time += Sorting.heapSort(sixRand);
		
		//4
		genRandom(456);
		time += Sorting.heapSort(threeRand);
		time += Sorting.heapSort(fourRand);
		time += Sorting.heapSort(fiveRand);
		time += Sorting.heapSort(sixRand);

		//5
		genRandom(12346);
		time += Sorting.heapSort(threeRand);
		time += Sorting.heapSort(fourRand);
		time += Sorting.heapSort(fiveRand);
		time += Sorting.heapSort(sixRand);
		
		//6
		genRandom(88888);
		time += Sorting.heapSort(threeRand);
		time += Sorting.heapSort(fourRand);
		time += Sorting.heapSort(fiveRand);
		time += Sorting.heapSort(sixRand);
		
		//7
		genRandom(2119);
		time += Sorting.heapSort(threeRand);
		time += Sorting.heapSort(fourRand);
		time += Sorting.heapSort(fiveRand);
		time += Sorting.heapSort(sixRand);
		
		//8
		genRandom(1223);
		time += Sorting.heapSort(threeRand);
		time += Sorting.heapSort(fourRand);
		time += Sorting.heapSort(fiveRand);
		time += Sorting.heapSort(sixRand);
		
		//9
		genRandom(2104);
		time += Sorting.heapSort(threeRand);
		time += Sorting.heapSort(fourRand);
		time += Sorting.heapSort(fiveRand);
		time += Sorting.heapSort(sixRand);
		
		//10
		genRandom(925);
		time += Sorting.heapSort(threeRand);
		time += Sorting.heapSort(fourRand);
		time += Sorting.heapSort(fiveRand);
		time += Sorting.heapSort(sixRand);
		
		return time;
	}
	/**
	 * generates the increasing order arrays
	 */
	public static void genUp() {
		threeUp = new int[1000];
		for(int i = 0; i <  threeUp.length; i++) {
			threeUp[i] = i;
		}
		
		fourUp = new int[10000];
		for(int i = 0; i <  fourUp.length; i++) {
			fourUp[i] = i;
		}
		
		fiveUp = new int[100000];
		for(int i = 0; i <  fiveUp.length; i++) {
			fiveUp[i] = i;
		}
		
		sixUp = new int[1000000];
		for(int i = 0; i <  sixUp.length; i++) {
			sixUp[i] = i;
		}
	}
	
	/**
	 * generates the decreasing order arrays
	 */
	public static void genDown() {
		threeDown = new int[1000];
		for(int i = 0; i <  threeDown.length; i++) {
			threeDown[i] = threeDown.length - i;
		}
		
		fourDown = new int[10000];
		for(int i = 0; i <  fourDown.length; i++) {
			fourDown[i] = fourDown.length - i;
		}
		
		fiveDown = new int[100000];
		for(int i = 0; i <  fiveDown.length; i++) {
			fiveDown[i] = fiveDown.length - i;
		}
		
		sixDown = new int[1000000];
		for(int i = 0; i <  sixDown.length; i++) {
			sixDown[i] = sixDown.length - i;
		}
	}
	
	/**
	 * generates arrays with random integers
	 * @param x the seed value
	 */
	public static void genRandom(int x) {
		Random next = new Random(x);
		
		threeRand = new int[1000];
		for(int i = 0; i <  threeRand.length; i++) {
			threeRand[i] = next.nextInt();
		}
		
		fourRand = new int[10000];
		for(int i = 0; i <  fourRand.length; i++) {
			fourRand[i] = next.nextInt();
		}
		
		fiveRand = new int[100000];
		for(int i = 0; i <  fiveRand.length; i++) {
			fiveRand[i] = next.nextInt();
		}
		
		sixRand = new int[1000000];
		for(int i = 0; i <  sixRand.length; i++) {
			sixRand[i] = next.nextInt();
		}
	}
}
