/* This file contains implementations of sorting algorithms.
 * You are NOT allowed to modify any of the given method headers.
 */

public class SortingAlgorithms {

    private static int stepCount = 0;

    public static int getStepCount() {
        return stepCount;
    }

    public static void resetStepCount() {
        stepCount = 0;
    }

    private static void incrementStep(int n) {
        stepCount += n;
    }

    public void insertionSort(Record[] arr, int n) {
        resetStepCount();
        for (int i = 1; i < n; i++) {
            incrementStep((n-1)-1+2); // for loop comparison
            Record key = arr[i];
            incrementStep((n-1)-1+1); // key assignment
            int j = i - 1;
            incrementStep((n-1)-1+1); // key assignment
            while (j >= 0 && arr[j].getIdNumber() > key.getIdNumber()) {
                incrementStep(2); // j >= 0 + comparison
                arr[j + 1] = arr[j];
                incrementStep(1); // data movement
                j--;
                incrementStep(1); // j decrement
            }
            arr[j + 1] = key;
            incrementStep(1); // final assignment
        }
        incrementStep(1); // for loop final check
    }

    public void selectionSort(Record[] arr, int n) {
        resetStepCount();
        for (int i = 0; i < n - 1; i++) {
            incrementStep(((n-1)-1)-1+2); // for loop comparison
            int minIdx = i;
            incrementStep(((n-1)-1)-1+1); // assignment
            for (int j = i + 1; j < n; j++) {
                incrementStep(1); // inner loop comparison
                incrementStep(1); // comparison between elements
                if (arr[j].getIdNumber() < arr[minIdx].getIdNumber()) {
                    minIdx = j;
                    incrementStep(1); // new min assignment
                }
            }
            Record temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
            incrementStep(3); // three assignments in swap
        }
        incrementStep(1); // outer loop final check
    }

    public void mergeSort(Record[] arr, int p, int r) {
        incrementStep(1); // mergeSort comparison (if condition checking)
        if (p < r) {
            int q = (p + r) / 2;
            incrementStep(1); // midpoint calculation
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    private void merge(Record[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        incrementStep(2); // range calculations

        Record[] L = new Record[n1];
        Record[] R = new Record[n2];
        incrementStep(2); // array allocations

        incrementStep((n1)-1+2); // for loop comparison
        for (int i = 0; i < n1; i++) {
            L[i] = arr[p + i];
            incrementStep((1); // copying to L
        }
        
        incrementStep((n2)-0+2); // for loop comparison
        for (int j = 0; j < n2; j++) {
            R[j] = arr[q + 1 + j];
            incrementStep(1); // copying to R
        }

        int i = 0, j = 0, k = p;
        incrementStep(3); // variable initializations

        while (i < n1 && j < n2) {
            incrementStep(2); // loop condition check
            incrementStep(1); // comparison
            if (L[i].getIdNumber() <= R[j].getIdNumber()) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
            incrementStep(1); // data assignment
        }

        while (i < n1) {
            incrementStep(1); // loop condition
            arr[k++] = L[i++];
            incrementStep(1); // assignment
        }

        while (j < n2) {
            incrementStep(1); // loop condition
            arr[k++] = R[j++];
            incrementStep(1); // assignment
        }
    }

    public void quickSort(Record[] arr, int low, int high) {
        incrementStep(1); // condition check (the if check)
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(Record[] arr, int low, int high) {
        Record pivot = arr[high];
        incrementStep(1); // pivot assignment
        int i = low - 1;
        incrementStep(1); // i initialization

        incrementStep((high-1)-low+2); // for loop comparison
        for (int j = low; j < high; j++) {
            incrementStep(1); // comparison
            if (arr[j].getIdNumber() <= pivot.getIdNumber()) {
                i++;
                incrementStep(1); // i increment
                Record temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                incrementStep(3); // swap operations
            }
        }
        Record temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        incrementStep(3); // final swap
        return i + 1;
    }
}
