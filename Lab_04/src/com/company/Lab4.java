package com.company;
import java.util.ArrayList;
import java.util.Scanner;

class NOTE {
    private String TEL, NAME;
    private int BDAY[] = new int[3];
    private Scanner scan = new Scanner(System.in);
    public void fill(){
        System.out.println("Enter surname and name: ");
        NAME = scan.nextLine();
        if (NAME == "")
            NAME = scan.nextLine();
        System.out.print("Enter telephone number: ");
        TEL = scan.nextLine();
        if (TEL == "")
            TEL = scan.nextLine();
        System.out.println("Enter date of birth: ");
        for (int i = 0; i < 3; i++)
            BDAY[i] = scan.nextInt();
    }
    public void showAll(){
        System.out.println("Surname, name: " + NAME + "\nTelephone number: " + TEL +
                "\nBirthday: " + BDAY[0] + "." + BDAY[1] + "." + BDAY[2]);
    }
    public String getTel(){
        return TEL;
    }
    public String getName(){
        return NAME;
    }
    public int getDay(){
        return BDAY[0];
    }
    public int getMonth(){
        return BDAY[1];
    }
    public int getYear(){
        return BDAY[2];
    }
    public void setTel(NOTE el){
        this.TEL = el.TEL;
    }
    public void setName(NOTE el){
        this.NAME = el.NAME;
    }
    public void setDay(NOTE el){
        this.BDAY[0] = el.BDAY[0];
    }
    public void setMonth(NOTE el){
        this.BDAY[1] = el.BDAY[1];
    }
    public void setYear(NOTE el){
        this.BDAY[2] = el.BDAY[2];
    }
}

class ListElement {
    ListElement next;
    NOTE element = new NOTE();
    ListElement(NOTE data){
        element.setDay(data);
        element.setTel(data);
        element.setName(data);
        element.setMonth(data);
        element.setYear(data);
    }
    void print(){
        element.showAll();
    }
    public boolean checkTel(String el){
        return el.equals(element.getTel());
    }
    public boolean checkName(String el){
        return el.equals(element.getTel());
    }
    public boolean checkDate(int el[]){
        return element.getDay() == el[0] && element.getMonth() == el[1] && element.getYear() == el[2];
    }
}

