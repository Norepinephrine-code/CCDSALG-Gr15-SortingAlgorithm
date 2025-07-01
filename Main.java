

public class Main {
    
    public static void main(String[] args) {
        /*
         * Algorithm:
         *      1. Read the files from the given path.
         *      2. Create 4 copies by storing them in a 2D array.
         *      3. Call the benchMark method for each sorting algorithm.
         *      4. Print the result of each sorting algorithm.
         */

         String[] file_name = new String[] {
            "random100.txt",
            "random25000.txt",
            "random50000.txt",
            "random75000.txt",
            "random100000.txt",
            "almostsorted.txt",
            "totallyreversed.txt"
         };

         /*
          * The FileReader.java file has the method name and parameter: public Record[] readFile(String path)
          * It needs a path so we will use "data/" + file_name[i] array to read the files.
          */

          System.out.printf("==============================================================\n"); 
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
            benchMark(record_array[3],4);                                 // Bubble Sort
            System.out.printf("==============================================================\n");                   
        }
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
            sortingAlgorithms.insertionSort(records, records.length);
            break;
        case 2:
            sortingAlgorithms.selectionSort(records, records.length);
            break;
        case 3:                                         // This is records.length - 1 because they work by index                 
            sortingAlgorithms.mergeSort(records, 0, records.length - 1);  
            break;
        case 4:                                         
            sortingAlgorithms.bubbleSort(records, records.length);
            break;
        }
        long endTime = System.currentTimeMillis();                       // End timer
        long duration = endTime - startTime;                             // Calculate duration
        long stepCount = SortingAlgorithms.getStepCount();               // Get the step count

        printResult(duration, stepCount, n, isSorted(records));          // Print the result
    }

    public static boolean isSorted(Record[] records) {
        int first_Id = records[0].getIdNumber();                          // Get the first ID number
        for (int i = 1; i < records.length; i ++) {
            if (first_Id > records[i].getIdNumber()) {                    // If the first ID number is greater than the current ID number
                return false;                                             // Return false at the first unsorted record
            } else {
                first_Id = records[i].getIdNumber();                      // Update the first ID number
            }
        }
        return true;                                                      // If all records are sorted, return true                          
    }

    public static void printResult(long duration, long stepCount, int algorithm, boolean isSorted) {
        String algoName = "Error";                                        // Default value for error tracing
        switch(algorithm) {
            case 1: algoName = "Insertion Sort";    break;
            case 2: algoName = "Selection Sort";    break;
            case 3: algoName = "Merge Sort";        break;
            case 4: algoName = "Bubble Sort";        break;
        }
        System.out.println((isSorted ? "YES \tThe records are sorted!" : "NO \tThe records are NOT sorted!"));
        System.out.printf("\t" + algoName + ": Duration = " + duration + " ms, Steps = " + stepCount + "\n");
   
    }
}


