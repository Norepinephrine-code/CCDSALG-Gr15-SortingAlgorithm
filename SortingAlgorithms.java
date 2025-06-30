/* This file contains implementations of sorting algorithms.
 * You are NOT allowed to modify any of the given method headers.
 */

public class SortingAlgorithms {

    private static long stepCount = 0;

    public static long getStepCount() {
        return stepCount;
    }

    private static void resetStepCount() {
        stepCount = 0;
    }

    private static void incrementStep(int n) {
        stepCount += n;
    }

    public void insertionSort(Record[] arr, int n) {
        resetStepCount();
        for (int i = 1; i < n; i++) {
            incrementStep(1); // for loop comparison
            Record key = arr[i];
            incrementStep(1); // key assignment
            int j = i - 1;
            incrementStep(1); // j assignment
            while (j >= 0 && arr[j].getIdNumber() > key.getIdNumber()) {
                incrementStep(2); // j >= 0 + comparison, there is two since its "&&" operator
                arr[j + 1] = arr[j];
                incrementStep(1); // data movement
                j--;
                incrementStep(1); // j decrement
            }
            incrementStep(2); // failed while comparison
            arr[j + 1] = key;
            incrementStep(1); // final assignment
        }
        incrementStep(1); // for loop final check
    }

    public void selectionSort(Record[] arr, int n) {
        resetStepCount();
        for (int i = 0; i < n - 1; i++) {
            incrementStep(1); // for loop comparison
            int minIdx = i;
            incrementStep(1); // assignment
            for (int j = i + 1; j < n; j++) {
                incrementStep(1); // inner loop comparison
                incrementStep(1); // comparison between elements
                if (arr[j].getIdNumber() < arr[minIdx].getIdNumber()) {
                    minIdx = j;
                    incrementStep(1); // new min assignment
                }
            }
            incrementStep(1); // inner loop final check
            Record temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
            incrementStep(3); // three assignments in swap
        }
        incrementStep(1); // outer loop final check
    }

    public void mergeSort(Record[] arr, int p, int r) {
        if (p == 0 && r == arr.length - 1) {
            resetStepCount();
        }
        incrementStep(1); // mergeSort comparison
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

        for (int i = 0; i < n1; i++) {
            incrementStep(1); // loop condition
            L[i] = arr[p + i];
            incrementStep(1); // copying to L
        }
        incrementStep(1); // loop final check
        
        for (int j = 0; j < n2; j++) {
            incrementStep(1); // loop condition
            R[j] = arr[q + 1 + j];
            incrementStep(1); // copying to R
        }
        incrementStep(1); // loop final check

        int i = 0, j = 0, k = p;
        incrementStep(3); // variable initializations

        while (i < n1 && j < n2) {
            incrementStep(2); // loop condition check. One for (i < n1), another one for (j < n2)
            incrementStep(1); // comparison (if condition check below)
            if (L[i].getIdNumber() <= R[j].getIdNumber()) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
            incrementStep(1); // data assignment above (since both only have one)
        }

        while (i < n1) {
            incrementStep(1); // loop condition
            arr[k++] = L[i++];
            incrementStep(1); // assignment
        }
        incrementStep(1); // final check for i < n1

        while (j < n2) {
            incrementStep(1); // loop condition
            arr[k++] = R[j++];
            incrementStep(1); // assignment
        }
        incrementStep(1); // final check for j < n2
    }

    public void quickSort(Record[] arr, int low, int high) {
        if (low == 0 && high == arr.length - 1) {
            resetStepCount();
        }
        incrementStep(1); // condition check of the 'if' below
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

        for (int j = low; j < high; j++) {
            incrementStep(1); // loop condition
            incrementStep(1); // comparison below
            if (arr[j].getIdNumber() <= pivot.getIdNumber()) {
                i++;
                incrementStep(1); // i increment
                Record temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                incrementStep(3); // swap operations
            }
        }
        incrementStep(1); // for loop final check
        Record temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        incrementStep(3); // final swap
        return i + 1;
    }
}
