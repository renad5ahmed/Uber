
package com.company;

import java.util.ArrayList;
/**
 * @ Class Request
 */
public class Request {
    protected Area source;
    protected Area destination;
    protected Client client;
    protected Driver driver;
    protected ArrayList<Offer>listOffer=new ArrayList<Offer>();

    /**
     * Default Constructor
     */
    public Request( ){

    }

    /**
     * Parametrize Constructor
     * @param a1 Source Area
     * @param a2 destination Area
     * @param c client
     */
    public Request(Area a1, Area a2 , Client c ){
        this.source = a1;
        this.destination =a2;
        this.client  = c;
        notify2();
    }

    /**
     * This Function To notify Drivers throw Trip Manger
     */
    public void notify2() {
        TripManager tm = new TripManager();
        tm.noftifyDrivers(this);
    }

    /**
     * This function to get Request's Data
     * @return Request's Data
     */
    @Override
    public String toString() {
        return "Request:" +'\n'+
                "   source=" + source +'\n'+
                "   destination=" + destination +'\n'+
                client +'\n';
    }
}