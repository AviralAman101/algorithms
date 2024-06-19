package in.algo.random.dp;

import java.util.Arrays;
/*
* Find triplets that are multiples of 'd' in the array arr
*
* Ex int[] arr = {1, 2, 3, 4, 5};
* d=12
*
* Only 1 triplet  = (3+4+5)=12
* Ans -> 1
* */
public class FindTriplets {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1, 2, 3, 4, 5,1, 2, 3, 4, 5};
        System.out.println(countWithoutDP(arr, 12));
        System.out.println(countTriplets(arr, 12));
    }

    static synchronized int countTriplets(int[] l, int d){
        long l1 = System.currentTimeMillis();
        int count = 0;
        int length = l.length;
        long dp[][] = new long[length+1][length+1];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                for (int k = j+1; k < length; k++) {
                    if(dp[i+1][k+1] != -1){
                        if((dp[i+1][k+1]+l[j])%d==0){
                            count++;
                        }
                    }else {
                        long temp = l[j]+l[k];
                        dp[j+1][k+1] = temp;
                        if((temp+l[i])%d==0){
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println("TIme DP" + (System.currentTimeMillis()-l1));
        return count;
    }

    static synchronized int countWithoutDP(int[] l, int d) throws InterruptedException {
        long l1 = System.currentTimeMillis();
        Thread.sleep(100);
        int count = 0;
        int length = l.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                for (int k = j+1; k < length; k++) {

                        long temp = l[j]+l[k];
                        if((temp+l[i])%d==0){
                            count++;
                        }

                }
            }
        }

        System.out.println("TIme GP" + (System.currentTimeMillis()-l1));

        return count;
    }
}
