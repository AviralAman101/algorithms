package in.algo;


import java.util.Arrays;

//Given an array arr of distinct elements of size N, the task is to rearrange the
// elements of the array in a zig-zag fashion so that the converted
// array should be in the below form:
//arr[0] < arr[1]  > arr[2] < arr[3] > arr[4] < . . . . arr[n-2] < arr[n-1] > arr[n].
public class ZigZag {
    public static void main(String[] args) {
        zigZag(new int[]{4, 3, 7, 8, 6, 2, 1},7);
    }

    public static void zigZag(int a[], int n){
        boolean flag=true;
        for (int i = 0; i < n-1; i++) {
            if(i%2==0 && a[i]>a[i+1]){
                //swap
                a[i]=a[i]+a[i+1];
                a[i+1]=a[i]-a[i+1];
                a[i]=a[i]-a[i+1];
            }else if (i%2!=0 && a[i]<a[i+1]){
                //swap
                a[i]=a[i]+a[i+1];
                a[i+1]=a[i]-a[i+1];
                a[i]=a[i]-a[i+1];
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
