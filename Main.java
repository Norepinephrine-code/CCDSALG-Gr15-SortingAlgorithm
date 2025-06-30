import java.util.*;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {
        /*
         * Algorithm:
         *      1. Read the files from the given path.
         *      2. Create 4 copies by storing them in a 2D array.
         *      3. Call the benchMark method for each sorting algorithm.
         */

         String[] file_name = new String[] {
            "random100.txt",
            "random25000.txt",
            "random50000.txt",
            "random75000.txt",
            "random100000.txt",
            "almostsorted100.txt",
            "totallyreversed.txt"
         };

         /*
          * The FileReader.java file has the method name and parameter: public Record[] readFile(String path)
          * It needs a path so we will use "data/" + file_name[i] array to read the files.
          */

        for (String file : file_name) {                                     // This loop iterates through each file name in the file_name array
            
            Record[] original = new FileReader().readFile("data/"+file);    // Read the file
            Record[][] record_array = new Record[4][];                      // Store in a 2D array
                for (int i = 0; i < 4; i++) {
                    record_array[i] = duplicateRecords(original);           // Duplicate so that they wont share the same reference
                }
            System.out.println("Sorting " + file + ":");                    // Print the file name
            benchMark(record_array[0],1);                                 // Insertion Sort
            benchMark(record_array[1],2);                                 // Selection Sort
            benchMark(record_array[2],3);                                 // Merge Sort
            benchMark(record_array[3],4);                                 // Quick Sort
        }

         /*
          * This is just duplicating the records so that we can sort them
          * without modifying the original array.
          */

    public static Record[] duplicateRecords (Record[] original) {
        Record[] duplicate = new Record[original.length];
        for (int i = 0; i < original.length; i++) {
            duplicate[i] = new Record(original[i].getName(), original[i].getIdNumber());
        }
        return duplicate;
    }

         /*
          * This is the benchMark method that will call the sorting algorithms
          */

    public static void benchMark (Record[] records, int n) {
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();   // Create an instance of SortingAlgorithms
        long startTime = System.currentTimeMillis();                     // Start timer

        switch(n) {                                                      // Choose algorithm
        case 1:
            sortingAlgorithms.insertionSort(records);
            break;
        case 2:
            sortingAlgorithms.selectionSort(records);
            break;
        case 3:
            sortingAlgorithms.mergeSort(records, 0, records.length - 1);
            break;
        case 4: 
            sortingAlgorithms.quickSort(records, 0, records.length - 1);
            break;
        }
        long endTime = System.currentTimeMillis();                       // End timer
        long duration = endTime - startTime;                             // Calculate duration
        int stepCount = sortingAlgorithms.getStepCount();                // Get the step count

        printResult(duration, stepCount, n); // Print the result
    }

    public static void printResult(long duration, int stepCount, int algorithm) {
        String algoName = "Error";                                        // Default value for error tracing
        switch(algorithm) {
            case 1: algoName = "Insertion Sort";    break;
            case 2: algoName = "Selection Sort";    break;
            case 3: algoName = "Merge Sort";        break;
            case 4: algoName = "Quick Sort";        break;
        }
        System.out.println(algoName + ": Duration = " + duration + " ms, Steps = " + stepCount);
   
    }

}


