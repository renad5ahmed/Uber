
package com.company;

import java.util.Scanner;
/**
 * @Class Client
 */
public class Client extends User implements SignUp {
    private Request request=new Request();

    /**
     * CLient's constructor that takes all data
     * @param userName Client's  username
     * @param email Client's email
     * @param password Client's password
     * @param mobileNumber Client's mobile number
     */
    public Client(String userName, String email, String password, String mobileNumber) {
        super(userName, email, password, mobileNumber);
    }

    /**
     * Client's constructor to take username and password for log in
     * @param email Client's email
     * @param password Client's password
     */
    public Client(String email, String password) {
        super(email, password);
    }

    /**
     * Client uses requestRide function to request a new ride
     * @param source source area for the requested ride
     * @param destination destination area for the requested ride
     */

    public void requestRide(String source, String destination) {
        Area src = new Area(source);
        Area dest = new Area(destination);
        request = new Request(src, dest, this);
    }

    /**
     * Client uses rateDriver method to rate the Ride's Driver
     * @param d ride's Driver
     * @param rate the rate that the user will set it to the Driver
     */
    public void rateDriver(Driver d, double rate) {
        d.rate.addRate(rate);
        d.rate.setRate(rate);
    }

    /**
     * This is Function Registration To Register Client
     * @return true: if Registration is successful
     *         false: if this Client is suspended
     */
    public Boolean Register() {
        boolean check = false;
        for (int i = 0; i < d.getSuspUser().size(); i++) {
            if (d.getSuspUser().get(i) == this.email) {
                check = true;
            }
        }
        if (!check) {
            d.getClientList().add((Client) this);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This is Function To LogIn Client
     * @return 1: if this client is suspended
     *         2: if this client login successful
     *         3: if this client not registered
     */
    public int logIn() {
        boolean check = true;
        for (int i = 0; i < d.getSuspUser().size(); i++) {
            if (d.getSuspUser().get(i) == this.email) {
                check = false;
            }
        }
        boolean flag = false;
        for (int i = 0; i < d.getClientList().size(); i++) {
            if (this.email.equals(d.getClientList().get(i).email) && this.password.equals(d.getClientList().get(i).password))
                flag = true;
        }
        if (check == false && flag == false) {
            return 1;
        } else if (check == true && flag == true) {
            return 2;
        } else {
            return 3;
        }
    }

    /**
     *This Function to Get list of Request's Offers
     * @throws NullPointerException if there is no offer list
     */
    public void ViewOffer() throws NullPointerException {
        if(request.listOffer.size()>=1){
            Scanner sc = new Scanner(System.in);

            for (int i = 0; i < request.listOffer.size(); i++) {
                System.out.println("Number of offer: " + (i + 1));
                System.out.println(request.listOffer.get(i));
            }
            System.out.println("Enter Number of Offer to accept");
            int n = sc.nextInt();
            request.listOffer.get(n - 1).accept = true;
            System.out.println("Do you want to set Rate ?(Yes/No)");
            String s = sc.next();
            if (s.equalsIgnoreCase("Yes")) {
                System.out.println("Enter the rate");
                double rate = sc.nextDouble();
                this.rateDriver(request.listOffer.get(n - 1).driver, rate);
            }
            request.listOffer.clear();
        }
        else{
            System.out.println("No Offer now :(");
        }
    }

    /**
     * This Function to makes Client to rate Drivers
     * @throws IndexOutOfBoundsException if the client chooses the id greater than list of the driver
     */
    public void rateAnyDriver() throws IndexOutOfBoundsException {
        try {
            Database d = new Database();
            for (int i = 0; i < d.getDriverList().size(); i++) {
                System.out.println("Driver " + (i + 1));
                System.out.println(d.getDriverList().get(i));
            }
            System.out.println(d.getDriverList().size());
            if (d.getDriverList().size() == 0) {
                System.out.println("No drivers available");
                return;
            } else {
                System.out.println("Do you want to rate any Driver ?(yes/no)");
                Scanner sc = new Scanner(System.in);
                String s = sc.next();
                if ("yes".equalsIgnoreCase(s)) {
                    System.out.println("Choose the Driver number.");
                    int id = sc.nextInt();
                    System.out.println("Enter the rate");
                    double r = sc.nextDouble();
                    this.rateDriver(d.getDriverList().get(id - 1), r);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No drivers available");
        }

    }

    /**
     * This is Client InterFace
     */
    public void clientInterface() {
        while (true) {
            System.out.println("Client's List");
            System.out.println("press 1 to request new ride.");
            System.out.println("press 2 to list all offers.");
            System.out.println("press 3 to rate Drivers.");
            System.out.println("press 4 to exit");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            switch (x) {
                case 1 -> {
                    System.out.println("Enter the source.");
                    String src = sc.next();
                    System.out.println("Enter the destination");
                    String dest = sc.next();
                    this.requestRide(src, dest);
                }
                case 2 -> this.ViewOffer();
                case 3 -> this.rateAnyDriver();
                case 4 -> {
                    break;
                }

            }
            if (x == 4)
                break;
        }
    }

    /**
     *This is Function to Get all Client's Data
     * @return client's data
     */
    @Override
    public String toString() {
        return "Client:" + '\n' +
                "   userName=" + userName + '\n' +
                "   email=" + email + '\n' +
                "   mobileNumber=" + mobileNumber + '\n' +
                "   ID=" + ID + '\n' +
                '}' + '\n';
    }

}