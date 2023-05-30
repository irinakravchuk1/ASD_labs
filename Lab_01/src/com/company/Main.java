package com.company;
import java.util.Scanner;

class Task1 {
    double V = -1, U = -1, T1 = -1, T2 = -1, S;
    Scanner scan = new Scanner(System.in);
    void start(){
        while (V <= 0) {
            System.out.print("Enter the speed of the boat in standing water (V, V > 0, km/h): ");
            V = scan.nextDouble();
        }
        while (U >= V || U <= 0) {
            System.out.print("Enter the speed of the river (U, U < V, km/h): ");
            U = scan.nextDouble();
        }
        while (T1 <= 0) {
            System.out.print("Enter the time of the boat on the lake (T1, T1 > 0, hours): ");
            T1 = scan.nextDouble();
        }
        while (T2 <= 0) {
            System.out.print("Enter the time of the boat on the river (T2, T2 > 0, hours): ");
            T2 = scan.nextDouble();
        }
        S = V * T1 + (V - U) * T2;
        System.out.println("The path that the boat will take (km): " + S + "\n");
    }
}

class Task2 {
    double x;
    Scanner scan = new Scanner(System.in);
    double countY(double x) {
        return (Math.pow((x + 1), 2) + 2 * (x + 1)) / 4;
    }
    void start() {
        System.out.print("Enter x: ");
        x = scan.nextDouble();
        System.out.println("y = " + countY(x) + "\n");
    }
}

class Task3 {
    Scanner scan = new Scanner(System.in);
    class Chessboard {
        int x = 0, y = 0;
        void setCoordinates(){
            while (x <= 0 || x > 8) {
                System.out.print("Enter x (1-8): ");
                x = scan.nextInt();
            }
            while (y <= 0 || y > 8) {
                System.out.print("Enter y (1-8): ");
                y = scan.nextInt();
            }
        }
    }
    void start() {
        Chessboard one = new Chessboard(), two = new Chessboard();
        System.out.println("First field");
        one.setCoordinates();
        System.out.println("Second field");
        two.setCoordinates();
        if (one.x == two.x && one.y == two.y)
            System.out.println("The coordinates are the same.\n");
        else
        if (one.x - one.y == two.x - two.y || one.x + one.y == two.x + two.y || one.x == two.x || one.y == two.y)
            System.out.println(true + "\n");
        else
            System.out.println(false + "\n");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        while (choice != 0) {
            System.out.println("Enter \"0\" to close the application\n" +
                    "Enter \"1\" to complete the first task\n" +
                    "Enter \"2\" to complete the second task\n" +
                    "Enter \"3\" to complete the third task");
            choice = scan.nextInt();
            switch (choice) {
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
                default:
                    System.out.println("Enter the correct value!");
            }
        }
    }
}