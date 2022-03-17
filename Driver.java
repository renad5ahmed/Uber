
package com.company;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @class Driver
 */
public class Driver extends User {

    protected String driverLicense;
    protected boolean driverStatus;
    protected String nationalId;
    protected ArrayList<Area> favArea = new ArrayList<Area>();
    Rating rate = new Rating();
    protected ArrayList<Request> Reqs = new ArrayList<Request>();

    /**
     * Driver's constructor that takes all data
     * @param userName Driver's UserName
     * @param email Driver's email
     * @param password Driver's Password
     * @param mobileNumber Driver's MobileNumber
     * @param NationalId Driver's NationalId
     * @param DriverLicense Driver's DriverLicense
     */
    public Driver(String userName, String email, String password, String mobileNumber, String NationalId, String DriverLicense) {
        super(userName, email, password, mobileNumber);
        this.nationalId = NationalId;
        this.driverLicense = DriverLicense;
        this.driverStatus = false;
        RegistrationDriver r = new RegistrationDriver(this, false);
        d.regDriversList.add(r);

    }

    /**
     * Driver's constructor to take username and password for log in
     * @param email Driver's email
     * @param password Driver's Password
     */
    public Driver(String email, String password) {
        super(email, password);
    }

    /**
     * This function to add favorite Area For Driver
     * @param area ,Driver's favorite Area
     */
    public void addFavArea(Area area) {
        favArea.add(area);
    }

    /**
     * This function to Change Driver Status
     * @param c Driver's status True or False
     */
    public void changeDriverStatus(boolean c) {
        this.driverStatus = c;
        if (c) {
            d.DriverList.add(this);
            d.penDriver.remove(this);
        }
    }

    /**
     * This function to see every ride request that was requested in the driver's favorite areas
     */
    public void viewAllRides(){
        for (int i = 0; i < this.Reqs.size(); i++) {
            System.out.println(this.Reqs.get(i));
        }
    }

