package com.dsa.dynamicprograming;

import java.util.Arrays;

public class PaintHouse {
    /**
     * <a href="https://autocode-next.lab.epam.com/courses/1379/syllabus/5681">Auto Code -> Paint House Problem</a>
     * Given a 2D array of size n x 3 where n is the number of houses.
     * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
     * Find the minimum cost to paint all houses such that no two adjacent houses have the same color.
     *
     */
    public static void main(String... s) {

        PaintHouse paintHouse = new PaintHouse();
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(paintHouse.minCost(costs));
    }

    public int minCost(int[][] costs) {
        if(null == costs || costs.length==0){
            return 0;
        }
        int[][] costsResult = new int [costs.length][3];

        Arrays.stream(costsResult).forEach(c->{
            c[0]=Integer.MAX_VALUE;
            c[1]=Integer.MAX_VALUE;
            c[2]=Integer.MAX_VALUE;
        });
        int i = 0;
        int j = -1;
        return getCost(costs, costsResult, i, j);
    }

    private int getCost(int[][] costs,int[][] costsResult , int i, int j) {
        if(i==costs.length-1){
            return getCheapestPaint(costs,i,j);
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
            if (j != k){
                int tCost;
                if (costsResult[i+1][k]<Integer.MAX_VALUE){
                    tCost = costsResult[i+1][k];
                }else{
                    tCost = getCost(costs,costsResult,i+1,k);
                    costsResult[i+1][k] = tCost;
                }
                min = Math.min(costs[i][k]+tCost,min);
            }
        }
        return min;
    }

    private int getCheapestPaint(int[][] costs, int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
            if (j != k && costs[i][k] < min) {
                min = costs[i][k];
            }
        }
        return min;
    }
}
