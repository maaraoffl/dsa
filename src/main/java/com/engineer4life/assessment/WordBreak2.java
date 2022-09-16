package com.engineer4life.assessment;
import java.util.*;

// 140. Word Break II
// https://leetcode.com/problems/word-break-ii
public class WordBreak2 {

    static class ResultBuilder {
        int start;
        List<String> partialResult;

        ResultBuilder(int start){
            this.start = start;
            this.partialResult = new ArrayList<>();
        }

        ResultBuilder(int start, List<String> partial){
            this.start = start;
            this.partialResult = partial;
        }
    }

    public List<List<String>> wordBreak(String s, List<String> wordDict) {
        var result = new ArrayList<List<String>>();

        Queue<ResultBuilder> queue = new ArrayDeque<>();
        queue.add(new ResultBuilder(0));

        while(!queue.isEmpty()){
            var resultHolder = queue.poll();
            if(resultHolder.start > s.length()-1) continue;

            for(var idx=resultHolder.start; idx < s.length(); idx++){
                String prefix = s.substring(resultHolder.start, idx+1);
                if(wordDict.contains(prefix)){
                    if(idx == s.length()-1) {
                        resultHolder.partialResult.add(prefix);
                        result.add(resultHolder.partialResult);
                    } else {
                        var clonedResult = new ArrayList<String>();
                        clonedResult.addAll(resultHolder.partialResult);
                        clonedResult.add(prefix);
                        queue.add(new ResultBuilder(idx+1, clonedResult));
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var wb2 = new WordBreak2();

        // test 1
        var result = wb2.wordBreak("catsanddog", Arrays.asList("cats","dog","sand","and","cat"));
        System.out.println(result);

        // test 2
        var result2 = wb2.wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple"));
        System.out.println(result2);

        // test 3
        var result3 = wb2.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat"));
        System.out.println(result3);
    }
}
