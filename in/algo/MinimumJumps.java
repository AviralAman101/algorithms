package in.algo;
/*
* Given an array of N integers arr[] where each element represents the maximum length
* of the jump that can be made forward from that element.
* This means if arr[i] = x, then we can jump any distance y such that y ≤ x.
Find the minimum number of jumps to reach the end of the array (starting from the first element).
* If an element is 0, then you cannot move through that element.*/
public class MinimumJumps {
    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{1, 3, 9, 2, 1, 2, 6, 7, 6, 8, 9}));
        System.out.println(minJumps(new int[]{2,3,1,1,1,3,1}));
        System.out.println(minJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
    }
    static int minJumps(int[] arr){
        int jumpCount=0;
        int start=0;
        if(arr[start]==0){
            return -1;
        }
        while (start<arr.length) {
            int max = arr[start];
            if (max + start >= arr.length-1) {
                return ++jumpCount;
            }
            int next=start+1;
            int l = arr.length;
            for (int i = 1; i <= max; i++) {
                int a =(l-(arr[next]+start+1));
                int b=(l-arr[start+i]-start-i);
                if(a>b){
                    next=start+i;
                }
            }
            start=next;
            jumpCount++;
        }
        return -1;
    }
}
