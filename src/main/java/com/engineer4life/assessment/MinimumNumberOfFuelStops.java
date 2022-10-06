package com.engineer4life.assessment;

/**
 * Leetcode: https://leetcode.com/problems/minimum-number-of-refueling-stops/
 * Difficulty: Hard
 * Time & Space complexity: O(n^2) & O(n)
 */
public class MinimumNumberOfFuelStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        var dp = new int[stations.length+1];
        dp[0] = startFuel;
        for(var stationId=0; stationId < stations.length; stationId++){
            for(var stopId=stationId; stopId >=0; stopId--){
                
                if(dp[stopId] >= stations[stationId][0])
                    dp[stopId+1] = Math.max(dp[stopId+1], dp[stopId] + stations[stationId][1]);
            }
        }
        
        for(var stop=0; stop <= stations.length; stop++){
            if(dp[stop] >= target) return stop;
        }
        return -1;
    }

    public static void main(String[] args) {
       var solution = new MinimumNumberOfFuelStops();
       
       var test1_stations = new int[][]{{10,60}, {20,30}, {30,30}, {60,40}};
       var test1_results = solution.minRefuelStops(100, 10, test1_stations);
       System.out.println(test1_results);
    }
}
