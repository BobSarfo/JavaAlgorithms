package com.algorithms.utils;

public class LinkedList<T> {
    Node<T> head;

    public void addLast(T value){
        if(head==null){
            head = new Node<>(value);
            return;
        }
        Node<T> temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next = new Node<>(value);

    }
    public void addFirst(T value){
        if(head==null){
            head = new Node<>(value);
            return;
        }
        var newHead = new Node<>(value);
        newHead.next=head;
        head = newHead;
    }

    public Node<T> ReverseList(Node<T> node) {
        Node<T> prev = null;
        Node<T> curr = node;
        Node<T> next = null;

        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;

            curr = next;
        }
        node=prev;
        return node;
    }

    private class Node<T>{
        private final T value;
        Node<T> next;

        public Node(T value){
            this.value = value;
        }

        public T getValue(){
            return this.value;
        }

    }


}
