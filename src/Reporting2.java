import java.io.*;

/**
 * the second report class of project 4
 * @author Chris Tsuei
 */
public class Reporting2 {
	
	public static int[] array;
	public static String MScxt240;
	private static String QScxt240;
	private static String HScxt240;
	/**
	 * the main class of the Reporting2 class
	 * @param args takes in an input file and sorts it using different methods
	 * @throws IOException  if there was no file inserted
	 */
	public static void main(String[] args) throws IOException {
		try {
			FileReader input = new FileReader(args[0]);
			BufferedReader writer = new BufferedReader(input);
			createArray(writer);
			writer.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Please enter a valid file");
		}
		FileWriter MS = new FileWriter("cxt240MS.txt");
		FileWriter HS = new FileWriter("cxt240HS.txt");
		FileWriter QS = new FileWriter("cxt240QS.txt");
		
		mergeCalc(MS);
		heapCalc(HS);
		quickCalc(QS);
		
		MS.close();
		HS.close();
		QS.close();
		
		System.out.println(MScxt240 + QScxt240 + HScxt240);
	}
	
	/**
	 * takes in the txt file and puts all of the ints into an array, reading by line
	 * @param writer the reader containing the file
	 * @throws IOException if the file doesn't exist
	 */
	public static void createArray(BufferedReader writer) throws IOException {
		String nextInt;
		array = new int[10000000];
		int numItems = 0;
		
		while((nextInt = writer.readLine()) != null) {
			array[numItems] = Integer.parseInt(nextInt);
			numItems++;
		}
		
		//makes an array with no blank indexes
		int[] shortenedArray = new int[numItems];
		
		for(int i = 0; i < shortenedArray.length; i++) {
			shortenedArray[i] = array[i];
		}
		
		array = shortenedArray;
	}
	
	/**
	 * calculates the time to mergesort a file
	 * @param writer the writer for the output sorted file
	 * @throws IOException if there is no valid writer
	 */
	public static void mergeCalc(FileWriter writer) throws IOException {
		int[] times = new int[3];
		
		mergeSort print = new mergeSort();
		int startTime = (int) System.nanoTime();
		print.sort(array);
		times[0] = (int) (System.nanoTime() - startTime);
		
		//writes out the results array
		for(int i = 0; i < print.sort.length; i++) {
			writer.write(print.sort[i] + System.getProperty("line.separator"));
		}
		
		times[1] = (int) Sorting.mergeSort(array);
		times[2] = (int) Sorting.mergeSort(array);
		
		MScxt240 = "MScxt240 = " + median(times) + "ms ";
	}
	
	/**
	 * calculates the time to quicksort a file
	 * @param writer the writer for the output sorted file
	 * @throws IOException if there is no valid writer
	 */
	public static void quickCalc(FileWriter writer) throws IOException {
		int[] times = new int[3];
		
		quickSort print = new quickSort();
		int startTime = (int) System.nanoTime();
		print.sort(array);
		times[0] = (int) (System.nanoTime() - startTime);
		
		//writes out the results array
		for(int i = 0; i < print.sortArray.length; i++) {
			writer.write(print.sortArray[i] + System.getProperty("line.separator"));
		}
		
		times[1] = (int) Sorting.quickSort(array);
		times[2] = (int) Sorting.quickSort(array);
		
		QScxt240 = "QScxt240 = " + median(times) + "ms ";
	}
	
	/**
	 * calculates the time to heapsort a file
	 * @param writer the writer for the output sorted file
	 * @throws IOException if there is no valid writer
	 */
	public static void heapCalc(FileWriter writer) throws IOException {
		int[] times = new int[3];
		
		heapSort print = new heapSort();
		int startTime = (int) System.nanoTime();
		print.sort(array);
		times[0] = (int) (System.nanoTime() - startTime);
		
		//writes out the results array
		for(int i = 0; i < print.sortArray.length; i++) {
			writer.write(print.sortArray[i] + System.getProperty("line.separator"));
		}
		
		times[1] = (int) Sorting.heapSort(array);
		times[2] = (int) Sorting.heapSort(array);
		
		HScxt240 = "HScxt240 = " + median(times) + "ms ";
	}
	
	/**
	 * takes in 3 number and returns the median
	 * @param time the 3 times
	 * @return the median
	 */
	public static int median(int[] time) {		
		if((time[0] >= time[1]) && (time[0] <= time[2]) || (time[0] <= time[1]) && (time[0] >= time[2])) {
			return time[0];
		}
		else if((time[1] >= time[2]) && (time[1] <= time[0]) || (time[1] <= time[2]) && (time[1] >= time[0])) {
			return time[1];
		}
		else {
			return time[2];
		}
	}
}
