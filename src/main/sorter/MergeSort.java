package main.sorter;

public class MergeSort implements Sorter {

    @Override
    public int[] sort(int[] values) {
        if (values.length <= 1) {
            return values;
        }

        int middle = values.length / 2;

        int[] left = new int[middle];
        int[] right = new int[values.length - middle];

        System.arraycopy(values, 0, left, 0, middle);
        System.arraycopy(values, middle, right, 0, values.length - middle);

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        
        while (i < left.length) {
            result[k++] = left[i++];
        }

        
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
