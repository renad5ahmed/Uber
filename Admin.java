
package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Scanner;
/**
 * @Class Admin
 */
public class Admin implements SignIn {

    protected String email;
    protected String password;
    Database d=new Database();
    protected ArrayList<RegistrationDriver> list;

    /**
     *Admin's constructor to set his email and password
     * @param e Admin's email
     * @param p Admin's password
     */
    public Admin(String e,String p) {
        Scanner sc=new Scanner(System.in);
        this.email=e;
        this.password=p;
    }

    /**
     * this function to view the list of registeration drivers
     */
    public void viweListRegDriver(){
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<d.regDriversList.size();i++){
            System.out.println(d.regDriversList.get(i));
        }
        while(d.regDriversList.size() >= 1){
            System.out.println("Please Enter Driver ID You want to verify ");
            int s=sc.nextInt();
            verify(s);
            System.out.println("Do You want to Continue ? (Yes/No)");
            String st=sc.next();
            if(st.equalsIgnoreCase("yes")){
                continue;
            }
            else if(st.equalsIgnoreCase("No")){
                System.out.println("Thank You For verify");
                break;
            }
            else{
                System.out.println("Wrong Input");
            }
        }
        if(d.regDriversList.size()==0){
            System.out.println("This is Last Registration Thank You Admin :)");
        }
    };

    /**
     *this function to verify the driver's account
     * @param id Driver's ID to verify the account
     */
    public void verify(int id){
        for(int i=0;i<d.regDriversList.size();i++){
            if(d.regDriversList.get(i).driver.ID==id){
                d.regDriversList.get(i).changeStatus(true);
                d.regDriversList.remove(d.regDriversList.get(i));
                break;
            }
        }
    }

    /**
     *this function to suspend user
     * @param id User's ID(Driver/Client) to be suspended
     */
    public void suspend(int id){
        for(int i=0;i<d.DriverList.size();i++){
            if(d.DriverList.get(i).ID==id){
                d.SuspUser.add(d.DriverList.get(i).email);
                d.DriverList.remove(d.DriverList.get(i));
            }
            if(d.ClientList.get(i).ID==id){
                d.SuspUser.add(d.ClientList.get(i).email);
                d.ClientList.remove(d.ClientList.get(i));
            }
        }
    };

    /**
     *this function to set email
     * @param email to set Admin's email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *this function to set password
     * @param password to set Admin's password
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * this function to set array list of registeration Drivers
     * @param list list of registeration Drivers
     */
    public void setList(ArrayList<RegistrationDriver> list) {
        this.list = list;
    }

    /**
     * to add another admin
     * @param e email of the new admin
     * @param p password of the new admin
     */
    public void addAdmin(String e, String p){
        Admin a=new Admin(e,p);
        d.AdminList.add(a);
    }

    /**
     * this function is created to log in as admin
     * @return 2: if the admin login successfully
     *         3: if the admin not registered
     */
    public int logIn() {
        boolean flag = false;
        for(int i=0; i< d.AdminList.size() ;i++)
        {
            if(this.email.equals(d.AdminList.get(i).email)&& this.password.equals(d.AdminList.get(i).password))
                flag = true;
        }
        if(flag==true){
            return 2;
        }
        else{
            return 3;
        }
    }

}