package com.company;
import java.util.Scanner;

class Array {
    private int[] arr;
    private Scanner scan = new Scanner(System.in);

    public Array(int size) {
        arr = new int[size];
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ": " + arr[i]);
        }
    }

    public void fillManual() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter " + (i + 1) + " element: ");
            arr[i] = scan.nextInt();
        }
    }

    public void fillRandom() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 11);
        }
    }

    public void sort(){
        int iterations = 0;
        for(int i = arr.length - 1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    iterations++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ": " + arr[i]);
        }
        System.out.println("Iterations amount: " + iterations);
    }

    public void sortSteps(){
        for(int i = arr.length - 1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    System.out.println(arr[j] + " <---> " + arr[j + 1]);
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ": " + arr[i]);
        }
    }
}

public class Lab9 {
    public static void main(String[] args) {
        int size, choice;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size: ");
        size = scan.nextInt();
        Array arr = new Array(size);
        System.out.println("Enter \"1\" to fill array randomly\n" +
                "Enter \"2\" to fill array manually");
        choice = scan.nextInt();
        switch (choice) {
            case 1:
                arr.fillRandom();
                break;
            case 2:
                arr.fillManual();
                break;
            default:
                System.out.println("Enter the correct value!");
        }
        arr.print();
        System.out.println("Enter \"1\" to print sorted array with iterations amount\n" +
                "Enter \"2\" to print sorted array with every step");
        choice = scan.nextInt();
        switch (choice) {
            case 1:
                arr.sort();
                break;
            case 2:
                arr.sortSteps();
                break;
            default:
                System.out.println("Enter the correct value!");
        }
    }
}
