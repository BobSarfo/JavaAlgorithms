package com.algorithms.problems;

public class Converter {
    public static String NumberToWords(int number){
         String[] levelthree = {"zero","hundred","thousand","million","billion","trillion"};
//        units

        int counter=-1;
//        hundreds
        int numberLength =String.valueOf(number).length();
        StringBuilder word = new StringBuilder();
        while(number>=0){
            int n = numberLength/3;
            number = number/10;

            if (counter == 0){
                word.append(levelthree[n]);
            }
            if(numberLength%3==0) counter =0;
        }
        return null;
    }

    private static String hundredToWords(int number){
        String[] units = {"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve",
                "thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
        String[] tens = {"zero","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

        int unit = number%10;
        int ten = number/10;
        StringBuilder result = new StringBuilder();
//        514; 925 102;

        if(number>100){
            int newunit = number%100;
            unit = newunit%10;
            ten = newunit/10;

            String.join("",units[ten/10], "hundred and",tens[ten],units[unit]);
        }
        if(number<21) return units[number];
        if(number%10==0 && number<=100) return tens[ten];

        if(number%10==0) return String.join(" ",units[ten/10], "hundred");

        if(number<100){
            return  String.join(" ",tens[ten],units[unit]);
        }


        return null;
    }
}
