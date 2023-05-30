package com.company;
import java.util.Scanner;

class Array{
    private int[] arr;
    private Scanner scan = new Scanner(System.in);

    public Array(int size){
        arr = new int[size];
    }

    public void print(){
        for (int i = 0; i < arr.length; i++){
            System.out.println(i + 1 + ": " + arr[i]);
        }
    }

    public void fillManual(){
        for (int i = 0; i < arr.length; i++){
            System.out.print("Enter " + (i + 1) + " element: ");
            arr[i] = scan.nextInt();
        }
    }

    public void fillRandom(){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 6);
        }
    }

    public int getValue(int i){
        return arr[i];
    }

    public boolean findPos(int value, int position){
        for (int i = 0; i < arr.length; i++){
            if (i != position){
                if (arr[i] == value)
                    return true;
            }
        }
        return false;
    }

    public boolean find(int value, Array additional){
        for (int i = 0; i < arr.length; i++){
            if (value == additional.getValue(i))
                return true;
        }
        return false;
    }
}
public class Lab8 {
    public static void main(String[] args){
        int size;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size: ");
        size = scan.nextInt();
        Array arr1 = new Array(size);
        Array arr2 = new Array(size);
        arr1.fillManual();
        arr2.fillRandom();
        System.out.println("Array 1: ");
        arr1.print();
        System.out.println("Array 2: ");
        arr2.print();
        System.out.println("Array 1: ");
        for (int i = 0; i < size; i++){
            if (!arr1.findPos(arr1.getValue(i), i) && !arr1.find(arr1.getValue(i), arr2))
                System.out.println((i + 1) + " element: " + arr1.getValue(i));
        }
        System.out.println("Array 2: ");
        for (int i = 0; i < size; i++){
            if (!arr2.findPos(arr2.getValue(i), i) && !arr2.find(arr2.getValue(i), arr1))
                System.out.println((i + 1) + " element: " + arr2.getValue(i));
        }
    }
}
