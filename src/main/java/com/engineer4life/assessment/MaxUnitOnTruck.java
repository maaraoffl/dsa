package com.engineer4life.assessment;

import java.util.Arrays;

public class MaxUnitOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxUnits = 0;
        Arrays.sort(boxTypes, (int[] o1, int[] o2) -> o2[1] - o1[1]);
        
        for(int[] boxType: boxTypes){
            int numBox = boxType[0];
            int numUnit = boxType[1];
            
            
            
            while(truckSize > 0 && numBox > 0){
                //System.out.printf("%d box taken that contains %d\n", numBox, numUnit);
                maxUnits += numUnit;
                numBox--;
                truckSize--;
            }
        }
        return maxUnits;
    }

    public static void main(String[] args) {
        var maxUnitOnTruck = new MaxUnitOnTruck();

        int[][] test1_boxTypes = new int[][]{{1,3}, {2,2}, {3,1}};
        int test1_truckSize = 4;
        int test1_result = maxUnitOnTruck.maximumUnits(test1_boxTypes, test1_truckSize);
        System.out.println(test1_result);

        int[][] test2_boxTypes = new int[][]{{5,10}, {2,5}, {4,7}, {3,9}};
        int test2_truckSize = 4;
        int test2_result = maxUnitOnTruck.maximumUnits(test2_boxTypes, test2_truckSize);
        System.out.println(test2_result);
    }
}
