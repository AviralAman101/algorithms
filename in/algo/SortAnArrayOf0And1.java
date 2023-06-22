package in.algo;

import java.util.Arrays;

public class SortAnArrayOf0And1 {
    public static void main(String[] args) {
        int[] a = {0, 2, 1, 2, 0};
        sort012(a,5);
        System.out.println(Arrays.toString(a));
    }
    public static void sort012(int a[], int n)
    {
        // code here
        int ar[]=new int[3];
        for(int i=0;i<n;i++){
            if(a[i]==0){
                ar[0]++;
            }
            if(a[i]==1){
                ar[1]++;
            }
            if(a[i]==2){
                ar[2]++;
            }
        }
        int c=0;
        for(int i=0;i<3;i++){
            while(ar[i]-->0){
                a[c++]=i;
            }
        }
    }
}
