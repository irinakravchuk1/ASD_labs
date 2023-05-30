package com.company;

class Matrix{
    private int[][] matrix;
    private int width, height, min = 10, sum;
    public Matrix (int height, int width){
        matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = (int) (Math.random() * 11);
            }
        }
        this.height = height;
        this.width = width;
    }

    public void print(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void findMin(){
        for (int i = 0; i < height; i++) {
            if (matrix[i][width - 1] < min)
                min = matrix[i][width - 1];
        }
        System.out.println("Minimal: " + min);
    }

    public void findSum(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println("Sum: " + sum);
    }
}

public class Lab12 {
    public static void main(String[] args) {
        Matrix first = new Matrix(4, 5);
        Matrix second = new Matrix(5, 8);
        System.out.println("First matrix:");
        first.print();
        first.findMin();
        first.findSum();
        System.out.println("\nSecond matrix:");
        second.print();
        second.findMin();
        second.findSum();
    }
}
