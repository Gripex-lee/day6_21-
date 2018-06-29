package day6_21;

import java.util.Scanner;

public class A061 {
    public static boolean checkMinHeap(int[] A){
        for (int i = 0; i <= (A.length - 2) / 2; i++) {
            if (A[i] > A[2 * i + 1] || ((2 * i + 2 != A.length) 
                                        && A[i] > A[2 * i + 2])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
    	Scanner br=new Scanner(System.in);
    	int[]a=new int[6];
    	for(int i=0;i<a.length;i++) {
    		a[i]=br.nextInt();
    	}
        if (checkMinHeap(a)) {
            System.out.println("Given array is a min heap");
        } else {
            System.out.println("Given array is not a min heap");
        }
    }
}
