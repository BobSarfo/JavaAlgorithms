package com.algorithms;

import com.algorithms.problems.Bowling;
import com.algorithms.problems.Staircase;
import com.algorithms.utils.Stack;

import java.util.*;

import static java.util.Arrays.stream;

public class Main {

    public static boolean solutionRoads(boolean[][] roadRegister) {
        Map<Integer,Boolean> in  = new HashMap<>();
        Map<Integer,Boolean> out  = new HashMap<>();

        int rows = roadRegister.length;
        int cols = roadRegister[0].length;
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                in.putIfAbsent(i,false);
                out.putIfAbsent(j,false);

                var currentRow = in.get(i);
                var rowState = roadRegister[i][j]||currentRow;
                out.put(i,rowState);


                var currentCol = out.get(j);
                var colState = roadRegister[i][j]||currentRow;
                out.put(j,rowState);

            }

        }

        for (int i = 0; i < in.size(); i++) {
            if (!in.get(i)) return  false;
            if (!out.get(i)) return  false;
        }
        return true;
    }

    public static void main(String[] args) {
//        ArrayList<ArrayList<String>> group = new ArrayList<>();
//        group.add(new ArrayList<String>((Arrays.asList("MNL","TAG"))));
//        group.add(new ArrayList<String>((Arrays.asList("CEB","TAC"))));
//        group.add(new ArrayList<String>((Arrays.asList("TAG","CEB"))));
//        group.add(new ArrayList<String>((Arrays.asList("TAC","BOR"))));
//        ArrayList<ArrayList<String>> group1 = new ArrayList<>();
//        group1.add(new ArrayList<String>((Arrays.asList("Chicago", "Winnipeg"))));
//        group1.add(new ArrayList<String>((Arrays.asList("Halifax", "Montreal"))));
//        group1.add(new ArrayList<String>((Arrays.asList("Montreal", "Toronto"))));
//        group1.add(new ArrayList<String>((Arrays.asList("Toronto", "Chicago"))));
//        group1.add(new ArrayList<String>((Arrays.asList("Winnipeg", "Seattle"))));

//
//        String input= "11 11 11 11 11 11 11 11 11 11";
//        String input1= "5/ 4/ 3/ 2/ 1/ 0/ X 9/ 4/ 7/2";
//        String input2 = "X X X X X X X X X XXX";
//        String input3 = "X 7/ 72 9/ X X X 23 6/ 7/3";
//        String input4 = "9/ 13 07 35 6/ 8/ 8/ X X 1/X"; //147
//        String input5 = "07 8/ 6/ 90 05 6/ X X 6/ 1/X";// 153
//        String input6 = "5/ 4/ 3/ 2/ 1/ 0/ X 9/ 4/ 8/8"; //150
//        String input7 ="12 X 23 41 3/ 04 6/ 36 6/ XX1";

        Staircase.calculate(4);

    }

	// write your code here
}
