
package com.company;
/**
 * @ Class Offer
 */
public class Offer  {
    protected double price;
    protected Driver driver;
    protected boolean accept;

    /**
     * Default Constructor To set Accept false
     */
    public Offer(){
        accept=false;
    }

    /**
     * This function to make offer
     * @param p Offer's Price
     * @param d Offer's Driver
     */
    public void makeOffer(double p,Driver d){
        this.price=p;
        this.driver=d;
    }

    /**
     * This function to Display All Data of offer
     * @return Offer's Data
     */
    @Override
    public String toString() {
        return "Offer:" +'\n'+
                "   price=" + price +'\n'+
                "Driver:"+'\n'+
                 "  Driver name="+ driver.userName +'\n'
                +"  Driver mobile ="+driver.mobileNumber+'\n'
                +"  Driver license="+driver.driverLicense+'\n'
                +"  Driver national ID ="+driver.nationalId+'\n'
                +"  Driver rate = "+driver.rate.getAvgRate();
    }

    /**
     * This Function To get Price of Offer
     * @return Offer's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * This Function to get Offer's Driver
     * @return Offer's Driver
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * This Function to Get Offer's Status
     * @return Offer's Status
     */
    public boolean isAccept() {
        return accept;
    }

    /**
     * This Function to set Offer's Price
     * @param price Offer's Price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This Function to Set Offer's Driver
     * @param driver Offer's Driver
     */
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    /**
     * This Function to Set Offer's Status
     * @param accept Offer's Status
     */
    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}