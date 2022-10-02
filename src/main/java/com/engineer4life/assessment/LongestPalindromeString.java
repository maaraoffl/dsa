package com.engineer4life.assessment;

public class LongestPalindromeString {
    public String longestPalindrome(String s) {
     int sLength = s.length();
     int left=0, mid=1, right=Math.min(mid+1, sLength-1);

     var longest = new int[]{0,1};
     
     while(left >=0 && right < sLength){
        var isOddPalindrome = isValidPalindrome(s, left, right);
        var isEvenPalindrome = isValidPalindrome(s, left, mid);

        var expandOddPalindrome = new int[]{0,0};
        var expandEvenPalindrome = new int[]{0,0};

        if(isOddPalindrome)
        expandOddPalindrome = expandPalindrome(s, left, right);

        System.out.printf("expandOddPalindrome: %d,%d\n", expandOddPalindrome[0], expandOddPalindrome[1]);
        
        if(isEvenPalindrome)
        expandEvenPalindrome = expandPalindrome(s, left, mid);

        System.out.printf("expandEvenPalindrome: %d,%d\n", expandEvenPalindrome[0], expandEvenPalindrome[1]);

        var currentLongest = (expandOddPalindrome[1] - expandOddPalindrome[0]) > (expandEvenPalindrome[1] - expandEvenPalindrome[0]) ? expandOddPalindrome : expandEvenPalindrome;
        longest = (currentLongest[1] - currentLongest[0]) > (longest[1] - longest[0]) ? currentLongest : longest;

        left++;
        mid++;
        right++;

        System.out.printf("At end: %d, %d, %d\n", left, mid, right);
     }
     return s.substring(longest[0], longest[1]+1);
    }

    int[] expandPalindrome(String s, int left, int right){
        while(left > 0 && right < s.length()){
            if(s.charAt(left-1) != s.charAt(right++)) break;
            left--;
            right++;
        }
        return new int[]{left, right};
    }

    boolean isValidPalindrome(String s, int left, int right){
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        var problem = new LongestPalindromeString();
        var result = problem.longestPalindrome("abbad");
        System.out.println(result);
    }
}
