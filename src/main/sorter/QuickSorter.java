package main.sorter;

public class QuickSorter implements Sorter {

    @Override
    public int[] sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public void quickSort(int[] array, int low, int high){
        if (low < high) {
            int i = quickParticio(array, low, high);
            quickSort(array, low, i - 1);
            quickSort(array, i + 1, high);
        }
    }

    public int quickParticio(int[] array, int low, int high){
        int pivo = array[low];
        int i = low;
        int temp = 0;
        for (int j = low + 1; j <= high; j++) {
            if (array[j] <= pivo) {
                i+=1;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        temp = array[i];
        array[i] = array[low];
        array[low] = temp;
        return i; 
    }
}
