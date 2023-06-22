package in.algo;
//You are an owner of lemonade island, each lemonade costs $5.
// Customers are standing in a queue to buy from you and order
// one at a time (in the order specified by given array bills[]).
// Each customer will only buy one lemonade and pay with either a
// $5, $10, or $20 bill. You must provide the correct change to
// each customer so that the net transaction is that the customer pays $5.
//
//NOTE: At first, you do not have any bill to provide changes with.
// You can provide changes from the bills that you get from the previous customers.
//
//Given an integer array bills of size N where bills [ i ] is
// the bill the ith customer pays, return true if you can
// provide every customer with the correct change, or false otherwise.
public class LemonadeChange {

    public static void main(String[] args) {
        System.out.println(lemonadeChange(5, new int[]{5, 5, 10, 10, 20}));
    }

    static boolean lemonadeChange(int N, int bills[]) {
        // code here
        int $5bill = 0;
        int $10bill = 0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) $5bill++;
            if(bills[i] == 10) $10bill++;

            if(bills[i]==5){
                continue;
            }if(bills[i]==10){
                if($5bill>0){
                    $5bill--;
                    continue;
                }else {
                    break;
                }
            }
            if(bills[i]==20){
                if($10bill>0 && $5bill>0){
                    $10bill--;
                    $5bill--;
                } else if ($5bill>2) {
                    $5bill-=3;
                }else break;
            }
        }
        return false;

    }
}

