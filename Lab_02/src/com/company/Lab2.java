package com.company;
import java.util.Scanner;

class Task1{
    Scanner scan = new Scanner(System.in);
    private int size, sum1, sum2;
    void start(){
        sum1 = 0;
        sum2 = 0;
        System.out.print("Enter size: ");
        size = scan.nextInt();
        int arr[] = new int [size];
        for (int i = 0; i < size; i++){
            arr[i] = (int) (Math.random() * (101 + 100)) - 100;
            System.out.print(arr[i] + "  ");
            if (i % 2 != 0)
                sum1 += Math.abs(arr[i]);
            if (i % 2 == 0 && i != 0 && i < (size - 1))
                sum2 += arr[i];
        }
        System.out.println("\nThe sum of modules of elements with odd indexes: " + sum1);
        System.out.println("The sum of the modulo elements that are located between the specified elements: " + Math.abs(sum2) + "\n");
    }
}

class Task2 {
    Scanner scan = new Scanner(System.in);
    private int size;
    void start() {
        System.out.print("Enter size: ");
        size = scan.nextInt();
        int arr[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = (int) (Math.random() * (101 + 100)) - 100;
                if ((i+j) % 2 != 0)
                    arr[i][j] = 0;
                System.out.print(arr[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Task3{
    Scanner scan = new Scanner(System.in);
    private int height, width, x, y, n;
    void start(){
        n = 1;
        System.out.print("Enter height: ");
        height = scan.nextInt();
        System.out.print("Enter width: ");
        width = scan.nextInt();
        int arr[][] = new int[height][width];
        for (int i = 0; i < height; i++) {
            arr[i][0] = n;
            n++;
        }
        for (int i = 1; i < width; i++) {
            arr[height - 1][i] = n;
            n++;
        }
        for (int i = height - 2; i >= 0; i--) {
            arr[i][width - 1] = n;
            n++;
        }
        for (int i = width - 2; i >= 1; i--) {
            arr[0][i] = n;
            n++;
        }
        x = 1;
        y = 1;
        while (n < height * width) {
            while (arr[y + 1][x] == 0) {
                arr[y][x] = n;
                n++;
                y++;
            }
            while (arr[y][x + 1] == 0) {
                arr[y][x] = n;
                n++;
                x++;
            }
            while (arr[y - 1][x] == 0) {
                arr[y][x] = n;
                n++;
                y--;
            }
            while (arr[y][x - 1] == 0) {
                arr[y][x] = n;
                n++;
                x--;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = n;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                System.out.print(arr[i][j] + "\t\t");
            System.out.println();
        }
        System.out.println();
    }
}

class Task4{
    Scanner scan = new Scanner(System.in);
    private int size;
    void start(){
        System.out.print("Enter size: ");
        size = scan.nextInt();
        int arr[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i + j < size - 1)
                    arr[i][j] = 0;
                else if (i + j > size - 1)
                    arr[i][j] = 1;
                else
                    arr[i][j] = 10;
                System.out.print(arr[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class Lab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Task4 task4 = new Task4();
        do {
            System.out.println("Enter \"0\" to close the application\n" +
                    "Enter \"1\" to complete the first task\n" +
                    "Enter \"2\" to complete the second task\n" +
                    "Enter \"3\" to complete the third task\n" +
                    "Enter \"4\" to complete the fourth task");
            choice = scan.nextInt();
            switch (choice){
                case 0:
                    break;
                case 1:
                    task1.start();
                    break;
                case 2:
                    task2.start();
                    break;
                case 3:
                    task3.start();
                    break;
                case 4:
                    task4.start();
                    break;
                default:
                    System.out.println("Enter the correct value!");
                    break;
            }
        } while (choice != 0);
    }
}