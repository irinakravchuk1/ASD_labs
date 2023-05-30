package com.company;
import java.util.LinkedList;
import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> listMain = new LinkedList<Integer>();
        System.out.println("Enter elements of the list(\"*\" to stop):");
        while(scan.hasNextInt()){
            listMain.add(scan.nextInt());
        }
        scan.nextLine();
        scan.nextLine();
        if (listMain.size() % 2 != 0){
            System.out.println("Enter one more element of the list:");
            listMain.add(scan.nextInt());
        }
        System.out.println("Your list:");
        for (int element : listMain){
            System.out.println(element);
        }
        LinkedList<Integer> listA = new LinkedList<Integer>(), listB = new LinkedList<Integer>();
        for (int i = 0; i < listMain.size(); i++){
            if (i < listMain.size()/2){
                listA.add(listMain.get(i));
            } else {
                listB.add(listMain.get(i));
            }
        }
        System.out.println("Your listA:");
        for (int element : listA){
            System.out.println(element);
        }
        System.out.println("Your listB:");
        for (int element : listB){
            System.out.println(element);
        }
        System.out.println("PA: " + listMain.get(listMain.size() / 2 - 1));
        System.out.println("PB: " + listMain.get(listMain.size() / 2));
    }
}