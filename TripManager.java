
package com.company;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Objects;
/**
 * @ Class TripManager
 */
public class TripManager{
    /**
     * this function notify all drivers has the same source Area of Request
     * @param cr , this is client Request
     */
    public void noftifyDrivers(Request cr){
       Database d=new Database();
        for (int i=0; i<d.DriverList.size(); i++){
            for(int j=0; j<d.DriverList.get(i).favArea.size(); j++){
                if(d.DriverList.get(i).favArea.get(j).getName().equalsIgnoreCase(cr.source.getName())){
                    d.DriverList.get(i).Reqs.add(cr);
                    break;
                }
            }
        }
    }
}