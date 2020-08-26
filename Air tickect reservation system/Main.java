package com.company;
import java.util.*;
import java.io.*;
public class Main
{
    static Scanner in = new Scanner(System.in);
    static Login acc = new Login();
    static userDetail a =new userDetail();
    static admin  adminUser= new admin();
    public static void main(String args[]) throws IOException {
        int choice;
        try{
        do {
            System.out.println("WELCOME TO AIRLINE RESERVATION SYSTEM");
            System.out.println("\n\t1. ADMIN MODE\n\t2. USER MODE\n\t3. EXIT\n\tEnter your choice...\t");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    userLogin();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid input\n");
                    break;
            }
        } while (true);
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Input !! please enter again!");
            in.nextLine();
            main(null);
        }
    }
    static void userLogin() throws IOException {
        int choice;
        int flag = 1;
        do
        {
            try {
                System.out.println("\n\t1. SIGN IN\n\t2. SIGN UP\n\t3.CHANGE PASSWORD\n\t4. RETURN TO MAIN MENU\n\tEnter your choice...");
                choice = in.nextInt();
                switch (choice) {
                    case 1: {
                        boolean b = acc.getidSignIn();
                        if (b == true) {
                            System.out.println("Welcome " +acc.id+"  🙂");
                            user();
                        } else {
                            System.out.println("\nInvalid username or password!");
                            System.out.println("\nDo you want to sign in again?\n\'y\' or \'n\'...");
                            char c = in.next().charAt(0);
                            switch (c) {
                                case 'y':
                                case 'Y':
                                    flag = 0;
                                    break;
                                case 'n':
                                case 'N':
                                    main(null);
                                    break;
                                default:
                                    System.out.println("Invalid Entry! Enter again");
                                    userLogin();
                            }
                        }
                        break;
                    }
                    case 2: {
                        acc.getidSignUp();
                        user();
                        break;
                    }
                    case 3:
                        acc.changePassword();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid input\n");
                        flag = 0;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input !! please enter again!");
                in.nextLine();
                userLogin();
            }
        } while (flag == 0);
    }
    static void adminLogin() throws IOException {
        int choice;
        int flag = 1;
        do
        {
            try {
                System.out.println("\n\t1. SIGN IN\n\t2. CHANGE PASSWORD\n\t3. RETURN TO MAIN MENU\n\tEnter your choice...");
                choice = in.nextInt();
                switch (choice) {
                    case 1: {
                        boolean b = acc.getidSignIn();
                        if (b == true) {
                            System.out.println("Welcome " +acc.id+"  🙂");
                            admin();
                        } else {
                            System.out.println("\nInvalid username or password!");
                            System.out.println("\nDo you want to sign in again?\n\'y\' or \'n\'...");
                            char c = in.next().charAt(0);
                            switch (c) {
                                case 'y':
                                case 'Y':
                                    flag = 0;
                                    break;
                                case 'n':
                                case 'N':
                                    main(null);
                                    break;
                                default:
                                    System.out.println("Invalid Entry! Enter again");
                                    adminLogin();
                            }
                        }
                        break;
                    }
                    case 2:
                        acc.changePassword();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid input\n");
                        flag = 0;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid Input !! please enter digits!");
                in.nextLine();
                adminLogin();
            }
        } while (flag == 0);
    }

    static void user() throws IOException {
        do
        {
            System.out.println("USER MENU");
            System.out.println("\n\t1. RESERVE\n\t2. CANCEL\n\t3. ENQUIRY\n\t4. RETURN TO MAIN MENU\n\tEnter your choice...");
            int choice;
            choice = in.nextInt();
            switch(choice)
            {
                case 1:
                    a.reserve();
                    break;
                case 2:
                    a.cancel();
                    break;
                case 3:
                    a.enquiry();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid input\n");
            }
        } while (true);
    }
    static void admin()throws IOException
    {
        int choice,flag=1;
        do {
            try {
                flag = 1;
                System.out.println("\n\t1. ADD FLIGHT\n\t2. CANCEL FLIGHT\n\t3. CHECK STATUS\n\t4. RETURN TO MAIN MENU/LOGOUT" +
                        "\n\tEnter your choice...\n");
                choice = in.nextInt();
                switch (choice) {
                    case 1:
                        adminUser.addFlight();
                        break;
                    case 2:
                        adminUser.CancelFlight();
                        break;
                    case 3:
                        adminUser.checkStatus();
                        break;
                    case 4:
                        main(null);
                        break;
                    default:
                        System.out.println("Invalid Input ! Enter again.");
                        flag = 0;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid Input !! please enter again!");
                in.nextLine();
                admin();
            }
        }while(true);
    }
}

