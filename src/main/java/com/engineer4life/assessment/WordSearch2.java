package com.engineer4life.assessment;

import java.util.ArrayList;
import java.util.*;

public class WordSearch2 {
    
    boolean findWords(char[][] board, String word, int rowIdx, int colIdx, int searchCharIdx, boolean[][] visited){
        if(rowIdx < 0 || 
            rowIdx > board.length-1 || 
            colIdx < 0 || 
            colIdx > board[0].length-1 || 
            visited[rowIdx][colIdx] ||
            searchCharIdx > word.length()-1 ||
            board[rowIdx][colIdx] != word.toCharArray()[searchCharIdx]
        ){
            // visited[rowIdx][colIdx] = false;
            return false;
        } 

        visited[rowIdx][colIdx] = true;
        // System.out.printf("Searching %s: Found %c at (%d,%d)\n", word, word.toCharArray()[searchCharIdx], rowIdx, colIdx);

        if(board[rowIdx][colIdx] == word.toCharArray()[searchCharIdx] && searchCharIdx == word.length()-1) return true;
        
        var result = findWords(board, word, rowIdx+1, colIdx, searchCharIdx+1, visited) ||
        findWords(board, word, rowIdx, colIdx+1, searchCharIdx+1, visited) ||
        findWords(board, word, rowIdx-1, colIdx, searchCharIdx+1, visited) ||
        findWords(board, word, rowIdx, colIdx-1, searchCharIdx+1, visited);

        visited[rowIdx][colIdx] = false;
        return result;
    }

    public List<String> findWords(char[][] board, String[] words) {
        var result = new ArrayList<String>();
        for(var word: words){
            var found = false;
            for(var rowIdx=0; rowIdx < board.length && !found; rowIdx++){
                for(var colIdx=0; colIdx < board[0].length && !found; colIdx++){
                    var visited = new boolean[board.length][board[0].length];
                    if(findWords(board, word, rowIdx, colIdx, 0, visited)){
                        result.add(word);
                        found = true;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var ws = new WordSearch2();

        // test 1
        var test1_board = new char[][]{
            {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}
        };
        var test1_words = new String[]{"oath", "pea", "eat", "rain"};        
        var test1_results = ws.findWords(test1_board, test1_words);
        System.out.println(test1_results);

        // test 2
        var test2_board = new char[][]{
            {'a','b'},{'c','d'}
        };
        var test2_words = new String[]{"abcb"};        
        var test2_results = ws.findWords(test2_board, test2_words);
        System.out.println(test2_results);


        var test3_board = new char[][]{{'a','a'}};
        var test3_words = new String[]{"aaa"};        
        var test3_results = ws.findWords(test3_board, test3_words);
        System.out.println(test3_results);
    }
}
