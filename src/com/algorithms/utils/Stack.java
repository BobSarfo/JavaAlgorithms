package com.algorithms.utils;

import java.util.Arrays;

public class Stack<T> {
    int size = 10;
    T[] store = (T[]) new Object[size];
    int pointer = -1;

    public void push(T item){
        pointer++;
        if(pointer>size){
            size=size*2;
            store = Arrays.copyOf(store,size);
        }
        store[pointer] = item;
    }

    public T pop(){
        var item= store[pointer];
        pointer--;
        if (pointer<(size/2-1)){
            size=size/2;
            store = Arrays.copyOf(store,size);
        }
        return item;
    }

    public T peek(){
        return store[pointer];
    }

    public boolean isEmpty(){
        return pointer == -1;
    }

    public void insertAtBottom(T value){

        if(pointer>size){
            size=size*2;
            store = Arrays.copyOf(store,size);
        }
        int pointerTemp =  pointer;
        T temp = store[pointer];
        for (int i = store.length; i >0 ; i--) {
            store[pointer+i] = store[pointer--];
        }

        pointer= pointerTemp+1;

    }

    public void reverse(){

    }

    void sort(){}
}
