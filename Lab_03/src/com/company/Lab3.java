package com.company;
import java.util.Scanner;

class NOTE{
    private String TEL, NAME;
    private int BDAY[] = new int[3];
    private Scanner scan = new Scanner(System.in);
    public NOTE(){
        System.out.print("Enter surname and name: ");
        NAME = scan.nextLine();
        System.out.print("Enter telephone number: ");
        TEL = scan.nextLine();
        System.out.println("Enter date of birth: ");
        for (int i = 0; i < 3; i++)
            BDAY[i] = scan.nextInt();
    }
    public void showAll(){
        System.out.println("Surname, name: " + NAME + "\nTelephone number: " + TEL +
                "\nBirthday: " + BDAY[0] + "." + BDAY[1] + "." + BDAY[2]);
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
    public void swap(NOTE a){
        String TEL = this.TEL, NAME = this.NAME;
        int BDAY[] = new int[3];
        for (int i = 0; i < 3; i++)
            BDAY[i] = this.BDAY[i];
        this.NAME = a.NAME;
        this.TEL = a.TEL;
        for (int i = 0; i < 3; i++)
            this.BDAY[i] = a.BDAY[i];
        a.NAME = NAME;
        a.TEL = TEL;
        for (int i = 0; i < 3; i++)
        a.BDAY[i] = BDAY[i];
    }
}

public class Lab3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice, month, N = 0;
        boolean value = false;
        NOTE BLOCKNOTE[] = new NOTE[N];
        do {
            System.out.println("Enter \"0\" to close the application\n" +
                    "Enter \"1\" to create or change array\n" +
                    "Enter \"2\" to sort records by ascending date of birth\n" +
                    "Enter \"3\" to display information about people born in a month\n" +
                    "Enter \"4\" to display all information");
            choice = scan.nextInt();
            switch (choice){
                case 0:
                    break;
                case 1:
                    System.out.print("Enter size: ");
                    N = scan.nextInt();
                    BLOCKNOTE = new NOTE[N];
                    for (int i = 0; i < N; i++) {
                        System.out.println(i + 1 + " element: ");
                        BLOCKNOTE[i] = new NOTE();
                    }
                    value = true;
                    break;
                case 2:
                    if (value){
                        for (int i = 0; i < N; i++) {
                            int min = BLOCKNOTE[i].getDay();
                            int position = i;
                            for (int j = i + 1; j < N; j++){
                                if (BLOCKNOTE[j].getDay() < min) {
                                    min = BLOCKNOTE[j].getDay();
                                    position = j;
                                }
                            }
                            BLOCKNOTE[i].swap(BLOCKNOTE[position]);
                        }

                        for (int i = 0; i < N; i++) {
                            int min = BLOCKNOTE[i].getMonth();
                            int position = i;
                            for (int j = i + 1; j < N; j++){
                                if (BLOCKNOTE[j].getMonth() < min) {
                                    min = BLOCKNOTE[j].getMonth();
                                    position = j;
                                }
                            }
                            BLOCKNOTE[i].swap(BLOCKNOTE[position]);
                        }

                        for (int i = 0; i < N; i++) {
                            int min = BLOCKNOTE[i].getYear();
                            int position = i;
                            for (int j = i + 1; j < N; j++){
                                if (BLOCKNOTE[j].getYear() < min) {
                                    min = BLOCKNOTE[j].getYear();
                                    position = j;
                                }
                            }
                            BLOCKNOTE[i].swap(BLOCKNOTE[position]);
                        }
                    } else
                        System.out.println("You have not created an array!");
                    break;
                case 3:
                    if (value) {
                        System.out.print("Enter month: ");
                        month = scan.nextInt();
                        for (int i = 0; i < N; i++) {
                            if (month == BLOCKNOTE[i].getMonth()) {
                                BLOCKNOTE[i].showAll();
                                value = false;
                            }
                        }
                        if (value) {
                            System.out.println("There are no people with such month of birth");
                        }
                        value = true;
                    } else
                        System.out.println("You have not created an array!");
                    break;
                case 4:
                    if (value) {
                        for (int i = 0; i < N; i++) {
                            System.out.println(i + 1 + " element: ");
                            BLOCKNOTE[i].showAll();
                        }
                    } else
                        System.out.println("You have not created an array!");
                    break;
                default:
                    System.out.println("Enter the correct value!");
                    break;
            }
        } while (choice != 0);
    }
}
