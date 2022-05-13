package com.algorithms.general;

import java.util.Arrays;
import java.util.Random;

public class ArraysAlgo {
    public static int[] moveElementBySteps(int[] elements, int steps){
        int len = elements.length;
        int[] result = new int[len];
        int temp;
        for (int i = 0; i<len;i++ ){
            temp = elements[(i+steps)%len];
            result[(i+steps)%len] =  elements[i];
        }
        return result;
    }

    static int[] shuffleArray(int[] elements){
        Random random = new Random();
        int len = elements.length;
        for (int i = 0; i < len; i++) {
            int randint = random.nextInt(i+1);
            SwapElements(elements,i,randint);
        }
        return elements;
    }

    private static void SwapElements(int[] elements, int i, int randint) {
        int temp = i;
        i = randint;
        randint = temp;
    }
}
