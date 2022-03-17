
package com.company;


import java.util.ArrayList;
/**
 * @Class DataBase
 */
class Database implements GeneralDatabase{
    static ArrayList<Client> ClientList = new ArrayList<Client>();
    static ArrayList<Driver> DriverList = new ArrayList<Driver>();
    static ArrayList<Admin> AdminList = new ArrayList<Admin>();
    static ArrayList<RegistrationDriver>regDriversList=new ArrayList<RegistrationDriver>();
    static ArrayList<Driver> penDriver=new ArrayList<Driver>();
    static ArrayList<String> SuspUser=new ArrayList<String>();

    /**
     * update to database
     */
     public void update() {
    }

    /**
     * delete from database
     */
    public void delete() {
    }

    /**
     * set to database
     */
    public void set() {
    }

    /**
     * get from database
     */
    public void get() {

    }

    /**
     * to get client list
     * @return list of clients
     */
    public static ArrayList<Client> getClientList() {
        return ClientList;
    }

    /**
     * to get Driver's list
     * @return list of drivers
     */
    public static ArrayList<Driver> getDriverList() {
        return DriverList;
    }

    /**
     * to get list of admins
     * @return list of admins
     */
    public static ArrayList<Admin> getAdminList() {
        return AdminList;
    }

    /**
     * to get registeration Drivers list
     * @return list of registeration driver
     */
    public static ArrayList<RegistrationDriver> getRegDriversList() {
        return regDriversList;
    }

    /**
     * to get list of pending drivers
     * @return list of pending drivers
     */
    public static ArrayList<Driver> getPenDriver() {
        return penDriver;
    }

    /**
     * to get suspended user
     * @return suspended user
     */
    public static ArrayList<String> getSuspUser() {
        return SuspUser;
    }
}