    /**
     *This function to notify Driver with every request that was requested in the driver's favorite areas
     */
    public void notification() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Reqs.size());
        for (int i = 0; i < Reqs.size(); i++) {
            System.out.println(Reqs.get(i));
        }
        while (Reqs.size() >= 1) {
            System.out.println("Please Enter Client ID and price,If You want to Make offer");
            int s = sc.nextInt();
            int p = sc.nextInt();
            DriverOffer(s, p);
            System.out.println("Do You want to Continue ? (Yes/No)");
            String st = sc.next();
            if (st.equalsIgnoreCase("yes")) {
                continue;
            } else if (st.equalsIgnoreCase("No")) {
                System.out.println("Thank You For Your Offer");
                break;
            } else {
                System.out.println("Wrong Input");
            }
        }
        if (Reqs.size() == 0) {
            System.out.println("This is Last Request Good Bye :)");
        }
    }

    /**
     * This is Driver InterFace
     */
    public void DriverInterface() {
        Scanner in = new Scanner(System.in);
        int input = 0;
        while (input != 4) {
            System.out.println("1- Add new Favourite area.");
            System.out.println("2- show ratings of your clients.");
            System.out.println("3- show all rides.");
            System.out.println("4- exit");
            input = in.nextInt();
            switch (input) {
                case 1 -> {
                    String ar;
                    System.out.println("Enter the name of area you want to add");
                    ar = in.next();
                    this.addFavArea(new Area(ar));
                }
                case 2 -> this.showRates();
                case 3 -> {
                    this.viewAllRides();
                    if(Reqs.size()>=1) {
                        System.out.println("Do you want to make Offer ? (Yes/No)");
                        String s = in.next();
                        System.out.println("Enter ID of Client and price of Your Offer respectively.");
                        int id = in.nextInt();
                        int pr = in.nextInt();
                        if (s.equalsIgnoreCase("yes")) {
                            for (int i = 0; i < Reqs.size(); i++) {
                                if (Reqs.get(i).client.ID == id) {
                                    Offer of = new Offer();
                                    of.makeOffer(pr, this);
                                    Reqs.get(i).listOffer.add(of);
                                    Reqs.remove(Reqs.get(i));
                                    break;
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("There is no Requests");
                        break;
                    }
                }
                case 4 -> {
                    break;
                }
            }
        }
    }

    /**
     * This function makes the driver make offer
     * @param id This is the ID of the customer who owns the ٌRequest
     * @param price This is Offer's Price
     */
    public void DriverOffer(int id, double price) {
        Offer off = new Offer();
        off.makeOffer(price, this);
        for (int i = 0; i < Reqs.size(); i++) {
            if (Reqs.get(i).client.ID == id) {
                Reqs.get(i).listOffer.add(off);
                Reqs.remove(Reqs.get(i));
            }
        }
    }

    /**
     * This function makes Driver Show all own ratings from Client
     */
    public void showRates() {
        this.rate.viewRatingsList();
    }

    /**
     * This is function Register
     * @return True if Registration Complete
     * @return False if Registration inComplete
     */
    public Boolean Register() {
        boolean check = false;
        for (int i = 0; i < d.SuspUser.size(); i++) {
            if (d.SuspUser.get(i) == this.email) {
                check = true;
            }
        }
        if (!check) {
            d.penDriver.add(this);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This function Login
     * @return True if LogIn Complete
     * @return False if LogIn inComplete
     */
    public int logIn() {
        boolean check = true;
        for (int i = 0; i < d.SuspUser.size(); i++) {
            if (d.SuspUser.get(i) == this.email) {
                check = false;
            }
        }
        boolean flag = false;
        for (int i = 0; i < d.DriverList.size(); i++) {
            if (this.email.equals(d.DriverList.get(i).email) && this.password.equals(d.DriverList.get(i).password)) {

                this.ID = d.DriverList.get(i).ID;
                this.Reqs = d.DriverList.get(i).Reqs;
                this.driverLicense = d.DriverList.get(i).driverLicense;
                this.driverStatus = d.DriverList.get(i).driverStatus;
                this.email = d.DriverList.get(i).email;
                this.favArea = d.DriverList.get(i).favArea;
                this.mobileNumber = d.DriverList.get(i).mobileNumber;
                this.nationalId = d.DriverList.get(i).nationalId;
                this.password = d.DriverList.get(i).password;
                this.rate = d.DriverList.get(i).rate;
                this.userName = d.DriverList.get(i).userName;
                flag = true;
            }
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
     * This function to Display all Driver's Data
     * @return Driver's Data
     */
    @Override
    public String toString() {
        return "Driver:" + '\n'
                + "   userName=" + userName + '\n'
                + "   email=" + email + '\n'
                + "   mobileNumber=" + mobileNumber + '\n'
                + "   ID=" + ID + '\n'
                + "   driverLicense=" + driverLicense + '\n'
                + "   driverStatus=" + driverStatus + '\n'
                + "   nationalId=" + nationalId + '\n'
                + "   favArea=" + favArea + '\n'
                + "   AvgRate=" + rate.getAvgRate() + '\n'
                + '}' + '\n';
    }

    /**
     * This function to set DriverLicense
     * @param driverLicense This is DriverLicense
     */
    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    /**
     * This function to set Driver Status
     * @param driverStatus Driver's Status
     */
    public void setDriverStatus(boolean driverStatus) {
        this.driverStatus = driverStatus;
    }

    /**
     * This Function to set Driver National ID
     * @param nationalId Driver's National ID
     */
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    /**
     * This function to set Driver's list of Favorite Area
     * @param favArea Driver's list of Favorite Area
     */
    public void setFavArea(ArrayList<Area> favArea) {
        this.favArea = favArea;
    }

    /**
     * This function to Set Driver's Rate
     * @param rate Driver's Rate
     */
    public void setRate(Rating rate) {
        this.rate = rate;
    }

    /**
     * This function to get DriverLicense
     * @return DriverLicense
     */
    public String getDriverLicense() {
        return driverLicense;
    }

    /**
     * This Function to get DriverStatus
     * @return DriverStatus
     */
    public boolean isDriverStatus() {
        return driverStatus;
    }

    /**
     * This function to get National ID
     * @return National ID
     */
    public String getNationalId() {
        return nationalId;
    }

    /**
     * This function to get list Favorite Area
     * @return List Favorite Area
     */
    public ArrayList<Area> getFavArea() {
        return favArea;
    }

    /**
     * This Function to get Rate fof Driver
     * @return Driver's Rate
     */
    public Rating getRate() {
        return rate;
    }
}