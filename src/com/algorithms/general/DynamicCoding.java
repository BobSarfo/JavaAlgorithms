package com.algorithms.general;

import java.util.HashMap;
import java.util.Map;

public class DynamicCoding{

    public static int GridTraveller(int n, int m ){
        if(n == 1 && m==1) return 1;
        if(n == 1 || m==1) return 0;

        return GridTraveller(n-1,m)  + GridTraveller(n, m-1);
    }


    public static long Fibonacci(long n,Map<Long,Long> store){

        if(store.containsKey(n)) return store.get(n);

        if(n <=2){
            return 1;
        }

        store.putIfAbsent(n,Fibonacci(n-1,store) + Fibonacci(n-2,store));
        return Fibonacci(n-1,store) + Fibonacci(n-2,store);
    }
}