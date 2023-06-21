package in.algo;
//Question :
// You will be given an integer n, your task is to return the sum
// of all natural number less than or equal to n.
//
// As the answer could be very large, return answer modulo 10^9+7.
public class ReverseCoding {

    public static void main(String[] args) {
        System.out.println(sumOfNaturals(63032));
    }
    static int sumOfNaturals(int z) {
        // code here
        long n =z;
        return (int)(n*(n+1)/2%1000000007);
    }
}
