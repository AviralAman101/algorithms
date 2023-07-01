package in.algo;


//Given two integers n and r, find nCr. Since the answer may be very large,
// calculate the answer modulo 109+7.
public class CombinationAlgorithm {
    public static void main(String[] args) {
        System.out.println(nCr(69,43));
    }
    static int nCr(int n, int r){
        long mod = 1000000009;
        if(r==0){
            return 1;
        }
        return (int)((getNum(n)/(getNum(r)*getNum(n-r)))%mod);
    // code here  {
    }

    public static long getNum(long n){
        long num = 1;
        for (int i = 1; i < n+1; i++) {
            System.out.println(num);
            num*=i;
        }
        System.out.println("****************");
        return num;
    }
}
