package com.algorithms.problems;

import java.util.ArrayList;
import java.util.Stack;

public class Staircase {

    public static void calculate(int steps){
        Stack<Stair> stairStack = new Stack<>();
        stairStack.add(new Stair(0,new ArrayList<>()));

        while (!stairStack.isEmpty()){
            Stair currentStair = stairStack.pop();
            if(currentStair.value==steps){
                System.out.println(currentStair.visited);
                continue;
            }
            int moveOne = currentStair.value+1;
            if(moveOne<=steps){
                stairStack.add(new Stair(moveOne,currentStair.visited));
            }
            int moveTwo = currentStair.value+2;
            if(moveTwo<=steps){
                stairStack.add(new Stair(moveTwo,currentStair.visited));
            }
        }
    }

    static class Stair{
        int value;
        ArrayList<Integer> visited = new ArrayList<>();

        Stair(int value,ArrayList<Integer> visited){
            this.value =value;
            this.visited.addAll(visited);
            this.visited.add(value);
        }
    }
}
