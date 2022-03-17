package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Admin bob = new Admin("bob" , "bob123");
        Database.AdminList.add(bob);
        Scanner sc = new Scanner(System.in);
        int s1 = 0;
        while (s1 != 3) {
            System.out.println("Welcome " + '\n' + "press 1 if you want to Sign Up." + '\n' + "press 2 if you want to Log In.");
            System.out.println("press 3 if you want to exit");
            s1 = sc.nextInt();
            switch (s1) {
                case 1:
                    System.out.println("press 1 if you want to Sign Up as client." + '\n' + "press 2 if you want to Sign Up as driver."+'\n'+"press 3 if you want to Exit.");
                    int ss = sc.nextInt();
                    switch (ss) {
                        case 1:
                            System.out.println("Enter username");
                            String username = sc.next();
                            System.out.println("Enter your email");
                            String email = sc.next();
                            System.out.println("Enter your password");
                            String password = sc.next();
                            System.out.println("Enter your mobile number");
                            String mobile = sc.next();

                            Client c = new Client(username, email, password, mobile);
                            if (c.Register()) {
                                System.out.println("Registration Successful");
                            } else {
                                System.out.println("this account is suspended");
                            }
                            break;

                        case 2:
                            System.out.println("Enter username");
                            String usernamee = sc.next();
                            System.out.println("Enter your email");
                            String emaill = sc.next();
                            System.out.println("Enter your password");
                            String passwordd = sc.next();
                            System.out.println("Enter your mobile number");
                            String mobilee = sc.next();
                            System.out.println("Enter your national ID");
                            String nID = sc.next();
                            System.out.println("Enter your driving license");
                            String drlicense = sc.next();
                            Driver driver = new Driver(usernamee, emaill, passwordd, mobilee, nID, drlicense);
                            if (driver.Register()) {
                                System.out.println("Registration Successful,we wait verify from Admin  ");
                            } else {
                                System.out.println("this account is suspended");
                            }
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1- Login as Client");
                    System.out.println("2- Login as Driver");
                    System.out.println("3- Login as Admin");
                    System.out.println("4- Exit");
                    int m = sc.nextInt();
                    switch (m) {
                        case 1:

                            System.out.println("Enter your email");
                            String email2 = sc.next();
                            System.out.println("Enter your password");
                            String password2 = sc.next();
                            Client c = new Client(email2, password2);
                            if (c.logIn() == 1) {
                                System.out.println("Suspended Account");
                            } else if (c.logIn() == 2) {
                                for(Client clie : Database.ClientList)
                                {
                                    if(c.getEmail().equalsIgnoreCase(clie.getEmail()))
                                        clie.clientInterface();
                                }

                            } else {
                                System.out.println("You must register first !");
                            }
                            break;
                        case 2:
                            System.out.println("Enter your email");
                            String email1 = sc.next();
                            System.out.println("Enter your password");
                            String password1 = sc.next();
                            Driver d = new Driver(email1, password1);
                            switch (d.logIn()) {
                                case 1 ->
                                        System.out.println("Suspended Account");
                                case 2 ->
                                        {
                                            for(Driver driv : Database.DriverList)
                                            {
                                                if(d.getEmail().equalsIgnoreCase(driv.getEmail()))
                                                    driv.DriverInterface();
                                            }

                                        }
                                default ->
                                        System.out.println("You must register first !");
                            }
                            break;

                        case 3:
                            System.out.println("Enter your email");
                            String email = sc.next();
                            System.out.println("Enter your password");
                            String password = sc.next();
                            Admin a = new Admin(email, password);
                            if (a.logIn() == 2) {
                                int in = 0;
                                while (in != 3) {
                                    System.out.println("1- show all pending drivers");
                                    System.out.println("2- suspend any driver");
                                    System.out.println("3- exit");
                                    in = sc.nextInt();
                                    if (in == 1) {
                                        a.viweListRegDriver();
                                    } else if (in == 2) {
                                        System.out.println("enter the id of email you want to suspend");
                                        int id = sc.nextInt(in);
                                        a.suspend(id);
                                    }
                                }
                            }
                            break;
                        case 4:
                            break;
                    }
            }
        }
    }
}