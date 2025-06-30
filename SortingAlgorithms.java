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

    private static void incrementStep() {
        stepCount++;
    }



    public void insertionSort(Record[] arr, int n) {
        resetStepCount();
        for (int i = 1; i < n; i++) {
            Record key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getIdNumber() > key.getIdNumber()) {
                arr[j + 1] = arr[j];
                j--;
                incrementStep();
            }
            arr[j + 1] = key;
        }
    }

    public void selectionSort(Record[] arr, int n) {
        resetStepCount();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                incrementStep();
                if (arr[j].getIdNumber() < arr[minIdx].getIdNumber()) {
                    minIdx = j;
                }
            }
            Record temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public void mergeSort(Record[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    private void merge(Record[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        Record[] L = new Record[n1];
        Record[] R = new Record[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[q + 1 + j];
        }

        int i = 0, j = 0, k = p;

        while (i < n1 && j < n2) {
            incrementStep();
            if (L[i].getIdNumber() <= R[j].getIdNumber()) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public void quickSort(Record[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(Record[] arr, int low, int high) {
        Record pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            incrementStep();
            if (arr[j].getIdNumber() <= pivot.getIdNumber()) {
                i++;
                Record temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Record temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
