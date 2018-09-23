package Array;
import java.util.Random;
import java.lang.*;

public class maxAbsDiff {

    public static void main(String args[]){
        int[] h = genArray(100);
        System.out.println(h.length);
        int x = maxArr2(h);
        System.out.print("maxDiff ==");
        System.out.println(x);
    }

    private static int[] genArray(int n){
        Random r = new Random();
        int[] x = new int[n];

        for(int i=0;i<n; i++) {
            x[i] = r.nextInt(100 + 1 + 100) - 100; //random.nextInt(max + 1 - min) + min
            System.out.print(x[i] + " ");
        }
        return x;
    }

    private static int maxArr(int[] A){
        int min = A[0], minIndx = 0;
        int max = A[0], maxIndx = 0;
        int maxDiff, maxPossDiff;
        if(A.length == 0)
            return 0;
        for(int i=1; i<A.length; i++){
            if(A[i]< min){
                min = A[i];
                minIndx = i;

            }
            if(A[i] > max){
                max = A[i];
                maxIndx = i;
            }
        }
        maxPossDiff = Math.abs(max-min) + A.length;
        maxDiff = Math.abs(max - min) + Math.abs(maxIndx - minIndx);
        if(maxDiff == maxPossDiff)
            return maxDiff;

        int checkDiff = 0;
        for(int i = 0; i<A.length; i++) {
            for (int j = 1; j < A.length; j++) {
                checkDiff = Math.abs(A[i] - A[j]) + Math.abs(i - j);
                if (checkDiff > maxDiff)
                    maxDiff = checkDiff;
            }
        }
        return maxDiff;
    }

    private static int maxArr2(int[] A){
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++)
        {
            max1 = Math.max(max1, A[i] + i);
            min1 = Math.min(min1, A[i] + i);
            max2 = Math.max(max2, A[i] - i);
            min2 = Math.min(min2, A[i] - i);
        }
        return Math.max(max1 - min1, max2 - min2);
    }
}
