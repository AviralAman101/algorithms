package in.algo.dynamicProgramming;


import java.util.Arrays;

/*
*
* Consider a scenario where a car needs to travel from a starting
* position to a destination located target miles east of the starting position.
* Along the way, there are multiple gas stations represented by the array `stations`.
* Each element in `stations` is of the form [position i, fuel i],
* indicating that the ith ngas statio is position i miles east of
* the starting position and has fuel i liters of gas available.


The car begins its journey with an infinite tank of gas, which is
* initially filled with startFuel liters. The car consumes one
* liter of gas per mile it drives. When the car arrives at a gas station,
* it has the option to stop and refuel, transferring all the available
* gas from the station to the car.


Your task is to determine the minimum number of refueling stops
* the car must make in order to reach its destination.
* If reaching the destination is not possible, return -1.


Note that even if the car reaches a gas station with 0 fuel left,
* it can still refuel there. Similarly, if the car reaches
* the destination with 0 fuel left, it is still considered a successful arrival.


Let's look at a few examples to illustrate the problem:


Example 1:

Input: target = 1, startFuel = 1, stations = []

Output: 0

Explanation: In this case, we can reach the target without making any refueling stops.


Example 2:

Input: target = 100, startFuel = 1, stations = [[10,100]]

Output: -1

Explanation: Here, it is not possible to reach the target (
* or even the first gas station) as the initial fuel is insufficient.


Example 3:

Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]

Output: 2

Explanation: Starting with 10 liters of fuel, we drive to position 10
* and consume 10 liters of fuel. Then, at position 10, we refuel
* from 0 liters to 60 liters. Next, we drive from position 10 to position 60,
* consuming 50 liters of fuel. Finally, we refuel
* from 10 liters to 50 liters at position 60. We continue driving until
* we reach the target.
* Along the way, we made 2 refueling stops, so the output is 2.


In summary, the problem asks for the minimum number of
* refueling stops required for a car to reach its destination,
* taking into account the available gas stations and the initial fuel.
*
* */
public class MinimumRefuelStops {
    public static void main(String[] args) {
        System.out.println(minimumRefuelDfs(100,10,new int[][]{{10,60},{20,30},{30,30},{60,40}}, 0,0));
        System.out.println(bottomUp1DMinimumRefuel(100,10,new int[][]{{10,60},{20,30},{30,30},{60,40}}));
        System.out.println(bottomUp1DMinimumRefuel(100,1,new int[][]{{10, 100}}));
    }

    private static int minimumRefuelDfs(int target, int fuelLeft, int[][] stations, int stops, int index){
        if(target <= fuelLeft) return stops;
        if(index == stations.length-1) return -1;
        if(fuelLeft < stations[index][0]) return -1;
        int stop=-1;
        if(fuelLeft >= stations[index][0])
            stop = minimumRefuelDfs(target-stations[index][0],
                    fuelLeft-stations[index][0]+stations[index][1], stations, stops+1, index+1);
        int dontStop = minimumRefuelDfs(target,
                fuelLeft, stations, stops, index+1);
        return getResult(stop, dontStop);
    }

    private static int getResult(int stop, int dontStop) {
        int result;
        if(stop == -1 && dontStop != -1)
            result = stop < dontStop ? stop : dontStop;
        else if(stop == -1) result = dontStop;
        else result = stop;
        return result;
    }

    private static int minimumRefuelSimple(int target, int startFuel, int[][] stations) {
        //int[] dp = new int[target + 1];
//        Arrays.sort(stations, (a, b) -> Integer.compare(b[1],a[1]));
//        Arrays.stream(stations).forEach(ar -> System.out.println(Arrays.toString(ar)));
        if(startFuel < stations[0][0]) return -1;
        int max=startFuel;
        for (int i = 0; i <= stations.length; i++) {
            for (int j = 0; j < stations.length; j++) {
                if(startFuel-stations[j][0]>=0 && stations[j][1] !=-1){
                    startFuel = startFuel-stations[j][0] + stations[j][1];
                    max+=stations[j][1];
                    stations[j][1] = -1;
                    break;
                }
            }
            if(max>target) return i+1;
        }
        return -1;
    }


    //
    private static int bottomUp1DMinimumRefuel(int target, int startFuel, int[][] stations){
        int[][] dp = new int[stations.length + 1][stations.length + 1];
        int[][] dpFuel = new int[stations.length + 1][(stations.length) + 1];
        if(startFuel>=target) return 0;
        for (int i = 0; i < stations.length+1; i++) {
            dp[i][0]=startFuel;
            dpFuel[i][0]=startFuel;
        }
        for (int i = 1; i <= stations.length; i++) {
            for (int j = 1; j <= i ; j++) {
                int refuel = 0;
                if(dpFuel[i-1][j-1]-stations[i-1][0]>=0){
                    refuel=stations[i-1][1]+dp[i-1][j-1];
                    dpFuel[i][j]=dpFuel[i-1][j-1]+stations[i-1][1]-stations[i-1][0];
                } else {
                    dpFuel[i][j] = dpFuel[i-1][j];
                }
                int notRefuel = dp[i-1][j];
                dp[i][j] = Math.max(notRefuel, refuel);
            }
        }
        //Arrays.stream(dp).forEach(ar -> System.out.println(Arrays.toString(ar)));
        for (int i = 1; i <= stations.length; i++) {
            if(dp[stations.length][i]>=target) return i;
        }
        return -1;
    }
}
