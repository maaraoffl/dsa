package com.engineer4life.assessment;

import java.util.Map;
import java.util.Stack;

/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
        var stack = new Stack<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        var data = Map.of("a", 10, "b", 20);
        data.put("a", 20);
        data.forEach((k,v) -> System.out.printf("%s:%d\n", k, v));        
    }
}
