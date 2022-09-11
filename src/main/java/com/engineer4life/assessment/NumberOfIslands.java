package com.engineer4life.assessment;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.*;

class NumberOfIslands {

    public int numIslands(char[][] grid) throws Exception {

        int result=0;

        if(grid.length < 1) throw new Exception("Invalid input");

        var height = grid.length;
        var width = grid[0].length;

        for(var rowIdx=0; rowIdx < height; rowIdx++){
            for(var colIdx=0; colIdx < width; colIdx++){
                if(grid[rowIdx][colIdx] == '0') continue;
                measureIsland(rowIdx, colIdx, grid);
                result += 1;
            }
        }

        return result;

    }

    void measureIsland(int rowIdx, int colIdx, char[][] grid){
        var queue = new ArrayDeque<Integer[]>();
        queue.add(new Integer[]{rowIdx, colIdx});

        while(!queue.isEmpty()){
            var currentPosition = queue.poll();
            grid[currentPosition[0]][currentPosition[1]] = '0';

            var neighbors = getNeighbors(currentPosition[0], currentPosition[1], grid);
            for(var neighbor: neighbors){
                queue.add(new Integer[]{neighbor[0], neighbor[1]});
            }
        }
    }

    List<Integer[]> getNeighbors(int rowIdx, int colIdx, char[][] grid){
        
        var neighbors = new ArrayList<Integer[]>();
        if(neitherBoundaryNorLand(rowIdx+1, colIdx, grid)) neighbors.add(new Integer[]{rowIdx+1, colIdx});
        if(neitherBoundaryNorLand(rowIdx, colIdx+1, grid)) neighbors.add(new Integer[]{rowIdx, colIdx+1});
        if(neitherBoundaryNorLand(rowIdx-1, colIdx, grid)) neighbors.add(new Integer[]{rowIdx-1, colIdx});
        if(neitherBoundaryNorLand(rowIdx, colIdx-1, grid)) neighbors.add(new Integer[]{rowIdx, colIdx-1});
        return neighbors;
    }

    boolean neitherBoundaryNorLand(int rowIdx, int colIdx, char[][] grid){
        var height = grid.length;
        var width = grid[0].length;

        if(rowIdx < 0 || colIdx < 0 || rowIdx > height-1 || colIdx > width-1 || grid[rowIdx][colIdx] == '0' ) return false;
        else return true;
    }

    public static void main(String[] args) throws Exception {
        var grid = new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        var territory = new NumberOfIslands();
        int numIsland = territory.numIslands(grid);
        System.out.println(numIsland);

    }
}