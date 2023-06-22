package in.algo;


//Given an array A of n positive numbers.
// The task is to find the first Equilibrium Point in an array.
//Equilibrium Point in an array is a position such that the sum
// of elements before it is equal to the sum of elements after it.
//Note: Return the index of Equilibrium point. (1-based index)

public class EquilibriumPoint {
    public static int equilibriumPoint(long arr[], int n) {
        int sum=0;
        if(n==1){
            return 1;
        }
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        long t=sum;
        for(int k=n-1;k>0;k--){
            t-=arr[k];
            long lf=arr[k-1];
            if((sum-t)==(t-lf)){
                return k;
            }
        }
        return -1;
        // Your code here
    }

    public static void main(String[] args) {
        long x = equilibriumPoint(new long[]{1,3,5,2,2} ,5);
        System.out.println(x);
    }
}