class LinkedList {
    ListElement head;
    public LinkedList insertInTheEnd(LinkedList list, NOTE data) {
        ListElement newData = new ListElement(data);
        newData.next = null;
        if (list.head == null) {
            list.head = newData;
        } else {
            ListElement last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newData;
        }
        return list;
    }
    public void printList(LinkedList list) {
        ListElement currEl = list.head;
        int i = 1;
        System.out.println("LinkedList: ");
        while (currEl != null) {
            System.out.println(i + " element:");
            i++;
            currEl.print();
            currEl = currEl.next;
        }
        System.out.println();
    }
    public void delEl(int position) {
        if(head == null)
            return;
        if (head.next == null) {
            head = null;
            return;
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        int curPos = 1;
        ListElement current = head;
        while (current.next != null) {
            if (curPos + 1 == position) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
            curPos++;
        }
    }
    public void searchName(String name){
        ListElement current = head;
        while (current != null) {
            if (current.checkName(name)) {
                current.print();
            }
            current = current.next;
        }
    }
    public void searchTel(String tel){
        ListElement current = head;
        while (current != null) {
            if (current.checkTel(tel)) {
                current.print();
            }
            current = current.next;
        }
    }
    public void searchDate(int date[]){
        ListElement current = head;
        while (current != null) {
            if (current.checkDate(date)) {
                current.print();
            }
            current = current.next;
        }
    }
}

public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choiceTask;
        do {
            System.out.println("Enter \"0\" to close the application\n" +
                    "Enter \"1\" to complete task 1\n" +
                    "Enter \"2\" to complete task 2");
            choiceTask = scan.nextInt();
            switch (choiceTask){
                case 1:
                    int choice;
                    NOTE el = new NOTE();
                    LinkedList list = new LinkedList();
                    do {
                        System.out.println("Enter \"0\" to close the application\n" +
                                "Enter \"1\" to add element(-s) to list\n" +
                                "Enter \"2\" to delete element from the list\n" +
                                "Enter \"3\" to add element to the end of the list\n" +
                                "Enter \"4\" to search by a field\n" +
                                "Enter \"5\" to print the list");
                        choice = scan.nextInt();
                        switch (choice) {
                            case 0:
                                break;
                            case 1:
                                String text;
                                System.out.print("Enter amount of elements: ");
                                int amount = scan.nextInt();
                                for (int i = 0; i < amount; i++){
                                    System.out.println(i + 1 + ":");
                                    el.fill();
                                    list = list.insertInTheEnd(list, el);
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.print("Enter position: ");
                                list.delEl(scan.nextInt());
                                System.out.println();
                                break;
                            case 3:
                                el.fill();
                                list.insertInTheEnd(list, el);
                                System.out.println();
                                break;
                            case 4:
                                System.out.print("Enter number of a field: ");
                                int field = scan.nextInt();
                                switch(field) {
                                    case 1:
                                        System.out.print("Enter name: ");
                                        String name = scan.nextLine();
                                        if (name == "")
                                            name = scan.nextLine();
                                        list.searchName(name);
                                        break;
                                    case 2:
                                        System.out.print("Enter telephone number: ");
                                        String tel = scan.nextLine();
                                        if (tel == "")
                                            tel = scan.nextLine();
                                        list.searchTel(tel);
                                        break;
                                    case 3:
                                        System.out.print("Enter date of birth: ");
                                        int date[] = new int[3];
                                        for (int i = 0; i < 3; i++)
                                            date[i] = scan.nextInt();
                                        list.searchDate(date);
                                        break;
                                    default:
                                        System.out.println("Enter the correct value!");
                                        break;
                                }
                                System.out.println();
                                break;
                            case 5:
                                list.printList(list);
                                break;
                            default:
                                System.out.println("Enter the correct value!");
                                break;
                        }
                    } while (choice != 0);
                    break;
                case 2:
                    String value;
                    int firstAmount = 0, secondAmount = 0;
                    ArrayList<String> platoon1 = new ArrayList<String>();
                    ArrayList<String> platoon2 = new ArrayList<String>();
                    System.out.println("First platoon(Enter \"*\" to stop): ");
                    while (true) {
                        value = scan.nextLine();
                        if (value.equals(""))
                            value = scan.nextLine();
                        if (value.equals("*"))
                            break;
                        platoon1.add(value);
                        firstAmount++;
                    }
                    System.out.println("Second platoon(Enter \"*\" to stop): ");
                    while (true) {
                        value = scan.nextLine();
                        if (value.equals(""))
                            value = scan.nextLine();
                        if (value.equals("*"))
                            break;
                        platoon2.add(value);
                        secondAmount++;
                    }
                    System.out.println("First platoon:");
                    for (int i = 0; i < firstAmount; i ++){
                        System.out.println(i + 1 + ": " + platoon1.get(i));
                    }
                    System.out.println("Second platoon:");
                    for (int i = 0; i < secondAmount; i ++){
                        System.out.println(i + 1 + ": " + platoon2.get(i));
                    }
                    int M;
                    System.out.print("Enter the amount of soldiers who died: ");
                    M = scan.nextInt();
                    for(int i = 0; i < M; i++){
                        platoon1.remove(firstAmount - i - 1);
                    }
                    for(int i = 0; i < M; i++){
                        platoon1.add(platoon2.get(i));
                    }
                    for(int i = 0; i < M; i++){
                        platoon2.remove(0);
                    }
                    secondAmount -= M;

                    System.out.println("First platoon:");
                    for (int i = 0; i < firstAmount; i ++){
                        System.out.println(i + 1 + ": " + platoon1.get(i));
                    }
                    System.out.println("Second platoon:");
                    for (int i = 0; i < secondAmount; i ++){
                        System.out.println(i + 1 + ": " + platoon2.get(i));
                    }
                    break;
                default:
                    System.out.println("Enter the correct value!");
                    break;
            }
        } while (choiceTask != 0);
    }
}