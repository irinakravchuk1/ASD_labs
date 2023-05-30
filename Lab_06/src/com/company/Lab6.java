package com.company;
import java.util.Scanner;

class Stack {
    private Node first = null;
    private class Node {
        int element;
        Node next;
    }
    public void push(int el) {
        Node oldfirst = first;
        first = new Node();
        first.element = el;
        first.next = oldfirst;
    }
    public void pop() {
        if (first != null) {
            first = first.next;
        }
    }
    public void print(){
        if (first != null) {
            Node copy = first;
            while (copy != null) {
                System.out.print(copy.element + "  ");
                copy = copy.next;
            }
            System.out.println();
        }
    }
    public int findSum(){
        int sum = 0;
        if (first != null) {
            Node copy = first;
            while (copy != null) {
                if (copy.element > 0)
                    sum += copy.element;
                copy = copy.next;
            }
        }
        return sum;
    }
}

public class Lab6 {
    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push(-5);
        stack.push(3);
        stack.push(-4);
        stack.push(5);
        stack.print();
        stack.pop();
        stack.push(10);
        stack.print();
        System.out.println("Sum = " + stack.findSum());
    }
}
