package com.engineer4life.assessment;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Leetcode: https://leetcode.com/problems/reorder-data-in-log-files
 * Difficulty: Easy
 * Time & Space complexity: O(M NlogN) & O(M logN)
 * 
 * M - Maximum length of the log
 * N - Number of logs
 * 
 * The compareTo function needs space for store temporary results
 * thats why we have O(M logN) for space instead of O(1)
 */

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, new LogComparator());
        return logs;
    }

    public static class LogComparator implements Comparator<String>{

        @Override
        public int compare(String l1, String l2){
           
            String[] split1 = l1.split(" ", 2);
            String[] split2 = l2.split(" ", 2);

            var isDigit1 = Character.isDigit(split1[1].charAt(0));
            var isDigit2 = Character.isDigit(split2[1].charAt(0));
            
            if(!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if(cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            else if(isDigit1 && !isDigit2) return 1;
            else if(!isDigit1 && isDigit2) return -1;
            else return 0;

        }
    }

    public static void main(String[] args) {
        var solution = new ReorderLogFiles();
        solution.reorderLogFiles(new String[]{
            "a1 9 2 3 1",
            "g1 act car",
            "zo4 4 7",
            "ab1 off key dog",
            "a8 act zoo"
        });

        solution.reorderLogFiles(new String[]{
            "dig1 8 1 5 1",
            "let1 art can",
            "dig2 3 6",
            "let2 own kit dig",
            "let3 art zero"
        });
    }
}
