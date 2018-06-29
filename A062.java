package day6_21;

public class A062 {
    private static int LEFT(int i) {
        return (2 * i + 1);
    }

    private static int RIGHT(int i) {
        return (2 * i + 2);
    }
    private static void Heapify(int[] A, int i, int size){
        int left = LEFT(i);
        int right = RIGHT(i);
        int smallest = i;
        if (left < size && A[left] < A[i]) {
            smallest = left;
        }
        if (right < size && A[right] < A[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(A, i, smallest);
            Heapify(A, smallest, size);
        }
    }
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void convert(int[] A){
        int i = (A.length - 2) / 2;
        while (i >= 0) {
            Heapify(A, i--, A.length);
        }
    }

    public static void main(String[] args){
        int a[] = { 9, 4, 7, 1, -2, 6, 5 };
        convert(a);
        for(int i=0;i<a.length;i++) {
        	System.out.print(a[i]+" ");
        }
    }
}
